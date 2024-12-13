package com.mock.OneToMany5;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	int phone;
	String name;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JsonIgnore
	Person person;
}
