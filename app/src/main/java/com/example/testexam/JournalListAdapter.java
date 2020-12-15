package com.example.testexam;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JournalListAdapter extends RecyclerView.Adapter<JournalListAdapter.JournalViewHolder> {

        private final LayoutInflater mInflater;
        private List<Journal> mJournal;

    JournalListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

        @Override
        public JournalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
            return new JournalViewHolder(itemView);
        }

        @Override
        public void onBindViewHolder(JournalViewHolder holder, int position) {
            if (mJournal != null) {
                Journal current = mJournal.get(position);
                holder.journalText.setText(current.getJournal());
                holder.dateJournal.setText(current.getDate());

            } else {
                // Covers the case of data not being ready yet.
                holder.journalText.setText("No journal");
                holder.dateJournal.setText("No date");
            }
        }

        void setJournals(List<Journal> journals){
            mJournal = journals;
            notifyDataSetChanged();
        }


        @Override
        public int getItemCount() {
            if (mJournal != null)
                return mJournal.size();
            else return 0;
        }

        class JournalViewHolder extends RecyclerView.ViewHolder {
            private final TextView journalText,dateJournal;

            private JournalViewHolder(View itemView) {
                super(itemView);
                journalText = itemView.findViewById(R.id.journal);
                dateJournal=itemView.findViewById(R.id.date);
            }
        }
}
