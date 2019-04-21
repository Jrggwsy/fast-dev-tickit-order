package com.irinnovative.onepagesigninsignup.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import com.irinnovative.onepagesigninsignup.R;

public class DateDialog extends DialogFragment {

    private DatePicker datepicker;
    private TimePicker timePicker;
    private TextView cancels;
    private TextView affirmRecharge;
    DateListener dateListener;
    public static int SHOW_TIME = 1;
    public static int GONE_TIME = 2;

    public static DateDialog newInstance(int type, String time) {
        DateDialog dateDialog = new DateDialog();
        Bundle bundle = new Bundle();
        bundle.putInt("DateType", type);
        bundle.putString("time", time);
        dateDialog.setArguments(bundle);
        return dateDialog;
    }

    public interface DateListener {
        void dateListener(String date);
    }

    public void setDatePickerListener(DateListener dateListener) {
        this.dateListener = dateListener;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_date_dialog, container, false);
        datepicker = (DatePicker) view.findViewById(R.id.datepicker);
        timePicker = (TimePicker) view.findViewById(R.id.time_picker);
        cancels = (TextView) view.findViewById(R.id.cancel);
        affirmRecharge = (TextView) view.findViewById(R.id.affirm);
        int type = getArguments().getInt("DateType");
        final boolean isTimeType = SHOW_TIME == type;
        if (isTimeType) {
            timePicker.setIs24HourView(true);
        } else {
            timePicker.setVisibility(View.GONE);
        }
        String mPickerTime = getArguments().getString("time", "");
        if (!TextUtils.isEmpty(mPickerTime)) {
            String[] split = mPickerTime.split(":");
            timePicker.setCurrentHour(Integer.parseInt(split[0].trim()));
            timePicker.setCurrentMinute(Integer.parseInt(split[1].trim()));
        }

        cancels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        affirmRecharge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String time = "";
                String month = (datepicker.getMonth() + 1) >= 10 ? String.valueOf(datepicker.getMonth() + 1) : "0" + (datepicker.getMonth() + 1);
                if (isTimeType) {
                    time = datepicker.getYear() + "-" + month + "-" + datepicker.getDayOfMonth() + " "
                            + timePicker.getCurrentHour() + ":" + timePicker.getCurrentMinute() + ":" + "00";
                } else {
                    time = datepicker.getYear() + "-" + month + "-" + datepicker.getDayOfMonth();
                }
                dateListener.dateListener(time);
                dismiss();
            }
        });
        return view;
    }
}