package com.example.andreas.money;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class analise extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgraf, imtab;

    public String [] kat = new String[10];
    public String [] amount = new String[10];

    public int CoC, i;
    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analise);

        imtab = (ImageButton) findViewById(R.id.imtabl);
        imgraf = (ImageButton) findViewById(R.id.imgraf);


        imgraf.setOnClickListener(this);
        imtab.setOnClickListener(this);


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
        CoC = cursor.getCount();
        cursor.close();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.imgraf:
                Intent intent = new Intent(this, Grafik.class);
                Bundle ka = new Bundle();
                ka.putStringArray ("kate",new String[]{kat[0],kat[1],kat[2],kat[3],kat[4],kat[5]});
                ka.putStringArray ("ame",new String[]{amount[0],amount[1],amount[2],amount[3],amount[4],amount[5]});
                intent.putExtras(ka);
                intent.putExtra("co", CoC);
                startActivity(intent);

                break;

            case R.id.imtabl:
                Intent intent2 = new Intent(this, tablea.class);
                startActivity(intent2);

                break;



            default:
                break;
    }
    }
}



