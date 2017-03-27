package com.example.nidhisingh.pmkvy_employer_app.employer_candidate_list;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.nidhisingh.pmkvy_employer_app.R;

import java.util.List;

/**
 * Created by Nidhi Singh on 3/22/2017.
 */

public class student_data_adapter extends RecyclerView.Adapter<student_data_adapter.student_info_view_holder> {


    public static class student_info_view_holder extends RecyclerView.ViewHolder{

       CardView cv ;
       TextView student_name,student_age,student_state,student_district,student_jobrole;

       student_info_view_holder(View student_view){

           super(student_view);
           cv = (CardView)student_view.findViewById(R.id.candidate_cv);
           student_name = (TextView)student_view.findViewById(R.id.student_name_list);
           student_age = (TextView)student_view.findViewById(R.id.student_age_list);
           student_state=(TextView)student_view.findViewById(R.id.student_state_list);
           student_district=(TextView)student_view.findViewById(R.id.student_district_list);
           student_jobrole=(TextView)student_view.findViewById(R.id.student_jobrole_list);


       }

   }

   List<student_details> students;


    student_data_adapter(List<student_details> students){

        this.students=students;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    //cardview under recyclerview

    @Override
    public student_info_view_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.student_info_list,parent,false);
        student_info_view_holder svh = new student_info_view_holder(v);
        return svh;
    }
    //call when data in recyler view is stored
    @Override
    public void onBindViewHolder(student_info_view_holder holder, int position) {
        holder.student_name.setText(students.get(position).student_name);
        holder.student_age.setText(students.get(position).student_age);
        holder.student_state.setText(students.get(position).student_state);
        holder.student_district.setText(students.get(position).student_district);
        holder.student_jobrole.setText(students.get(position).student_jobrole);




    }

    @Override
    public int getItemCount() {
        return students.size();
    }

}
