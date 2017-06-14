package com.hwt3314.example.univhelper;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Rajat Sharma on 08/06/17.
 */

public class GroupItemsAdaptor extends ArrayAdapter<StudyGroup>{
    private StudyGroup[] data;
    private Context context;

    public GroupItemsAdaptor(Context context, StudyGroup[] data){
        super(context, R.layout.group_item, data);
        this.context = context;
        this.data = data;
        //selectedEmails = new ArrayList<String>();
        //selectedStudents = new ArrayList<Student>();


    }

    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final StudyGroup gr = data[position];
        LayoutInflater inflater = ((Activity)context).getLayoutInflater();
        convertView = inflater.inflate(R.layout.group_item, parent, false);
        TextView nameTextView = (TextView)convertView.findViewById(R.id.name);
        TextView emailCountTextView = (TextView)convertView.findViewById(R.id.emailsCount);
        nameTextView.setText(gr.getName());
        emailCountTextView.setText(gr.getStudentCount() + " emails");
        return convertView;
    }
}
