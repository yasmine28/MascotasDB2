package mx.yasmine.mascotasdb2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.MainActivity;
import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.adapter.MascotaAdapter;
import mx.yasmine.mascotasdb2.R;
import mx.yasmine.mascotasdb2.presentador.FavouritesPresenter;
import mx.yasmine.mascotasdb2.presentador.IFavouritesPresenter;
import mx.yasmine.mascotasdb2.presentador.RecyclerViewFragmentPresenter;
import mx.yasmine.mascotasdb2.vista.fragment.IFavouritesView;


public class FavouritesActivity extends AppCompatActivity implements IFavouritesView{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IFavouritesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favourites);
        listaMascotas = (RecyclerView)findViewById(R.id.rvMascotas);
        Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);

        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter = new FavouritesPresenter(this,getBaseContext());


    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if(keyCode== KeyEvent.KEYCODE_BACK){
            Intent intent = new Intent(FavouritesActivity.this, MainActivity.class);
            startActivity(intent);
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void generarLinearLayoutVerticalFav() {
        LinearLayoutManager llmanager = new LinearLayoutManager(this);
        llmanager.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llmanager);
    }

    @Override
    public MascotaAdapter crearAdaptadorFav(ArrayList<Mascota> alm) {
        MascotaAdapter adaptador = new MascotaAdapter(alm, this);
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorFavRV(MascotaAdapter ma) {
              listaMascotas.setAdapter(ma);

    }
}
