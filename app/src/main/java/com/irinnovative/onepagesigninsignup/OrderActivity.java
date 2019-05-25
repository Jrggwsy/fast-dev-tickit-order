package com.irinnovative.onepagesigninsignup;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.sql.Database;
import com.irinnovative.onepagesigninsignup.sql.Ticket;
import com.irinnovative.onepagesigninsignup.sql.User;


/**
 * Created by zxkj on 2018/11/22.
 */

public class OrderActivity extends AppCompatActivity {

    private int mSelect = 0;
    private ConstraintLayout businessSeat;
    private ConstraintLayout firstSeat;
    private ConstraintLayout secondSeat;
    private ConstraintLayout noSeat;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        TextView passengerInformation = (TextView) findViewById(R.id.passenger_information);
        TextView order = (TextView) findViewById(R.id.order);

        TextView businessSeatCount = (TextView) findViewById(R.id.businessSeatCount);
        TextView firstSeatCount = (TextView) findViewById(R.id.firstSeatCount);
        TextView secondSeatCount = (TextView) findViewById(R.id.secondSeatCount);
        TextView noSeatCount = (TextView) findViewById(R.id.noSeatCount);

        TextView identifier = (TextView) findViewById(R.id.identifier);
        TextView origin = (TextView) findViewById(R.id.origin);
        TextView originTime = (TextView) findViewById(R.id.originTime);
        TextView destination = (TextView) findViewById(R.id.destination);
        TextView destinationTime = (TextView) findViewById(R.id.destinationTime);
        TextView time = (TextView) findViewById(R.id.time);

        businessSeat = (ConstraintLayout) findViewById(R.id.businessSeat);
        firstSeat = (ConstraintLayout) findViewById(R.id.firstSeat);
        secondSeat = (ConstraintLayout) findViewById(R.id.secondSeat);
        noSeat = (ConstraintLayout) findViewById(R.id.noSeat);

        businessSeat.setOnClickListener(onClick);
        firstSeat.setOnClickListener(onClick);
        secondSeat.setOnClickListener(onClick);
        noSeat.setOnClickListener(onClick);

        final Ticket ticket = getIntent().getParcelableExtra("data");
        businessSeatCount.setText(String.valueOf(ticket.getbusinessSeatCount()));
        firstSeatCount.setText(String.valueOf(ticket.getfirstSeatCount()));
        secondSeatCount.setText(String.valueOf(ticket.getsecondSeatCount()));
        noSeatCount.setText(String.valueOf(ticket.getNoSeatCount()));

        identifier.setText(ticket.getIdentifier());
        origin.setText(ticket.getOrigin());
        originTime.setText(ticket.getOriginTime());
        destination.setText(ticket.getDestination());
        destinationTime.setText(ticket.getDestinationTime());
        time.setText(ticket.getTime());

        passengerInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassengerInformationDialog dialog = PassengerInformationDialog.newInstance();
                dialog.show(getSupportFragmentManager(), "");
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences sharedPreferences = getSharedPreferences("user", 0);
                String userName = sharedPreferences.getString("userName", "");
                Database database = Database.newInstance(OrderActivity.this);
                User user = database.getUser('"' + userName + '"');
                if (TextUtils.isEmpty(user.getName()) || TextUtils.isEmpty(user.getSex()) ||
                        TextUtils.isEmpty(user.getNumber()) || TextUtils.isEmpty(user.getNumberId())) {
                    Toast.makeText(OrderActivity.this, "请先填写个人信息", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (mSelect == 0) {
                    Toast.makeText(OrderActivity.this, "请先选择座位", Toast.LENGTH_SHORT).show();
                    return;
                } else if (mSelect == 1) {
                    ticket.setbusinessSeatCount(ticket.getbusinessSeatCount() - 1);
                } else if (mSelect == 2) {
                    ticket.setfirstSeatCount(ticket.getfirstSeatCount() - 1);
                } else if (mSelect == 3) {
                    ticket.setsecondSeatCount(ticket.getsecondSeatCount() - 1);
                } else if (mSelect == 4) {
                    ticket.setNoSeatCount(ticket.getNoSeatCount() - 1);
                }
                database.upTicket(ticket);
                Toast.makeText(OrderActivity.this, "购买成功", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    private View.OnClickListener onClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.businessSeat:
                    mSelect = 1;
                    setSelectBackground(businessSeat);
                    break;

                case R.id.firstSeat:
                    mSelect = 2;
                    setSelectBackground(firstSeat);
                    break;

                case R.id.secondSeat:
                    mSelect = 3;
                    setSelectBackground(secondSeat);
                    break;

                case R.id.noSeat:
                    mSelect = 4;
                    setSelectBackground(noSeat);
                    break;

                default:
                    break;
            }
        }
    };

    private void setSelectBackground(View view) {
        businessSeat.setBackgroundColor(0xffffffff);
        firstSeat.setBackgroundColor(0xffffffff);
        secondSeat.setBackgroundColor(0xffffffff);
        noSeat.setBackgroundColor(0xffffffff);
        view.setBackgroundColor(0xff87cefa);
    }

}
