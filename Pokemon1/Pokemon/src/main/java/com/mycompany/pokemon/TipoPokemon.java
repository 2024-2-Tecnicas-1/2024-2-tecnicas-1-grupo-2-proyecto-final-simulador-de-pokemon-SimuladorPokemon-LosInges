package com.mycompany.pokemon;

public enum TipoPokemon {
    NORMAL,
    FUEGO,
    AGUA,
    ELECTRICO,
    PLANTA,
    HIELO;

    public double getEfectividad(TipoPokemon tipoOponente) {
        switch (this) {
            case FUEGO:
                return (tipoOponente == PLANTA) ? 2.0 :
                       (tipoOponente == AGUA || tipoOponente == HIELO) ? 0.5 : 1.0;
            case AGUA:
                return (tipoOponente == FUEGO) ? 2.0 :
                       (tipoOponente == ELECTRICO || tipoOponente == PLANTA) ? 0.5 : 1.0;
            case ELECTRICO:
                return (tipoOponente == AGUA) ? 2.0 :
                       (tipoOponente == PLANTA) ? 1.0 : 1.0;
            case PLANTA:
                return (tipoOponente == AGUA) ? 2.0 :
                       (tipoOponente == FUEGO || tipoOponente == HIELO) ? 0.5 : 1.0;
            case HIELO:
                return (tipoOponente == PLANTA) ? 2.0 :
                       (tipoOponente == FUEGO) ? 0.5 : 1.0;
            case NORMAL:
                return 1.0;
            default:
                return 1.0;
        }
    }
}

