package com.alugueldecarros.AluguelDeCarros.Cliente.repositories;

import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}