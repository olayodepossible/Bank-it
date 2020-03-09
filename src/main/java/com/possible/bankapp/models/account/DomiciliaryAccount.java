package com.possible.bankapp.models.account;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.possible.bankapp.models.AuditModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.UUID;

@Entity
@Table(name = "domiciliaryAccounts")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DomiciliaryAccount extends AuditModel {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @NotNull
    @NotBlank
    private DomiciliaryAccountType domiciliaryAccountType;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "accountNumber", referencedColumnName = "accountNumber", nullable = false)
    @JsonIgnore
    private Account account;
}
