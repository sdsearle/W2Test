package com.example.admin.w2test;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

/**
 * Created by admin on 9/8/2017.
 */

public class NumThread extends Thread {

    Handler h;
    public NumThread(Handler handler) {
        h = handler;
        int num = (int)(Math.random()*100);
        Bundle bundle = new Bundle();
        bundle.putInt("data",num);
        Message message = new Message();
        message.setData(bundle);
        handler.sendMessage(message);
    }
}
