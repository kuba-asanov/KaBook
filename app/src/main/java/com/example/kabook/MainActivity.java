package com.example.kabook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<NamesItem> namesbook;

    private RecyclerView mRecyclerView;
    private NamesAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        creatNamesList();
        buildRecyclerView();
    }

    public void creatNamesList() {
        namesbook = new ArrayList<>();

        namesbook.add(new NamesItem(R.drawable.bogat, "Богатый папа, бедный папа", "Роберт Кийосаки"));
        namesbook.add(new NamesItem(R.drawable.mask, "Илон Маск: Tesla, SpaceX и дорога в будущее", "Эшли Вэнс"));
        namesbook.add(new NamesItem(R.drawable.izzony, "Выйди из зоны комфорта", "Брайан Трейси"));
        namesbook.add(new NamesItem(R.drawable.magiautra, "Магия утра", "Хэл Элрод"));
        namesbook.add(new NamesItem(R.drawable.nike, "Продавец обуви", "Фил Найт"));
        namesbook.add(new NamesItem(R.drawable.genri, "Моя жизнь,   мои достижения", "Генри Форд"));
    }

    public void buildRecyclerView() {
        mRecyclerView = findViewById(R.id.rv_books);
        mRecyclerView.setHasFixedSize(true);
        mLayoutManager = new LinearLayoutManager(this);
        mAdapter = new NamesAdapter(namesbook);

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new NamesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Intent intent = new Intent(MainActivity.this,Bookpdf.class);
                intent.putExtra("Kuba",namesbook.get(position));

                startActivity(intent);
            }
        });

    }
}
