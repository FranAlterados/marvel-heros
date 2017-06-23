package com.example.franalterados.marvelheros;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.franalterados.marvelheros.business.BusinessCallback;
import com.example.franalterados.marvelheros.business.HeroController;
import com.example.franalterados.marvelheros.dasrecyclerview.HeroRecyclerView;
import com.example.franalterados.marvelheros.model.Hero;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jfmargar.dasrecyclerview.RecyclerAdapter;
import es.jfmargar.dasrecyclerview.RecyclerItem;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class ListActivity extends AppCompatActivity {

    @Bind(R.id.rvHeros)
    RecyclerView rvHeros;

    List<Hero> lstHeros = new ArrayList<>();
    RecyclerAdapter adapter;
    List<RecyclerItem> lstItem = new ArrayList<>();

    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        initRecyclerView();
        getHeros();
    }

    private void getHeros() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.setTitle("Downloading heros");
        progressDialog.setCancelable(false);
        progressDialog.show();
        HeroController.getAllHeros(new BusinessCallback<List<Hero>>() {
            @Override
            public void success(List<Hero> heros, Response response) {
                lstHeros = heros;
                reloadRecyclerView();
                progressDialog.dismiss();
            }

            @Override
            public void failure(RetrofitError error) {
                Toast.makeText(ListActivity.this, "Connection Error", Toast.LENGTH_SHORT).show();
                progressDialog.dismiss();
            }
        });
    }

    private void reloadRecyclerView() {
        lstItem.clear();
        for (Hero hero : lstHeros) {
            lstItem.add(new HeroRecyclerView(hero));
        }

        adapter.notifyDataSetChanged();
    }

    private void initRecyclerView() {
        rvHeros.setHasFixedSize(true);
        rvHeros.setLayoutManager(new LinearLayoutManager(this));
        RecyclerAdapter.ViewHolder.ClickListener listener = new RecyclerAdapter.ViewHolder.ClickListener() {
            @Override
            public void onClick(View v, int position, boolean isLongClick) {
                Hero hero = lstHeros.get(position);
                clickHero(hero);
            }
        };

        adapter = new RecyclerAdapter(lstItem, R.layout.cardview_hero, this);
        adapter.setClickListener(listener);
        rvHeros.setAdapter(adapter);
    }

    private void clickHero(Hero hero) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("hero", hero);
        startActivity(intent);
    }


}
