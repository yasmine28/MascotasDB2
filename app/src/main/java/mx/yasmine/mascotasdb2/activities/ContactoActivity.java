package mx.yasmine.mascotasdb2.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import mx.yasmine.mascotasdb2.pojo.Contacto;
import mx.yasmine.mascotasdb2.R;


public class ContactoActivity extends AppCompatActivity {
    private EditText name;
    private EditText email;
    private EditText comentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);





        Button enviar =(Button)findViewById(R.id.enviar_button);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name=(EditText) findViewById(R.id.complete_name);
                email=(EditText) findViewById(R.id.ftm_email);
                comentario=(EditText) findViewById(R.id.ftm_mensaje);

                final Contacto contacto = new Contacto(name.getText().toString(),email.getText().toString(),comentario.getText().toString());
                System.out.println("EMAIL" + contacto.getEmail());
                System.out.println("NOMBRE" + contacto.getName());
                Toast.makeText(ContactoActivity.this,contacto.getEmail(), Toast.LENGTH_SHORT).show();
                Intent intent =new Intent(ContactoActivity.this,MailConfirmActivity.class);
                intent.putExtra("CONTACTO", contacto);

               startActivity(intent);
                finish();


            }
        });



    }
}
