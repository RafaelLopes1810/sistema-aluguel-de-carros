package com.alugueldecarros.AluguelDeCarros.Cliente.repositories;

import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Buscar cliente por email
    Optional<Cliente> findByEmail(String email);

    // Buscar cliente por CPF
    Optional<Cliente> findByCpf(String cpf);

    // Autenticar cliente (login) por email e senha
    Optional<Cliente> findByEmailAndSenha(String email, String senha);
}
