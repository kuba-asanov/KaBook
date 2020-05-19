package com.example.kabook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.github.barteksc.pdfviewer.PDFView;

public class Bookpdf extends AppCompatActivity {
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookpdf);

        Intent intent = getIntent();
        NamesItem namesItem = intent.getParcelableExtra("Kuba");

        int Ibook = namesItem.getmImageResourse();
        System.out.println("KUBA  " + Ibook);

        pdfView = findViewById(R.id.pdfView);
        if (Ibook == 2131099733){
            pdfView.fromAsset("Богатый папа бедный папа.pdf").load();
        }else if (Ibook==2131099743){
            pdfView.fromAsset("Илон Маск.pdf").load();
        }else if(Ibook==2131099741){
            pdfView.fromAsset("Выйди из зоны комфорта.pdf").load();
        }else if(Ibook==2131099742){
            pdfView.fromAsset("Магия утра.pdf").load();
        }else if(Ibook==2131099744){
            pdfView.fromAsset("Продавец обуви. Фил Найт.pdf").load();
        }else if(Ibook==2131099738){
            pdfView.fromAsset("Генри Форд. Моя жизнь.pdf").load();
        }
    }
}
