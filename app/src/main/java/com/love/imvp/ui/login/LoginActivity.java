package com.love.imvp.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

    }

    @Override
    protected void onResume() {
        super.onResume();
        present.start();
    }

    @Override
    public void loginError(String msg) {
        Toast.makeText(LoginActivity.this, ""+msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginSuccess() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void setPresenter(LoginContract.Present presenter) {

    }

    @OnClick(R.id.btnLogin)
    public void login(){
        final String tel = edtName.getText().toString();
        final String code = edtCode.getText().toString();
        Map<String,String > map = new HashMap<>();
        map.put("tel",tel);
        map.put("code",code);

        present.login(map);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ButterKnife.unbind(this);
    }
}
