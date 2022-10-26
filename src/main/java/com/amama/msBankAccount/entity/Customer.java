package com.amama.msBankAccount.entity;


import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

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
@Table(name="Customer")
@EntityListeners(AuditingEntityListener.class)
public class Customer {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id ;
	String name;
	
	@OneToMany(mappedBy = "customer")
	private List<BankAccount> bankAccounts;
	@CreatedDate
	@JsonIgnore
	private Instant createdDate;
	@LastModifiedDate
	@JsonIgnore
	private Instant modifiedDate;
}
