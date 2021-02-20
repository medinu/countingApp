package com.pandinu.countingapp;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.pandinu.countingapp.Model.Count;

public class CountingFragment extends Fragment {
    private static final String TAG = "CountingFragment";
    private Count count;
    private TextView mTextView;

    private Button mPlusOne, mPlusFive, mMinusOne, mMinusFive, mReset;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        count = new Count();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_count, container, false);

        mTextView = (TextView)v.findViewById(R.id.TextView_count);
        mTextView.setText(count.getCount()+"");

        mPlusOne = (Button)v.findViewById(R.id.Button_plus_one);
        mPlusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, count.getCount()+"");
                count.setCount(count.getCount() + 1);
                Log.e(TAG, count.getCount()+"");
                updateText(count.getCount());
            }
        });


        mPlusFive = (Button)v.findViewById(R.id.Button_plus_five);
        mPlusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setCount(count.getCount() + 5);
                updateText(count.getCount());
            }
        });

        mMinusOne = (Button)v.findViewById(R.id.Button_minus_one);
        mMinusOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setCount(count.getCount() - 1);
                updateText(count.getCount());
            }
        });

        mMinusFive = (Button)v.findViewById(R.id.Button_minus_five);
        mMinusFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count.setCount(count.getCount() - 5);
                updateText(count.getCount());
            }
        });

        mReset = (Button)v.findViewById(R.id.Button_reset);
        mReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count = new Count();
                updateText(count.getCount());
            }
        });


        return v;
    }

    private void updateText(int newCount){
        mTextView.setText(newCount+"");
    }

}
