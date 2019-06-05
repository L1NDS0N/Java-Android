package br.senai.rn.catalogo.models;

public class Produto {
    private int id = 0;
    private String nome;
    private String preco;
    private String fabricante;

    public Produto(String nome, String preco, String fabricante){
    this.nome = nome;
    this.preco = preco;
    this.fabricante = fabricante;

    }

    public Produto() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean temIdValido() {
        return id > 0;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "nome='" + nome + '\'' +
                ", preco='" + preco + '\'' +
                ", fabricante='" + fabricante + '\'' +
                '}';
    }
}
