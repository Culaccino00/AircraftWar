package edu.hitsz.DAO;

import java.io.Serializable;

public class Record implements Serializable {
    private String userName;
    private int score;
    private String time;
    public Record(String userName, int score, String time){
        this.userName = userName;
        this.score = score;
        this.time = time;
    }
    public Record(){
    }
    public void setUserName(String userName){
        this.userName = userName;
    }

    public String getUserName(){
        return userName;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore(){
        return score;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTime(){
        return time;
    }

}
