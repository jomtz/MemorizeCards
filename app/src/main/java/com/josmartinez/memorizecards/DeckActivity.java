package com.josmartinez.memorizecards;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.LinkedList;

public class DeckActivity extends AppCompatActivity {

    private final LinkedList<String> mCardList = new LinkedList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deck_main);

        for (int i = 0; i < 20; i++) {
            mCardList.addLast("Word " + i);
        }


    }
}
