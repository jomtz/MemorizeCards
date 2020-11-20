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


    // The method needs to instantiate a LayoutInflator for mInflater
    // and set mCardList to the passed in data

    public CardListAdapter(Context context, LinkedList<String> cardList) {
        mInflater = LayoutInflater.from(context);
        this.mCardList = cardList;
    }

    //It inflates the item layout, and returns a ViewHolder with the layout and the adapter.
    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mItemView = mInflater.inflate(R.layout.cardlist_item, parent, false);
        return new CardViewHolder(mItemView, this);
    }

    //This method connects your data to the view holder.
    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        String mCurrent = mCardList.get(position);
        holder.cardItemView.setText(mCurrent);
    }

    @Override
    public int getItemCount() {
        return mCardList.size();
    }

    // ViewHolder for the adapter

    public class CardViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public final TextView cardItemView;
        final CardListAdapter mAdapter;

        // Constructor that initializes the ViewHolder TextView from the word XML resource,
        // and sets its adapter
        public CardViewHolder(@NonNull View itemView, CardListAdapter adapter) {
            super(itemView);
            cardItemView = itemView.findViewById(R.id.word_title);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            // Get the position of the item that was clicked.
            int mPosition = getLayoutPosition();
            // Use that to access the affected item in mCardList.
            String element = mCardList.get(mPosition);
            // Change the word in the mCardList.
            mCardList.set(mPosition, "Clicked! " + element);
            // Notify the adapter, that the data has changed so it can
            // update the RecyclerView to display the data.
            mAdapter.notifyDataSetChanged();
        }
    }
}
