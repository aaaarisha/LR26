package com.vasilkovamgkct.lr26;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class WorkoutDetailFragment extends Fragment {

    private static final String ARG_WORKOUT_ID = "workoutId";

    public static WorkoutDetailFragment newInstance(int workoutId) {
        WorkoutDetailFragment fragment = new WorkoutDetailFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_WORKOUT_ID, workoutId);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView textWorkoutName = view.findViewById(R.id.textWorkoutName);
        TextView textWorkoutDescription = view.findViewById(R.id.textWorkoutDescription);

        if (getArguments() != null) {
            int workoutId = getArguments().getInt(ARG_WORKOUT_ID);
            Workout workout = Workout.workouts[workoutId];
            textWorkoutName.setText(workout.getName());
            textWorkoutDescription.setText(workout.getDescription());
        }
    }
}
