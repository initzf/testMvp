package com.love.imvp.ui.main;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;

import com.love.imvp.R;
import com.love.imvp.base.BaseActivity;
import com.love.imvp.ui.home.IndexFragment;

public class MainActivity extends BaseActivity {

    private IndexFragment mainFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(mainFragment==null){
            mainFragment = new IndexFragment();
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_main,mainFragment);
        fragmentTransaction.commit();
    }
}
