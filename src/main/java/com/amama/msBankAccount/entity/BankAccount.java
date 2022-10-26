package com.amama.msBankAccount.entity;

import java.time.Instant;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.amama.msBankAccount.Audit.Auditable;
import com.amama.msBankAccount.entity.enums.AccountType;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
public class BankAccount extends Auditable<String> {
	@Id
private String id; 
private double balance;
private String currency;
@Enumerated(EnumType.STRING)
private AccountType type;
@ManyToOne
private Customer customer;
}
