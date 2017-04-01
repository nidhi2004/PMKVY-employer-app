package com.example.nidhisingh.pmkvy_employer_app.employer_candidate_list;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nidhisingh.pmkvy_employer_app.detailed_candidate_information.*;
import com.example.nidhisingh.pmkvy_employer_app.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Nidhi Singh on 3/22/2017.
 */

public class employer_candidate_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    List<student_details> s_d;
    RecyclerView candidate_list_rv;
    Spinner sp_state_list,sp_district_list,sp_sector_list,sp_jobrole_list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employe_candidates);


        this.setTitle("Certified Candidates");


        candidate_list_rv = (RecyclerView) findViewById(R.id.recyclerview_student_list);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        candidate_list_rv.setLayoutManager(llm);
        candidate_list_rv.setHasFixedSize(true);
        candidate_list_rv.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), candidate_list_rv, new ClickListener() {


            @Override
            public void onClick(View view, int position) {
                Intent detailed_info = new Intent(view.getContext(),datailed_candidate_info.class);

                startActivity(detailed_info);

            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));

        // spinner(STATE)
        sp_state_list = (Spinner) findViewById(R.id.spinner_state_list);
        sp_state_list.setOnItemSelectedListener(this);
        List<String> categories_state = new ArrayList<String>();

        categories_state.add("chattisgarh");
        categories_state.add("rajasthan");
        categories_state.add("uttar pradesh");
        categories_state.add("madhya pradesh");

        ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categories_state);
        adapter_state.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_state_list.setAdapter(adapter_state);

        //spinner(DISTRICT)
        sp_district_list = (Spinner) findViewById(R.id.spinner_district_list);
        sp_district_list.setOnItemSelectedListener(this);
        List<String> categories_district = new ArrayList<String>();

        categories_district.add("balod");
        categories_district.add("durg");
        categories_district.add("kota");
        categories_district.add("dhamtari");

        ArrayAdapter<String> adapter_district = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories_district);
        adapter_district.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_district_list.setAdapter(adapter_district);

        //spinner(SECTOR)
        sp_sector_list = (Spinner) findViewById(R.id.spinner_sector_list);
        sp_sector_list.setOnItemSelectedListener(this);
        List<String> categories_sector  = new  ArrayList<>();

        categories_sector.add("sector1");
        categories_sector.add("sector2");
        categories_sector.add("sector3");
        categories_sector.add("sector4");

        ArrayAdapter<String> adapter_sector = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories_sector);
        adapter_district.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sector_list.setAdapter(adapter_sector);

        //spinner(JOBROLE)
        sp_jobrole_list = (Spinner) findViewById(R.id.spinner_jobrole_list);
        sp_jobrole_list.setOnItemSelectedListener(this);
        List<String> categories_jobrole = new ArrayList<>();

        categories_jobrole.add("jobrole1");
        categories_jobrole.add("jobrole2");
        categories_jobrole.add("jobrole3");
        categories_jobrole.add("jobrole4");

        ArrayAdapter<String> adapter_jobrole = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories_jobrole);
        adapter_jobrole.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_jobrole_list.setAdapter(adapter_jobrole);
        initializedata();
        initailizeadapter();
    }

    private void initializedata(){

        s_d = new ArrayList<>();
        // todo:from database to recycler view
        s_d.add(new student_details("nidhi","20","cg","balod","none"));
        s_d.add(new student_details("gauri","27","cg","durg","doctor"));
        s_d.add(new student_details("rajni","22","mp","jabalpur","none"));
        s_d.add(new student_details("rakesh","23","mp","sambalpur","none"));
    }
     private void initailizeadapter(){

         student_data_adapter s_a_d = new student_data_adapter(s_d);
         candidate_list_rv.setAdapter(s_a_d);
        s_a_d.notifyDataSetChanged();

     }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        // for State
        String item_state = parent.getItemAtPosition(position).toString();



        //for district
        String item_district = parent.getItemAtPosition(position).toString();



        //for sector
        String item_sector = parent.getItemAtPosition(position).toString();



        //for jobrole
        String item_jobrole = parent.getItemAtPosition(position).toString();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

