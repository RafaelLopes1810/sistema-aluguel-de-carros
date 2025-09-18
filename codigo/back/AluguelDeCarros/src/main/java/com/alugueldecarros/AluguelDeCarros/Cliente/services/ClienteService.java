package com.alugueldecarros.AluguelDeCarros.Cliente.services;

import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;
import com.alugueldecarros.AluguelDeCarros.Cliente.repositories.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public List<Cliente> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> buscarPorId(Long id) {
        return clienteRepository.findById(id);
    }

    public Cliente salvar(Cliente cliente) {
        // Verifica duplicidade de email
        if (clienteRepository.findByEmail(cliente.getEmail()).isPresent()) {
            throw new RuntimeException("Email já cadastrado!");
        }

        // Verifica duplicidade de CPF
        if (clienteRepository.findByCpf(cliente.getCpf()).isPresent()) {
            throw new RuntimeException("CPF já cadastrado!");
        }

        return clienteRepository.save(cliente);
    }

    public void deletar(Long id) {
        clienteRepository.deleteById(id);
    }

    // Login (autenticação básica)
    public Optional<Cliente> login(String email, String senha) {
        return clienteRepository.findByEmailAndSenha(email, senha);
    }
}
