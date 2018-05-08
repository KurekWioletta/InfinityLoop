package com.hecate.infinityloop.ui.levels.level;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.di.components.ActivityComponent;
import com.hecate.infinityloop.ui.base.BaseFragment;
import com.hecate.infinityloop.ui.levels.SelectLvlPagerAdapter;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.ButterKnife;

public class LvlFragment extends BaseFragment implements LvlContract.View {

    @Inject
    LvlPresenter<LvlContract.View> mPresenter;

    @Inject
    SelectLvlPagerAdapter mPagerAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lvl, container, false);

        ActivityComponent component = getActivityComponent();
        if (component != null) {
            component.inject(this);
            setUnBinder(ButterKnife.bind(this, view));
            mPresenter.onAttach(this);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        mPresenter.onDetach();
        super.onDestroyView();
    }

}
