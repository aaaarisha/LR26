package com.vasilkovamgkct.lr26;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ListView listViewWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewWorkouts = findViewById(R.id.listViewWorkouts);

        // Получаем список названий тренировок
        String[] workoutNames = new String[Workout.workouts.length];
        for (int i = 0; i < workoutNames.length; i++) {
            workoutNames[i] = Workout.workouts[i].getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, workoutNames);
        listViewWorkouts.setAdapter(adapter);

        listViewWorkouts.setOnItemClickListener((parent, view, position, id) -> {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("workoutId", position);
            startActivity(intent);
        });
    }
}
