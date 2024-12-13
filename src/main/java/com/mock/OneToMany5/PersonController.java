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
@RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonRepo repo;
	
	@GetMapping
	public List<Person> getAll() {
		return repo.findAll();	}
	
	@GetMapping("/{id}")
	public Person getById(@PathVariable int id) {
		return repo.findById(id).orElseThrow();
		}
	
	@PostMapping
	public Person add(@RequestBody Person person) {
		Person p=new Person();
		p.setDob(person.getDob());
		p.setFirst(person.getFirst());
		p.setLast(person.getLast());
		
		List<Bank> l=new ArrayList();
		for(Bank b:person.getBank()) {
			Bank b1=new Bank();
			b1.setName(b.getName());
			b1.setPhone(b.getPhone());
			b1.setPerson(person);
			l.add(b1);
		}
		p.setBank(l);
		 return repo.save(p);	}
	
	@DeleteMapping("/{id}")
	public void del(@PathVariable int id) {
		 repo.deleteById(id);	}
	

	@PutMapping("/{id}")
	public Person update(@PathVariable int id,@RequestBody Person person) {
		Person p = repo.findById(id).orElseThrow();
		
		p.setDob(person.getDob());
		p.setFirst(person.getFirst());
		p.setLast(person.getLast());
		
		List<Bank> l=p.getBank();
		for(Bank b:person.getBank()) {
			Bank b1=new Bank();
			b1.setName(b.getName());
			b1.setPhone(b.getPhone());
			b1.setPerson(person);
			l.add(b1);
		}
		p.setBank(l);
		 return repo.save(p);
		}
	@GetMapping("/{pNo}/{pSize}")
	public Page<Person> getById(@PathVariable int pNo,@PathVariable int pSize) {
		PageRequest of = PageRequest.of(pNo, pSize);
		return repo.findAll(of);
		}
	
}
