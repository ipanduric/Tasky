package com.zadaca.ipand.tasky;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class NewTaskActivity extends Activity {

    TextView tvTask;
    EditText etTitle, etDescription;
    Spinner sCategory, sPriority;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        SetUpUI();
    }

    private void SetUpUI() {

        tvTask = (TextView) findViewById(R.id.tvTask);
        etTitle = (EditText) findViewById(R.id.etTitle);
        etDescription = (EditText) findViewById(R.id.etDescription);
        sCategory = (Spinner) findViewById(R.id.sCategory);
        sPriority = (Spinner) findViewById(R.id.sPriority);

    }
}
