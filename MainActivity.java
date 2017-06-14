package com.hwt3314.example.univhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by Rajat Sharma on 8/06/17.
 */

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> paperCodes;
    private ArrayList<StudyGroup> studyGroups;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // Handler function when button "Start Group" is clicked
    public void startGroupBtnClicked(View view){
        // create a new intent with search paper activity
        Intent i = new Intent(MainActivity.this, GroupsActivity.class);

        // pass the data into the intent
        if(paperCodes == null)
            paperCodes = createPaperCodes();
        i.putExtra("paperCodes", paperCodes);

        if(students == null)
            students = createStudents();
        i.putExtra("students",students);

        if(studyGroups == null)
            studyGroups = new ArrayList<StudyGroup>();
        i.putExtra("studyGroups",studyGroups);

        // start the search paper activity through the intent
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == 2404) {
            if(data != null) {
                students = (ArrayList<Student>)data.getSerializableExtra("students");
                paperCodes = (ArrayList<String>)data.getSerializableExtra("paperCodes");
                studyGroups = (ArrayList<StudyGroup>)data.getSerializableExtra("studyGroups");
            }
        }
    }

    // Create a list of all paper codes
    private ArrayList<String> createPaperCodes(){
        ArrayList<String> paperCodes = new ArrayList<String>();
        paperCodes.add("ComSci101");
        paperCodes.add("SoftEng205");
        paperCodes.add("Maths108");
        paperCodes.add("Design180");
        return paperCodes;
    }

    // Create a list of students with name and email
    private ArrayList<Student> createStudents(){
        ArrayList<Student> students = new ArrayList<Student>();
        Student s = new Student("Rajat","Sharma","s.rajat94@yahoo.co.nz");
        s.addPaper("ComSci101");
        s.addPaper("SoftEng205");
        students.add(s);

        s = new Student("Dave","Comia","dave.comia@hotmail.com");
        s.addPaper("Maths108");
        s.addPaper("Design180");
        students.add(s);

        s = new Student("Alex","Glenn","alex.glenn@gmail.com");
        s.addPaper("Design180");
        students.add(s);

        s = new Student("Megha","Menon","megha.menon@yahoo.com");
        s.addPaper("SoftEng205");
        s.addPaper("ComSci101");
        students.add(s);

        s = new Student("Nathan","Kwong","nathan.kwong@gmail.com");
        s.addPaper("Maths108");
        s.addPaper("SoftEng205");
        students.add(s);

        return students;
    }
}
