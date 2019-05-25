package com.irinnovative.onepagesigninsignup;

import android.content.Intent;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.irinnovative.onepagesigninsignup.adapter.VehicleAdapter;
import com.irinnovative.onepagesigninsignup.sql.Database;
import com.irinnovative.onepagesigninsignup.sql.Ticket;

import java.util.List;

import jp.co.recruit_lifestyle.android.widget.WaveSwipeRefreshLayout;

public class VehicleActivity extends AppCompatActivity {

    private VehicleAdapter adapter;
    private String start;
    private String end;
    private WaveSwipeRefreshLayout mWaveSwipeRefreshLayout;

    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            mWaveSwipeRefreshLayout.setRefreshing(false);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicle);
        RecyclerView recycler = (RecyclerView) findViewById(R.id.recycler);
        TextView title = (TextView) findViewById(R.id.title);
        mWaveSwipeRefreshLayout = (WaveSwipeRefreshLayout) findViewById(R.id.main_swipe);


        start = getIntent().getStringExtra("start");
        end = getIntent().getStringExtra("end");
        adapter = new VehicleAdapter(start, end);
        recycler.setAdapter(adapter);
        recycler.setLayoutManager(new LinearLayoutManager(this));
        recycler.addItemDecoration(new DividerItemDecoration(this, 1));
        int space = 8; //为RecylerView中的条目设置间隔
        recycler.addItemDecoration(new SpacesItemDecoration(space));

        title.setText(start.concat("<>").concat(end));

        adapter.setListener(new VehicleAdapter.VehicleListener() {
            @Override
            public void itemClick(Ticket ticket) {
               Intent intent = new Intent(VehicleActivity.this, OrderActivity.class);
               intent.putExtra("data", ticket);
               startActivity(intent);
               //Toast.makeText(VehicleActivity.this,"订票系统维护中！",Toast.LENGTH_SHORT).show();
            }
        });


        mWaveSwipeRefreshLayout.setOnRefreshListener(new WaveSwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Do work to refresh the list here.
                handler.postDelayed(runnable, 2000);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Ticket> ticket = Database.newInstance(this.getApplicationContext()).getTicket(start, end);
        adapter.setData(ticket);
    }

    private class SpacesItemDecoration extends RecyclerView.ItemDecoration {
        private int space;
        public SpacesItemDecoration(int space) {
            this.space = space;
        }
        @Override
        public void getItemOffsets(Rect outRect, View view,
                                   RecyclerView parent, RecyclerView.State state) {
            outRect.left = space;
            outRect.right = space;
            outRect.bottom = space;

            // Add top margin only for the first item to avoid double space between items
            if (parent.getChildPosition(view) == 0)
                outRect.top = space;
        }
    }
}
