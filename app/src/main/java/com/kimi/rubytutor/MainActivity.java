package com.kimi.rubytutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    private ArrayList<Bonus> bonusArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        for (int i = 0; i < 10; i++) {
            if (i == 4) {
                Bonus bonus = new Bonus("Ruby ", "Manager", 1, IconType.Blue);
                bonusArrayList.add(bonus);
            } else {
                Bonus bonus = new Bonus("黑晶條件 ", "Test 5566", 0, IconType.Red);
                bonusArrayList.add(bonus);
            }
        }


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        recyclerView.setAdapter(new BonusAdapter(bonusArrayList));

    }


}


