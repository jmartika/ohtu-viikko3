package ohtu;

import java.util.*;

public class Submission {
    private int week;
    private int hours;
    private List<Integer> exercises;
    private String course; 




    public void setWeek(int week) {
        this.week = week;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }
    
     public void setExercises(List exercises) {
        this.exercises = exercises;
    }
     
      public void setCourse(String course) {
        this.course = course;
    }
    
    public int getWeek() {
        return week;
    }
    
    public int getHours() {
        return hours;
    }
    
    public int getExercises(){
        int summa = this.exercises.size();           
        return summa;
    }



    @Override
    public String toString() {
        return ""+course + ", viikko " + week + " tehtyjä tehtäviä yhteensä " + exercises.size() + " aikaa kului " + hours + " tehdyt tehtävät: " + exercises;
    }
    
}