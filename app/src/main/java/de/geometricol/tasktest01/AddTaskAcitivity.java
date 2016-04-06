package de.geometricol.tasktest01;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddTaskAcitivity extends Activity {

    private EditText titleText;
    private EditText notesText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task_acitivity);
        titleText = (EditText) findViewById(R.id.titleText);
        notesText = (EditText) findViewById(R.id.notesText);

    }

    public void onAcceptButtonClick(View v){
        Intent resultIntent = getIntent();
        String title = titleText.getText().toString();
        String notes = notesText.getText().toString();
        resultIntent.putExtra("TITLE", title);
        resultIntent.putExtra("NOTES", notes);
        setResult(1,resultIntent);
        finish();
    }


    public void onDeclineButtonClick(View v){
        onBackPressed();
    }


    @Override
    public void onBackPressed(){
        setResult(0);
        super.onBackPressed();
    }


}
