package com.josmartinez.memorizecards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedList;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardViewHolder> {

    private final LinkedList<String> mCardList;
    private LayoutInflater mInflater;


    public CardListAdapter(Context context, LinkedList<String> cardList) {
        mInflater = LayoutInflater.from(context);
        this.mCardList = cardList;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.cardlist_item, parent, false);

        return new CardViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String mCurrent = mCardList.get(position);
        holder.cardItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }

    public static class CardViewHolder extends RecyclerView.ViewHolder {

        public final TextView cardItemView;
        final CardListAdapter mAdapter;

        public CardViewHolder(@NonNull View itemView, CardListAdapter adapter) {
            super(itemView);
            cardItemView = itemView.findViewById(R.id.word_title);
            this.mAdapter = adapter;

        }
    }
}
