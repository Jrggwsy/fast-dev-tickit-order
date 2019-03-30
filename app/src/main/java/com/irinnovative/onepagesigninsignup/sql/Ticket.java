package com.irinnovative.onepagesigninsignup.sql;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by zxkj on 2018/11/20.
 */

public class Ticket implements Parcelable {

    private int _id;//列车的识别，该表的主键，用于在数据库中存取信息

    private String origin;//出发地

    private String destination;//目的地

    private String originTime;//出发时间

    private String destinationTime;//到达时间

    private String time;//总时长

    private String identifier;//车次号

    private int businessSeatCount;//商务座剩余量

    private int firstSeatCount;//一等座剩余量

    private int secondSeatCount;//二等座剩余量

    private int noSeatCount;//无座剩余量

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getOriginTime() {
        return originTime;
    }

    public void setOriginTime(String originTime) {
        this.originTime = originTime;
    }

    public String getDestinationTime() {
        return destinationTime;
    }

    public void setDestinationTime(String destinationTime) {
        this.destinationTime = destinationTime;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public int getbusinessSeatCount() {
        return businessSeatCount;
    }

    public void setbusinessSeatCount(int businessSeatCount) {
        this.businessSeatCount = businessSeatCount;
    }

    public int getfirstSeatCount() {
        return firstSeatCount;
    }

    public void setfirstSeatCount(int firstSeatCount) {
        this.firstSeatCount = firstSeatCount;
    }

    public int getsecondSeatCount() {
        return secondSeatCount;
    }

    public void setsecondSeatCount(int secondSeatCount) {
        this.secondSeatCount = secondSeatCount;
    }

    public int getNoSeatCount() {
        return noSeatCount;
    }

    public void setNoSeatCount(int noSeatCount) {
        this.noSeatCount = noSeatCount;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this._id);
        dest.writeString(this.origin);
        dest.writeString(this.destination);
        dest.writeString(this.originTime);
        dest.writeString(this.destinationTime);
        dest.writeString(this.time);
        dest.writeString(this.identifier);
        dest.writeInt(this.businessSeatCount);
        dest.writeInt(this.firstSeatCount);
        dest.writeInt(this.secondSeatCount);
        dest.writeInt(this.noSeatCount);
    }

    public Ticket() {
    }

    protected Ticket(Parcel in) {
        this._id = in.readInt();
        this.origin = in.readString();
        this.destination = in.readString();
        this.originTime = in.readString();
        this.destinationTime = in.readString();
        this.time = in.readString();
        this.identifier = in.readString();
        this.businessSeatCount = in.readInt();
        this.firstSeatCount = in.readInt();
        this.secondSeatCount = in.readInt();
        this.noSeatCount = in.readInt();
    }

    public static final Creator<Ticket> CREATOR = new Creator<Ticket>() {
        @Override
        public Ticket createFromParcel(Parcel source) {
            return new Ticket(source);
        }

        @Override
        public Ticket[] newArray(int size) {
            return new Ticket[size];
        }
    };
}



