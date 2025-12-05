package com.example.crudconroom;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    private AppDatabase db;
    private TaskAdapter adapter;
    private RecyclerView rvTasks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = AppDatabase.getDatabase(this);
        rvTasks = findViewById(R.id.rvTasks);
        rvTasks.setLayoutManager(new LinearLayoutManager(this));

        FloatingActionButton fab = findViewById(R.id.fabAdd);
        // Usando lambda para el click del FAB
        fab.setOnClickListener(v -> startActivity(new Intent(this, TaskFormActivity.class)));
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new TaskAdapter(db.taskDao().getAllTasks(), new TaskAdapter.OnItemActionListener() {
            @Override
            public void onEdit(Task task) {
                Intent intent = new Intent(MainActivity.this, TaskFormActivity.class);
                intent.putExtra("ID", task.id);
                startActivity(intent);
            }

            @Override
            public void onDelete(Task task) {
                db.taskDao().delete(task);
                // Recargar la lista
                adapter.updateList(db.taskDao().getAllTasks());
            }
        });
        rvTasks.setAdapter(adapter);
    }
}