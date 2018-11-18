package ohtu;

import java.util.*;

public class Information{
    private List<Integer> exercises;
    private String fullName;
    private String name;
    private String term;
    private int year;



    public void setExercises(List exercises) {
        this.exercises = exercises;

    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    
    public void setYear(int year) {
        this.year = year;
    }
    
    public void setTerm(String term) {
        this.term = term;
    }
    public int getMaxTeht(int week) {
        return this.exercises.get(week);
    }
    
    public String getFullName() {
        return this.fullName;
    }

    public String getName() {
        return this.name;
    }
    
    public List getExercises() {
        return this.exercises;
    }
    
    public int getYear() {
        return this.year;
    }
    public String getTerm() {
        return this.term;
    }

    @Override
    public String toString() {
        return "";
    }
    
}