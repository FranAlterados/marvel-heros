package com.example.franalterados.marvelheros.rest.model;

import java.util.List;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class DTOSuperheroes {
    List<DTOHero> superheroes;

    public List<DTOHero> getSuperheroes() {
        return superheroes;
    }

    public void setSuperheroes(List<DTOHero> superheroes) {
        this.superheroes = superheroes;
    }
}
