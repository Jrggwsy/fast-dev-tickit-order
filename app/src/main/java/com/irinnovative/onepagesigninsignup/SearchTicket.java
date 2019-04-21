package com.irinnovative.onepagesigninsignup;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.sql.Database;
import com.irinnovative.onepagesigninsignup.sql.SqlDataInsert;
import com.irinnovative.onepagesigninsignup.ui.DateDialog;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

import dmax.dialog.SpotsDialog;

import static com.irinnovative.onepagesigninsignup.ui.DateDialog.GONE_TIME;

public class SearchTicket extends AppCompatActivity {

    EditText place1;
    String messageStart;
    EditText place2;
    String messageEnd;
    TextView textView_Date;
    TextView textView_class;
    TextView textView_Week;
    Button button_change;
    Button button_ticket_query;

    private AlertDialog dialog;
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            dialog.dismiss();
            Intent intent = new Intent(SearchTicket.this, VehicleActivity.class);
            intent.putExtra("start", messageStart);
            intent.putExtra("end", messageEnd);
            startActivity(intent);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_ticket);
        textView_class=(TextView)findViewById(R.id.textview_class);
        button_change=(Button)findViewById(R.id.button_change);//交换按钮
        button_ticket_query=(Button)findViewById(R.id.ticket_query);//查询按钮
        textView_Date=(TextView)findViewById(R.id.textview_Date);
        textView_Week=(TextView)findViewById(R.id.textview_Week);
        dialog = new SpotsDialog.Builder().setMessage("查询中").setTheme(R.style.Custom).setContext(this).build();

        initSQLData();

        //交换
        button_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place1=(EditText) findViewById(R.id.place_1);
                place2=(EditText) findViewById(R.id.place_2);
                String temp1,temp2;
                temp1=place1.getText().toString();
                temp2=place2.getText().toString();
                place1.setText(temp2);
                place2.setText(temp1);
            }
        });

        textView_class.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(SearchTicket.this,"内测版本，暂时不可选择其他",Toast.LENGTH_SHORT).show();
            }
        });


        //设置日期
        Calendar c = Calendar.getInstance();
        c.setTimeZone(TimeZone.getTimeZone("GMT+8:00"));
        String mMonth = String.valueOf(c.get(Calendar.MONTH) + 1);// 获取当前月份
        String mDay = String.valueOf(c.get(Calendar.DAY_OF_MONTH));// 获取当前月份的日期号码
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        textView_Date.setText(setDateText(mMonth, mDay));
        textView_Date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DateDialog dateDialog = DateDialog.newInstance(GONE_TIME, "");
                dateDialog.show(getSupportFragmentManager(), "");
                dateDialog.setDatePickerListener(new DateDialog.DateListener() {
                    @Override
                    public void dateListener(String date) {
                        textView_Date.setText(date);
                        textView_Week.setText(getWeek(date));
                    }
                });
            }
        });

        //查询按钮
        button_ticket_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                place1=(EditText) findViewById(R.id.place_1);
                place2=(EditText) findViewById(R.id.place_2);
                messageStart=place1.getText().toString();
                messageEnd=place2.getText().toString();
                if(TextUtils.isEmpty(messageStart)){
                    Toast.makeText(SearchTicket.this, "出发地不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(TextUtils.isEmpty(messageEnd)){
                    Toast.makeText(SearchTicket.this, "目的地不可为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                dialog.show();
                handler.postDelayed(runnable, 2000);
            }
        });
    }

    private void initSQLData() {
        if (Database.newInstance(this).getTicketCount() == 0) {
            SqlDataInsert sqlDataInsert = new SqlDataInsert();
            sqlDataInsert.inst(this);
        }
    }
    private String setDateText(String month, String day) {
        return month.concat("月").concat(day).concat("日");
    }
    private String getWeek(String pTime) {

        String Week = "";

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c = Calendar.getInstance();
        try {

            c.setTime(format.parse(pTime));

        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 1) {
            Week += "周日";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 2) {
            Week += "周一";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 3) {
            Week += "周二";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 4) {
            Week += "周三";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 5) {
            Week += "周四";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 6) {
            Week += "周五";
        }
        if (c.get(Calendar.DAY_OF_WEEK) == 7) {
            Week += "周六";
        }


        return Week;
    }

    private void setWeekText(String mWay) {
        if ("1".equals(mWay)) {
            mWay = "日";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        textView_Week.setText("周".concat(mWay));
    }
}
