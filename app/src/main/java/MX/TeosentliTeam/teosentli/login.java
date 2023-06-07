package MX.TeosentliTeam.teosentli;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.concurrent.TimeUnit;

public class login extends AppCompatActivity {

    FirebaseDatabase DB;
    DatabaseReference DBReference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Splash);
        super.onCreate(savedInstanceState);
        try {
            TimeUnit.SECONDS.sleep(5);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        setTheme(R.style.Theme_Teosentli);
        setContentView(R.layout.activity_login);

    }

    public void auth(View view) {
        Toast.makeText(this,"Autenticando",Toast.LENGTH_SHORT).show();
        activarFirebase();
        EditText mail= findViewById(R.id.mailInput);
        EditText pass= findViewById(R.id.passlogin);
       if(verificarUsuario(mail.getText().toString(),pass.getText().toString())){
           //Toast.makeText(login.this ,"Login Success",Toast.LENGTH_SHORT).show();

       }else{
           Toast.makeText(this,"Usuario no encontrado",Toast.LENGTH_SHORT).show();
       }

    }

    private boolean verificarUsuario(String mail,String pass) {

    DBReference.child("Usuario").addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot snapshot) {
            for (DataSnapshot objSnapShot : snapshot.getChildren()){
                usuario us = objSnapShot.getValue(usuario.class);
                //Toast.makeText(login.this,mail+"|"+us.getMail()+"|"+pass+"|"+us.getPass(),Toast.LENGTH_SHORT).show();
                if(us.getMail().equalsIgnoreCase(mail) && us.getPass().equalsIgnoreCase(pass)){
                    Intent intent = new Intent(login.this, MainActivity.class);
                    startActivity(intent);
                }else {Toast.makeText(login.this,"Auth problem",Toast.LENGTH_SHORT).show();}
            }
        }

        @Override
        public void onCancelled(@NonNull DatabaseError error) {

        }
    });
    return  true;//correctauth[0];
    }

    private void activarFirebase() {
        FirebaseApp.initializeApp(login.this);
        DB= FirebaseDatabase.getInstance();
        DBReference= DB.getReference();
    }

    public void goRegistro(View view) {
        Intent intent = new Intent(this, registro.class);
        startActivity(intent);
    }
}