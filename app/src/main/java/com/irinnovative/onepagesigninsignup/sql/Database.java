package com.irinnovative.onepagesigninsignup.sql;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zxkj on 2018/11/19.
 */

public class Database extends SQLiteOpenHelper {

    public static Database database;
    private SQLiteDatabase db;

    public Database(Context context) {
        super(context, "stu.db", null, 1);
        db = getReadableDatabase();
    }

    public static Database newInstance(Context context) {
        if (database == null) {
            database = new Database(context);
        }
        return database;
    }

    public void insertUser(User user) {
        ContentValues values = new ContentValues();
        values.put("_id", System.currentTimeMillis());
        values.put("userName", user.getUserName());
        values.put("password", user.getPassword());
        values.put("numberId", "");
        values.put("name", "");
        values.put("sex", "");
        values.put("number", "");
        db.insert("User", null, values);
    }

    public User getUser(String name) {
        Cursor cursor = db.query("User", null, "userName=".concat(name), null, null, null, null);
        User user = new User();
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                user.set_id(cursor.getInt(0));
                user.setUserName(cursor.getString(1));
                user.setPassword(cursor.getString(2));
                user.setNumberId(cursor.getString(3));
                user.setName(cursor.getString(4));
                user.setSex(cursor.getString(5));
                user.setNumber(cursor.getString(6));
            }
            cursor.close();
        }
        return user;
    }

    public void upUser(User user) {
        ContentValues values = new ContentValues();
        values.put("numberId", user.getNumberId());
        values.put("name", user.getName());
        values.put("sex", user.getSex());
        values.put("number", user.getNumber());
        String whereClause = "userName=?";
        String[] whereArgs = {user.getUserName()};
        db.update("User", values, whereClause, whereArgs);
    }

    public void uoUser(User user) {
        ContentValues values = new ContentValues();
        values.put("password", "111111");
        values.put("numberId", "111111");
        String whereClause = "userName=?";
        String[] whereArgs = {user.getUserName()};
        db.update("User", values, whereClause, whereArgs);
    }

    public void insertTicket(Ticket ticket) {
        ContentValues values = new ContentValues();
        values.put("_id", System.currentTimeMillis());
        values.put("origin", ticket.getOrigin());
        values.put("destination", ticket.getDestination());
        values.put("originTime", ticket.getOriginTime());
        values.put("destinationTime", ticket.getDestinationTime());
        values.put("time", ticket.getTime());
        values.put("identifier", ticket.getIdentifier());
        values.put("businessSeatCount", ticket.getbusinessSeatCount());
        values.put("firstSeatCount", ticket.getfirstSeatCount());
        values.put("secondSeatCount", ticket.getsecondSeatCount());
        values.put("noSeatCount", ticket.getNoSeatCount());
        db.insert("Ticket", null, values);
    }

    public void upTicket(Ticket ticket) {
        ContentValues values = new ContentValues();
        values.put("businessSeatCount", ticket.getbusinessSeatCount());
        values.put("firstSeatCount", ticket.getfirstSeatCount());
        values.put("secondSeatCount", ticket.getsecondSeatCount());
        values.put("noSeatCount", ticket.getNoSeatCount());
        String whereClause = "origin=?  AND destination=?  AND originTime=?  AND destinationTime=?  AND time=?";
        String[] whereArgs = {ticket.getOrigin(), ticket.getDestination(), ticket.getOriginTime(), ticket.getDestinationTime(), ticket.getTime()};
        db.update("Ticket", values, whereClause, whereArgs);
    }

    public int getTicketCount() {
        Cursor cursor = db.query("Ticket", null, null, null, null, null, null);
        return cursor.getCount();
    }

    public List<Ticket> getTicket(String origin, String destination) {
        Cursor cursor = db.query("Ticket", null, "origin like '%".concat(origin).concat("%'")
                        .concat(" AND ").concat("destination like '%").concat(destination).concat("%'")
                , null, null, null, null);
        List<Ticket> tickets = new ArrayList<>();
        while (cursor.moveToNext()) {
            Ticket ticket = new Ticket();
            ticket.set_id(cursor.getInt(0));
            ticket.setOrigin(cursor.getString(1));
            ticket.setDestination(cursor.getString(2));
            ticket.setOriginTime(cursor.getString(3));
            ticket.setDestinationTime(cursor.getString(4));
            ticket.setTime(cursor.getString(5));
            ticket.setIdentifier(cursor.getString(6));
            ticket.setbusinessSeatCount(cursor.getInt(7));
            ticket.setfirstSeatCount(cursor.getInt(8));
            ticket.setsecondSeatCount(cursor.getInt(9));
            ticket.setNoSeatCount(cursor.getInt(10));
            tickets.add(ticket);
        }
        return tickets;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String stuUserTable = "create table User(_id integer primary key autoincrement,userName text , password text, numberId text, name text, sex text, number text)";
        String stuTicketTable = "create table Ticket(_id integer primary key autoincrement,origin text , destination text" +
                ",originTime text ,destinationTime text , time text , identifier text,businessSeatCount Integer,firstSeatCount Integer" +
                ",secondSeatCount Integer,noSeatCount Integer)";
        db.execSQL(stuUserTable);
        db.execSQL(stuTicketTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
