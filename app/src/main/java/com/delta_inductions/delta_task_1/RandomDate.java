package com.delta_inductions.delta_task_1;
import java.util.GregorianCalendar;


public class RandomDate {
    private static final String TAG = "RandomDate";
    private static String Day;
    private static String Date;

    public static String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }

    public static String getDate() {
        return Date;
    }

    public static void setDate(String date) {
        Date = date;
    }

    public static void randomDate() {

        GregorianCalendar gc = new GregorianCalendar();

        int year = randBetween(1999, 2040);

        gc.set(gc.YEAR, year);

        int dayOfYear = randBetween(1, gc.getActualMaximum(gc.DAY_OF_YEAR));

        gc.set(gc.DAY_OF_YEAR, dayOfYear);


        switch (gc.get(gc.DAY_OF_WEEK))
        {
            case 1 : Day ="Sunday";
            break;
            case 2 : Day ="Monday";
                    break;
            case 3 : Day ="Tuesday";
            break;
            case 4 : Day ="Wednesday";
                break;
            case 5 : Day ="Thursday";
                break;
            case 6 : Day ="Friday";
                break;
            case 7 : Day ="Saturday";
                break;
            default:Day="null";
            break;
        }

        setDate (gc.get(gc.DAY_OF_MONTH) + "/" + (gc.get(gc.MONTH) + 1) + "/" + gc.get(gc.YEAR));

    }

    public static int randBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }


}




