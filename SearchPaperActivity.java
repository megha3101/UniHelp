package com.hwt3314.example.univhelper;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.ArrayList;

/**
 * Created by Rajat Sharma on 8/6/17.
 */

public class SearchPaperActivity extends AppCompatActivity {

    private ArrayList<Student> students;
    private ArrayList<String> paperCodes;
    private ArrayAdapter<String> adaptor;
    private ArrayList<String> codes;
    private  ArrayList<StudyGroup> studyGroups;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_paper);
        setTitle("Search Paper");

        // get the search view widget
        final SearchView searchView = (SearchView)findViewById(R.id.searchText);
        //searchView.setBackgroundColor(Color.BLUE);

        codes = new ArrayList<String>();

        // get the paper codes list from intent
        paperCodes = getIntent().getStringArrayListExtra("paperCodes");

        // get the students data from intent
        students = (ArrayList<Student>)getIntent().getSerializableExtra("students");

        // get the study groups from intent
        studyGroups = (ArrayList<StudyGroup>)getIntent().getSerializableExtra("studyGroups");

        // get the students data from intent
        //ArrayList<Student> students = (ArrayList<Student>)getIntent().getSerializableExtra("students");

        // get the paper codes list view
        ListView paperCodesListView = (ListView) findViewById(R.id.listPaperCodes);
        paperCodesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String paperCode = (String)parent.getItemAtPosition(position);
                Intent i = new Intent(SearchPaperActivity.this, CreateGroupActivity.class);
                i.putExtra("paperCode",paperCode);
                i.putExtra("students",students);
                i.putExtra("paperCodes",paperCodes);
                i.putExtra("studyGroups",studyGroups);
                startActivity(i);
            }
        });


        adaptor = new ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, codes);
        paperCodesListView.setAdapter(adaptor);

        // display all the paper codes when the activity shows
        for(String code : paperCodes){
            codes.add(code);
            adaptor.notifyDataSetChanged();
        }
        // add search view submit and text change listener
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                codes.clear();
                adaptor.notifyDataSetChanged();
                String queryString = searchView.getQuery().toString();
                for(String code : paperCodes){
                    if(queryString.length() == 0 || queryString == null){
                        codes.add(code);
                        adaptor.notifyDataSetChanged();
                    }
                    else if(code.toLowerCase().contains(queryString.toLowerCase())){
                        codes.add(code);
                        adaptor.notifyDataSetChanged();
                    }
                }
                return false;
            }
        });
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
}
