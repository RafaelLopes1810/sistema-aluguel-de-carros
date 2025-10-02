package com.alugueldecarros.AluguelDeCarros.Carro.service;

import com.alugueldecarros.AluguelDeCarros.Carro.model.Carro;
import com.alugueldecarros.AluguelDeCarros.Carro.repository.CarroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarroService {

    private final CarroRepository carroRepository;

    public CarroService(CarroRepository carroRepository) {
        this.carroRepository = carroRepository;
    }

    public List<Carro> listarTodos() {
        return carroRepository.findAll();
    }

    public Optional<Carro> buscarPorId(Long id) {
        return carroRepository.findById(id);
    }

    public Carro salvar(Carro carro) {
        return carroRepository.save(carro);
    }

    public void deletar(Long id) {
        carroRepository.deleteById(id);
    }
}
