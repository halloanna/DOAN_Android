package com.manager.doan_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        //thanh navigation
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_menu_tong_quat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_tong_quat:
                        Intent intentHome=new Intent(getApplicationContext(),activity_tongquat.class);
                        startActivity(intentHome);
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

                        break;
                }
                return true;
            }
        });
        //-------------------------------------
    }
}
