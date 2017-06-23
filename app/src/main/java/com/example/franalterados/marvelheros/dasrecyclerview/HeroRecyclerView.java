package com.example.franalterados.marvelheros.dasrecyclerview;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.franalterados.marvelheros.R;
import com.example.franalterados.marvelheros.model.Hero;

import java.util.ArrayList;
import java.util.List;

import es.jfmargar.dasrecyclerview.RecyclerItem;
import es.jfmargar.dasrecyclerview.ViewPack;

/**
 * Created by FranAlterados on 23/6/17.
 */
public class HeroRecyclerView extends RecyclerItem {

    Hero hero;

    public HeroRecyclerView(Hero hero) {
        this.hero = hero;

        ViewPack viewPack1 = new ViewPack();
        viewPack1.setObject(hero.getName());
        viewPack1.setResource(R.id.tvHeroName);
        viewPack1.setViewClass(TextView.class);

        ViewPack viewPack2 = new ViewPack();
        viewPack2.setObject(hero.getRealName());
        viewPack2.setResource(R.id.tvHeroRealName);
        viewPack2.setViewClass(TextView.class);

        ViewPack viewPack3 = new ViewPack();
        viewPack3.setObject(hero.getPhoto());
        viewPack3.setResource(R.id.ivHeroAvatar);
        viewPack3.setViewClass(ImageView.class);

        List<ViewPack> lstViewPack = new ArrayList<>();
        lstViewPack.add(viewPack1);
        lstViewPack.add(viewPack2);
        lstViewPack.add(viewPack3);

        setLstViewPack(lstViewPack);

    }
}
