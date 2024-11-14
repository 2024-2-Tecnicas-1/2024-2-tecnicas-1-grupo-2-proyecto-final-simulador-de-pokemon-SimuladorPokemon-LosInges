package com.mycompany.pokemon;

import java.util.HashMap;
import java.util.Map;

public class Pokedex {
    private static Map<String, Pokemon> pokemones = new HashMap<>();

    // Método para inicializar algunos Pokémon de ejemplo
    static {
    pokemones.put("Charmander", new Pokemon("Charmander", TipoPokemon.FUEGO, 100, 50, 30)); // Agregar ataque y defensa
    pokemones.put("Pikachu", new Pokemon("Pikachu", TipoPokemon.ELECTRICO, 90, 40, 25)); // Agregar ataque y defensa
}


    public static void listarPokemones() {
        System.out.println("Pokémones disponibles en la Pokédex:");
        for (String nombre : pokemones.keySet()) {
            System.out.println("- " + nombre);
        }
    }

    // Método para registrar un nuevo Pokémon en la Pokédex
    public static void registrarPokemon(String nombre, TipoPokemon tipo) {
        if (!pokemones.containsKey(nombre)) {
            pokemones.put(nombre, new Pokemon(nombre, tipo, 100, 50, 30)); // Pasando ataque y defensa
            System.out.println("Pokémon " + nombre + " registrado en la Pokédex.");
        } else {
            System.out.println("El Pokémon " + nombre + " ya existe en la Pokédex.");
        }
    }

    // Obtener un Pokémon de la Pokédex (opcionalmente hacer una copia)
    public static Pokemon obtenerPokemon(String nombre) {
        return pokemones.get(nombre);
    }
}
