package com.example.listviewdemo;

import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.telephony.mbms.StreamingServiceInfo;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView grocery, price;
    EditText gro, prc;
    ArrayList<String> groceryItemList = new ArrayList<String>();
    ArrayList<String> priceList = new ArrayList<String>();
    ArrayAdapter<String> groadapter;
    ArrayAdapter<String> prcadapter;
    float s = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        grocery = (ListView) findViewById(R.id.grocery);
        price = (ListView) findViewById(R.id.price);
        gro = (EditText) findViewById(R.id.groceryName);
        prc = (EditText) findViewById(R.id.priceName);
        groadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, groceryItemList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };


        prcadapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, priceList) {

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View view = super.getView(position, convertView, parent);

                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.WHITE);

                return view;
            }
        };
        grocery.setAdapter(groadapter);
        price.setAdapter(prcadapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void total() {
        for (String x : priceList) {
            s = s + Float.parseFloat(x);
            //String z=Float.toString(s);
            //Toast.makeText(this,"The total price is:"+z,Toast.LENGTH_LONG).show();
        }
        String z = Float.toString(s);
        Toast.makeText(this, "The total price is:" + z, Toast.LENGTH_LONG).show();
        s = 0;
        //Log.i("heey",z);

    }

    public void addClicked(View view) {
        if (gro.getText().toString().isEmpty() || prc.getText().toString().isEmpty())
        {Toast.makeText(this, "Invalid Entry:Blank entries not allowed.", Toast.LENGTH_SHORT).show();

        }
        else {
            groceryItemList.add(gro.getText().toString());
            priceList.add(prc.getText().toString());

            grocery.setAdapter(groadapter);
            price.setAdapter(prcadapter);
            total();
        }


    }
}
