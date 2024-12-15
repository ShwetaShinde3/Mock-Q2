package com.mock.OneToMany5;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/p_b")
public class PersonBankController {

	@Autowired
	PersonBankRepo repo;
	
	@GetMapping
	public List<Person_Bank> getAll() {
		return repo.findAll();	}
	
	@GetMapping("/{id}")
	public Person_Bank getById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
		}
	
	@PostMapping
	public Person_Bank add(@RequestBody Person_Bank person) {
		
		
		 return repo.save(person);	}
	
	@DeleteMapping("/{id}")
	public void del(@PathVariable int id) {
		 repo.deleteById(id);	}
	

	@PutMapping("/{id}")
	public Person_Bank update(@PathVariable int id,@RequestBody Person_Bank person) {
		Person_Bank p = repo.findById(id).orElseThrow();
		
		p.setAccountType(person.getAccountType());
		
		
		 return repo.save(p);
		}
	@GetMapping("/{pNo}/{pSize}")
	public Page<Person_Bank> getById(@PathVariable int pNo,@PathVariable int pSize) {
		PageRequest of = PageRequest.of(pNo, pSize);
		return repo.findAll(of);
		}
	
}
