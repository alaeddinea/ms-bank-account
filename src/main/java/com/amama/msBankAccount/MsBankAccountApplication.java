package com.amama.msBankAccount;



import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.amama.msBankAccount.entity.BankAccount;
import com.amama.msBankAccount.entity.Customer;
import com.amama.msBankAccount.entity.enums.AccountType;
import com.amama.msBankAccount.repository.BankAccountRepository;
import com.amama.msBankAccount.repository.CustomerRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "aware")
public class MsBankAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsBankAccountApplication.class, args);
	}

	@Bean
	public AuditorAware<String>aware() {
		return () -> Optional.of("Administrator");
	}
	@Bean
	CommandLineRunner star(BankAccountRepository bankAccountRepository, CustomerRepository customerRepository) {
		return args -> {
			Stream.of("Mohamed", "Yassin", "Hana", "Imene").forEach(n -> {
				Customer customer = Customer.builder().name(n).build();
				customerRepository.save(customer);
			});
			customerRepository.findAll().forEach(customer -> {
				for (int i = 0; i < 10; i++) {
					BankAccount bankAccount = BankAccount.builder().id(UUID.randomUUID().toString())
							.type(Math.random() > 0.5 ? AccountType.CURRENT_ACCOUNT : AccountType.SAVING_ACOUNT)
							.balance(1000 + Math.random() * 90000)
							.currency(i > 5 ? "DT" : "EURO").customer(customer).build();

					bankAccountRepository.save(bankAccount);
				}
			});

		};
	}
}
