package com.amama.msBankAccount.service;


import com.amama.msBankAccount.DTO.BankAccountRequestDTO;
import com.amama.msBankAccount.DTO.BankAccountResponseDTO;

public interface BankAccountService {
public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO );
public BankAccountResponseDTO updateAccount(String id,BankAccountRequestDTO bankAccountRequestDTO );
public boolean deleteAccount(String id);

}
