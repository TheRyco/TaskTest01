package de.geometricol.tasktest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private TextView infoView;
    private TasksArrayList tasks;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        infoView = (TextView) findViewById(R.id.infoView);
        tasks = new TasksArrayList();


    }

    protected void onCreateTaskButtonClick(View v) {
        Intent createTaskIntent = new Intent(this, AddTaskAcitivity.class);

        startActivityForResult(createTaskIntent, 1);


    }

    protected void onShowTasksButtonClick(View v) {
        Intent showTasksIntent = new Intent(this, ShowTasksActivity.class);
        showTasksIntent.putExtra("TASKS_LIST", tasks);
        startActivity(showTasksIntent);
    }

    private void onAddTaskResult(int resultCode, Intent data) {

        switch (resultCode) {

            case 1:
                infoView.setText("Task created! Title: " + data.getStringExtra("TITLE") + " Notes: " + data.getStringExtra("NOTES"));
                tasks.add(new Task(data.getStringExtra("TITLE"), data.getStringExtra("NOTES")));
                break;
            default:
                infoView.setText("Unknown Result Code!");
                break;


        }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == 0){
            infoView.setText("Result 0!");
            return;
        }

        switch (requestCode) {

            case 1: onAddTaskResult(resultCode, data);
                break;

        }




    }

    @Override
    protected void onPause() {


        super.onPause();
    }
}
