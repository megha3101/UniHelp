package com.hwt3314.example.univhelper;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat Sharma on 8/6/2017.
 */

public class Student implements Serializable{
    private String firstName;
    private String lastName;
    private String email;
    private boolean selected;
    private List<String> enrolledPapers;

    public Student(String fname, String lname, String email){
        firstName = fname;
        lastName = lname;
        this.email = email;
        enrolledPapers = new ArrayList<String>();
    }

    public String getFirstName(){
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName(){
        return lastName;
    }

    public String getEmail(){
        return email;
    }

    public boolean isSelected(){
        return selected;
    }

    public void setSelected(boolean selected){
        this.selected = selected;
    }

    public void addPaper(String paperCode){
        enrolledPapers.add(paperCode);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Student))
            return false;
        Student otherStud = (Student)obj;
        return firstName.equals(otherStud.firstName) && lastName.equals(otherStud.lastName);
    }

    public boolean isEnrolledInPaper(String paperCode){
        for(String code  : enrolledPapers){
            if(code.equals(paperCode))
                return true;
        }
        return false;
    }
}
