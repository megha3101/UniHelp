package com.hwt3314.example.univhelper;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.hwt3314.example.univhelper.R;
import com.hwt3314.example.univhelper.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat Sharma on 8/6/2017.
 */

public class StudentItemsAdaptor extends ArrayAdapter<Student> {
    private Student[] data;
    Context context;
    private List<String> selectedEmails;
    private List<Student> selectedStudents;

    public StudentItemsAdaptor(Context context, Student[] data){
        super(context, R.layout.student_item, data);
        this.context = context;
        this.data = data;
        selectedEmails = new ArrayList<String>();
        selectedStudents = new ArrayList<Student>();
    }

    public List<String> getSelectedEmails(){
        return selectedEmails;
    }

    public List<Student> getSelectedStudents() {
        return selectedStudents;
    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final Student stud = data[position];
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.student_item, parent, false);
        TextView nameTextView = (TextView)convertView.findViewById(R.id.name);
        TextView emailTextView = (TextView)convertView.findViewById(R.id.email);
        CheckBox chbx = (CheckBox)convertView.findViewById(R.id.selected);
        chbx.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean checked) {
                if(checked){
                    selectedEmails.add(stud.getEmail());
                    selectedStudents.add(stud);
                }else{
                    selectedEmails.remove(stud.getEmail());
                    selectedStudents.remove(stud);
                }
            }
        });
        nameTextView.setText(stud.getFirstName() + " " + stud.getLastName());
        emailTextView.setText(stud.getEmail());
        chbx.setSelected(false);
        return convertView;
    }
}
