package com.example.nidhisingh.pmkvy_employer_app.feedback;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

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
 * Created by Nidhi Singh on 3/31/2017.
 */

public class feedback extends AppCompatActivity implements View.OnClickListener,AdapterView.OnItemSelectedListener {
    EditText feedback_subject,feedback_details;
    Spinner sp_training_center;
    Button button_submit;
    RatingBar Rating_bar_rating;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employer_feedback);

        this.setTitle("Feedback");
        feedback_subject = (EditText) findViewById(R.id.subject_feedback);
        feedback_details = (EditText) findViewById(R.id.details_feedback);
        sp_training_center = (Spinner) findViewById(R.id.spinner_feedback);
        button_submit = (Button) findViewById(R.id.submit_feedback);
        Rating_bar_rating = (RatingBar) findViewById(R.id.rating);

        button_submit.setOnClickListener(this);
        sp_training_center.setOnItemSelectedListener(this);

        List<String> training_centers = new ArrayList<>();
        //todo:if required add categories

        ArrayAdapter<String> adapter_course_name = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,training_centers);
        adapter_course_name.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_training_center.setAdapter(adapter_course_name);

    }

    @Override
    public void onClick(View v) {
        if(Check_data()) {
            try {
                JSONObject add = new JSONObject();
                add.put("subject", feedback_subject.getText().toString());
                add.put("details", feedback_details.getText().toString());
                add.put("rating", 3);
                new get_feedback_request(feedback_subject, feedback_details, Rating_bar_rating, add, v.getContext()).execute();

            }catch (Exception e) {
                Log.d("ERROR" , e.getMessage());
            }
        }
    }

    boolean Check_data() {
        boolean flag = true;
        return flag;
    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String item_course_name = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

class get_feedback_request extends AsyncTask<String, Void, String> {
    boolean flag;
    String feedback_subject,feedback_details;
    Spinner sp_training_center;
    RatingBar Rating_bar_rating;
    Context context;
    JSONObject add;

    public get_feedback_request(String feedback_subject, String feedback_details, RatingBar Rating_bar_rating, JSONObject add, Context context) {
        this.add = add;
        this.context = context;
        this.feedback_subject = feedback_subject;
        this.feedback_details = feedback_details;
        this.Rating_bar_rating = Rating_bar_rating;
    }


    @Override
    protected String doInBackground(String... params) {
        try {

            String link ="http://192.168.15.107:8000" + "/api/coursefeedback/";
            //todo: change database


            URL url = new URL(link);
            URLConnection con = url.openConnection();

            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());


            wr.write(add.toString());
            wr.flush();


            BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()));

            StringBuilder sb = new StringBuilder();
            String line = null;

            while ((line = reader.readLine()) != null) {
                Log.d("LINE : ", line);
                if (line.equals("true")) {
                    //TODO: 3/20/2017 add response checking from server format is in jason
                    flag = true;
                } else
                    flag = false;

                sb.append(line);
            }
            return sb.toString();


        } catch (Exception e) {
            Log.d("ERROR", e.getMessage());
            return "Exception: " + e.getMessage();
        }

    }
}
