package com.example.admin.w2test;

/**
 * Created by admin on 9/8/2017.
 */

class MySingleton {
    private static final MySingleton ourInstance = new MySingleton();

    static MySingleton getInstance() {
        return ourInstance;
    }

    private MySingleton() {
    }
}
