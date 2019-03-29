package com.hecate.infinityloop.ui.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.data.gameplay.model.Element;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.game.element.ElementAdapter;
import com.hecate.infinityloop.ui.selectlvl.level.LevelAdapter;
import com.hecate.infinityloop.utils.ScreenUtils;
import com.hecate.infinityloop.utils.ViewUtils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends BaseActivity implements GameContract.View {

    @Inject
    GamePresenter<GameContract.View> mPresenter;

    @Inject
    ElementAdapter mElementAdapter;

    @BindView(R.id.grid_game_gameboard)
    GridView gameboardGridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(this);

        mPresenter.onViewInitialized();
    }

    @Override
    public void setUpGameboard(int dimX, List<Element> elementList) {
        int elementSize = ScreenUtils.getElementSize(this);

        mElementAdapter.addItems(elementList);

        gameboardGridView.setAdapter(mElementAdapter);
        gameboardGridView.getLayoutParams().width = dimX * elementSize;
        gameboardGridView.setNumColumns(dimX);

        gameboardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> container, View view, int position, long id) {
                mPresenter.onElementClick(position);
            }
        });
    }

    @Override
    public void rotateElement(int position, int angle) {
        // rotate view by 90 degrees on every click
        RotateAnimation animation = ViewUtils.rotateBitmap(angle, 200);
        mElementAdapter.getItem(position).startAnimation(animation);
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, GameActivity.class);
    }
}
