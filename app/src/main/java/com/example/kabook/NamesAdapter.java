package com.example.kabook;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.ExampleViewHolder> {
    private ArrayList<NamesItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener{
        void onItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener){
        mListener=listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public TextView mTextView1;
        public TextView mTextView2;
        private CardView cv;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            cv = itemView.findViewById(R.id.cv);
            mImageView = itemView.findViewById(R.id.iv_book);
            mTextView1 = itemView.findViewById(R.id.tv_name_book);
            mTextView2 = itemView.findViewById(R.id.tv_about_book);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
    public NamesAdapter(ArrayList<NamesItem> exampleList){
        mExampleList = exampleList;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.name_book, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        NamesItem currentItem = mExampleList.get(position);
        holder.mImageView.setImageResource(currentItem.getmImageResourse());
        holder.mTextView1.setText(currentItem.getNameBook());
        holder.mTextView2.setText(currentItem.getAboutBook());
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();
    }

}
