package com.hecate.infinityloop.data;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.status.StatusHelper;
import com.hecate.infinityloop.di.DatabaseInfo;

public interface DataManager extends DbHelper, StatusHelper {
    boolean doesDatabaseExist();
}
