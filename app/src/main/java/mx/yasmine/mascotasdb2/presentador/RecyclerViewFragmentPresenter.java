package mx.yasmine.mascotasdb2.presentador;

import android.content.Context;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.db.ConstructorMascotas;
import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.vista.fragment.IRecyclerViewFragmentView;

/**
 * Created by Yasmine on 14/11/2016.
 */

public class RecyclerViewFragmentPresenter implements IRecyclerViewFragmentPresenter {

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;

    public RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context) {
        this.iRecyclerViewFragmentView=iRecyclerViewFragmentView;
        this.context = context;
        obtenerMascotasBD();
    }


    @Override
    public void obtenerMascotasBD() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostrarMascotasRV();


    }

    @Override
    public void mostrarMascotasRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV(iRecyclerViewFragmentView.crearAdaptador(mascotas));
        iRecyclerViewFragmentView.generarLinearLayoutVertical();


    }
}
