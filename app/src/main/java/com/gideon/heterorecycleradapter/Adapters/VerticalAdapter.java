package com.gideon.heterorecycleradapter.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;


import com.gideon.heterorecycleradapter.Model.SingleVertical;
import com.gideon.heterorecycleradapter.R;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;


public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.MyViewHolder> {
    //private ArrayList<HashMap<String, Object>> data;
    private ArrayList<SingleVertical> data;
    private Context context;

    public VerticalAdapter(ArrayList<SingleVertical> data, Context context) {
        this.data = data;
        this.context = context;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vertical_single_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        SingleVertical kejaModel = data.get(position);
        Picasso.with(context).load(kejaModel.getImage()).into(holder.image);
        holder.price.setText(kejaModel.getPlace());
        holder.location.setText(kejaModel.getLocation());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.price.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView location, price;

        public MyViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);
            location = itemView.findViewById(R.id.location);
            price = itemView.findViewById(R.id.price);
        }
    }
}
