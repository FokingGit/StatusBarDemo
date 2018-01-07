package com.example.foking.myapplication;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


public class ToolBarAndStatusBarSameColorActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toolbar_andstatusbar_same_color);

        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.status_toolBar_same_color));
        } else {
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            ViewGroup systemContent = findViewById(android.R.id.content);

            View statusBarView = new View(this);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
            statusBarView.setBackgroundColor(getResources().getColor(R.color.status_toolBar_same_color));

            systemContent.getChildAt(0).setFitsSystemWindows(false);

            systemContent.addView(statusBarView, 0, lp);

        }
        printChildView((ViewGroup) window.getDecorView());

    }

    public int getStatusBarHeight() {
        int statusBarHeight1 = -1;
        //获取status_bar_height资源的ID
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            //根据资源ID获取响应的尺寸值
            statusBarHeight1 = getResources().getDimensionPixelSize(resourceId);
        }
        return statusBarHeight1;
    }

    private void printChildView(ViewGroup viewGroup) {
        Log.i("printView-ViewGroup", viewGroup.getClass().getSimpleName() + "的子View和数量:" + viewGroup.getChildCount());
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            String simpleName = viewGroup.getChildAt(i).getClass().getSimpleName();
            Log.i("printView-ChildView", simpleName);
        }
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                printChildView((ViewGroup) viewGroup.getChildAt(i));
            }
        }
    }
}
