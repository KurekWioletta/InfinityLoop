package com.hecate.infinityloop.ui.game;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;

import com.hecate.infinityloop.R;
import com.hecate.infinityloop.ui.base.BaseActivity;
import com.hecate.infinityloop.utils.AppConst;
import com.hecate.infinityloop.utils.ScreenUtils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GameActivity extends BaseActivity implements GameContract.View {

    @Inject
    GamePresenter<GameContract.View> mPresenter;

    @BindView(R.id.layout_gameboard)
    LinearLayout gameboardLayout;

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
    protected void onPostResume() {
        super.onPostResume();
        gameboardLayout.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                setUp();
            }
        });
    }

    @Override
    public void setUpGameboard(int dimX, int dimY) {


    }

    @Override
    public void setGameboardPositionX(float posX) {
        gameboardLayout.setX(posX);
        gameboardLayout.invalidate();
    }

    @Override
    public void setGameboardPositionY(float posY) {
        gameboardLayout.setY(posY);
        gameboardLayout.invalidate();
    }

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, GameActivity.class);
        return intent;
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setUp() {
        final float[] posX = {0};
        final float[] posY = {0};
        final float screenWidth = ScreenUtils.getScreenWidth(this);
        final float screenHeight = ScreenUtils.getScreenHeight(this) + ScreenUtils.getNavigationBarHeight(this);

        if (gameboardLayout.getWidth() > screenWidth || gameboardLayout.getHeight() > screenHeight) {
            gameboardLayout.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    switch (event.getAction()) {
                        case MotionEvent.ACTION_DOWN: {
                            posX[0] = gameboardLayout.getX() - event.getRawX();
                            posY[0] = gameboardLayout.getY() - event.getRawY();
                            return true;
                        }
                        case MotionEvent.ACTION_MOVE: {
                            mPresenter.onGameboardMove(gameboardLayout.getWidth(), screenWidth,
                                    event.getRawX() + posX[0], gameboardLayout.getHeight(), screenHeight, event.getRawY() + posY[0]);
                            return true;
                        }
                        case MotionEvent.ACTION_UP:
                            return true;
                    }
                    return true;
                }
            });
        }
    }
}
