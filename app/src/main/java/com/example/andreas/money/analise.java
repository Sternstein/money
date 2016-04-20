package com.example.andreas.money;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class analise extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgraf, imtab;
    Button btest;

    public String [] kat = new String[10];
    public String [] amount = new String[10];
    public String cc;
    public int cq, i;
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    TextView txSh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        imtab = (ImageButton) findViewById(R.id.imtabl);
        imgraf = (ImageButton) findViewById(R.id.imgraf);
        btest = (Button) findViewById(R.id.btest);


        imgraf.setOnClickListener(this);
        imtab.setOnClickListener(this);
        btest.setOnClickListener(this);

        txSh = (TextView) findViewById(R.id.textView3);



        mDatabaseHelper = new DatabaseHelper(this , "mydatabase.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        columns = new String[]{DatabaseHelper.CATEGORY_COLUMN,
                "sum(ammount) as ammount"};

        groupBy = "category";
        orderBy = "ammount";


        Cursor cursor = mSqLiteDatabase.query(mDatabaseHelper.DATABASE_TABLE, columns,
                selection, selectionArgs,
                groupBy, having, orderBy) ;

        i = 0;


        while (cursor.moveToNext()) {


            String categ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CATEGORY_COLUMN));
            String ammo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.AMMOUNT_COLUMN));
            kat[i] = categ;
            amount[i] = ammo;
            i++;


        }
        int c = cursor.getCount();
        cc = String.valueOf(c);

        cursor.close();
        txSh.setText(cc);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.imgraf:
                Intent intent = new Intent(this, Grafik.class);
                Bundle ka = new Bundle();
                ka.putStringArray ("kate",kat);
                ka.putStringArray ("ame",amount);
                intent.putExtras(ka);
                intent.putExtra("co", cc);
                startActivity(intent);

                break;

            case R.id.imtabl:
                Intent intent2 = new Intent(this, tablea.class);
                startActivity(intent2);

                break;

            case R.id.btest:
                Intent intent3 = new Intent(this, List.class);
                Bundle ka3 = new Bundle();
                ka3.putStringArray ("kate",kat);
                ka3.putStringArray ("ame",amount);
                intent3.putExtras(ka3);
                intent3.putExtra("co", cc);
                startActivity(intent3);

                break;



            default:
                break;
    }
    }
}



