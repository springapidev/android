package com.coderbd.easysilentpro;
import java.util.Date;
/**
 * Created by Rajaul Islam on 11/1/2017.
 */

public class EasySchedule {
    private int id;
    private String name;
    private String startingTime;
    private  String endingTime;
    private String status;

    public EasySchedule() {
    }

    public EasySchedule(int id) {
        this.id = id;
    }

    public EasySchedule(int id, String name, String startingTime, String endingTime, String status) {
        this.id = id;
        this.name = name;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.status = status;
    }

    public EasySchedule(String name, String startingTime, String endingTime, String status) {
        this.name = name;
        this.startingTime = startingTime;
        this.endingTime = endingTime;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartingTime() {
        return startingTime;
    }

    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }

    public String getEndingTime() {
        return endingTime;
    }

    public void setEndingTime(String endingTime) {
        this.endingTime = endingTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
