package mx.yasmine.mascotasdb2.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.yasmine.mascotasdb2.pojo.Mascota;
import mx.yasmine.mascotasdb2.R;

/**
 * Created by Yasmine on 27/10/2016.
 */

public class MascotaFavAdapter extends RecyclerView.Adapter<MascotaFavAdapter.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaFavAdapter(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;

    }
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cv_mascotas_fav,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MascotaViewHolder holder, int position) {
        final Mascota m = mascotas.get(position);
        holder.imgFoto.setImageResource(m.getFoto());
       holder.tvNombreCV.setText(m.getNombre());
        holder.tvTipoCV.setText(m.getTipo());
        holder.tvRaiting.setText("" +m.getLikes());


     /*   holder.imgFoto.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(activity, m.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity, Mascota.class);
                intent.putExtra("nombre",m.getNombre());
                intent.putExtra("tipo",m.getTipo());

                activity.startActivity(intent);
            }
        });*/

        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity,"Diste Like a " + m.getNombre(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgFoto;
        private TextView tvNombreCV;
        private TextView tvTipoCV;
        private ImageButton btnLike;
        private TextView tvRaiting;


        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView)itemView.findViewById(R.id.imgFoto);
            tvNombreCV = (TextView)itemView.findViewById(R.id.tvNombreCV);
            tvTipoCV =(TextView)itemView.findViewById(R.id.tvTipoCV);
            tvRaiting=(TextView)itemView.findViewById(R.id.tvRaitingCV);
            btnLike = (ImageButton)itemView.findViewById(R.id.btnLike);

        }
    }
}
