package com.janvi.mycredibleinfo;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.support.v7.widget.ContentFrameLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

public class ExampleDialog extends AppCompatDialogFragment {
    private EditText name,email,uname,pass;
    private DialogListener dialogListener;
    @Override
    public android.app.Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder=new AlertDialog.Builder(getActivity());
        LayoutInflater inflater=getActivity().getLayoutInflater();
        View view=inflater.inflate(R.layout.dialog,null);
        builder.setView(view)
                .setTitle("Edit")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setPositiveButton("Apply", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String Name=name.getText().toString();
                        String Email=email.getText().toString();
                        String Uname=uname.getText().toString();
                        String Pass=pass.getText().toString();
                        if(!(Name.equals(""))&&!(Pass.equals(""))&&!(Email.equals(""))&&!(Uname.equals(""))) {
                            dialogListener.applyText(Name,Email,Uname,Pass);
                        }
                        else if(!(Uname.equals(""))) {
                            dialogListener.applyuname(Uname);
                        }
                        else if(!(Pass.equals(""))&&!(Email.equals(""))) {
                            dialogListener.apply(Email,Pass);
                        }
                        else if(!(Email.equals(""))) {
                            dialogListener.applyemail(Email);
                        }
                        else if(!(Pass.equals(""))) {
                            dialogListener.applypass(Pass);
                        }
                        else if(!(Name.equals("")))
                            dialogListener.applyname(Name);
                    }
                });
        name=view.findViewById(R.id.name);
        email=view.findViewById(R.id.email);
        uname=view.findViewById(R.id.username);
        pass=view.findViewById(R.id.pass);
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        dialogListener=(DialogListener) context;
    }

    public interface DialogListener
    {
        void applyname(String name);
        void applyemail(String email);
        void applyuname(String uname);
        void applypass(String pass);
        void applyText(String name, String email, String uname, String pass);
        void apply(String email,String pass);
    }
}
