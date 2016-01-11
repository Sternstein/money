package com.example.andreas.money;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgPlus, imgMinus, imgGra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgPlus = (ImageButton) findViewById(R.id.imgPlus);
        imgMinus = (ImageButton) findViewById(R.id.imgMinus);
        imgGra = (ImageButton) findViewById(R.id.imgGra);

        imgPlus.setOnClickListener(this);
        imgGra.setOnClickListener(this);
        imgMinus.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imgMinus:
                Intent intent = new Intent(this, AusActivity.class);
                startActivity(intent);

                break;
            case R.id.imgPlus:
                Intent intent2 = new Intent(this, EinActivity.class);
                startActivity(intent2);

                break;
            case R.id.imgGra:
                Intent intent3 = new Intent(this, analise.class);
                startActivity(intent3);

                break;

            default:
                break;

        }
    }
}
