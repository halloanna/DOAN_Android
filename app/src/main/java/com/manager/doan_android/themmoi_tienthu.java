package com.manager.doan_android;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class themmoi_tienthu extends AppCompatActivity implements View.OnClickListener  {
    EditText editText,editTextNumberThu;
    RadioGroup rg;
    RadioButton radioBtnTienLuong,radioBtnTienThuong,radioBtnDienNuoc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmoi_tienthu);
        editTextNumberThu=findViewById(R.id.txtTienThu);

        radioBtnDienNuoc=findViewById(R.id.diennuoc_thu);
        radioBtnTienLuong=findViewById(R.id.tienluong_thu);
        radioBtnTienThuong=findViewById(R.id.tienthuong_thu);

        radioBtnDienNuoc.setOnClickListener(this);
        radioBtnTienLuong.setOnClickListener(this);
        radioBtnTienThuong.setOnClickListener(this);
        //auto chon ngày hiện tại trên feild chọn ngày của tiền chi
        //create a date string.
        String date_n = new SimpleDateFormat(" dd/MM/yyyy", Locale.getDefault()).format(new Date());
        //get hold of textview.
        editText   =  findViewById(R.id.ngayThemTienThu);
        //set it as current date.
        editText.setText(date_n);

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
        editTextNumberThu.addTextChangedListener(new TextWatcher() {

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
                    editTextNumberThu.setText(finalValue.reverse());
                    editTextNumberThu.setSelection(finalValue.length());
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
        //------------------------------------------------------



    }
    public void onClick(View v) {
        int id = v.getId();
        switch (id) {
            case R.id.tienluong_thu:
                editTextNumberThu.requestFocus();
                radioBtnTienLuong.setChecked(true);
                radioBtnTienThuong.setChecked(false);
                radioBtnDienNuoc.setChecked(false);

                break;
            case R.id.tienthuong_thu:
                editTextNumberThu.requestFocus();
                radioBtnTienLuong.setChecked(false);
                radioBtnTienThuong.setChecked(true);
                radioBtnDienNuoc.setChecked(false);
                break;
            case R.id.diennuoc_thu:
                editTextNumberThu.requestFocus();
                radioBtnTienLuong.setChecked(false);
                radioBtnTienThuong.setChecked(false);
                radioBtnDienNuoc.setChecked(true);
                break;


        }


    }


}
