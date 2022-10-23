package com.amama.msBankAccount.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.amama.msBankAccount.DTO.BankAccountRequestDTO;
import com.amama.msBankAccount.DTO.BankAccountResponseDTO;
import com.amama.msBankAccount.entity.BankAccount;
import com.amama.msBankAccount.entity.Customer;
import com.amama.msBankAccount.repository.BankAccountRepository;
import com.amama.msBankAccount.repository.CustomerRepository;
import com.amama.msBankAccount.service.BankAccountServiceImpl;

@Controller
public class BankAccountGraphqlController {
	@Autowired
    private BankAccountRepository bankAccountRepository;
	@Autowired
	 private BankAccountServiceImpl bankAccountServiceImpl;
	@Autowired
	 private CustomerRepository customerRepository;

	@QueryMapping
	public List<BankAccount> accountsList(){
		return bankAccountRepository.findAll();
	}
	@QueryMapping
	public BankAccount accountById(@Argument String id){
		return bankAccountRepository.findById(id)
				.orElseThrow(()->new RuntimeException(String.format("Account %s is not found",id)));
	}
	@MutationMapping
	public BankAccountResponseDTO addAccount(@Argument BankAccountRequestDTO bankAccountRequestDTO){
		
				return  bankAccountServiceImpl.addAccount(bankAccountRequestDTO);
				
	}
	@MutationMapping
	public BankAccountResponseDTO updateAccount(@Argument String id , @Argument BankAccountRequestDTO bankAccountRequestDTO){
		
		return  bankAccountServiceImpl.updateAccount(id,bankAccountRequestDTO);
				
	}
	@MutationMapping
	public boolean deleteAccount(@Argument String id ){
		return bankAccountServiceImpl.deleteAccount(id);
	}
	
	@QueryMapping
	public List<Customer> customerList(){
		return customerRepository.findAll();
	}
}
