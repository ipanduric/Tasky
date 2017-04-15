package com.zadaca.ipand.tasky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import static com.zadaca.ipand.tasky.MainActivity.OUTPUT_CATEGORY;
import static com.zadaca.ipand.tasky.MainActivity.OUTPUT_DESCRIPTION;
import static com.zadaca.ipand.tasky.MainActivity.OUTPUT_PRIORITY;
import static com.zadaca.ipand.tasky.MainActivity.OUTPUT_TITLE;

public class NewTaskActivity extends Activity implements View.OnClickListener {

    TextView tvTask;
    EditText etTitle, etDescription;
    Spinner sCategory, sPriority;
    Button bAddTask;

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
        bAddTask = (Button) findViewById(R.id.bAddTask);
        bAddTask.setOnClickListener(this);

    }


    @Override
    public void onClick(View v) {
        String titleInput = null, descriptionInput = null, priorityInput, categoryInput;

        if (etTitle.getText().toString().isEmpty()) {
            Toast.makeText(this, "Please, enter title!", Toast.LENGTH_SHORT).show();
        } else {
            titleInput = etTitle.getText().toString();
        }
        if (!(etTitle.getText().toString().isEmpty())) {
            descriptionInput = etDescription.getText().toString();
            priorityInput = sPriority.getSelectedItem().toString();
            categoryInput = sCategory.getSelectedItem().toString();
            Intent intent = new Intent();
            intent.putExtra(OUTPUT_TITLE, titleInput);
            intent.putExtra(OUTPUT_DESCRIPTION, descriptionInput);
            intent.putExtra(OUTPUT_PRIORITY, priorityInput);
            intent.putExtra(OUTPUT_CATEGORY, categoryInput);
            this.setResult(RESULT_OK, intent);
            this.finish();
        }
    }
}

