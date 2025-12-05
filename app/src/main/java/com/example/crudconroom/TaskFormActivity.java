package com.example.crudconroom;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class TaskFormActivity extends AppCompatActivity {

    private AppDatabase db;
    private int taskId = 0;
    private EditText etTitle, etDesc;
    private CheckBox cbCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_form);

        db = AppDatabase.getDatabase(this);
        etTitle = findViewById(R.id.etTitle);
        etDesc = findViewById(R.id.etDescription);
        cbCompleted = findViewById(R.id.cbCompleted);

        if (getIntent().hasExtra("ID")) {
            taskId = getIntent().getIntExtra("ID", 0);
            Task task = db.taskDao().getTaskById(taskId);
            if (task != null) {
                etTitle.setText(task.title);
                etDesc.setText(task.description);
                cbCompleted.setChecked(task.isCompleted);
                cbCompleted.setVisibility(View.VISIBLE);
            }
        }

        findViewById(R.id.btnSave).setOnClickListener(v -> {
            String title = etTitle.getText().toString();
            if (title.isEmpty()) {
                etTitle.setError("Requerido");
                return;
            }

            Task task = new Task();
            task.title = title;
            task.description = etDesc.getText().toString();
            task.isCompleted = cbCompleted.isChecked();

            if (taskId > 0) {
                // Actualizar
                task.id = taskId;
                Task originalTask = db.taskDao().getTaskById(taskId);
                if (originalTask != null) {
                    task.createdAt = originalTask.createdAt;
                }
                db.taskDao().update(task);
                Toast.makeText(this, "Tarea Actualizada", Toast.LENGTH_SHORT).show();
            } else {
                // Insertar
                task.createdAt = System.currentTimeMillis();
                db.taskDao().insert(task);
                Toast.makeText(this, "Tarea Guardada", Toast.LENGTH_SHORT).show();
            }

            finish();
        });
    }
}