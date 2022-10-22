package com.amama.msBankAccount.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.amama.msBankAccount.entity.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccount {
	@Id
private String id; 
private Date createdDate;
private double balance;
private String currency;
@Enumerated(EnumType.STRING)
private AccountType type;
}
