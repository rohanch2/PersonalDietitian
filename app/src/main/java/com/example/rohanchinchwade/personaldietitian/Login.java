package com.example.rohanchinchwade.personaldietitian;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login extends AppCompatActivity {
    EditText Email, Password;
    ImageButton btLogin;

    Context context = getApplicationContext();
    Context c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        //hide Actionbar
        getWindow().requestFeature(Window.FEATURE_ACTION_BAR);
        //getActionBar().hide();
        context = this;

        setContentView(R.layout.activity_login);

        Email = (EditText) findViewById(R.id.Email);
        Password = (EditText) findViewById(R.id.Password);
        //btLogin = (ImageButton) findViewById(R.id.btLogin);

        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                _("Login Button Hit");

                String uname = Email.getText() + "";
                String pass = Password.getText() + "";

                _("uname" + uname);
                _("Password" + pass);

                if (uname.length() == 0 || pass.length() == 0) {
                    _("Please enter username and password");

                }
                else if (uname.equals("admin") && pass.equals("admin")){
                    startActivity(new Intent(getApplicationContext(),Profile.class));
                }
                else{
                    _("Enter Correct credentials");
                }

            }
        });
    }





    //Reference: https://www.youtube.com/watch?v=gr7mSd-ulsk
    private void _(String s){ Log.d("MyApp", "MyMainActivity" + "#######" + s);}
    private static void __(String s){Log.d("MyApp", "MyMainActivity_" + "#######" + s);}
}

