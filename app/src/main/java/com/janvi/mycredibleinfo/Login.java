package com.janvi.mycredibleinfo;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Login extends AppCompatActivity implements ExampleDialog.DialogListener {

     TextView Name,Email,Uname,Pass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name=(TextView)findViewById(R.id.name);
        Email=(TextView)findViewById(R.id.email);
        Uname=(TextView)findViewById(R.id.username);
        Pass=(TextView)findViewById(R.id.password);
    }

    public void logout(View view)
    {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void edit(View view)
    {
       ExampleDialog exampleDialog=new ExampleDialog();
       exampleDialog.show(getSupportFragmentManager(),"Example dialog");
    }

    @Override
    public void applyText(String name, String email, String uname, String pass) {
        Name.setText(name);
        Email.setText(email);
        Uname.setText(uname);
        Pass.setText(pass);
    }

    @Override
    public void apply(String email, String pass) {
        Email.setText(email);
        Pass.setText(pass);
    }

    @Override
    public void applyname(String name) {
        Name.setText(name);
    }

    @Override
    public void applyemail(String email) {
        Email.setText(email);
    }

    @Override
    public void applyuname(String uname) {
        Uname.setText(uname);
    }

    @Override
    public void applypass(String pass) {
        Pass.setText(pass);
    }
}
