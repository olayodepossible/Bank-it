package com.possible.bankapp.repositories;

import com.possible.bankapp.models.transfer.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Integer> {
}
