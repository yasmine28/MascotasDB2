package mx.yasmine.mascotasdb2.vista.fragment;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.adapter.MascotaAdapter;
import mx.yasmine.mascotasdb2.pojo.Mascota;

/**
 * Created by Yasmine on 14/11/2016.
 */

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> alm);
    public void inicializarAdaptadorRV(MascotaAdapter ma);
}
