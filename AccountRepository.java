package com.dbs.accountmanagement.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dbs.accountmanagement.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	@Transactional
    @Modifying
    @Query("UPDATE Account a SET a.customerName = :customerName, a.accountType = :accountType, a.balance = :balance, a.updationTime = :updationTime WHERE a.accountNumber = :accountNumber")
    void updateAccount(@Param("accountNumber") Long accountNumber, @Param("customerName") String customerName, @Param("accountType") String accountType, @Param("balance") Double balance, @Param("updationTime") LocalDateTime updationTime);
	
	@Query("SELECT COALESCE(MAX(a.accountNumber), 24000) FROM Account a")
    Long getMaxAccountNumberOrDefault();
	
}
