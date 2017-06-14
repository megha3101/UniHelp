package com.hwt3314.example.univhelper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat Sharma on 08/06/17.
 */

public class GroupsActivity extends AppCompatActivity {

    private ArrayList<StudyGroup> studyGroups;
    private ArrayList<String> paperCodes;
    private ArrayList<Student> students;
    private ArrayList<StudyGroup> listData;
    private GroupItemsAdaptor adaptor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups);
        setTitle("Study Groups");

        TextView textView = (TextView)findViewById(R.id.groupsHeader);

        // get all the data from intent
        studyGroups = (ArrayList<StudyGroup>)getIntent().getSerializableExtra("studyGroups");
        paperCodes = (ArrayList<String>)getIntent().getSerializableExtra("paperCodes");
        students = (ArrayList<Student>)getIntent().getSerializableExtra("students");

        if(studyGroups.size() == 0)
            textView.setText("No groups found");

        ListView groupsListView = (ListView) findViewById(R.id.listGroups);

        groupsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                StudyGroup group = (StudyGroup) parent.getItemAtPosition(position);
                List<String> emails = group.getEmails();
                String[] toList = (String[]) emails.toArray(new String[emails.size()]);

                Intent email = new Intent(Intent.ACTION_SEND);
                email.putExtra(Intent.EXTRA_EMAIL, toList);
                email.putExtra(Intent.EXTRA_SUBJECT, "Lets Study!");
                email.putExtra(Intent.EXTRA_TEXT, "Hey we are in the same paper, we should study together!");
                email.setType("message/rfc822");
                startActivity(Intent.createChooser(email, "Choose an Email client :"));
            }
        });

        listData = new ArrayList<StudyGroup>();
        for(StudyGroup gr : studyGroups){
            listData.add(gr);
        }

        adaptor = new GroupItemsAdaptor(this, (StudyGroup[]) listData.toArray(new StudyGroup[listData.size()]));
        groupsListView.setAdapter(adaptor);
    }


    public void newGroup(View view){
        // create a new intent with search paper activity
        Intent i = new Intent(GroupsActivity.this, SearchPaperActivity.class);

        // pass the data to intent
        i.putExtra("paperCodes", paperCodes);
        i.putExtra("students",students);
        i.putExtra("studyGroups",studyGroups);

        // start the search paper activity through the intent
        startActivity(i);
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
}
