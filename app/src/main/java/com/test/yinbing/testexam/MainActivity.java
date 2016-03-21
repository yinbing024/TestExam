package com.test.yinbing.testexam;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends FragmentActivity {

    private ImageView back_iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        setListener();
    }

    private void initView() {
        //back_iv = (ImageView) findViewById(R.id.back_iv);
    }

    private void setListener() {

    }


}
