package com.mock.OneToMany5;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person_Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	private String accountType;

    @ManyToOne()
    @JoinColumn(name = "person_id")
    
    private Person person;

    @ManyToOne()
    @JoinColumn(name = "bank_id")
    private Bank bank;
}
