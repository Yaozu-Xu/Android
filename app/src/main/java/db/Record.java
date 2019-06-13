package db;

import android.annotation.SuppressLint;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Record extends DataSupport {

    private String sport;
    private String distance;
    private String duration;
    private String recordTime;
    private String name;

//    public Record(String sport, String distance, String duration, String recordTime, String name){
//        this.sport = sport;
//        this.distance = distance;
//        this.duration = duration;
//        this.recordTime = recordTime;
//        this.name = name;
//    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getSport() {
        return sport;
    }

    public void setSport(String sport) {
        this.sport = sport;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(String recordTime) {
        this.recordTime = recordTime;
    }

    public static String getCurrentTime(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");//设置日期格式
        return df.format(new Date());// new Date()为获取当前系统时间，也可使用当前时间戳

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
