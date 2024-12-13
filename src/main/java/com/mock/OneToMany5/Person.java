package com.mock.OneToMany5;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String first;
	String last;
	String dob;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "person_bank", uniqueConstraints = @UniqueConstraint(columnNames = { "account-type" }),joinColumns = @JoinColumn(name="person_id"),inverseJoinColumns = @JoinColumn(name="bank_id"))
	List <Bank> bank;
}