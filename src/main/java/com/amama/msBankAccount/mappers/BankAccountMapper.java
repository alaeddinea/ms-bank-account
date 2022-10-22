package com.amama.msBankAccount.mappers;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import com.amama.msBankAccount.DTO.BankAccountRequestDTO;
import com.amama.msBankAccount.DTO.BankAccountResponseDTO;
import com.amama.msBankAccount.entity.BankAccount;

@Component
public class BankAccountMapper {
public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount) {
	BankAccountResponseDTO bankAccountResponseDTO =new BankAccountResponseDTO();
	BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
	return bankAccountResponseDTO;
}
public BankAccount toBankAccount(BankAccountRequestDTO bankAccountRequestDTO ) {
	BankAccount bankAccount=BankAccount.builder()
			.id(UUID.randomUUID().toString())
			.balance(bankAccountRequestDTO.getBalance())
			.createdDate(new Date())
			.type(bankAccountRequestDTO.getType())
			.currency(bankAccountRequestDTO.getCurrency())
			.build();
	return bankAccount;
}
}
