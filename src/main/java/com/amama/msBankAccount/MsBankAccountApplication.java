package com.amama.msBankAccount;



import java.util.Date;
import java.util.UUID;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.amama.msBankAccount.entity.BankAccount;
import com.amama.msBankAccount.entity.enums.AccountType;
import com.amama.msBankAccount.repository.BankAccountRepository;

@SpringBootApplication
public class MsBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBankAccountApplication.class, args);
	}
	@Bean
CommandLineRunner star(BankAccountRepository bankAccountRepository) {
	return  args -> {
		for (int i = 0; i < 10; i++) {
			BankAccount bankAccount=BankAccount.builder()
					.id(UUID.randomUUID().toString())
					.type(Math.random()>0.5 ?AccountType.CURRENT_ACCOUNT:AccountType.SAVING_ACOUNT)
					.balance(1000+Math.random()*90000)
					.createdDate(new Date())
					.currency(i>5?"DT":"EURO")
					.build();
					
			bankAccountRepository.save(bankAccount);
		}
	};
}
}
