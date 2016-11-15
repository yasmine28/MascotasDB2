package mx.yasmine.mascotasdb2.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.db.ConstructorFavMascotas;
import mx.yasmine.mascotasdb2.db.ConstructorMascotas;
import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.vista.fragment.IFavouritesView;
import mx.yasmine.mascotasdb2.vista.fragment.IRecyclerViewFragmentView;

/**
 * Created by Yasmine on 15/11/2016.
 */

public  class FavouritesPresenter implements IFavouritesPresenter{

    private IFavouritesView iFavouritesView;
    private Context context;
    private ConstructorFavMascotas constructorFavMascotas;
    private ArrayList<Mascota> mascotas;

    public FavouritesPresenter(IFavouritesView iFavouritesView, Context context) {
        this.iFavouritesView=iFavouritesView;
        this.context = context;
        obtenerMascotasFavBD();
    }

    @Override
    public void obtenerMascotasFavBD() {
        constructorFavMascotas = new ConstructorFavMascotas(context);
        mascotas = constructorFavMascotas.obtenerMascotasFav();
        mostrarMascotasFavRV();

    }

    @Override
    public void mostrarMascotasFavRV() {
        iFavouritesView.inicializarAdaptadorFavRV(iFavouritesView.crearAdaptadorFav(mascotas));
        iFavouritesView.generarLinearLayoutVerticalFav();;
    }
}

