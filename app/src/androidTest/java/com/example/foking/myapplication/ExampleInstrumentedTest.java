package com.example.foking.myapplication;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;
import android.view.ViewGroup;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();
    }

    private void printChildView(ViewGroup viewGroup) {
        Log.i("printView-ViewGroup", viewGroup.getClass().getSimpleName() + "的子View和数量:" + viewGroup.getChildCount());
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            if (viewGroup.getChildAt(i) instanceof ViewGroup) {
                printChildView((ViewGroup) viewGroup.getChildAt(i));
            } else {
                Log.i("printView", viewGroup.getChildAt(i).getClass().getSimpleName() + "是" + viewGroup.getClass().getSimpleName() + "的子View");
            }
        }
    }

    private void testRxJava() {

    }


}
