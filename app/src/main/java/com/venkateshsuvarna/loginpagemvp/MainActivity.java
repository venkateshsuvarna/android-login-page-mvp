package com.venkateshsuvarna.loginpagemvp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.venkateshsuvarna.loginpagemvp.presenter.ILoginPresenter;
import com.venkateshsuvarna.loginpagemvp.view.ILoginView;
import com.venkateshsuvarna.loginpagemvp.view.LoginPresenter;

public class MainActivity extends AppCompatActivity implements ILoginView{

    EditText edt_email;
    EditText edt_password;
    Button btn_login;

    ILoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_login = findViewById(R.id.btn_login);
        edt_email = findViewById(R.id.edt_email);
        edt_password = findViewById(R.id.edt_password);

        loginPresenter = new LoginPresenter(this);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edt_email.getText().toString(),edt_password.getText().toString());
            }
        });

    }

    @Override
    public void onLoginResult(String message) {
        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
    }
}
