package com.amama.msBankAccount.entity;

import org.springframework.data.rest.core.config.Projection;

@Projection(types = BankAccount.class,name = "p1")
public interface BankAccountProjection {
 public String getId();
 public String getType();
 
}
