package com.manager.doan_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class bao_cao extends AppCompatActivity {

ListView lv;
DBConnection db;
SimpleCursorAdapter myAdapter;
Button xoaBtn;
    public static ArrayList<TienChi> tienChis;
private static final long id=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bao_cao);
        xoaBtn=findViewById(R.id.imgBtnXoa);
        //thanh navigation
        final BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_menu_tong_quat);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()){
                    case R.id.nav_tong_quat:
                        Intent intentHome=new Intent(getApplicationContext(),activity_tongquat.class);
                        startActivity(intentHome);
                        break;
                    case R.id.nav_bao_cao:
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
        lv=findViewById(R.id.lv);
        db = new DBConnection(this);
        Cursor c = db.getAllInfo();

        String[] from = new String[] {
                "ten","tien","ngay"
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.txtTEN,
                R.id.txtTIEN,
                R.id.txtNGAY
        };
        myAdapter = new SimpleCursorAdapter(this,R.layout.custom_listview_update,c,from,to,0);
        lv.setAdapter(myAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Integer deleteRow= db.deleteData(tienChis.get(position).get_id().toString());
                if(deleteRow>0)
                    Toast.makeText(bao_cao.this,"Đã xóa 1 dòng",Toast.LENGTH_LONG).show();
                else Toast.makeText(bao_cao.this,"Xóa không thành công",Toast.LENGTH_LONG).show();
            }
        });


    }





}
