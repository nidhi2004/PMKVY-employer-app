package com.example.nidhisingh.pmkvy_employer_app.home_page_employer;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.example.nidhisingh.pmkvy_employer_app.R;
import com.example.nidhisingh.pmkvy_employer_app.employer_candidate_list.employer_candidate_list;
import com.example.nidhisingh.pmkvy_employer_app.employer_training_list.employer_training_list;

/**
 * Created by Nidhi Singh on 3/26/2017.
 */

public class home_page extends AppCompatActivity implements AdapterView.OnClickListener {

    Button certified_candidate_list,find_training_center;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_homepage);
        //for find_training_center
        find_training_center = (Button)findViewById(R.id.find_tc_employer_home);
        find_training_center.setOnClickListener(this);

        //for certified candidaye_list
        certified_candidate_list = (Button)findViewById(R.id.certified_list_home);
        certified_candidate_list.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent certified_candidate_list = new Intent(this,employer_candidate_list.class);
        Intent find_training_center = new Intent(this,employer_training_list.class);

        if(v.getId()== R.id.find_tc_employer_home)
        {
            startActivity(find_training_center);
        }
        else
        {
            startActivity(certified_candidate_list);
        }

    }
}
