package com.manager.doan_android;


import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;


public class activity_themmoi extends TabActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_themmoi);

        TabHost tabHost = getTabHost();

        // thiet lap tab cho danh muc tien chi
        TabSpec tienchi = tabHost.newTabSpec("Tiền Chi");
        tienchi.setIndicator("Tiền Chi", getResources().getDrawable(R.drawable.ic_launcher_background));
        Intent tienChiIntent = new Intent(this, themmoi_tienchi.class);
        tienchi.setContent(tienChiIntent);

        // thiet lap tab cho danh muc thin thu
        TabSpec tienthu = tabHost.newTabSpec("Tiền Thu");
        tienthu.setIndicator("Tiền Thu", getResources().getDrawable(R.drawable.ic_launcher_background));
        Intent tienThuIntent = new Intent(this, themmoi_tienthu.class);
        tienthu.setContent(tienThuIntent);


        // lan luot Them cac TabSpec vao TabHost
        tabHost.addTab(tienchi);
        tabHost.addTab(tienthu);

    }


}