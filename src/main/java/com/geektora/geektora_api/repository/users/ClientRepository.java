package com.geektora.geektora_api.repository.users;

import com.geektora.geektora_api.model.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
