package com.mock.OneToMany5;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonBankRepo extends JpaRepository<Person_Bank, Integer> {

}
