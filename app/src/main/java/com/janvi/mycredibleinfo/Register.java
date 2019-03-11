package com.janvi.mycredibleinfo;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Register extends AppCompatActivity {

    EditText Name,Email,Username,Password,Conpassword;
    String name,email,username,password,conpass;
    String reg_url="http://192.168.0.3/register.php";
    AlertDialog.Builder builder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Name=(EditText)findViewById(R.id.name);
        Email=(EditText)findViewById(R.id.email);
        Username=(EditText)findViewById(R.id.textview);
        Password=(EditText)findViewById(R.id.pass);
        Conpassword=(EditText)findViewById(R.id.conpass);
        builder=new AlertDialog.Builder(Register.this);
    }
    public void register(View v)
    {
        name=Name.getText().toString();
        email=Email.getText().toString();
        username=Username.getText().toString();
        password=Password.getText().toString();
        conpass=Conpassword.getText().toString();
        if(name.equals("")||email.equals("")||username.equals("")||password.equals("")||conpass.equals(""))
        {
            builder.setTitle("Someting went wrong..");
            builder.setMessage("Please fill all the fields...");
            diaplayAlert("input_error");
        }
        else
        {
            if(!(password.equals(conpass)))
            {
                builder.setTitle("Someting went wrong..");
                builder.setMessage("Your Passwords are not matching...");
                diaplayAlert("input_error");
            }
            else
            {
                if(name.equals("janvi")) {
                    String code = "req_failed";
                    String message="User already exist...";
                    builder.setTitle("Server Response...");
                    builder.setMessage(message);
                    diaplayAlert(code);

                }
                else if(name.equals("Janvi")){

                    String message="Thank you for registration with us...";
                    builder.setTitle("Server Response...");
                    builder.setMessage(message);
                    diaplayAlert("req_success");


                }
               /*  StringRequest stringRequest=new StringRequest(Request.Method.POST,reg_url,
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) {
                                try {
                                    JSONArray jsonArray=new JSONArray(response);
                                    JSONObject jsonObject=jsonArray.getJSONObject(0);
                                    String code=jsonObject.getString("code");
                                    String message=jsonObject.getString("message");

                                    builder.setTitle("Server Response...");
                                    builder.setMessage(message);
                                    diaplayAlert(code);
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                }

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(),"error occur"+error.getMessage(),Toast.LENGTH_SHORT).show();

                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> params =new HashMap<String, String>();
                        params.put("name",name);
                        params.put("email",email);
                        params.put("user_name",username);
                        params.put("password",password);
                        return params;
                    }
                };
                MySingleton.getmInstance(Register.this).addToRequestque(stringRequest);
            */}
        }
    }


    public void diaplayAlert(final String code)
    {
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(code.equals("input_error"))
                {
                   Password.setText("");
                   Conpassword.setText("");
                }
                else if(code.equals("req_success"))
                {
                    Name.setText("");
                    Email.setText("");
                    Username.setText("");
                    Password.setText("");
                    Conpassword.setText("");

                }
                else if (code.equals("req_failed"))
                {
                    Name.setText("");
                    Email.setText("");
                    Username.setText("");
                    Password.setText("");
                    Conpassword.setText("");
                }
            }
        });
        AlertDialog alertDialog=builder.create();
        alertDialog.show();
    }
}
