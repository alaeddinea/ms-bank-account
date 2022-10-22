package com.amama.msBankAccount.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.amama.msBankAccount.entity.BankAccount;

@RepositoryRestResource
public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
	@RestResource(path = "byType")
	List<BankAccount> findByType(@Param("t") String type);
	@RestResource(path = "byCurrency")
	List<BankAccount> findByCurrency(@Param("c") String currency);
}
