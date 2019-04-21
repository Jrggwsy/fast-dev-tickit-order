package com.irinnovative.onepagesigninsignup.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.irinnovative.onepagesigninsignup.R;
import com.irinnovative.onepagesigninsignup.sql.Ticket;

import java.util.List;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.ViewHolder> {

    private List<Ticket> data;
    private VehicleListener listener;
    private String start;
    private String end;

    public VehicleAdapter(String start, String end) {
        this.start = start;
        this.end = end;
    }

    public interface VehicleListener {
        void itemClick(Ticket ticket);
    }

    public void setListener(VehicleListener listener) {
        this.listener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == 1) {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vehicle_null_item, parent, false));
        } else {
            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vehicle_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        int itemViewType = getItemViewType(position);
        if (itemViewType == 1) {
            holder.tips.setText("很抱歉,按您的查询条件，当前未找到从".concat(start).concat("到").concat(end).concat("的列车"));
        } else {
            final Ticket ticket = data.get(position);
            holder.identifier.setText(ticket.getIdentifier());
            holder.origin.setText(ticket.getOrigin());
            holder.originTime.setText(ticket.getOriginTime());
            holder.destination.setText(ticket.getDestination());
            holder.destinationTime.setText(ticket.getDestinationTime());
            holder.time.setText(ticket.getTime());
            holder.businessSeatCount.setText(String.valueOf(ticket.getbusinessSeatCount()));
            holder.firstSeatCount.setText(String.valueOf(ticket.getfirstSeatCount()));
            holder.secondSeatCount.setText(String.valueOf(ticket.getsecondSeatCount()));
            holder.noSeatCount.setText(String.valueOf(ticket.getNoSeatCount()));

            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.itemClick(data.get(position));
                }
            });
        }
    }

    @Override
    public int getItemViewType(int position) {
        return (data == null || data.size() == 0) ? 1 : 0;
    }

    @Override
    public int getItemCount() {
        return (data == null || data.size() == 0) ? 1 : data.size();
    }

    public void setData(List<Ticket> data) {
        this.data = data;
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView identifier;
        TextView origin;
        TextView originTime;
        TextView destination;
        TextView destinationTime;
        TextView time;
        TextView businessSeatCount;
        TextView firstSeatCount;
        TextView secondSeatCount;
        TextView noSeatCount;
        TextView tips;

        public ViewHolder(View itemView) {
            super(itemView);
                tips = (TextView) itemView.findViewById(R.id.tips);
                identifier = (TextView) itemView.findViewById(R.id.identifier);
                origin = (TextView) itemView.findViewById(R.id.origin);
                originTime = (TextView) itemView.findViewById(R.id.originTime);
                destination = (TextView) itemView.findViewById(R.id.destination);
                destinationTime = (TextView) itemView.findViewById(R.id.destinationTime);
                time = (TextView) itemView.findViewById(R.id.time);
                businessSeatCount = (TextView) itemView.findViewById(R.id.businessSeatCount);
                firstSeatCount = (TextView) itemView.findViewById(R.id.firstSeatCount);
                secondSeatCount = (TextView) itemView.findViewById(R.id.secondSeatCount);
                noSeatCount = (TextView) itemView.findViewById(R.id.noSeatCount);
        }
    }

}
