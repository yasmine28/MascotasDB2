package mx.yasmine.mascotasdb2.vista.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.adapter.MascotaAdapter;
import mx.yasmine.mascotasdb2.R;
import mx.yasmine.mascotasdb2.presentador.IRecyclerViewFragmentPresenter;
import mx.yasmine.mascotasdb2.presentador.RecyclerViewFragmentPresenter;


public class HomeFragment extends Fragment implements IRecyclerViewFragmentView{
    ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IRecyclerViewFragmentPresenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home,container,false);
        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);
        presenter = new RecyclerViewFragmentPresenter(this, getContext());
       return v;

    }

    @Override
    public void generarLinearLayoutVertical() {

        LinearLayoutManager llmanager = new LinearLayoutManager(getActivity());
        llmanager.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llmanager);

    }

    @Override
    public MascotaAdapter crearAdaptador(ArrayList<Mascota> alm) {
        MascotaAdapter adaptador = new MascotaAdapter(alm, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter ma) {
        listaMascotas.setAdapter(ma);
    }
}

