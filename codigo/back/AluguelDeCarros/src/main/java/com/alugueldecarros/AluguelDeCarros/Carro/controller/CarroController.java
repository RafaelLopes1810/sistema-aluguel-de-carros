package com.alugueldecarros.AluguelDeCarros.Carro.controller;

import com.alugueldecarros.AluguelDeCarros.Carro.model.Carro;
import com.alugueldecarros.AluguelDeCarros.Carro.service.CarroService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carros")
@CrossOrigin(origins = "*") 
public class CarroController {

    private final CarroService carroService;

    public CarroController(CarroService carroService) {
        this.carroService = carroService;
    }

    @GetMapping
    public List<Carro> listarTodos() {
        return carroService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> buscarPorId(@PathVariable Long id) {
        return carroService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Carro salvar(@RequestBody Carro carro) {
        return carroService.salvar(carro);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carro> atualizar(@PathVariable Long id, @RequestBody Carro carro) {
        return carroService.buscarPorId(id)
                .map(c -> {
                    c.setNome(carro.getNome());
                    c.setAno(carro.getAno());
                    c.setPlaca(carro.getPlaca());
                    c.setFoto(carro.getFoto());
                    return ResponseEntity.ok(carroService.salvar(c));
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deletar(@PathVariable Long id) {
        return carroService.buscarPorId(id)
                .map(c -> {
                    carroService.deletar(id);
                    return ResponseEntity.noContent().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}
