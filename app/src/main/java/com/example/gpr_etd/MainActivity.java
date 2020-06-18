package com.example.gpr_etd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.app.AppOpsManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Toast;

import java.lang.reflect.Method;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity{
    private Button btnOpenSettings;
    private SwitchCompat switchCompatHotSpot;

    private boolean isRestored;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindWidget();
        /*switchCompatHotSpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchCompatHotSpot.isChecked()) {
                    Toast.makeText(getApplicationContext(), "Switch HotSPOT is on: " + "true", LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "Switch HotSPOT is on: " + "false", LENGTH_SHORT).show();
                }
            }
        });*/

        //setupSwitchCompatEventListener();
        setupWidgetListener();
    }

    private void setupSwitchCompatEventListener() {
        //switchHotSpot.setOnCheckedChangeListener(this);
    }




    private void setupWidgetListener() {
        btnOpenSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(Settings.ACTION_WIRELESS_SETTINGS), 0);
            }
        });
    }

    private void bindWidget() {
        btnOpenSettings = (Button) findViewById(R.id.btnOpenWirelessSettings);
        switchCompatHotSpot = (SwitchCompat) findViewById(R.id.switchHotSpot);
    }


/*    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        switch (buttonView.getId()){
            case (R.id.switchHotSpot):
                if(isChecked) {
                    isRestored = false;
                    Toast.makeText(getApplicationContext(), "Switch HotSPOT is on: " + isChecked, LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Switch HotSPOT is on: " + isChecked, LENGTH_SHORT).show();

                }
                break;
        }
    }*/
}
