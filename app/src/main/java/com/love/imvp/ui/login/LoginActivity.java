package com.love.imvp.ui.login;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.love.imvp.R;
import com.love.imvp.base.BaseActivity;
import com.love.imvp.ui.main.MainActivity;

import java.util.HashMap;
import java.util.Map;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func1;

/**
 * 作者：zf on 2016/6/12 11:10
 * 邮箱：initzf@126.com
 */
public class LoginActivity extends BaseActivity implements LoginContract.View {
    private static final String TAG = "LoginActivity";
    private LoginContract.Present present;

    @Bind(R.id.edtName)
    EditText edtName;

    @Bind(R.id.edtCode)
    EditText edtCode;

    @Bind(R.id.btnLogin)
    Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        present = new LoginPresenter(this);

        /*Observable.interval(10, TimeUnit.SECONDS)
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        Log.i(TAG, "call: "+aLong);
                    }
                });*/


        String[] arr = {"1", "2", "3", "4"};

        Observable.from(arr).map(new Func1<String, Integer>() {
            @Override
            public Integer call(String s) {
                final int i = Integer.parseInt(s);
                if (i % 2 == 0) {
                    return i;
                } else {
                    return 0;
                }
            }
        }).map(new Func1<Integer, String>() {
            @Override
            public String call(Integer integer) {
                return integer.toString()+"zzzzzzzzzzzzzzzz";
            }
        }).subscribe(new Action1<String>() {
            @Override
            public void call(String s) {
                Log.i(TAG, "call: "+s);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    public void loginError(String msg) {
        Toast.makeText(LoginActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(LoginActivity.this, btnLogin,"startIndex").toBundle());
        }else{
            startActivity(intent);
        }
    }

    @Override
    public void setPresenter(LoginContract.Present presenter) {

    }

    @OnClick(R.id.btnLogin)
    public void login() {
        final String tel = edtName.getText().toString();
        final String code = edtCode.getText().toString();
        Map<String, String> map = new HashMap<>();
        map.put("tel", tel);
        map.put("code", code);

        present.login(map);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
