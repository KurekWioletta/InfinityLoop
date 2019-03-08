package com.hecate.infinityloop.data;

import com.hecate.infinityloop.data.db.DbHelper;
import com.hecate.infinityloop.data.game.GameStateHelper;
import com.hecate.infinityloop.data.prefs.PreferencesHelper;

public interface DataManager extends DbHelper, PreferencesHelper, GameStateHelper {

}
