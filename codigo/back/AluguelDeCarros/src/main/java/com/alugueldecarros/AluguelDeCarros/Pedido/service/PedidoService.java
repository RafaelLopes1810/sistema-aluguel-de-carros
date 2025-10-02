package com.alugueldecarros.AluguelDeCarros.Pedido.service;

import com.alugueldecarros.AluguelDeCarros.Carro.model.Carro;
import com.alugueldecarros.AluguelDeCarros.Cliente.models.Cliente;
import com.alugueldecarros.AluguelDeCarros.Pedido.model.Pedido;
import com.alugueldecarros.AluguelDeCarros.Carro.repository.CarroRepository;
import com.alugueldecarros.AluguelDeCarros.Cliente.repositories.ClienteRepository;
import com.alugueldecarros.AluguelDeCarros.Pedido.repository.PedidoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final ClienteRepository clienteRepository;
    private final CarroRepository carroRepository;

    public PedidoService(PedidoRepository pedidoRepository, ClienteRepository clienteRepository, CarroRepository carroRepository) {
        this.pedidoRepository = pedidoRepository;
        this.clienteRepository = clienteRepository;
        this.carroRepository = carroRepository;
    }

    public List<Pedido> listarTodos() {
        return pedidoRepository.findAll();
    }

    public List<Pedido> listarPorCliente(Long clienteId) {
        return pedidoRepository.findByClienteId(clienteId);
    }

    public Optional<Pedido> buscarPorId(Long id) {
        return pedidoRepository.findById(id);
    }

    public Pedido criarPedido(Long clienteId, Long carroId) {
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
        Carro carro = carroRepository.findById(carroId)
                .orElseThrow(() -> new RuntimeException("Carro não encontrado"));

        Pedido pedido = new Pedido(cliente, carro);
        return pedidoRepository.save(pedido);
    }

    public Pedido atualizarStatus(Long id, String status) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(status);
        return pedidoRepository.save(pedido);
    }

    public void deletar(Long id) {
        pedidoRepository.deleteById(id);
    }
}
