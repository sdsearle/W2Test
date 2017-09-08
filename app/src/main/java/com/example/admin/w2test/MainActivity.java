package com.example.admin.w2test;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView tvNum;
    private MySingleton mySingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvNum = (TextView) findViewById(R.id.tvNum);

        ArrayList<Integer> myInts = new ArrayList<>();
        myInts.add(2);
        myInts.add(3);
        myInts.add(3);

        addOdds(myInts);
        mySingleton = MySingleton.getInstance();

        String email = "myEmail@email.com";
        Log.d("TAG", "onCreate: " + emailVailidator(email));
    }

    private boolean emailVailidator(String email) {
        if (email.contains("@")) {
            if (email.substring(email.indexOf("@")).contains(".") && email.indexOf("@") > 0) {
                return true;
            }
        }
        return false;
    }

    private void addOdds(ArrayList<Integer> myInts) {
        int tmp = 0;
        for (int i : myInts
                ) {
            if (i % 2 != 0) {
                tmp += i;
            }
        }
        Log.d("TAG", "addOdds: " + tmp);
    }

    public void generateNumber(View view) {
        //AsyncNumTask ant = new AsyncNumTask();
        //ant.execute();
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                tvNum.setText(String.valueOf(message.getData().getInt("data")));
                return false;
            }
        });

        NumThread nt = new NumThread(handler);
        nt.start();

    }
}
