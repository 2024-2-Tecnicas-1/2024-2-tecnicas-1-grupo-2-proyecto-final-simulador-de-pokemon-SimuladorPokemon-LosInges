/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pokemon;

public class Batalla {
    private Pokemon pokemon1;
    private Pokemon pokemon2;

    public Batalla(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
    }

    public void iniciar() {
        System.out.println(pokemon1.getNombre() + " vs " + pokemon2.getNombre());
        while (pokemon1.estaVivo() && pokemon2.estaVivo()) {
            realizarAtaque(pokemon1, pokemon2);
            if (!pokemon2.estaVivo()) {
                System.out.println(pokemon2.getNombre() + " ha sido derrotado!");
                break;
            }

            realizarAtaque(pokemon2, pokemon1);
            if (!pokemon1.estaVivo()) {
                System.out.println(pokemon1.getNombre() + " ha sido derrotado!");
            }
        }
    }

    private void realizarAtaque(Pokemon atacante, Pokemon defensor) {
        int danioBase = atacante.getAtaque();
        double efectividad = atacante.getTipo().getEfectividad(defensor.getTipo());
        int danio = (int) (danioBase * efectividad);
        defensor.recibirDanio(danio);
        System.out.println(atacante.getNombre() + " ataca a " + defensor.getNombre() + ". Salud restante de " + defensor.getNombre() + ": " + defensor.getSalud());
    }
}
