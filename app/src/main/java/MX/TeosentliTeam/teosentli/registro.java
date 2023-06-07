package MX.TeosentliTeam.teosentli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class registro extends AppCompatActivity {

    FirebaseDatabase DB;
    DatabaseReference DBReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        iniciarFireBase();
    }

    private void iniciarFireBase() {
        FirebaseApp.initializeApp(this);
        DB= FirebaseDatabase.getInstance();
        DBReference= DB.getReference();
    }

    public void registo(View view) {
        usuario Us = new usuario();
        Us.setId("0");
        EditText nombre = findViewById(R.id.nombreinput);
        Us.setnUsusario(nombre.getText().toString());
        EditText mail= findViewById(R.id.mailinput);
        Us.setMail(mail.getText().toString());
        EditText pass = findViewById(R.id.passinput);
        Us.setPass(pass.getText().toString());
        DBReference.child("Usuario").child(Us.getId()).setValue(Us);
        Toast.makeText(this,"Registrado!",Toast.LENGTH_SHORT).show();
    }
}