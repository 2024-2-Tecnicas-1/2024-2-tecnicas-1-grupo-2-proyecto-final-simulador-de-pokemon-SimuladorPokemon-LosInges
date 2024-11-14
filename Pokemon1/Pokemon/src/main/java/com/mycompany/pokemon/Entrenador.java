package com.mycompany.pokemon;

import java.util.ArrayList;
import java.util.List; // Agregar esta línea para importar List

public class Entrenador {
    private String nombre;
    private List<Pokemon> equipo;

    public Entrenador(String nombre) {
        this.nombre = nombre;
        this.equipo = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void agregarPokemon(Pokemon pokemon) {
        if (equipo.size() < 6) {
            equipo.add(pokemon);
            System.out.println(pokemon.getNombre() + " ha sido agregado al equipo de " + nombre + ".");
        } else {
            System.out.println("El equipo ya está completo. No se puede agregar más Pokémones.");
        }
    }

    public void entrenarPokemon(int index, int incrementoAtaque, int incrementoDefensa) {
        if (index < 0 || index >= equipo.size()) {
            System.out.println("Índice de Pokémon no válido.");
            return;
        }
        Pokemon pokemon = equipo.get(index);
        pokemon.mejorarAtaque(incrementoAtaque);
        pokemon.mejorarDefensa(incrementoDefensa);
        System.out.println(pokemon.getNombre() + " ha sido entrenado. Ataque: " + pokemon.getAtaque() + ", Defensa: " + pokemon.getDefensa());
    }

    public void mostrarEquipo() {
        if (equipo.isEmpty()) {
            System.out.println(nombre + " no tiene Pokémones en su equipo.");
            return;
        }
        System.out.println("Equipo de " + nombre + ":");
        for (int i = 0; i < equipo.size(); i++) {
            Pokemon p = equipo.get(i);
            System.out.println((i + 1) + ". " + p.getNombre() + " (Salud: " + p.getSalud() + ", Ataque: " + p.getAtaque() + ", Defensa: " + p.getDefensa() + ")");
        }
    }

    public List<Pokemon> getEquipo() {
        return equipo;
    }
}
