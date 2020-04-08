package com.manager.doan_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.RadioButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class themmoi_tienchi extends AppCompatActivity implements View.OnClickListener {
EditText editTextNgay,editTextNumber;
Button btnThemTienChi;
RadioButton rb1,rb2,rb3,rb4,rb5,rb6,rb7,rb8,rb9;
DBConnection db;
String ten;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmoi_tienchi);
        btnThemTienChi=findViewById(R.id.btn_them_chi);
        editTextNumber=findViewById(R.id.txtTienChi);editTextNumber.setText("0");
        editTextNgay   =  findViewById(R.id.ngayThemTienChi);editTextNgay.setText("01/01/2019");
        rb1=findViewById(R.id.baohiem);
        rb2=findViewById(R.id.canhan);
        rb3=findViewById(R.id.quanao);
        rb4=findViewById(R.id.mypham);
        rb5=findViewById(R.id.giaoluu);
        rb6=findViewById(R.id.anuong);
        rb7=findViewById(R.id.giaoduc);
        rb8=findViewById(R.id.diennuoc);
        rb9=findViewById(R.id.dichuyen);

            //----------------------------------
        rb1.setOnClickListener(this);
        rb2.setOnClickListener(this);
        rb3.setOnClickListener(this);
        rb4.setOnClickListener(this);
        rb5.setOnClickListener(this);
        rb6.setOnClickListener(this);
        rb7.setOnClickListener(this);
        rb8.setOnClickListener(this);
        rb9.setOnClickListener(this);
        //---------------------------------------




        //----------------------------------------



        //auto chon ngày hiện tại trên feild chọn ngày của tiền chi
        //create a date string.
        String date_n = new SimpleDateFormat(" dd/MM/yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.

        //set it as current date.
        editTextNgay.setText(date_n);
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
        //ham convert so, dang #,###
        editTextNumber.addTextChangedListener(new TextWatcher() {

            boolean isManualChange = false;

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (isManualChange) {
                    isManualChange = false;
                    return;
                }

                try {
                    String value = s.toString().replace(",", "");
                    String reverseValue = new StringBuilder(value).reverse()
                            .toString();
                    StringBuilder finalValue = new StringBuilder();
                    for (int i = 1; i <= reverseValue.length(); i++) {
                        char val = reverseValue.charAt(i - 1);
                        finalValue.append(val);
                        if (i % 3 == 0 && i != reverseValue.length() && i > 0) {
                            finalValue.append(",");
                        }
                    }
                    isManualChange = true;
                    editTextNumber.setText(finalValue.reverse());
                    editTextNumber.setSelection(finalValue.length());
                } catch (Exception e) {
                    // Do nothing since not a number
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });
        //------------------------------------------------------database
        db = new DBConnection(this);
            btnThemTienChi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View c) {
                        if(rb1.isChecked())
                            db.addTienChi(getString(R.string.baohiem_string),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                        else if (rb2.isChecked())
                            db.addTienChi(getString(R.string.canhan),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                         else if (rb3.isChecked())
                            db.addTienChi(getString(R.string.quanao),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                         else if(rb4.isChecked())
                            db.addTienChi(getString(R.string.mypham),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                        else if (rb5.isChecked())
                            db.addTienChi(getString(R.string.giaoluu),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                        else if(rb6.isChecked())
                            db.addTienChi(getString(R.string.anuong),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                         else if(rb7.isChecked())
                            db.addTienChi(getString(R.string.giaoduc),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                           else if (rb8.isChecked())
                            db.addTienChi(getString(R.string.diennuoc),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                          else
                            db.addTienChi(getString(R.string.dichuyen),editTextNumber.getText().toString(),editTextNgay.getText().toString());
                }
            });
        //------------------------
    }
//----------------------
    //-làm cho các radion buton check 1 cai duy nhất
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.baohiem:
                editTextNumber.requestFocus();
                rb1.setChecked(true);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.canhan:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(true);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.quanao:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(true);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.mypham:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(true);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.giaoluu:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(true);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.anuong:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(true);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.giaoduc:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(true);
                rb8.setChecked(false);
                rb9.setChecked(false);
                break;
            case R.id.diennuoc:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(true);
                rb9.setChecked(false);
                break;
            case R.id.dichuyen:
                editTextNumber.requestFocus();
                rb1.setChecked(false);
                rb2.setChecked(false);
                rb3.setChecked(false);
                rb4.setChecked(false);
                rb5.setChecked(false);
                rb6.setChecked(false);
                rb7.setChecked(false);
                rb8.setChecked(false);
                rb9.setChecked(true);
                break;
        }
    }
    //-ham them du lieu--------------------------



    //--------------------------------

    //capnhat du lieu--------------


    //laydulieu nguoi dung-----------------


}


