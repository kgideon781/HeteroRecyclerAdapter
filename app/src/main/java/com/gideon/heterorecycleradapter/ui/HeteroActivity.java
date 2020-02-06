package com.gideon.heterorecycleradapter.ui;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.gideon.heterorecycleradapter.Adapters.MainAdapter;
import com.gideon.heterorecycleradapter.Model.SingleHorizontal;
import com.gideon.heterorecycleradapter.Model.SingleVertical;
import com.gideon.heterorecycleradapter.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class HeteroActivity extends AppCompatActivity {
    private ArrayList<Object> objects = new ArrayList<>();
    private static final String TAG = HeteroActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hetero);
        RecyclerView recyclerView = findViewById(R.id.recycler_View);
        MainAdapter adapter = new MainAdapter(this, getObject());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private ArrayList<Object> getObject() {
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("Data");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                objects.add(getVerticalData(dataSnapshot).get(0));
                objects.add(getHorizontalData(dataSnapshot).get(0));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        return objects;
    }

    public static ArrayList<SingleVertical> getVerticalData(DataSnapshot dataSnapshot) {
        ArrayList<SingleVertical> singleVerticals = new ArrayList<>();
        //singleVerticals.add(new SingleVertical( "", "", null));


        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
           // SingleVertical singleVertical = dataSnapshot.getValue(SingleVertical.class);
//                Log.e("TAG",singleVertical.getLocation());
            singleVerticals.add(new SingleVertical(

                    snapshot.child("price").getValue(String.class),
                    snapshot.child("location").getValue(String.class),
                    snapshot.child("image").getValue(String.class)

            ));
            Log.e(TAG,"Text loaded");
        }



        return singleVerticals;
    }


    public static ArrayList<SingleHorizontal> getHorizontalData(DataSnapshot dataSnapshot) {
        ArrayList<SingleHorizontal> singleHorizontals = new ArrayList<>();
        for (DataSnapshot snapshot : dataSnapshot.getChildren()){
            // SingleVertical singleVertical = dataSnapshot.getValue(SingleVertical.class);
//                Log.e("TAG",singleVertical.getLocation());
            singleHorizontals.add(new SingleHorizontal(

                    snapshot.child("price").getValue(String.class),
                    snapshot.child("location").getValue(String.class),
                    snapshot.child("image").getValue(String.class)
            ));
            Log.e(TAG,"Horizontal data loaded");
        }
        return singleHorizontals;
    }


}
