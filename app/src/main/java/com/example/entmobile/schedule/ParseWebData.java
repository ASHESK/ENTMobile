package com.example.entmobile.schedule;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

public class ParseWebData {
    private static final String FILE_NAME = "ent_shcedule_data.txt";
    private final Context context;

    public ParseWebData(Context context) {
        this.context = context;
    }

    protected ArrayList<Course> loadDataFromHtml() {
        try {
            String html = "http://planning.univ-lemans.fr/jsp/custom/modules/plannings/anonymous_cal.jsp?resources=2668&projectId=3&calType=ical&nbWeeks=4";
            URL url = new URL(html);

            URLConnection conn = url.openConnection();
            conn.setConnectTimeout(60000); // timing out in a minute

            InputStream file = context.getAssets().open("ADECal.ics");

            return openScheduleData(file);
        } catch (Exception e) {
            Log.w("parsing", e + ".");
            return new ArrayList<>();
        }
    }

    /**
     * Save data in a file and create the file if it doesn't exist
     *
     * @param data The data as a String that should be saved in the file
     * @return True if the data was correctly saved in the file
     */
    private boolean saveData(String data) {
        try {
            FileOutputStream file = context.openFileOutput(FILE_NAME, Context.MODE_PRIVATE); // create and/or open the file

            file.write(data.getBytes()); //Write in file
            file.close(); //File closed

            return true;
        } catch (IOException e) {
            Log.i("creating files", "could not create / save " + FILE_NAME);
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<Course> readScheduleData() {
        try {
            InputStream file = //context.getAssets().open("ADECal.ics"); // temporary way of getting the calendar not from the ent
                    context.openFileInput(FILE_NAME);

            return openScheduleData(file);
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    /**
     * Method that read the calendar from the ent
     * It should be called only once when the file is downloaded because it takes some times to read the data
     */
    private static ArrayList<Course> openScheduleData(InputStream file) {
        ArrayList<Course> coursesFromData = new ArrayList<>();

        if (file != null)
            try {
                BufferedReader br = new BufferedReader(new InputStreamReader(file)); // parsing the file
                String data = "", // initialisation of the data
                        line;

                boolean isEvent = false;
                while ((line = br.readLine()) != null) { // if there is a line
                    Log.i("prompt", line);

                    if (isEvent) // if the line is part of an event
                        data += line + "\n"; // get the line

                    if (line.contains("BEGIN:VEVENT")) // if the line is the start of an event
                        isEvent = true;

                    if (line.contains("END:VEVENT")) { // if the line is the end of an event
                        coursesFromData.add(Course.readData(data)); // extract the data of the text end ad it to courses

                        isEvent = false;
                        data = ""; // reset the data
                    }
                }

                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        return coursesFromData;
    }

}
