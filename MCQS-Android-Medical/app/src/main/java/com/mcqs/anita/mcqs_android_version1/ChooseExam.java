package com.mcqs.anita.mcqs_android_version1;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

public class ChooseExam extends AppCompatActivity {

    private TextView actionBarTitle;
    private ListView lv;
    private ListViewAdapter adapter;
    private EditText inputSearch;
    private ArrayList<Exam> examList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_exam);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        actionBarTitle = (TextView) findViewById(R.id.action_bar_text);
        actionBarTitle.setText(R.string.title_activity_choose_exam);


        examList = new ArrayList<Exam>();

        // TODO: 23/09/2015 Download Exam List - http://192.168.1.7:4444/question/list/ 
        createList();

        adapter = new ListViewAdapter(this, examList);

        lv = (ListView) findViewById(R.id.listView);
        inputSearch = (EditText) findViewById(R.id.editText);

        lv.setAdapter(adapter);

        inputSearch.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable arg0) {
                // TODO Auto-generated method stub
                String text = inputSearch.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(text);
            }

            @Override
            public void beforeTextChanged(CharSequence arg0, int arg1,
                                          int arg2, int arg3) {
                // TODO Auto-generated method stub
            }

            @Override
            public void onTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
                // TODO Auto-generated method stub
            }
        });


    }



    private void createList(){
        // TODO: 22/09/2015 Sample Data 
        Exam exam1 = new Exam("Bear", 1,"Bears are mammals of the family Ursidae. Bears are classified as caniforms, or doglike carnivorans, with the pinnipeds being their closest living relatives.");
        Exam exam2 = new Exam("Camel", 2,"A camel is an even-toed ungulate within the genus Camelus, bearing distinctive fatty deposits known as \"humps\" on its back.");
        Exam exam3 = new Exam("Cat", 3,"The domestic cat (Felis catus or Felis silvestris catus) is a small, usually furry, domesticated, and carnivorous mammal.");
        Exam exam4 = new Exam("Deer", 4,"Deer (singular and plural) are the ruminant mammals forming the family Cervidae.");
        Exam exam5 = new Exam("Dog", 5,"The domestic dog (Canis lupus familiaris or Canis familiaris) is a domesticated canid which has been selectively bred for millennia for various behaviors, sensory capabilities, and physical attributes.");
        Exam exam6 = new Exam("Goat", 6,"The domestic goat (Capra aegagrus hircus) is a subspecies of goat domesticated from the wild goat of southwest Asia and Eastern Europe.");
        Exam exam7 = new Exam("Horse", 7,"The horse (Equus ferus caballus) is one of two extant subspecies of Equus ferus.");
        
        examList.add(exam1);
        examList.add(exam2);
        examList.add(exam3);
        examList.add(exam4);
        examList.add(exam5);
        examList.add(exam6);
        examList.add(exam7);
    }



        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_choose_exam, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            // if (id == R.id.action_settings) {
            //   return true;
            //  }

            return super.onOptionsItemSelected(item);
        }

}
