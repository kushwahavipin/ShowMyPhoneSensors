package com.e.showmyphonesensors;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
 ListView slist;
 SensorManager sm;
 List<Sensor> los;
 ArrayList<String> name,company;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        slist=findViewById(R.id.slist);
        sm= (SensorManager) getSystemService(SENSOR_SERVICE);
        los=sm.getSensorList(Sensor.TYPE_ALL); /// all the types of sensors /// returns List Sensor
        name=new ArrayList<>();
        company=new ArrayList<>();
        for(int i=0;i<los.size();i++)
        {
            name.add(los.get(i).getName());
            company.add(los.get(i).getVendor());
        }
        ArrayAdapter ad=new ArrayAdapter(this, android.R.layout.simple_list_item_1,name);
        slist.setAdapter(ad);
        slist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, ""+company.get(i), Toast.LENGTH_SHORT).show();
            }
        });







    }
}