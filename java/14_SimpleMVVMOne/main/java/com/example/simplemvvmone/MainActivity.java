package com.example.simplemvvmone;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

// MainActivity.java
public class MainActivity extends AppCompatActivity {

    private TaskViewModel taskViewModel;
    private EditText editTextTask;
    private Button buttonAddTask;
    private RecyclerView recyclerViewTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskViewModel = new ViewModelProvider(this).get(TaskViewModel.class);

        // Initialize UI components
        editTextTask = findViewById(R.id.editTextTask);
        buttonAddTask = findViewById(R.id.buttonAddTask);
        recyclerViewTasks = findViewById(R.id.recyclerViewTasks);

        // Set up RecyclerView and its adapter
        TaskAdapter taskAdapter = new TaskAdapter();
        recyclerViewTasks.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewTasks.setAdapter(taskAdapter);

        // Example: Observe changes in tasks
        taskViewModel.getAllTasks().observe(this, tasks -> {
            // Update UI with the new list of tasks
            taskAdapter.setTasks(tasks);
        });

        // Example: Handle button click to add a task
        buttonAddTask.setOnClickListener(v -> {
            String taskTitle = editTextTask.getText().toString().trim();
            if (!TextUtils.isEmpty(taskTitle)) {
                Task newTask = new Task();
                newTask.title = taskTitle;
                taskViewModel.insert(newTask);

                // Clear the input field
                editTextTask.getText().clear();
            }
        });
    }
}
