package com.example.nidhisingh.pmkvy_employer_app.employer_login;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nidhisingh.pmkvy_employer_app.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

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
              get_login_request login_req = new get_login_request(employer_email.getText().toString(), employer_pass.getText().toString(), v.getContext());
            login_req.execute();
        }

    }

    private boolean checkData() {
        boolean valid = true;

        if (employer_email == null || !android.util.Patterns.EMAIL_ADDRESS.matcher(employer_email.getText()).matches()) {
            valid = false;
            employer_email.setError("Enter Valid Email Address");
        } else {
            employer_email.setError(null);
        }

        if (employer_pass == null || employer_pass.length() < 4) {
            valid = false;
            employer_pass.setError("Password Should be Greater Than 4 AlpaNumeric ");
        } else {
            employer_pass.setError(null);
        }
        return valid;

    }
}


    class get_login_request extends AsyncTask<String, Void, String> {

    String employer_email, employer_pass;
    JSONObject json;

    boolean flag;
    Context context;

    public get_login_request(String employer_email, String employer_pass, Context context) {


        this.employer_email = employer_email;
        this.employer_pass = employer_pass;
        this.context = context;
    }

    @Override
    protected void onPostExecute(String s) {
        if (flag) {
            Toast.makeText(context.getApplicationContext(), "Login Successful " + s, Toast.LENGTH_LONG).show();
            SharedPreferences sharedPreferences;
            sharedPreferences=context.getApplicationContext().getSharedPreferences("PREF",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=sharedPreferences.edit();
            editor.putString("NAME","TEST");
            editor.apply();
            editor.commit();

        } else
            Toast.makeText(context.getApplicationContext(), "Login Failed" + s, Toast.LENGTH_LONG).show();

    }

    @Override

    protected String doInBackground(String... params) {

        try {
            String link = "192.168.43.5:8000/api/employer/employerlogincheck";



            URL url = new URL(link);
            URLConnection con = url.openConnection();

            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());

            json = new JSONObject();
            JSONObject add = new JSONObject();

            add.put("eu_email", employer_email);
            add.put("eu_password", employer_pass);
            json.put("data", add);


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

