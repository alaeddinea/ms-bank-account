package com.amama.msBankAccount.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.amama.msBankAccount.entity.Customer;
@RepositoryRestResource
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
