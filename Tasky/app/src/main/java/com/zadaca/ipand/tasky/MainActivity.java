package com.zadaca.ipand.tasky;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView lvTasks;
    Button bNewTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SetUpUI();
    }

    private void SetUpUI() {

        lvTasks = (ListView) findViewById(R.id.lvTasks);
        bNewTask = (Button) findViewById(R.id.bNewTask);
    }


}
