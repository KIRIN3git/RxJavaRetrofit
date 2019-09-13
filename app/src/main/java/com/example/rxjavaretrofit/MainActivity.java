package com.example.rxjavaretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView name_text = (TextView) findViewById(R.id.name_text);
        TextView language_text = (TextView) findViewById(R.id.language_text);
        TextView description_text = (TextView) findViewById(R.id.description_text);
        TextView url_text = (TextView) findViewById(R.id.url_text);


        Response<List<ResponseData>> response = ApiClient.fetchResponsLit();
        Log.w("DEBUG_DATA","xxxxxxxxxxxxxxxxxxxx");
/*
        Handler handler = new Handler();


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Response<List<ResponseData>> response = ApiClient.fetchResponsLit();

                List<ResponseData> data = response.body();

                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        StringBuilder all_text = new StringBuilder();
                        for(int i = 0; i < data.size(); i++){
                            all_text.append(data.get(i).name).append("\n");
                        }

                        name_text.setText(data.get(0).name);
                        language_text.setText(all_text);
                        description_text.setText(data.get(0).description);
                        url_text.setText(data.get(0).url);
                    }
                });


            }
        });
        thread.start();
 */
    }
}
