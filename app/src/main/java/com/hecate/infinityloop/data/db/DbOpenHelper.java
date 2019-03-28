package com.hecate.infinityloop.data.db;

import android.content.Context;
import android.util.Log;

import com.hecate.infinityloop.data.db.model.DaoMaster;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.DatabaseInfo;
import com.hecate.infinityloop.utils.AppLogger;

import org.greenrobot.greendao.database.Database;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    private String DB_NAME;
    private Context mContext;

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String dbName) {
        super(context, dbName);
        mContext = context;
        DB_NAME = dbName;
    }

    @Override
    public void onCreate(Database db){
        super.onCreate(db);
        try {
            importDatabase(db);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void onUpgrade(Database db, int oldVersion, int newVersion) {
        super.onUpgrade(db, oldVersion, newVersion);

        AppLogger.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);

        switch (oldVersion) {
            case 1:
            case 2:
        }
    }

    private void importDatabase(Database db) throws IOException {
        String backupFile = DB_NAME.split("\\.")[0] + ".sql";

        try (BufferedReader br = new BufferedReader( new InputStreamReader(mContext.getAssets().open(backupFile)))) {
            for(String line; (line = br.readLine()) != null; ) {
                Log.e("aaa", line);
                db.execSQL(line);
            }
        } catch (IOException e){
            throw e;
        }

    }

}