package com.mycompany.pokemon;

public class Pokemon {
    private String nombre;
    private TipoPokemon tipo;
    private int salud;
    private int ataque;
    private int defensa;

    public Pokemon(String nombre, TipoPokemon tipo, int salud, int ataque, int defensa) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.salud = salud;
        this.ataque = ataque;
        this.defensa = defensa;
    }

    public String getNombre() {
        return nombre;
    }

    public TipoPokemon getTipo() {
        return tipo;
    }

    public int getSalud() {
        return salud;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefensa() {
        return defensa;
    }

    public void recibirDanio(int danio) {
        int danioReducido = danio - defensa;
        salud -= Math.max(danioReducido, 0);
        if (salud < 0) {
            salud = 0;
        }
    }

    public boolean estaVivo() {
        return salud > 0;
    }
    
    public void mejorarAtaque(int incremento) {
        ataque += incremento;
    }

    public void mejorarDefensa(int incremento) {
        defensa += incremento;
    }
}
