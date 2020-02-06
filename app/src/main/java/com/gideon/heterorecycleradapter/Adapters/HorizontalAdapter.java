package com.gideon.heterorecycleradapter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.gideon.heterorecycleradapter.Model.SingleHorizontal;
import com.gideon.heterorecycleradapter.Model.SingleVertical;
import com.gideon.heterorecycleradapter.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;


public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.MyViewHolder> {

    ArrayList<SingleHorizontal> data = new ArrayList<>();
    Context context;

    public HorizontalAdapter(ArrayList<SingleHorizontal> data, Context context) {
        this.data = data;
        this.context = context;

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.horizontal_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        SingleHorizontal kejaModel = data.get(position);
        Picasso.with(context).load(kejaModel.getImage()).into(holder.image);
        holder.price.setText(kejaModel.getPlace());
        holder.location.setText(kejaModel.getLocation());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView price, location, pubDate;
        ImageView image;

        public MyViewHolder(View itemView) {
            super(itemView);
            price = itemView.findViewById(R.id.price);
            location = itemView.findViewById(R.id.location);
            pubDate = itemView.findViewById(R.id.published_date);
            image = itemView.findViewById(R.id.image_view);
        }
    }
}
