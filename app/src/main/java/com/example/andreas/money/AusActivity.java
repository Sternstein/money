package com.example.andreas.money;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AusActivity extends AppCompatActivity implements View.OnClickListener {

    public String val;
    Button bak;
    ImageButton baus1, baus2, baus3, baus4, baus5, baus6, baus7, baus8, baus9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aus);

        baus1 = (ImageButton) findViewById(R.id.imagefood);
        baus2 = (ImageButton) findViewById(R.id.imagealco);
        baus3 = (ImageButton) findViewById(R.id.imagerest);
        baus4 = (ImageButton) findViewById(R.id.imageparf);
        baus5 = (ImageButton) findViewById(R.id.imagechem);
        baus6 = (ImageButton) findViewById(R.id.imageclo);
        baus7 = (ImageButton) findViewById(R.id.imagepet);
        baus8 = (ImageButton) findViewById(R.id.imagetran);
        baus9 = (ImageButton) findViewById(R.id.imagehome);

        bak = (Button) findViewById(R.id.bback);
        baus1.setOnClickListener(this);
        baus2.setOnClickListener(this);
        baus3.setOnClickListener(this);
        baus4.setOnClickListener(this);
        baus5.setOnClickListener(this);
        baus6.setOnClickListener(this);
        baus7.setOnClickListener(this);
        baus8.setOnClickListener(this);
        baus9.setOnClickListener(this);
        bak.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.imagefood:
                val = getString(R.string.aus1);
                Intent intent = new Intent(this, Bearb.class);
                intent.putExtra("f", val);
                startActivity(intent);

                break;
            case R.id.imagealco:
                val = getString(R.string.aus2);
                Intent intent2 = new Intent(this, Bearb.class);
                intent2.putExtra("f", val);
                startActivity(intent2);

                break;
            case R.id.imagerest:
                val = getString(R.string.aus3);
                Intent intent3 = new Intent(this, Bearb.class);
                intent3.putExtra("f", val);
                startActivity(intent3);

                break;

            case R.id.imageparf:
                val = getString(R.string.aus4);
                Intent intent4 = new Intent(this, Bearb.class);
                intent4.putExtra("f", val);
                startActivity(intent4);

                break;

            case R.id.imagechem:
                val = getString(R.string.aus5);
                Intent intent5 = new Intent(this, Bearb.class);
                intent5.putExtra("f", val);
                startActivity(intent5);

                break;
            case R.id.imageclo:
                val = getString(R.string.aus6);
                Intent intent6 = new Intent(this, Bearb.class);
                intent6.putExtra("f", val);
                startActivity(intent6);

                break;



            case R.id.bback:
                Intent intent7 = new Intent(this, MainActivity.class);
                startActivity(intent7);

                break;

            case R.id.imagepet:
                val = getString(R.string.aus7);
                Intent intent8 = new Intent(this, Bearb.class);
                intent8.putExtra("f", val);
                startActivity(intent8);

                break;

            case R.id.imagetran:
                val = getString(R.string.aus8);
                Intent intent9 = new Intent(this, Bearb.class);
                intent9.putExtra("f", val);
                startActivity(intent9);

                break;

            case R.id.imagehome:
                val = getString(R.string.aus9);
                Intent intent10 = new Intent(this, Bearb.class);
                intent10.putExtra("f", val);
                startActivity(intent10);

                break;




            default:
                break;

        }
    }

}
