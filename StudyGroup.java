package com.hwt3314.example.univhelper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat Sharma on 8/6/2017.
 */

public class StudyGroup implements Serializable{
    private String name;
    private List<Student> students;

    public StudyGroup(String name){
        this.name = name;
        students = new ArrayList<Student>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getStudentCount(){
        return students.size();
    }

    public void addStudent(Student s){
        students.add(s);
    }

    public List<Student> getStudents(){
        return students;
    }

    public List<String> getEmails(){
        List<String> emails = new ArrayList<String>();
        for(Student s : students){
            emails.add(s.getEmail());
        }
        return emails;
    }
}
