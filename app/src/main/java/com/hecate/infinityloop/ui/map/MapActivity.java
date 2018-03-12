package com.hecate.infinityloop.ui.map;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hecate.infinityloop.R;

public class MapActivity extends AppCompatActivity {

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MapActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
    }
}
