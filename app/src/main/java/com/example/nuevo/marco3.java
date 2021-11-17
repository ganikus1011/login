package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

public class marco3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marco3);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
    public void ActivityMain(View vie){
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

}