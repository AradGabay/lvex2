package com.example.lvex2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;



import java.util.List;


public class countryinfo extends AppCompatActivity implements AdapterView.OnItemClickListener {



    String[] country;

    String[][]Capitals ={
            {"Washington","Ottawa","Mexico City","Buenos Aires","Bogota","Brasilia","Santiago"},
            {"London","Paris","Berlin","Rome","Madrid","Athens","Varsha"},
            {"Beijing","Tokyo","Tel Aviv","New Delhi","Singapore","Bangkok","Damascus"},
            {"Harara","Campala","Abuja","Rabbat","Hartum","Addis Ababa","Antananarivo"}};

    String[][]Population ={
            {"327.2M","37.06M","273M","340M","440M","330M","220M"},
            {"120M","516.02M","153.33M","164.27M","852.2M","220.5M","120.5M"},
            {"1.330B","126,8M","10M","990M","47M","170M","300M"},
            {"52M","211M","223M","83M","216M","512M","70M"}};

    int a2;
    ArrayAdapter<String>adp2;
    ListView lv2;
    TextView tv1,tv2;
    Intent t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_countryinfo);

        tv1 = findViewById(R.id.CC);
        tv2 = findViewById(R.id.pop);
        lv2 = findViewById(R.id.lv2);

        t2 = getIntent();
        a2 = t2.getIntExtra("placement",-1);
        country = t2.getStringArrayExtra("countries");
        adp2 = new ArrayAdapter<String>(this,R.layout.support_simple_spinner_dropdown_item,country);

        lv2.setOnItemClickListener(this);
        lv2.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv2.setAdapter(adp2);

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        tv1.setText("Capital City: "+Capitals[a2][position]);
        tv2.setText("Population: "+Population[a2][position]);


    }


    public void back(View view) {
        finish();

    }

}