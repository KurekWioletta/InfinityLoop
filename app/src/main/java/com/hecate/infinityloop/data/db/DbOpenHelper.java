package com.hecate.infinityloop.data.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;

import com.hecate.infinityloop.data.db.model.DaoMaster;
import com.hecate.infinityloop.di.ApplicationContext;
import com.hecate.infinityloop.di.DatabaseInfo;
import com.hecate.infinityloop.utils.AppLog;

import org.greenrobot.greendao.database.Database;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class DbOpenHelper extends DaoMaster.OpenHelper {

    private static String DB_NAME;

    private Context mContext;

    @Inject
    public DbOpenHelper(@ApplicationContext Context context, @DatabaseInfo String dbName) {
        super(context, dbName);
        this.mContext = context;

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

        AppLog.d("DEBUG", "DB_OLD_VERSION : " + oldVersion + ", DB_NEW_VERSION : " + newVersion);

        switch (oldVersion) {
            case 1:
            case 2:
        }
    }

    public void importDatabase(Database db) throws IOException {
        String backupFile = DB_NAME.split("\\.")[0] + ".sql";

        try (BufferedReader br = new BufferedReader( new InputStreamReader(mContext.getAssets().open(backupFile)))) {
            for(String line; (line = br.readLine()) != null; ) {
                db.execSQL(line);
                for(int i = 0; i < 100000; i++)
                    Log.e("aaa", "aaa");
            }
            Log.e("DDDDD", "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
        } catch (IOException e){
            throw e;
        }

    }

}