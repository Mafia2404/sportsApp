package com.example.sportsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListner {
    //1.adapter view
    private RecyclerView recyclerView;
    //2.data source
    private List<Sports> sportsList;
    //3.adapter
    private CustomAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        //code here
        recyclerView=findViewById(R.id.recyclerView);
        sportsList=new ArrayList<>();
        Sports s1=new Sports("Basketball",R.drawable.basketball);
        Sports s2=new Sports("Football",R.drawable.football);
        Sports s3=new Sports("Tennis",R.drawable.tennis);
        Sports s4=new Sports("Volleyball",R.drawable.volley);
        Sports s5=new Sports("Ping",R.drawable.ping);

        sportsList.add(s1);
        sportsList.add(s2);
        sportsList.add(s3);
        sportsList.add(s4);
        sportsList.add(s5);

        myAdapter=new CustomAdapter(sportsList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(myAdapter);
        myAdapter.setClickListener(this);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, sportsList.get(position).getSportName(), Toast.LENGTH_SHORT).show();
    }
}