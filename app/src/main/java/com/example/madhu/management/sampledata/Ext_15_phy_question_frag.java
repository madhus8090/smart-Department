package com.example.madhu.management.sampledata;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madhu.management.R;

/**
 * Created by Chowdary on 05/03/2018.
 */

public class Ext_15_phy_question_frag extends Fragment {
   View v;
    public Ext_15_phy_question_frag() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.ext_15_phy_question_frag, container,false);
        return v;
    }
}
