package mx.yasmine.mascotasdb2;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;



import java.util.ArrayList;

import mx.yasmine.mascotasdb2.adapter.FragmentAdapter;
import mx.yasmine.mascotasdb2.vista.fragment.HomeFragment;
import mx.yasmine.mascotasdb2.vista.fragment.PerfilFragment;
import mx.yasmine.mascotasdb2.activities.AboutActivity;
import mx.yasmine.mascotasdb2.activities.ContactoActivity;
import mx.yasmine.mascotasdb2.activities.FavouritesActivity;

public class MainActivity extends AppCompatActivity {




    private Toolbar toolBar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    Activity favActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        toolBar = (Toolbar) findViewById(R.id.miActionBar);
        tabLayout = (TabLayout)findViewById(R.id.tabLayout);
        viewPager = (ViewPager)findViewById(R.id.vPager);
        setUpViewPager();
        if(toolBar != null){
            setSupportActionBar(toolBar );

        }




      //  Toolbar miActionBar = (Toolbar)findViewById(R.id.miActionBar);
     // setSupportActionBar(miActionBar);

        ImageView favoritosImg = (ImageView)findViewById(R.id.imgFav);


       favoritosImg.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "Mascotas Favoritas!!!",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, FavouritesActivity.class);

               startActivity(intent);
            }
        });
    }


    private ArrayList<Fragment> agregarFragments(){
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new HomeFragment());
        fragments.add(new PerfilFragment());
        return fragments;
    }
    private void setUpViewPager(){
        viewPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(),agregarFragments()) );
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.mipmap.ic_home);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_cat_perfil);



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.mAbout:
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;
            case R.id.mContacto:
                Intent intent2 = new Intent(this, ContactoActivity.class);
                startActivity(intent2);

                break;
        }
        return super.onOptionsItemSelected(item);
    }



    public void IrSegundaActividad(){
        Intent intent =new Intent(this,FavouritesActivity.class);
        startActivity(intent);
    }
}
