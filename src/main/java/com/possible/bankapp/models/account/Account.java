package com.possible.bankapp.models.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.possible.bankapp.models.AuditModel;
import com.possible.bankapp.models.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "accounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account extends AuditModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String accountNumber;

    @NotNull
    @NotBlank
    private AccountType accountType;

    private AccountStatus accountStatus = AccountStatus.ACTIVE;

    private Double accountBalance = 0.00;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "userId", nullable = false)
    @JsonIgnore
    private User user;
}
