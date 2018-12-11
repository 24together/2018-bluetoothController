package com.andrstudy.bluetoothcontroller2;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {


    private ToggleButton toggleButton;
    private MyReceiver receiver;
    public static Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //블루투스 퍼미션 권한 요청
        BluetoothAdapter btAdapter;
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        //블루투스 지원유무
        if (btAdapter == null) {
            Toast.makeText(this, "이 기기는 블루투스 기능을 지원하지 않습니다.", Toast.LENGTH_SHORT).show();
        }

        toggleButton = (ToggleButton) findViewById(R.id.toggleButton);
        toggleButton.setOnCheckedChangeListener(this);



        IntentFilter filter = new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED);
        receiver = new MyReceiver();
        this.registerReceiver(receiver, filter);

        mContext = this;

        if ( btAdapter.getState() == BluetoothAdapter.STATE_ON) {//블루투스 On시 끄기 상태로 보이도록
            toggleButton.setChecked(true);
        } else {
            toggleButton.setChecked(false);
        }

    }
    public ToggleButton getToggleButton(){
        return toggleButton;
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

        //블루투스 퍼미션 권한 요청
        BluetoothAdapter btAdapter;
        btAdapter = BluetoothAdapter.getDefaultAdapter();

        if (toggleButton.isChecked()==true) {
            btAdapter.enable();
        } else {
            btAdapter.disable();
        }

    }
}