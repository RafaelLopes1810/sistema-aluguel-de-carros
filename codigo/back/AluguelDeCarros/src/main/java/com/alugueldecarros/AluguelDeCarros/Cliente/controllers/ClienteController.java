package com.alugueldecarros.AluguelDeCarros.Cliente.controllers;

import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;
import com.alugueldecarros.AluguelDeCarros.Cliente.services.ClienteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    // Listar todos
    @GetMapping
    public List<Cliente> listarTodos() {
        return clienteService.listarTodos();
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id) {
        return clienteService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Criar novo cliente
    @PostMapping
    public Cliente criar(@RequestBody Cliente cliente) {
        return clienteService.salvar(cliente);
    }

    // Atualizar cliente
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        return clienteService.buscarPorId(id)
                .map(c -> {
                    c.setNome(cliente.getNome());
                    c.setCpf(cliente.getCpf());
                    c.setEndereco(cliente.getEndereco());
                    c.setTelefone(cliente.getTelefone());
                    c.setProfissao(cliente.getProfissao());
                    c.setEmail(cliente.getEmail());
                    c.setSenha(cliente.getSenha());
                    return ResponseEntity.ok(clienteService.salvar(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    // Deletar cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (clienteService.buscarPorId(id).isPresent()) {
            clienteService.deletar(id);
            return ResponseEntity.noContent().build(); // 204 No Content
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found
        }
    }
}
