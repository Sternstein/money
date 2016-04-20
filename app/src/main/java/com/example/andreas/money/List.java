package com.example.andreas.money;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class List extends ListActivity {

    private TextView mTextView;

    public String [] kat = new String[10];
    public String [] amount = new String[10];
    public int [] col = new int[10];
    public String cou;
    public int im;



    String[] mContacts = {
            "Jacob Anderson", "Emily Duncan", "Michael Fuller",
            "Emma Greenman", "Joshua Harrison", "Madison Johnson",
            "Matthew Cotman", "Olivia Lawson", "Andrew Chapman",
            "Daniel Honeyman", "Isabella Jackson", "William Patterson",
            "Joseph Godwin", "Samantha Bush", "Christopher Gateman"};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Intent intent = getIntent();
        Bundle bb = getIntent().getExtras();
        kat = bb.getStringArray("kate");
        amount = bb.getStringArray("ame");
        cou = intent.getStringExtra("co");
        im = Integer.parseInt(cou);

        setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, kat));
        mTextView = (TextView)findViewById(R.id.textSelect);
    }

    public void onListItemClick(
            ListView parent, View v, int position, long id) {
        mTextView.setText(String.format("Select: %s; pos: %s; id: %s", kat[position], position, id));
    }
}