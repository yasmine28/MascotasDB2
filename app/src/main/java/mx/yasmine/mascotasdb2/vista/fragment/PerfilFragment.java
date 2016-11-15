package mx.yasmine.mascotasdb2.vista.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.adapter.MascotaFavAdapter;
import mx.yasmine.mascotasdb2.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView listaFotosFav;
    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
                       {


        View v = inflater.inflate(R.layout.fragment_perfil,container,false);
        listaFotosFav = (RecyclerView) v.findViewById(R.id.rvPerfilFav);


      //final   LinearLayoutManager llmanager = new LinearLayoutManager(getContext());
        //llmanager.setOrientation(LinearLayoutManager.VERTICAL);

      //  listaFotosFav.setLayoutManager(llmanager);
       GridLayoutManager llmanager = new GridLayoutManager(getContext(),3);


        listaFotosFav.setLayoutManager(llmanager);

        inicializarListaMascotas();
        inicializarAdaptador();

        //listaContactos.setLayoutManager(glm);
        // Inflate the layout for this fragment
        return v;
    }
    public void inicializarAdaptador(){
        MascotaFavAdapter adaptador = new MascotaFavAdapter(mascotas, getActivity());
        listaFotosFav.setAdapter(adaptador);


    }
    public void  inicializarListaMascotas() {
        mascotas = new ArrayList<>();
        mascotas.add(new Mascota("Lula1", "gato", R.drawable.gato1,1));
        mascotas.add(new Mascota("Lula2", "gato", R.drawable.gato1,5));
        mascotas.add(new Mascota("Lula3", "gato",  R.drawable.gato1,2));
        mascotas.add(new Mascota("Lula4", "perro",  R.drawable.gato1,4));
        mascotas.add(new Mascota("Lula5", "gato",  R.drawable.gato1,0));
        mascotas.add(new Mascota("lula6", "perro",  R.drawable.gato1,5));
    }

}
