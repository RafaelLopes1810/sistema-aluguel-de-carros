package com.alugueldecarros.AluguelDeCarros.Carro.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carros")
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private int ano;
    private String placa;
    private String foto; // Caminho da imagem

    public Carro() {}

    public Carro(String nome, int ano, String placa, String foto) {
        this.nome = nome;
        this.ano = ano;
        this.placa = placa;
        this.foto = foto;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }
    public String getFoto() { return foto; }
    public void setFoto(String foto) { this.foto = foto; }
}
