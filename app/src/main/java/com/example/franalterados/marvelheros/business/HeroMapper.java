package com.example.franalterados.marvelheros.business;

import com.example.franalterados.marvelheros.model.Hero;
import com.example.franalterados.marvelheros.rest.model.DTOHero;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class HeroMapper {

    public static Hero dtoHerotoHero(DTOHero dtoHero) {
        Hero hero = new Hero();

        hero.setName(dtoHero.getName());
        hero.setPhoto(dtoHero.getPhoto());
        hero.setRealName(dtoHero.getRealName());
        hero.setHeight(dtoHero.getHeight());
        hero.setPower(dtoHero.getPower());
        hero.setAbilities(dtoHero.getAbilities());
        hero.setGroups(dtoHero.getGroups());

        return hero;
    }

    public static List<Hero> lstDtoHeroToLstHero(List<DTOHero> lstDtoHero) {
        List<Hero> lstHero = new ArrayList<>();

        for (DTOHero dtoHero : lstDtoHero) {
            lstHero.add(dtoHerotoHero(dtoHero));
        }

        return lstHero;
    }

}
