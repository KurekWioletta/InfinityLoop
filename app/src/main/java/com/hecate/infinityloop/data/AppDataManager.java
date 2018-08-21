package com.hecate.infinityloop.data;

import android.content.Context;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.db.model.Level;
import com.hecate.infinityloop.di.ApplicationContext;

import java.util.List;

import javax.inject.Inject;

public class AppDataManager implements DataManager {

    private final Context mContext;
    private final DbHelper mDbHelper;

    @Inject
    public AppDataManager(@ApplicationContext Context context, DbHelper dbHelper) {
        mContext = context;
        mDbHelper = dbHelper;
    }

    @Override
    public List<Level> getDifficyltyLevels(Long difficultyId) {
        return null;
    }
}
