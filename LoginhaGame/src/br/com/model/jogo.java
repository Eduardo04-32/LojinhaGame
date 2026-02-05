/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.model;

/**
 *
 * @author jesus
 */
public class jogo {
    
    private int id;
    private String titulos;
    private String plataforma;
    private double preco;
    private String imagemPath;

    public jogo() {
    }

    public jogo(int id, String titulos, String plataforma, double preco, String imagemPath) {
        this.id = id;
        this.titulos = titulos;
        this.plataforma = plataforma;
        this.preco = preco;
        this.imagemPath = imagemPath;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulos() {
        return titulos;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getImagemPath() {
        return imagemPath;
    }

    public void setImagemPath(String imagemPath) {
        this.imagemPath = imagemPath;
    }
    
    
    
    
}
