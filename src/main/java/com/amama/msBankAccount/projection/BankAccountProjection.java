package com.amama.msBankAccount.projection;

import org.springframework.data.rest.core.config.Projection;

import com.amama.msBankAccount.entity.BankAccount;

@Projection(types = BankAccount.class,name = "p1")
public interface BankAccountProjection {
 public String getId();
 public String getType();
 
}
