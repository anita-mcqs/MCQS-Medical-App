package com.mcqs.anita.mcqs_android_version1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by david-MCQS on 23/09/2015.
 */
public class DownloadExam extends AppCompatActivity {

    private TextView actionBarTitle;
    TextView txtName;
    TextView txtDescription;
    String description;
    String name;
    int id;
  //  Button downloadExam;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selectedexam);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.actionbar);
        actionBarTitle = (TextView) findViewById(R.id.action_bar_text);
        actionBarTitle.setText(R.string.title_activity_download_exam);

        Intent i = getIntent();

        name = i.getStringExtra("name");
        id = i.getIntExtra("id", 0);
        description = i.getStringExtra("description");

        txtName = (TextView) findViewById(R.id.textViewExamName);
        txtDescription = (TextView) findViewById(R.id.textViewExamDescription);

        txtName.setText(name);
        txtDescription.setText(description);





    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_download_exam, menu);
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
