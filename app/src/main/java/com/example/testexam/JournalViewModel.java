package com.example.testexam;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class JournalViewModel extends AndroidViewModel {

    private JournalRepository mRepository;

    private LiveData<List<Journal>> mAllJournals;

    public JournalViewModel (Application application) {
        super(application);
        mRepository = new JournalRepository(application);
        mAllJournals = mRepository.getmAllJournal();
    }

    LiveData<List<Journal>> getAllWords() { return mAllJournals; }
    public void insert(Journal journal) { mRepository.insert(journal); }
}
