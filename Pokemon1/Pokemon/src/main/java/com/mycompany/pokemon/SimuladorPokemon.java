package com.mycompany.pokemon;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SimuladorPokemon {
    public static List<Entrenador> entrenadores = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
        do {
            System.out.println("Simulador de Batallas Pokémon");
            System.out.println("1. Gestionar Entrenadores");
            System.out.println("2. Gestionar Pokémones");
            System.out.println("3. Iniciar Batalla");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> gestionarEntrenadores();
                case 2 -> gestionarPokemon();
                case 3 -> iniciarBatalla();
                case 4 -> System.out.println("Saliendo del simulador...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void gestionarEntrenadores() {
        int opcion;
        do {
            System.out.println("Gestionar Entrenadores");
            System.out.println("1. Registrar nuevo entrenador");
            System.out.println("2. Ver lista de entrenadores");
            System.out.println("3. Seleccionar un entrenador");
            System.out.println("4. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarEntrenador();
                case 2 -> verEntrenadores();
                case 3 -> seleccionarEntrenador();
                case 4 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void registrarEntrenador() {
        System.out.print("Nombre del nuevo entrenador: ");
        String nombre = scanner.nextLine();
        entrenadores.add(new Entrenador(nombre));
        System.out.println("Entrenador " + nombre + " registrado con éxito.");
    }

    private static void verEntrenadores() {
        if (entrenadores.isEmpty()) {
            System.out.println("No hay entrenadores registrados.");
            return;
        }
        System.out.println("Entrenadores registrados:");
        for (int i = 0; i < entrenadores.size(); i++) {
            System.out.println((i + 1) + ". " + entrenadores.get(i).getNombre());
        }
    }

    private static void seleccionarEntrenador() {
        verEntrenadores();
        System.out.print("Selecciona un entrenador (número): ");
        int index = scanner.nextInt() - 1;
        scanner.nextLine();
        if (index < 0 || index >= entrenadores.size()) {
            System.out.println("Entrenador no válido.");
            return;
        }
        Entrenador entrenadorSeleccionado = entrenadores.get(index);
        gestionarEntrenadorSeleccionado(entrenadorSeleccionado);
    }

    private static void gestionarEntrenadorSeleccionado(Entrenador entrenador) {
        int opcion;
        do {
            System.out.println("Entrenador: " + entrenador.getNombre());
            System.out.println("1. Ver equipo de Pokémones");
            System.out.println("2. Agregar Pokémon al equipo");
            System.out.println("3. Entrenar Pokémon");
            System.out.println("4. Volver a gestionar entrenadores");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> entrenador.mostrarEquipo();
                case 2 -> agregarPokemon(entrenador);
                case 3 -> entrenarPokemon(entrenador);
                case 4 -> System.out.println("Volviendo al menú anterior...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 4);
    }

    private static void agregarPokemon(Entrenador entrenador) {
        System.out.print("Nombre del Pokémon: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo del Pokémon (NORMAL, FUEGO, AGUA, ELECTRICO, PLANTA, HIELO): ");
        String tipoString = scanner.nextLine();

        TipoPokemon tipoPokemon;
        try {
            tipoPokemon = TipoPokemon.valueOf(tipoString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de Pokémon no válido.");
            return;
        }

        entrenador.agregarPokemon(new Pokemon(nombre, tipoPokemon, 100, 50, 30));
        System.out.println("Pokémon agregado al equipo.");
    }

    public static void entrenarPokemon(Entrenador entrenador) {
    System.out.println("Selecciona un Pokémon para entrenar:");
    entrenador.mostrarEquipo();
    System.out.print("Número del Pokémon: ");
    int index = scanner.nextInt() - 1;
    scanner.nextLine();

    System.out.print("Incremento de ataque: ");
    int incrementoAtaque = scanner.nextInt();
    scanner.nextLine();

    System.out.print("Incremento de defensa: ");
    int incrementoDefensa = scanner.nextInt();
    scanner.nextLine();

    entrenador.entrenarPokemon(index, incrementoAtaque, incrementoDefensa);
}


    private static void gestionarPokemon() {
        int opcion;
        do {
            System.out.println("Gestionar Pokémones");
            System.out.println("1. Ver todos los Pokémones registrados");
            System.out.println("2. Registrar nuevo Pokémon");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> Pokedex.listarPokemones();
                case 2 -> registrarNuevoPokemon();
                case 3 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 3);
    }

    private static void registrarNuevoPokemon() {
        System.out.print("Nombre del nuevo Pokémon: ");
        String nombre = scanner.nextLine();

        System.out.print("Tipo del Pokémon (NORMAL, FUEGO, AGUA, ELECTRICO, PLANTA, HIELO): ");
        String tipoString = scanner.nextLine();

        TipoPokemon tipoPokemon;
        try {
            tipoPokemon = TipoPokemon.valueOf(tipoString.toUpperCase());
        } catch (IllegalArgumentException e) {
            System.out.println("Tipo de Pokémon no válido.");
            return;
        }

        Pokedex.registrarPokemon(nombre, tipoPokemon);
    }

    private static void iniciarBatalla() {
    if (entrenadores.size() < 2) {
        System.out.println("Debe haber al menos dos entrenadores registrados para iniciar una batalla.");
        return;
    }

    // Seleccionar Entrenador 1
    System.out.println("Selecciona el primer entrenador:");
    verEntrenadores();
    int index1 = obtenerNumeroValido("Número del primer entrenador: ");
    if (index1 < 0 || index1 >= entrenadores.size()) {
        System.out.println("Entrenador no válido.");
        return;
    }
    Entrenador entrenador1 = entrenadores.get(index1);

    // Seleccionar un Pokémon del Entrenador 1
    System.out.println("Selecciona el Pokémon del primer entrenador:");
    entrenador1.mostrarEquipo();
    int pokemonIndex1 = obtenerNumeroValido("Número del Pokémon: ");
    if (pokemonIndex1 < 0 || pokemonIndex1 >= entrenador1.getEquipo().size()) {
        System.out.println("Pokémon no válido.");
        return;
    }
    Pokemon pokemon1 = entrenador1.getEquipo().get(pokemonIndex1);

    // Seleccionar Entrenador 2
    System.out.println("Selecciona el segundo entrenador:");
    verEntrenadores();
    int index2 = obtenerNumeroValido("Número del segundo entrenador: ");
    if (index2 < 0 || index2 >= entrenadores.size() || index2 == index1) {
        System.out.println("Entrenador no válido o el mismo entrenador seleccionado.");
        return;
    }
    Entrenador entrenador2 = entrenadores.get(index2);

    // Seleccionar un Pokémon del Entrenador 2
    System.out.println("Selecciona el Pokémon del segundo entrenador:");
    entrenador2.mostrarEquipo();
    int pokemonIndex2 = obtenerNumeroValido("Número del Pokémon: ");
    if (pokemonIndex2 < 0 || pokemonIndex2 >= entrenador2.getEquipo().size()) {
        System.out.println("Pokémon no válido.");
        return;
    }
    Pokemon pokemon2 = entrenador2.getEquipo().get(pokemonIndex2);

    // Iniciar la batalla
    Batalla batalla = new Batalla(pokemon1, pokemon2);
    batalla.iniciar();
}

private static int obtenerNumeroValido(String mensaje) {
    int numero = -1;
    boolean valido = false;
    while (!valido) {
        try {
            System.out.print(mensaje);
            numero = scanner.nextInt();
            scanner.nextLine();  // Limpiar el salto de línea
            valido = true;
        } catch (InputMismatchException e) {
            System.out.println("¡Entrada inválida! Debes ingresar un número entero.");
            scanner.nextLine();  // Limpiar la entrada errónea
        }
    }
    return numero - 1; // Ajustamos el índice para que empiece desde 0
}


}
