package com.janvi.mycredibleinfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
        TextView textView;
        EditText uname,upass;
        String username,pass;
    AlertDialog.Builder builder;
        String server_url="http://192.168.0.3/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView=(TextView)findViewById(R.id.register);
        uname=(EditText)findViewById(R.id.name);
        upass=(EditText)findViewById(R.id.pass);
        builder=new AlertDialog.Builder(MainActivity.this);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });
    }

    public void login(View view)
    {
        username=uname.getText().toString();
        pass=upass.getText().toString();
        if(username.equals("janvi21"))
        {
            Intent intent=new Intent(this,Login.class);
            startActivity(intent);
        }
        else
        {
            String message="User does not exist...";
            builder.setTitle("Server Response...");
            builder.setMessage(message);
            diaplayAlert("req_failed");

        }
    }

    public void diaplayAlert(final String code)
    {
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                if (code.equals("req_failed"))
                {
                    uname.setText("");
                    upass.setText("");
                }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
