package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button  btnListen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        event();
    }

    private void event() {
        btnListen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScreenShotListenManager manager = ScreenShotListenManager.newInstance(getApplicationContext());
                manager.setListener(
                        new ScreenShotListenManager.OnScreenShotListener() {
                            public void onShot(String imagePath) {
                                // do something
                                Log.d("工aaaaaaaa", imagePath);
                            }
                        }
                );
                manager.startListen();

            }
        });
    }

    private void initView() {
        btnListen = findViewById(R.id.btn_listen);

    }
}
