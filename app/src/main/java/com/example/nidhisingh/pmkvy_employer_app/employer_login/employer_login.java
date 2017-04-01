package com.example.nidhisingh.pmkvy_employer_app.employer_login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.nidhisingh.pmkvy_employer_app.R;

/**
 * Created by Nidhi Singh on 4/1/2017.
 */

public class employer_login extends AppCompatActivity implements View.OnClickListener {
    EditText employer_email, employer_pass;
    Button employer_login;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_login_page);

        employer_email = (EditText)findViewById(R.id.employer_email);
        employer_pass = (EditText)findViewById(R.id.employer_pass);
        employer_login = (Button)findViewById(R.id.employer_login);

        employer_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        boolean checkValidData = checkData();
        if(checkValidData) {

        }

    }

    private boolean checkData() {

    }
}
