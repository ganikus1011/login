package com.example.nuevo;

import androidx.appcompat.app.AppCompatActivity;

import android.nfc.Tag;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class conexionbd extends AppCompatActivity {
    private static final String TAG = APIRestActivity.class.getSimpleName();
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_conexionbd);
      et1= findViewById(R.id.entrada_url);
      et2= findViewById(R.id.entrada_clave);
      tv1= findViewById(R.id.caja_texto);
      }
    public void conecta(View view){
        AsyncTask.execute(new Runnable() {

            @Override
            public void run() {
                try {
                    URL guthubEndpoint = new URL(et1.getText().toString());
                    HttpsURLConnection myConnection = (HttpsURLConnection) guthubEndpoint.openConnection();
                    myConnection.setRequestProperty("User-agent", "my-rest-v0.1");
                    if (myConnection.getResponseCode() == 200){
                        Log.e(TAG, "Conexión EXITOSA" );
                        tv1.setText("Se conectó CORRECTAMENTE");
                        InputStream responseBody = myConnection.getInputStream();
                        InputStreamReader responseBodyReader = new InputStreamReader(responseBody,"UTF-8");
                        JsonReader jsonReader = new JsonReader(responseBodyReader);
                        jsonReader.beginObject();
                        while(jsonReader.hasNext()){
                            String key = jsonReader.nextName();
                            if(key.equals(et2.getText().toString())){
                                String value = jsonReader.nextString();
                                tv1.setText(value);
                                break;
                            }
                            else{
                                jsonReader.skipValue();
                            }
                        }
                       }
                    else{
                        Log.e(TAG, "Pailas no hubo conexión" );
                        tv1.setText("Pailas no Se pudo conectar"+myConnection.getResponseCode());
                    }
                } catch (MalformedURLException e) {
                    Log.e(TAG, "MalformedURLException" + e.getMessage());
                } catch (IOException e) {
                    Log.e(TAG, "IOException" + e.getMessage());
                }
            }
        });

    }

}