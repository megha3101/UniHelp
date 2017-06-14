package com.hwt3314.example.univhelper;

import android.content.Intent;
import android.support.v4.content.res.TypedArrayUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat Sharma on 08/06/17.
 */

public class CreateGroupActivity extends AppCompatActivity {

    private ArrayList<String> paperCodes;
    private ArrayList<Student> students;
    private ArrayList<StudyGroup> studyGroups;
    private ArrayList<Student> listData;
    private int selectCount = 0;
    private StudentItemsAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_group);

        // get the selected paper code from intent
        final String paperCode = getIntent().getStringExtra("paperCode");
        setTitle(paperCode);

        ListView listView = (ListView) findViewById(R.id.listStudents);
        final TextView txtView = (TextView)findViewById(R.id.header);

        /*
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student stud = (Student)parent.getItemAtPosition(position);
                //if(stud.isSelected()){
                    selectCount++;
                    txtView.setText(paperCode + " - " + selectCount + " selected");
                //}
            }
        });
        listView.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectCount++;
                txtView.setText(paperCode + " - " + selectCount + " selected");
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        */

        // get the students data from intent
        students = (ArrayList<Student>)getIntent().getSerializableExtra("students");
        // get the paper codes from intent
        paperCodes = (ArrayList<String>)getIntent().getSerializableExtra("paperCodes");
        // get the study groups from intent
        studyGroups = (ArrayList<StudyGroup>)getIntent().getSerializableExtra("studyGroups");

        listData = new ArrayList<Student>();

        for(Student s : students){
            if(s.isEnrolledInPaper(paperCode)){
                listData.add(s);
            }
        }

        adaptor = new StudentItemsAdaptor(this, (Student[]) listData.toArray(new Student[listData.size()]));
        listView.setAdapter(adaptor);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                Intent intent= new Intent();
                intent.putExtra("paperCodes", paperCodes);
                intent.putExtra("students",students);
                intent.putExtra("studyGroups",studyGroups);
                setResult(RESULT_OK, intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void createGroup(View view){
        EditText grNameTextView = (EditText)findViewById(R.id.groupName);
        String grName = grNameTextView.getText().toString();
        if(grName == null || grName.length() == 0){
            Toast.makeText(this,"Please enter the group name", Toast.LENGTH_SHORT);
            return;
        }
        // create a new study group and start GroupsActivity
        List<Student> selectedStudents = adaptor.getSelectedStudents();
        StudyGroup gr = new StudyGroup(grName);
        for(Student s : selectedStudents){
            gr.addStudent(s);
        }
        // add the new study group to the list
        studyGroups.add(gr);

        Intent i = new Intent(CreateGroupActivity.this, GroupsActivity.class);
        i.putExtra("studyGroups",studyGroups);
        i.putExtra("paperCodes",paperCodes);
        i.putExtra("students",students);
        startActivity(i);

    }
}
