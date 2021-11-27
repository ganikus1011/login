package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class marco3 extends AppCompatActivity {
    private EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marco3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        et1 = (EditText) findViewById(R.id.c_entrada);
    }
    public void ActivityMain(View view){
        Intent newIntent = new Intent(  this, MainActivity.class);
        startActivity(newIntent);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    }
    public void onBackPressed(){
        finish();
    }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
        if(id==android.R.id.home)
            onBackPressed();
        return true;

    }
    public void enviarMensaje(View view){
        String mens = et1.getText().toString();
         FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Mensaje");

        myRef.setValue(mens);
    }
}