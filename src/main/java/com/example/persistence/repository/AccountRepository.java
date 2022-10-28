package com.example.persistence.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.persistence.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{


	
	@Query("select b from Account b where b.id=?1")
	Optional<Account> accountByName(String name);
}
