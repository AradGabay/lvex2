package com.example.lvex2;

import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;



public class choosecontinet extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] continents = {"America", "Europe", "Asia", "Africa"};
    String[][] Countries =
            {{"United States","Canada","Mexico","Argentina","Colombia","Brazil","Chile"},
            {"United Kingdom","France","Germany","Italy","Spain","Greece","Poland"},
            {"China","Japan","Israel","India","Singapore","Thailand","Syria"},
            {"Zimbabwe","Uganda","Nigeria","Morocco","Sudan","Ethiopia","Madagascar"}};
    ListView lv;
    int a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choosecontinet);

        lv = findViewById(R.id.lv);
        a=-3;

        lv.setOnItemClickListener(this);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, continents);
        lv.setAdapter(adp);
    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this, continents[position], Toast.LENGTH_SHORT).show();
        a=position;

    }



    public void nxt(View view) {
        if(a==-3) Toast.makeText(this, "No Continent Picked", Toast.LENGTH_SHORT).show();

            else{
                Intent t1 = new Intent(this, countryinfo.class);
                t1.putExtra("placement", a);
                t1.putExtra("countries",Countries[a]);
                startActivity(t1);

            }

    }
}