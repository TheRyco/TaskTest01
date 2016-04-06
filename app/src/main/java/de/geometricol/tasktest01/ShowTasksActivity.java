package de.geometricol.tasktest01;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class ShowTasksActivity extends AppCompatActivity {

    private TasksArrayList tasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_tasks);
        Intent launchIntent = getIntent();
        tasks = (TasksArrayList) launchIntent.getSerializableExtra("TASKS_LIST");

    }








}
