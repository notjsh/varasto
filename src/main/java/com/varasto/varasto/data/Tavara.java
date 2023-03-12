package com.varasto.varasto.data;

public class Tavara {
    private int id;
    private String name;
    private double paino;
    private char hyllyKirjain;
    private char hyllyNumero;


    public Tavara() {
    }

    public Tavara(int id, String name, double paino, char hyllyKirjain, char hyllyNumero) {
        this.id = id;
        this.name = name;
        this.paino = paino;
        this.hyllyKirjain = hyllyKirjain;
        this.hyllyNumero = hyllyNumero;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPaino() {
        return this.paino;
    }

    public void setPaino(double paino) {
        this.paino = paino;
    }

    public char getHyllyKirjain() {
        return this.hyllyKirjain;
    }

    public void setHyllyKirjain(char hyllyKirjain) {
        this.hyllyKirjain = hyllyKirjain;
    }

    public char getHyllyNumero() {
        return this.hyllyNumero;
    }

    public void setHyllyNumero(char hyllyNumero) {
        this.hyllyNumero = hyllyNumero;
    }

    public Tavara id(int id) {
        setId(id);
        return this;
    }

    public Tavara name(String name) {
        setName(name);
        return this;
    }

    public Tavara paino(double paino) {
        setPaino(paino);
        return this;
    }

    public Tavara hyllyKirjain(char hyllyKirjain) {
        setHyllyKirjain(hyllyKirjain);
        return this;
    }

    public Tavara hyllyNumero(char hyllyNumero) {
        setHyllyNumero(hyllyNumero);
        return this;
    }
}