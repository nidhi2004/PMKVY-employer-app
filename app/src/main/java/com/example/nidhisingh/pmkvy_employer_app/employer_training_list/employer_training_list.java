package com.example.nidhisingh.pmkvy_employer_app.employer_training_list;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.nidhisingh.pmkvy_employer_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nidhi Singh on 3/22/2017.
 */
//main class file(recyclerview)
public class employer_training_list extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private Spinner sp_state_list1,sp_district_list1,sp_sector_list1,sp_jobrole_list1;
    List<training_details> t_d;
    RecyclerView training_recycler_view ;
    //layout(where recycler is used) and recycler id is linked here
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employe_training);
        training_recycler_view = (RecyclerView) findViewById(R.id.recyclerview_training_list);
        LinearLayoutManager t_linear = new LinearLayoutManager(this);
        training_recycler_view.setLayoutManager(t_linear);

        // spinner(STATE)
        sp_state_list1 = (Spinner) findViewById(R.id.spinner_state_list1);
        sp_state_list1.setOnItemSelectedListener(this);
        List<String> categories_state_training = new ArrayList<String>();

        categories_state_training.add("chattisgarh");
        categories_state_training.add("rajasthan");
        categories_state_training.add("uttar pradesh");
        categories_state_training.add("madhya pradesh");

        ArrayAdapter<String> adapter_state_training = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, categories_state_training);
        adapter_state_training.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_state_list1.setAdapter(adapter_state_training);

        //spinner(DISTRICT)
        sp_district_list1 = (Spinner) findViewById(R.id.spinner_district_list1);
        sp_district_list1.setOnItemSelectedListener(this);
        List<String> categories_district_training = new ArrayList<String>();

        categories_district_training.add("balod");
        categories_district_training.add("durg");
        categories_district_training.add("kota");
        categories_district_training.add("dhamtari");

        ArrayAdapter<String> adapter_district_training = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,categories_district_training);
        adapter_district_training.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_district_list1.setAdapter(adapter_district_training);

        //spinner(SECTOR)
        sp_sector_list1 = (Spinner) findViewById(R.id.spinner_sector_list1);
        sp_sector_list1.setOnItemSelectedListener(this);
        List<String> categories_sector_training  = new  ArrayList<>();

        categories_sector_training.add("sector1");
        categories_sector_training.add("sector2");
        categories_sector_training.add("sector3");
        categories_sector_training.add("sector4");

        ArrayAdapter<String> adapter_sector_training = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories_sector_training);
        adapter_sector_training.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_sector_list1.setAdapter(adapter_sector_training);

        //spinner(JOBROLE)
        sp_jobrole_list1 = (Spinner) findViewById(R.id.spinner_jobrole_list1);
        sp_jobrole_list1.setOnItemSelectedListener(this);
        List<String> categories_jobrole_training = new ArrayList<>();

        categories_jobrole_training.add("jobrole1");
        categories_jobrole_training.add("jobrole2");
        categories_jobrole_training.add("jobrole3");
        categories_jobrole_training.add("jobrole4");

        ArrayAdapter<String> adapter_jobrole_training = new ArrayAdapter(this,android.R.layout.simple_spinner_item,categories_jobrole_training);
        adapter_jobrole_training.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_jobrole_list1.setAdapter(adapter_jobrole_training);


        initializedata();
        initializeadapter();
    }
     //contents of training list from database are added here
     private void initializedata()
    {
        t_d = new ArrayList<>();
        t_d.add(new training_details("trainingcenter1","rajasthan_address","675543727"));
        t_d.add(new training_details("trainingcenter2","delhi_address","675543727"));
        t_d.add(new training_details("trainingcenter3","chhattisgarh_address","675543727"));
        t_d.add(new training_details("trainingcenter4","uttarpradesh_address","675543727"));
        t_d.add(new training_details("trainingcenter5","madhyapradesh_address","675543727"));


    }
    private void initializeadapter()
    {
        training_data_adapter t_a_d = new training_data_adapter(t_d);
        training_recycler_view.setAdapter(t_a_d);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        // for State
        String item_state_training = parent.getItemAtPosition(position).toString();


        //for district
        String item_district_training = parent.getItemAtPosition(position).toString();


        //for sector
        String item_sector_training = parent.getItemAtPosition(position).toString();


        //for jobrole
        String item_jobrole_training = parent.getItemAtPosition(position).toString();


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}