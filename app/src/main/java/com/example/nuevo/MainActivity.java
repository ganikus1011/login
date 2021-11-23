package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public MainActivity() {
        super();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
       getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }
    public void gotoActivity(View view){
        Intent newIntent = new Intent( this, marco2.class);
        newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
         startActivity(newIntent);
             }
    public boolean onOptionsItemSelected(MenuItem menuItem){
        int id = menuItem.getItemId();
          if(id == R.id.menu_lluvia){
              Intent newIntent = new Intent(this, marco2.class);
              newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(newIntent);
          }
          else if(id == R.id.menu_actividad){
              Intent newIntent = new Intent(this, marco3.class);
              newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(newIntent);
          }
          else if(id == R.id.menu_login){
              Intent newIntent = new Intent(this, Login.class);
              newIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
              startActivity(newIntent);
          }
        return super.onOptionsItemSelected(menuItem);
    }

}