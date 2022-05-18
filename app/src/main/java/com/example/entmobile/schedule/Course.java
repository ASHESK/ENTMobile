package com.example.entmobile.schedule;

import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalTime;
import java.util.Comparator;
import java.util.Date;
import java.util.StringTokenizer;

/**
 * Class containing the data of a course (time, emplacement, people involved, ...)
 */
public class Course {
    /**
     * Contain the number of the class, its type and its name
     * for exemple : M3103 - TDm - Algo avancée
     */
    private final String courseName;
    private final String room;

    private final String teacher;
    /**
     * Is the group of student attending to the course
     * for exemple : TD21A
     */
    private final String groupAttending;

    private final Date start;
    private final Date end;
    private final String duration;

    public Course(String courseName, String room, String teacher, String groupAttending, Date start, Date end, String duration) {
        this.courseName = courseName;
        this.room = room;
        this.teacher = teacher;
        this.groupAttending = groupAttending;
        this.start = start;
        this.end = end;
        this.duration = duration;
    }

    /**
     * Compare two courses by their starting times
     */
    public final static Comparator<? super Course> compareStartHour = new Comparator<Course>() {
        public int compare(Course c1, Course c2) {
            Duration dif = getHourMinuteDiference(c2.getStartDate(), c1.getStartDate());

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                return (int) dif.toMinutes();
            }
            return 0;
        }
    };

    /**
     * Take a string value of a course in the format of the schedule from the ent and read it.
     * It will extract the data of the string
     *
     * @param data A course in the form given by the ent
     * @return The full data of the course extracted
     */
    public static Course readData(String data) {
        // initialising values
        String courseName = "", room = "";
        String teacher = "", groupAttending = "";
        Date start = null, end = null;
        String duration = "";

        StringTokenizer whole = new StringTokenizer(data, "\n"), st; // browse data line by line
        while (whole.hasMoreTokens()) { // if there is a line after the current one
            st = new StringTokenizer(whole.nextToken(), ":"); // the lines are in form TYPE:VALUE
            String information = st.nextToken(); // so we create a new token to separate the two parts
            // of the line end we read the TYPE part of the line

            if (st.hasMoreTokens()) { // if the line as the VALUE part
                switch (information) { // we serch for the TYPE
                    case "DTSTART": // if TYPE is start time
                        start = convertStringIntoDate(st.nextToken());
                        break;

                    case "DTEND": // if TYPE is end time
                        end = convertStringIntoDate(st.nextToken());
                        break;

                    case "SUMMARY": // if TYPE is name of the course
                        courseName = st.nextToken();
                        break;

                    case "LOCATION": // if TYPE is emplacement
                        room = st.nextToken();
                        break;

                    case "DESCRIPTION": // if TYPE is group attending and teacher
                        // this part is formated this way : group \n teacher
                        String value = st.nextToken().replace("\\n", ":");
                        StringTokenizer people = new StringTokenizer(value, ":");
                        while (people.hasMoreTokens()) {

                            String peopleText = people.nextToken();
                            if (!peopleText.contains("Exported")) {
                                if (peopleText.matches("(.*)[0-9](.*)") || peopleText.contains("DUT") || !peopleText.equals(peopleText.toUpperCase())) {
                                    // if is a student (the teachers have their name and surname in all caps)
                                    groupAttending += peopleText + " ";
                                }
                                else {
                                    teacher += peopleText + " ";
                                }
                            }
                        }
                        break;
                }

                // if the start and end time were extracted
                if (start != null && end != null) {
                    Duration dif = getHourMinuteDiference(start, end);
                    duration = dif.toString().replace("PT", "").toLowerCase();
                }
            }
        }

        // creation of a new course containing the data of the string
        return new Course(courseName, room, teacher, groupAttending, start, end, duration);
    }

    /**
     * Get the difference of hours and minutes between two dates
     *
     * @param firstDate  The first date to compare
     * @param secondDate The second date to compare
     * @return The difference between the two in Duration
     */
    public static Duration getHourMinuteDiference(Date firstDate, Date secondDate) {
        Duration diference = null;

        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            // recuperation of hours and minutes of each dates
            LocalTime firstTime = LocalTime.of(firstDate.getHours(), firstDate.getMinutes());
            LocalTime secondTime = LocalTime.of(secondDate.getHours(), secondDate.getMinutes());

            // calculate difference between these dates
            diference = Duration.between(firstTime, secondTime);
        }

        return diference;
    }

    /**
     * This method takes the string date of form : 'yyyyMMdd*HHmmss*'
     * with '*' replacing a character of lesser importance
     *
     * @param data The date in string with the correct format ('yyyyMMdd*HHmmss*')
     * @return The same date as in the string but in a Date object
     */
    private static Date convertStringIntoDate(String data) {
        Date date = null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd"); //formatting the recuperation of the day to match the data
            date = new Date(sdf.parse(data.substring(0, 9)).getTime()); // recuperate the time in the data

            // the method sdf.parse() does not work for the full string at the same time
            // we have to get the hour and minutes separately
            sdf = new SimpleDateFormat("HHmm"); // formatting the recuperation of the hour to match the data
            Date hourMin = new Date(sdf.parse(data.substring(9, 13)).getTime()); // recuperate the time in the data
            date.setHours(hourMin.getHours()); // set the new hour
            date.setMinutes(hourMin.getMinutes()); // set the new minutes
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return date;
    }

    public Date getStartDate() {
        return start;
    }

    public String[] getInfos() {
        return new String[]{Schedule.getHourFormated(start), Schedule.getHourFormated(end), courseName, room};
    }

    public String[] getTotalInfos() {
        String[] infos = getInfos();
        int iLength = infos.length;
        String[] total = new String[iLength + 3];
        for (int i=0; i<iLength; i++)
            total[i] = infos[i];

        total[iLength] = teacher;
        total[iLength + 1] = groupAttending;
        total[iLength + 2] = duration;

        return total;
    }

    @Override
    public String toString() {
        return "Course{" + courseName + '\'' +
                ", room='" + room + '\'' +
                ", teacher='" + teacher + '\'' +
                ", groupe='" + groupAttending + '\'' +
                ", start='" + Schedule.getDateFormated(start) + " " + Schedule.getHourFormated(start) + '\'' +
                ", end='" + Schedule.getDateFormated(end) + " " + Schedule.getHourFormated(end) + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }

}
