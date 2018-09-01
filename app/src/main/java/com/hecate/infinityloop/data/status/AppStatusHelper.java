package com.hecate.infinityloop.data.status;

import javax.inject.Inject;

public class AppStatusHelper implements StatusHelper {

    private long chosenDifficulty;

    @Inject
    public AppStatusHelper() {
    }

    @Override
    public long getChosenDifficulty() {
        return chosenDifficulty;
    }

    @Override
    public void setChosenDifficulty(long difficultyId) {
        chosenDifficulty = difficultyId;
    }

}
