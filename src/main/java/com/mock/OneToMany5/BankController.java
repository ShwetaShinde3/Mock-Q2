package com.mock.OneToMany5;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private BankRepo bankRepository;

    @GetMapping
    public List<Bank> getAllBanks( ) {
        return bankRepository.findAll();
    }

    @PostMapping
    public Bank createBank(@RequestBody Bank bank) {
        return bankRepository.save(bank);
    }

    @GetMapping("/{id}")
    public Bank getBankById(@PathVariable int id) {
        return bankRepository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Bank updateBank(@PathVariable int id,@RequestBody Bank bankDetails) {
        Bank bank = bankRepository.findById(id).orElseThrow();
        bank.setName(bankDetails.getName());
        bank.setPhone(bankDetails.getPhone());
        return bankRepository.save(bank);
    }

    @DeleteMapping("/{id}")
    public void deleteBank(@PathVariable int id) {
        bankRepository.deleteById(id);
    }
}

