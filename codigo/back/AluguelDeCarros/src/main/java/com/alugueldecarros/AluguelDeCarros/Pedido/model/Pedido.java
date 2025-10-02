package com.alugueldecarros.AluguelDeCarros.Pedido.model;

import jakarta.persistence.*;
import com.alugueldecarros.AluguelDeCarros.Carro.model.Carro;
import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status = "Pendente";

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "carro_id", nullable = false)
    private Carro carro;

    public Pedido() {}

    public Pedido(Cliente cliente, Carro carro) {
        this.cliente = cliente;
        this.carro = carro;
        this.status = "Pendente";
    }

    // Getters e Setters
    public Long getId() { return id; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Carro getCarro() { return carro; }
    public void setCarro(Carro carro) { this.carro = carro; }
}
