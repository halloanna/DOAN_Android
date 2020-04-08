package com.manager.doan_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.anychart.AnyChart;
import com.anychart.AnyChartView;
import com.anychart.chart.common.dataentry.DataEntry;
import com.anychart.chart.common.dataentry.ValueDataEntry;
import com.anychart.charts.Pie;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class activity_tongquat extends AppCompatActivity {
    AnyChartView bieu_do_thu_chi;
    String[] months = {"1" , "2" , "3" , "4" , "5" , "6" , "7" , "8" , "9" , "10" , "11" , "12" };
    int[] earings = {600, 900, 10000 , 700 ,600 ,1200 ,45000 ,38458 ,69696 ,86969 ,38382 ,3823456};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tongquat);


        bieu_do_thu_chi = findViewById(R.id.bieu_do_thu_chi);
        setupPiechart();
        //thanh navigation
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_menu_tong_quat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_tong_quat:
                        Intent tongquat = new Intent(getApplicationContext(),activity_tongquat.class);
                        startActivity(tongquat);
                        break;
                    case R.id.nav_bao_cao:
                        Intent baocao = new Intent(getApplicationContext(),bao_cao.class);
                        startActivity(baocao);
                        break;
                    case R.id.nav_them_tien_chi:
                        Intent intentTemTienChi = new Intent(getApplicationContext(),activity_themmoi.class);
                        startActivity(intentTemTienChi);
                        break;
                    case R.id.setting:
                        Intent setting = new Intent(getApplicationContext(), setting.class);
                        startActivity(setting);
                        break;
                }
                return true;
            }
        });
        //-------------------------------------
    }
    public void  setupPiechart(){
        Pie pie = AnyChart.pie();
        List<DataEntry> dataEntries = new ArrayList<>();

        for (int i = 0; i < months.length; i++){
            dataEntries.add(new ValueDataEntry(months[i], earings[i]));
        }
        pie.data(dataEntries);
        bieu_do_thu_chi.setChart(pie);
    }
}
