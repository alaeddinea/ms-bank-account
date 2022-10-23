package com.amama.msBankAccount.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amama.msBankAccount.DTO.BankAccountRequestDTO;
import com.amama.msBankAccount.DTO.BankAccountResponseDTO;
import com.amama.msBankAccount.entity.BankAccount;
import com.amama.msBankAccount.repository.BankAccountRepository;
import com.amama.msBankAccount.service.BankAccountServiceImpl;

@RestController
@RequestMapping("/api/bankAccounts")
public class BankAccountController {
	BankAccountRepository bankAccountRepository;
	BankAccountServiceImpl bankAccountServiceImpl;
	
	
	public BankAccountController(BankAccountRepository bankAccountRepository,
			BankAccountServiceImpl bankAccountServiceImpl) {
		super();
		this.bankAccountRepository = bankAccountRepository;
		this.bankAccountServiceImpl = bankAccountServiceImpl;
	}
	@GetMapping("/")
	public List<BankAccount> bankAccounts(){
		return bankAccountRepository.findAll();
	}
	@GetMapping("/{id}")
	public BankAccount bankAccount(@PathVariable String id){
		return  bankAccountRepository.findById(id).orElseThrow();
	}
	@PostMapping("/")
	public BankAccountResponseDTO save(@RequestBody BankAccountRequestDTO bankAccountRequestDTO ){
		return  bankAccountServiceImpl.addAccount(bankAccountRequestDTO);
	}
	@PutMapping("/{id}")
	public BankAccountResponseDTO update(@PathVariable  String id,@RequestBody BankAccountRequestDTO bankAccountRequestDTO ){
		return  bankAccountServiceImpl.updateAccount(id,bankAccountRequestDTO);
	}
	@DeleteMapping("/{id}")
	public void dalete(@PathVariable String id){
		bankAccountServiceImpl.deleteAccount(id);
	}
}
