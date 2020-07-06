package com.kimi.rubytutor;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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
                Bonus bonus = new Bonus("黑晶條件 " + i, "Test 5566", 0, IconType.Red);
                bonusArrayList.add(bonus);
            }
        }


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        BonusAdapter adapter = new BonusAdapter(bonusArrayList);
        recyclerView.setAdapter(adapter);

        adapter.setItemClick(new BonusItemClick() {
            @Override
            public void onClick(Bonus bonus) {
                Log.d("Ruby", "onClick: " + bonus.getName());
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
    }


}


