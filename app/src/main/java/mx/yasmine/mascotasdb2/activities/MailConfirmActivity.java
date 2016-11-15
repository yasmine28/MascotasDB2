package mx.yasmine.mascotasdb2.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import mx.yasmine.mascotasdb2.pojo.Contacto;
import mx.yasmine.mascotasdb2.R;



public class MailConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail_confirm);




        Bundle bundle = getIntent().getExtras();
        final Contacto r = (Contacto) bundle.getSerializable("CONTACTO");
        Toast.makeText(MailConfirmActivity.this,r.getName(), Toast.LENGTH_SHORT).show();

        Properties props = new Properties();

// Nombre del host de correo, es smtp.gmail.com
        props.setProperty("mail.smtp.host", "smtp.gmail.com");

// TLS si está disponible
        props.setProperty("mail.smtp.starttls.enable", "true");

// Puerto de gmail para envio de correos
        props.setProperty("mail.smtp.port","465");

// Nombre del usuario
        props.setProperty("mail.smtp.user", "yo@yo.com");

// Si requiere o no usuario y password para conectarse.
        props.setProperty("mail.smtp.auth", "true");

                    Session session = Session.getDefaultInstance(props);
        session.setDebug(true);
       final  MimeMessage message = new MimeMessage(session);
        // Quien envia el correo
        try {
            message.setFrom(new InternetAddress("icaro282828@gmail.com"));
            // A quien va dirigido
            message.addRecipient(Message.RecipientType.TO,
                    new InternetAddress(r.getEmail()));
            message.setSubject("Contacto Petagram de"+ r.getName());
            message.setText(r.getNotes() );

           final Transport t = session.getTransport("smtp");

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        t.connect("icaro282828@gmail.com", "pelukas1471");
                        t.sendMessage(message, message.getAllRecipients());
                    } catch (MessagingException e) {
                        e.printStackTrace();
                    }

                }
            }).start();



            // Cierre.
            t.close();


        } catch (MessagingException e) {
            e.printStackTrace();
        }




    }
}
