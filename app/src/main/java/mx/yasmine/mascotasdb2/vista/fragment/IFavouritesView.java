package mx.yasmine.mascotasdb2.vista.fragment;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.adapter.MascotaAdapter;
import mx.yasmine.mascotasdb2.pojo.Mascota;

/**
 * Created by Yasmine on 15/11/2016.
 */

public interface IFavouritesView {
    public void generarLinearLayoutVerticalFav();
    public MascotaAdapter crearAdaptadorFav(ArrayList<Mascota> alm);
    public void inicializarAdaptadorFavRV(MascotaAdapter ma);
}
