package com.example.foking.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.bt_fullscreen_notext)
    Button btFullscreenNotext;
    @BindView(R.id.bt_fullscreen_text)
    Button btFullscreenText;
    @BindView(R.id.bt_toolbar_status_same_color)
    Button btToolbarStatusSameColor;
    @BindView(R.id.bt_change_statusbar_text_colr)
    Button btChangeStatusbarTextColr;
    @BindView(R.id.bt_fragment_status)
    Button btFragmentStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.bt_fullscreen_notext, R.id.bt_fullscreen_text, R.id.bt_fragment_status, R.id.bt_toolbar_status_same_color, R.id.bt_change_statusbar_text_colr})
    public void onViewClicked(View view) {
        Intent intent = new Intent();
        Class clazz = null;
        switch (view.getId()) {
            case R.id.bt_fullscreen_notext:
                clazz = FullScrrenNoTextActivity.class;
                break;
            case R.id.bt_fullscreen_text:
                clazz = FullScrrenHaveTextActivity.class;
                break;
            case R.id.bt_toolbar_status_same_color:
                clazz = ToolBarAndStatusBarSameColorActivity.class;
                break;
            case R.id.bt_change_statusbar_text_colr:
                clazz = ChangeStatusBarColorActivity.class;
                break;
            case R.id.bt_fragment_status:
                clazz = FragmentStatusAndActionBarActivity.class;
                break;
        }
        intent.setClass(MainActivity.this, clazz);
        startActivity(intent);
    }

}
