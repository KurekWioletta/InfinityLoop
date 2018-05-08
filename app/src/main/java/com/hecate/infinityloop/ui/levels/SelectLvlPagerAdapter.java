package com.hecate.infinityloop.ui.levels;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.hecate.infinityloop.ui.levels.level.LvlFragment;

import java.util.ArrayList;
import java.util.List;

public class SelectLvlPagerAdapter extends FragmentStatePagerAdapter{

    private List<LvlFragment> mFragments;

    public SelectLvlPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        mFragments = new ArrayList<>();

        for(int i = 0; i< 5; i++){
            addLvlFragment(new LvlFragment());
            Log.e("vp", "fragment init");

        }
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount(){
        return mFragments.size();
    }

    private void addLvlFragment(LvlFragment fragment) {
        mFragments.add(fragment);
    }

}
