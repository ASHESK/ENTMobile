package com.example.entmobile.schedule;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entmobile.R;

import java.util.ArrayList;

public class CourseAdaptator extends RecyclerView.Adapter<ContentViewHolder> {
    private final ArrayList<Course> adaptedCourses;

    /**
     * Instantiate the class with the courses to be displayed
     * @param courses
     */
    public CourseAdaptator(ArrayList<Course> courses) {
        this.adaptedCourses = courses;
    }

    @NonNull
    @Override
    public ContentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.schedule_course_view, parent, false);
        // get the schedule_card_view.xml layout and set it for ContentViewHolder
        return new ContentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ContentViewHolder holder, int position) {
        holder.initContentViewHolder(adaptedCourses.get(position)); // give this particular holder its course
    }

    @Override
    public int getItemCount() {
        return adaptedCourses.size();
    }
}
