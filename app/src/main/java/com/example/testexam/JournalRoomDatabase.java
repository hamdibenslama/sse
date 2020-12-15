package com.example.testexam;


import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Journal.class}, version = 1, exportSchema = false)
public abstract class JournalRoomDatabase extends RoomDatabase {

    public abstract JournalDao journalDao();
    private static JournalRoomDatabase INSTANCE;

    static JournalRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (JournalRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            JournalRoomDatabase.class, "journal_database")

                            .fallbackToDestructiveMigration()
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }
        return INSTANCE;

    }
    private static RoomDatabase.Callback sRoomDatabaseCallback =
            new RoomDatabase.Callback(){

                @Override
                public void onOpen (@NonNull SupportSQLiteDatabase db){
                    super.onOpen(db);
                    new PopulateDbAsync(INSTANCE).execute();
                }
            };
    private static class PopulateDbAsync extends AsyncTask<Void, Void, Void> {

        private final JournalDao mDao;
       // String[] words = {"dolphin", "crocodile", "cobra"};

        PopulateDbAsync(JournalRoomDatabase db) {
            mDao = db.journalDao();
        }

        @Override
        protected Void doInBackground(final Void... params) {

            mDao.deleteAll();

//            for (int i = 0; i <= words.length - 1; i++) {
//                Word word = new Word(words[i]);
//                mDao.insert(word);
//            }
            return null;
        }
    }

}
