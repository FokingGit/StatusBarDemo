package com.example.foking.myapplication;

import android.content.Context;
import android.nfc.Tag;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;


/**
 * Created by fengjian on 2017/10/19.
 * function:
 */

public abstract class BaseNoStatusBarFragment extends Fragment {

    public static String TAG = "BaseNoStatusBarFragment";
    private ViewGroup mView;


    @Override
    public void onHiddenChanged(boolean hidden) {
        Log.i(TAG, getClass().getSimpleName() + "：onHiddenChanged");
        if (!hidden && FragmentUtil.judgeGetActivityCanUse(this)) {
            getActivity().setTitle(getFragmentTitle());
        }
    }

    protected abstract void configFragmentView(View view);

    public abstract int getFragmentView();

    public abstract String getFragmentTitle();

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.i(TAG, getClass().getSimpleName() + "：onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, getClass().getSimpleName() + "：onCreate");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + "：onCreateView");
        mView = (ViewGroup) LayoutInflater.from(getActivity()).inflate(getFragmentView(), container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + "：onViewCreated");
        ButterKnife.bind(view);
        configFragmentView(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.i(TAG, getClass().getSimpleName() + "：onActivityCreated");
        getActivity().setTitle(getFragmentTitle());
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.i(TAG, getClass().getSimpleName() + "：onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.i(TAG, getClass().getSimpleName() + "：onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.i(TAG, getClass().getSimpleName() + "：onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.i(TAG, getClass().getSimpleName() + "：onStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.i(TAG, getClass().getSimpleName() + "：onDestroyView");
        super.onDestroyView();
    }


    @Override
    public void onDestroy() {
        Log.i(TAG, getClass().getSimpleName() + "：onDestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.i(TAG, getClass().getSimpleName() + "：onDetach");
        super.onDetach();
    }


}
