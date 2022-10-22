package com.amama.msBankAccount.DTO;

import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

import com.amama.msBankAccount.entity.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
private String id; 
private Date createdDate;
private double balance;
private String currency;
private AccountType type;
}
