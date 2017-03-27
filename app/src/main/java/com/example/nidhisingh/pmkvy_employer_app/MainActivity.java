package com.example.nidhisingh.pmkvy_employer_app;
import com.example.nidhisingh.pmkvy_employer_app.home_page_employer.*;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.nidhisingh.pmkvy_employer_app.R;

import com.example.nidhisingh.pmkvy_employer_app.employer_candidate_list.employer_candidate_list;
import com.example.nidhisingh.pmkvy_employer_app.employer_training_list.employer_training_list;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button rv_home_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //homepage
        rv_home_page = (Button)findViewById(R.id.rv_home_page);
        rv_home_page.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent recycler_homepage=new Intent(this,home_page.class);
        startActivity(recycler_homepage);
    }
}