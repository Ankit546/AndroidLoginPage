package com.example.kumarankit.anotherfirstapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {


    private EditText Name;
    private EditText Password;
    private TextView Info;

    private Button Login;
    private int counter=5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.etName);
        Password=(EditText)findViewById(R.id.etPassword);
        Info=(TextView)findViewById(R.id.tvInfo);
        Login=(Button)findViewById(R.id.btn);

        Info.setText("No of Attempts remaining: 5");
        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString(),Password.getText().toString());
            }
        });

        //assigning variable to xml Layout IDS

    }

    private void validate(String userName,String userPassword){

        if(userName.equals("Admin") && userPassword.equals("1234")){
            Intent in=new Intent(MainActivity.this ,SecondActivity.class);
            //from one activity to another, like starting and ending point
            startActivity(in);
           // startActivity(intent);
        }
        else{
            counter--;
            Info.setText("Number of Attempts remaining: "+String.valueOf(counter));

            if(counter==0){
                Login.setEnabled(false);
            }
        }

    }
}
