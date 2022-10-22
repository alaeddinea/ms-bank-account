package com.amama.msBankAccount.DTO;

import java.util.Date;

import com.amama.msBankAccount.entity.enums.AccountType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountRequestDTO {
private double balance;
private String currency;
private AccountType type;
}
