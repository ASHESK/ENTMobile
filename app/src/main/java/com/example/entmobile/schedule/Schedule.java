package com.example.entmobile.schedule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.entmobile.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * The main class for the schedule module
 */
public class Schedule extends AppCompatActivity {
    RecyclerView scheduleView;

    ArrayList<Course> courses;

    private Calendar calendar;
    
    private static String[] MONTHS;

    private TextView dateView;

    FloatingActionButton backToCurrentDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.schedule_activity);

        // load data
        ParseWebData parser = new ParseWebData(this);
        courses = parser.loadDataFromHtml();

        // instantiation
        calendar = Calendar.getInstance();
        MONTHS = getResources().getStringArray(R.array.months);

        scheduleView = findViewById(R.id.scheduleView); // instantiate the recycler
        RecyclerView.LayoutManager recyclerManager = new LinearLayoutManager(this);
        scheduleView.setLayoutManager(recyclerManager); // set a manager for the recycler
        scheduleView.setHasFixedSize(true);

        dateView = findViewById(R.id.dateView); // instantiate the view of the date
        dateView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openCalendar(v);
            }
        });

        // Set a listener on the Previous Date button
        ImageButton button_previous = findViewById(R.id.button_previousDate);
        button_previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                previousDate();
            }
        });

        // Set a listener on the Next Date button
        ImageButton button_next = findViewById(R.id.button_nextDate);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextDate();
            }
        });

        backToCurrentDay = findViewById(R.id.floating_back_to_current_day);
        backToCurrentDay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goBackToCurrentDay();
            }
        });

        changeDate(0); // instantiate the recycler and the date view
    }

    /**
     * Open a dialog view with a calendar to change the date
     *
     * @param v The view where to launch the dialog
     */
    private void openCalendar(View v) {
        DialogChangeDay changeDay = new DialogChangeDay(v, calendar.getTimeInMillis());
        changeDay.getBuilder().setPositiveButton(R.string.validate, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Date date = changeDay.getSelectedDate();
                int dif = getDifInDays(calendar.getTime(), date);
                changeDate(dif - 1);

                dialog.dismiss();
            }
        })
                .create().show();
    }

    /**
     * Change the day in the calendar to the amount of day computed in the argument.
     * It set the dateView to the current date of the calendar and it show the courses of the day
     *
     * @param amountOfDay The amount of days to add to the calendar
     * @return the string value of the date
     */
    private String changeDate(int amountOfDay) {
        calendar.add(Calendar.DAY_OF_YEAR, amountOfDay); // change the day in the calendar
        String dateText = getDateFormated(calendar.getTime()); // get a string from the date
        dateView.setText(dateText); // set dateView to this string

        ArrayList<Course> thisDayCourses = getCoursesOfTheDay(); // get course for the day
        showCourses(thisDayCourses); // and show them

        if (getDifInDays(calendar.getTime(), new Date()) < 1) {
            backToCurrentDay.setRotationY(0);
            backToCurrentDay.setVisibility(View.VISIBLE);
        }
        else if (getDifInDays(calendar.getTime(), new Date()) > 1) {
            backToCurrentDay.setRotationY(180);
            backToCurrentDay.setVisibility(View.VISIBLE);
        }
        else {
            backToCurrentDay.setRotationY(0);
            backToCurrentDay.setVisibility(View.INVISIBLE);
        }
        return dateText;
    }

    /**
     * Show the givens course in the page on a view. It shows there start and end time (in hour)
     * , there name and their location
     *
     * @param courseToBeShown The courses to be shown on the page
     */
    private void showCourses(ArrayList<Course> courseToBeShown) {
        Collections.sort(courseToBeShown, Course.compareStartHour); // sort the course by their starting hour

        // put the courses to be shown in the recycler view
        RecyclerView.Adapter recyclerAdapter = new CourseAdaptator(courseToBeShown);
        scheduleView.setAdapter(recyclerAdapter); // adapt the recycler view
    }

    /**
     * Gives the courses of the day
     *
     * @return All the lessons happening the same day as the same day of the current day in calendar
     */
    private ArrayList<Course> getCoursesOfTheDay() {
        ArrayList<Course> coursesOfDay = new ArrayList<>();
        Date currentDate = calendar.getTime(); // get the current date

        for (Course course : courses) {
            Date cDate = course.getStartDate();
            if (cDate!=null &&
                    currentDate.getYear() == cDate.getYear() &&
                    currentDate.getMonth() == cDate.getMonth() &&
                    currentDate.getDate() == cDate.getDate()) {
                // if same year, month, day
                coursesOfDay.add(course); // add to the list
            }
        }

        return coursesOfDay;
    }

    /**
     * Change the date of the calendar to the current one
     */
    private void goBackToCurrentDay() {
        int dif = getDifInDays(new Date(), calendar.getTime()); // the difference in days

        changeDate(dif * -1); // go back to today
    }

    /**
     * Get the difference in days between two dates. If the second date is before the first it will return < 0,
     * if its after it will return > 0 and if they are the same, it will return 0
     *
     * @param firstDate  The first date
     * @param secondDate The second date
     * @return The difference in int between those dates from the first date to the second
     */
    public static int getDifInDays(Date firstDate, Date secondDate) {
        int diference = 0;

        if (firstDate != null && secondDate != null) { // if there really are dates

            if (firstDate.compareTo(secondDate) != 0) {
                long diffInMillies = secondDate.getTime() - firstDate.getTime();
                diference = (int) TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);

                if (secondDate.compareTo(firstDate) == 1)
                    diference += 1;
            }
        }

        return diference;
    }

    /**
     * Change the current date of the calendar to the previous one
     */
    private void previousDate() {
        changeDate(-1);
    }

    /**
     * Change the current date of the calendar to the next one
     */
    private void nextDate() {
        changeDate(1);
    }

    /**
     * Get the string value of the day
     *
     * @param date Date used for the day
     * @return the string value of the date
     */
    public static String getDateFormated(Date date) {
        return date.getDate() + " " + MONTHS[date.getMonth()] + " " + (date.getYear() + 1900);
    }

    /**
     * Get the string value of the hour
     *
     * @param date Date used for the hour
     * @return the string value of the date
     */
    public static String getHourFormated(Date date) {
        return date.getHours() + "h" + ((date.getMinutes() > 0) ? date.getMinutes() : "");
    }

}
