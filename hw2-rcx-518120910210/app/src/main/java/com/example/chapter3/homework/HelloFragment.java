package com.example.chapter3.homework;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.ArrayList;
import java.util.List;

public class HelloFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private LottieAnimationView animationView;
    private SearchAdapter mSearchAdapter = new SearchAdapter();
    private static final String TAG = "HelloFragment";

    @Nullable

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
super.setUserVisibleHint(isVisibleToUser);
 if (getUserVisibleHint()) {

} else {} }
//界面不可见 相当于onpause

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.activity_search,container, false);
        mRecyclerView = view.findViewById(R.id.rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setAdapter(mSearchAdapter);
        animationView = view.findViewById(R.id.animation_view);

        animationView.playAnimation();
        final List<String> items = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            items.add("这是小明的第" + i + " 个朋友");
        }
        mSearchAdapter.notifyItems(items);
        mRecyclerView.setVisibility(View.INVISIBLE);

        return  view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(TAG, "onAttach() called with: context = [" + context + "]");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        Log.d(TAG, "onCreate() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setVisibility(View.VISIBLE);
                ObjectAnimator AlphaAnimator1 = ObjectAnimator.ofFloat(mRecyclerView,
                        "alpha", 0f, 1f);
                AlphaAnimator1.setInterpolator(new LinearInterpolator());
                AlphaAnimator1.setDuration(1000);
//                AlphaAnimator1.setRepeatMode(ValueAnimator.RESTART);
//                AlphaAnimator1.setRepeatCount(0);
                ObjectAnimator AlphaAnimator2 = ObjectAnimator.ofFloat(animationView,
                        "alpha", 1f, 0f);
                AlphaAnimator2.setInterpolator(new LinearInterpolator());///
                AlphaAnimator2.setDuration(1000);
//                AlphaAnimator2.setRepeatMode(ValueAnimator.RESTART);
//                AlphaAnimator1.setRepeatCount(0);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(AlphaAnimator1,AlphaAnimator2);
                animatorSet.start();

                // 这里会在 5s 后执行
                //animationView.setVisibility(View.GONE);




                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
               
            }
        }, 2000);
        Log.d(TAG, "onActivityCreated() called with: savedInstanceState = [" + savedInstanceState + "]");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG, "onStart() called");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG, "onPause() called");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "onStop() called");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.d(TAG, "onDestroyView() called");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy() called");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach() called");
    }
}
