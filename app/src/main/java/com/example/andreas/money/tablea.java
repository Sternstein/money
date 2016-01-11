package com.example.andreas.money;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class tablea extends AppCompatActivity {

    private DatabaseHelper mDatabaseHelper;
    private SQLiteDatabase mSqLiteDatabase;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablea);


        TableLayout table = new TableLayout(this);

        table.setStretchAllColumns(true);
        table.setShrinkAllColumns(true);

        TableRow rowTitle = new TableRow(this);
        rowTitle.setGravity(Gravity.CENTER_HORIZONTAL);



        TableRow rowPar = new TableRow(this);





        // title column/row
        TextView title = new TextView(this);
        title.setText("Бабло");

        title.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
        title.setGravity(Gravity.CENTER);
        title.setTypeface(Typeface.SERIF, Typeface.BOLD);

        TableRow.LayoutParams params = new TableRow.LayoutParams();
        params.span = 3;

        rowTitle.addView(title, params);

        TextView catLabel = new TextView(this);
        catLabel.setText("Категория");
        catLabel.setTypeface(Typeface.DEFAULT_BOLD);
        catLabel.setGravity(Gravity.CENTER_HORIZONTAL);

        rowPar.addView(catLabel);

        TextView datLabel = new TextView(this);
        datLabel.setText("Дата");
        datLabel.setTypeface(Typeface.DEFAULT_BOLD);
        datLabel.setGravity(Gravity.CENTER_HORIZONTAL);

        rowPar.addView(datLabel);

        TextView ammLabel = new TextView(this);
        ammLabel.setText("Сумма, руб");
        ammLabel.setTypeface(Typeface.DEFAULT_BOLD);
        ammLabel.setGravity(Gravity.CENTER_HORIZONTAL);

        rowPar.addView(ammLabel);






        table.addView(rowTitle);
        table.addView(rowPar);

        mDatabaseHelper = new DatabaseHelper(this, "mydatabase.db", null, 1);
        mSqLiteDatabase = mDatabaseHelper.getWritableDatabase();

        String[] columns = null;
        String selection = null;
        String[] selectionArgs = null;
        String groupBy = null;
        String having = null;
        String orderBy = null;

        columns = new String[]{DatabaseHelper.CATEGORY_COLUMN,
                DatabaseHelper.DATE_COLUMN, DatabaseHelper.AMMOUNT_COLUMN};


        orderBy = "category";


        Cursor cursor = mSqLiteDatabase.query(mDatabaseHelper.DATABASE_TABLE, columns,
                selection, selectionArgs,
                groupBy, having, orderBy) ;


        while (cursor.moveToNext()){
            String categ = cursor.getString(cursor.getColumnIndex(DatabaseHelper.CATEGORY_COLUMN));
            String data = cursor.getString(cursor.getColumnIndex(DatabaseHelper.DATE_COLUMN));
            String ammo = cursor.getString(cursor.getColumnIndex(DatabaseHelper.AMMOUNT_COLUMN));

            TableRow rowDatei = new TableRow(this);

            TextView cateLabel = new TextView(this);
            cateLabel.setText(categ);
            cateLabel.setTypeface(Typeface.DEFAULT_BOLD);
            cateLabel.setGravity(Gravity.CENTER_HORIZONTAL);

            TextView dtLabel = new TextView(this);
            dtLabel.setText(data);
            dtLabel.setTypeface(Typeface.DEFAULT_BOLD);
            dtLabel.setGravity(Gravity.CENTER_HORIZONTAL);

            TextView amLabel = new TextView(this);
            amLabel.setText(ammo);
            amLabel.setTypeface(Typeface.DEFAULT_BOLD);
            amLabel.setGravity(Gravity.CENTER_HORIZONTAL);

            rowDatei.addView(cateLabel);
            rowDatei.addView(dtLabel);
            rowDatei.addView(amLabel);

            table.addView(rowDatei);

        }
        cursor.close();






        setContentView(table);


    }

}
