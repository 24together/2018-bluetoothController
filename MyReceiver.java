package com.andrstudy.bluetoothcontroller2;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
import android.widget.ToggleButton;

import static com.andrstudy.bluetoothcontroller2.MainActivity.mContext;

/**
 * Created by 2 on 2018-05-12.
 */

public class MyReceiver extends BroadcastReceiver {

    private ToggleButton toggleButton;


    @Override
    public void onReceive(Context context, Intent intent) {


        int state = intent.getIntExtra(BluetoothAdapter.EXTRA_STATE, -1);
        String strState = "";
        //함수로 가져오기
         toggleButton = (ToggleButton)((MainActivity) mContext).getToggleButton();

        //블루투스 상태에 따라 토스트와 토글버튼의 상태 변화
        switch(state){
            case BluetoothAdapter.STATE_ON:
                strState = "ON";
                toggleButton.setChecked(true);
                Toast.makeText(context, "bluetooth "+strState, Toast.LENGTH_SHORT).show();
                break;
            case BluetoothAdapter.STATE_OFF:
                strState = "OFF";
                toggleButton.setChecked(false);
                Toast.makeText(context, "bluetooth "+strState, Toast.LENGTH_SHORT).show();
                break;
        }


    }

}
