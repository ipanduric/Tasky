package com.zadaca.ipand.tasky;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    ListView lvTasks;
    Button bNewTask;
    TaskAdapter taskAdapter;

    public static final String OUTPUT_TITLE = "title";
    public static final String OUTPUT_DESCRIPTION = "description";
    public static final String OUTPUT_CATEGORY = "category";
    public static final String OUTPUT_PRIORITY = "priority";
    public static final int REQUEST_CODE_TASK = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUpUI();
    }

    private void SetUpUI() {

        lvTasks = (ListView) findViewById(R.id.lvTasks);
        bNewTask = (Button) findViewById(R.id.bNewTask);
        ArrayList<Task> task = this.loadTask();

        taskAdapter = new TaskAdapter(task);

        this.lvTasks.setAdapter(this.taskAdapter);

        this.bNewTask.setOnClickListener(this);

        this.lvTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

        AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
        builder1.setMessage("Do you want to delete this task?");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        TaskDBHelper.getInstance(getApplicationContext()).deleteTask((Task) taskAdapter.getItem(position));
                        taskAdapter.deleteAt(position);
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
        return true;
    }
        });
    }

        private ArrayList<Task> loadTask() {
        return TaskDBHelper.getInstance(this).getAllTasks();
    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(getApplicationContext(), NewTaskActivity.class);
        this.startActivityForResult(intent, REQUEST_CODE_TASK);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_TASK && resultCode == RESULT_OK) {

            String title = data.getStringExtra(OUTPUT_TITLE);
            String description = data.getStringExtra(OUTPUT_DESCRIPTION);
            String category = data.getStringExtra(OUTPUT_CATEGORY);
            String priority = data.getStringExtra(OUTPUT_PRIORITY);
            TaskDBHelper.getInstance(getApplicationContext()).insertTask(new Task(title, description, category, priority));
            taskAdapter.addNewTask(new Task(title, description, category, priority));
        }



}}
