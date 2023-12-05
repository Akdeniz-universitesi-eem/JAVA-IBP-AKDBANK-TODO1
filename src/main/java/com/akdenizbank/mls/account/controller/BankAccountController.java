package com.akdenizbank.mls.account.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.akdenizbank.mls.account.BankAccount;
import com.akdenizbank.mls.account.service.BankAccountService;
import com.akdenizbank.mls.generic.rest.GenericApiResponse;

@RestController
@RequestMapping("/api/v1/bank-accounts")
public class BankAccountController {

    @Autowired
    private BankAccountService bankAccountService;

    //TODO: CREATE BANK ACCOUNT METHOD
    //TODO: UPDATE BANK ACCOUNT METHOD
    @GetMapping
    public GenericApiResponse getAllBankAccounts(Pageable pageable) {
        Page<BankAccount> bankAccountsPage = this.bankAccountService.getAll(pageable);
        return new GenericApiResponse(200, "Success", "29647532", bankAccountsPage);
    }

    @GetMapping("/{id}")
    public GenericApiResponse getBankAccountById(@PathVariable String id) {
        BankAccount bankAccountInDB = this.bankAccountService.getById(id);
        if (bankAccountInDB == null) {
            throw new RuntimeException("No Such Bank Account");
        }
        return new GenericApiResponse(200, "Success", "13732854", bankAccountInDB);
    }

    @DeleteMapping("/{id}")
    public GenericApiResponse deleteBankAccount(@PathVariable String id) {
        this.bankAccountService.delete(id);
        return new GenericApiResponse(200, "Success", "3984756");
    }
}
