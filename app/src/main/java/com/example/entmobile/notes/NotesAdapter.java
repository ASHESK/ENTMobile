package com.example.entmobile.notes;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.preference.Preference;
import androidx.recyclerview.widget.RecyclerView;

import com.example.entmobile.R;

import java.util.ArrayList;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {

    public List<Note> mData;
    private final LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private final Context context;


    // data is passed into the constructor
    NotesAdapter(Context context, List<Note> data) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;
    }

    // inflates the row layout from xml when needed
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        @SuppressLint("ResourceType") View view = mInflater.inflate(R.layout.note_display, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Note note = mData.get(position);
        holder.note_title.setText(note.getTitle());
        holder.note_cat.setText(note.getCategory());
        holder.note_cont.setText(note.getContent());
    }

    // total number of rows
    @Override
    public int getItemCount() {
        return mData.size();
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        View viewForeground;
        View viewBackground;
        TextView note_title;
        TextView note_cat;
        TextView note_cont;

        ViewHolder(View itemView) {
            super(itemView);
            note_title = itemView.findViewById(R.id.note_title);
            note_cat = itemView.findViewById(R.id.note_category);
            note_cont = itemView.findViewById(R.id.note_content);
            viewBackground = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    // convenience method for getting data at click position
    Note getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }

    public void removeItem(int position) {

        if (mData == null || mData.isEmpty()) {
            return;
        }
        else if (position > -1) {
            mData.remove(position);

            notifyItemRemoved(position);
            notifyItemRangeChanged(position, mData.size());
        }

        // notify the item removed by position
        // to perform recycler view delete animations
        // NOTE: don't call notifyDataSetChanged()

        //notifyItemRemoved(position);
    }

    public void restoreItem(Note note, int position) {
        mData.add(position, note);
        // notify item added by position
        notifyItemInserted(position);
    }
}
