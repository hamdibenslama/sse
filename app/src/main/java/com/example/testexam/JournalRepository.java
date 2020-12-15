package com.example.testexam;


import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JournalRepository {

    private JournalDao journalDao;
    private LiveData<List<Journal>> mAllJournal;

    JournalRepository(Application application) {
        JournalRoomDatabase db = JournalRoomDatabase.getDatabase(application);
        journalDao = db.journalDao();
        mAllJournal = journalDao.getAllJournals();
    }

    LiveData<List<Journal>> getmAllJournal() {
        return mAllJournal;
    }

    public void insert (Journal journal) {
        new insertAsyncTask(journalDao).execute(journal);
    }

    private static class insertAsyncTask extends AsyncTask<Journal, Void, Void> {

        private JournalDao mAsyncTaskDao;

        insertAsyncTask(JournalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Journal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }


    }
}
