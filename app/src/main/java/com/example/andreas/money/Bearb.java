package com.example.andreas.money;


import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Bearb extends AppCompatActivity implements View.OnClickListener {

    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;
    public String kat;
    int DIALOG_DATE = 1;



    int Year;
    int Month;
    int Day;

    Button inp;
    TextView txV;
    EditText date;
    EditText amm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bearb);

        mDatabaseHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);
        final Calendar c = Calendar.getInstance();
        DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
        String datet = df.format(c.getTime());


        Year = c.get(Calendar.YEAR);
        Month = c.get(Calendar.MONTH);
        Day = c.get(Calendar.DAY_OF_MONTH);







        txV = (TextView) findViewById(R.id.txV);
        inp = (Button) findViewById(R.id.button7);
        date = (EditText) findViewById(R.id.editText);
        amm = (EditText) findViewById(R.id.editText2);



        Intent intent = getIntent();
        kat = intent.getStringExtra("f");
        txV.setText("Категория: " + kat);
        date.setText(datet);


        View.OnClickListener dat = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(DIALOG_DATE);
            }
        };



        date.setOnClickListener(dat);
        inp.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();
        String da=date.getText().toString();
        String am=amm.getText().toString();


        ContentValues newValues = new ContentValues();
        // Задайте значения для каждого столбца
        newValues.put(DatabaseHelper.CATEGORY_COLUMN, kat);
        newValues.put(DatabaseHelper.DATE_COLUMN, da);
        newValues.put(DatabaseHelper.AMMOUNT_COLUMN, am );
        // Вставляем данные в таблицу
        mSqLiteDatabase.insert("money", null, newValues);

        mDatabaseHelper.close();

        Intent inte;
        inte = new Intent(this, AusActivity.class);
        startActivity(inte);
    }

    protected Dialog onCreateDialog(int id) {
        if (id == DIALOG_DATE) {
            DatePickerDialog tpd = new DatePickerDialog(this, myCallBack, Year, Month, Day);
            return tpd;
        }
        return super.onCreateDialog(id);
    }

    DatePickerDialog.OnDateSetListener myCallBack = new DatePickerDialog.OnDateSetListener() {

        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            Year = year;
            Month = monthOfYear;
            Day = dayOfMonth;
            Date d = new Date(Year - 1900,Month,Day);
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            String strDate = df.format(d);
            date.setText(strDate);
        }
    };



}
