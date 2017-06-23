package com.example.franalterados.marvelheros;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.franalterados.marvelheros.model.Hero;
import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {


    @Bind(R.id.tvHeroName)
    TextView tvHeroName;

    @Bind(R.id.tvHeroRealName)
    TextView tvHeroRealName;

    @Bind(R.id.ivHeroAvatar)
    ImageView ivHeroAvatar;

    @Bind(R.id.tvHeroPower)
    TextView tvHeroPower;

    @Bind(R.id.tvHeroAbilities)
    TextView tvHeroAbilities;

    @Bind(R.id.tvHeroGroups)
    TextView tvHeroGroups;

    @Bind(R.id.tvHeroHeight)
    TextView tvHeroHeight;

    Hero hero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ButterKnife.bind(this);
        hero = (Hero) getIntent().getExtras().getSerializable("hero");
        setData();
    }

    private void setData() {
        tvHeroName.setText(hero.getName());
        tvHeroRealName.setText(hero.getRealName());
        tvHeroPower.setText(hero.getPower());
        tvHeroAbilities.setText(hero.getAbilities());
        tvHeroGroups.setText(hero.getGroups());
        tvHeroHeight.setText(hero.getHeight());

        Picasso.with(this).load(hero.getPhoto()).into(ivHeroAvatar);
    }
}
