package com.hecate.infinityloop.ui.game;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.ui.game.element.ElementAdapter;
import com.hecate.infinityloop.utils.DimensionsUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends BaseActivity implements GameContract.View {

    private ElementAdapter mElementAdapter;

    @Inject
    GamePresenter<GameContract.View> mPresenter;

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

-+-    @Override
    public void setUpGameboard(int dimX, int dimY, int[] elementsArray) {
        int elementSize = DimensionsUtils.getElementSize(this);

        mElementAdapter = new ElementAdapter(this, elementsArray);

        gameboardGridView.setAdapter(mElementAdapter);
        gameboardGridView.getLayoutParams().width = dimX * elementSize;
        gameboardGridView.getLayoutParams().height = dimY * elementSize;
        gameboardGridView.setNumColumns(dimX);

        gameboardGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> container, View view, int position, long id) {
                //todo rotate animation
            }
        });
    }

    public static Intent getStartIntent(Context context) {
        return new Intent(context, GameActivity.class);
    }
}
