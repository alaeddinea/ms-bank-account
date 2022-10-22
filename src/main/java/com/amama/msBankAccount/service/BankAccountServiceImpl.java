package com.amama.msBankAccount.service;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.amama.msBankAccount.DTO.BankAccountRequestDTO;
import com.amama.msBankAccount.DTO.BankAccountResponseDTO;
import com.amama.msBankAccount.entity.BankAccount;
import com.amama.msBankAccount.mappers.BankAccountMapper;
import com.amama.msBankAccount.repository.BankAccountRepository;



@Service @Transactional
public class BankAccountServiceImpl implements BankAccountService{
	@Autowired                                          
	private BankAccountRepository bankAccountRepository;
	@Autowired   
	BankAccountMapper bankAccountMapper;
	public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
		BankAccount saveBankAccount= bankAccountRepository.save(bankAccountMapper.toBankAccount(bankAccountRequestDTO));
		BankAccountResponseDTO bankAccountResponseDTO =bankAccountMapper.fromBankAccount(saveBankAccount);
		return bankAccountResponseDTO;
	}

	
}
