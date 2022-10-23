package com.amama.msBankAccount.service;

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
	@Override
	public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO bankAccountRequestDTO) {
		BankAccount updatedBankAccount= bankAccountRepository.findById(id).orElseThrow(()->new RuntimeException(String.format("ID %s not found",id)));	
		if(updatedBankAccount != null) {
			updatedBankAccount.setBalance(bankAccountRequestDTO.getBalance());
			updatedBankAccount.setType(bankAccountRequestDTO.getType());
			updatedBankAccount.setCurrency(bankAccountRequestDTO.getCurrency());
		}
		
		return bankAccountMapper.fromBankAccount(bankAccountRepository.save(updatedBankAccount));
		 
	}
	@Override
	public boolean deleteAccount(String id) {
		// TODO Auto-generated method stub
		 bankAccountRepository.deleteById(id);
		 return true;
	}

	
}
