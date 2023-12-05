package com.akdenizbank.mls.user;

import com.akdenizbank.mls.account.BankAccount;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CustomerUser extends AppUser {

}
