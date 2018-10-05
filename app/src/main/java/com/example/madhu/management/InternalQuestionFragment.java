package com.example.madhu.management;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.madhu.management.sampledata.ChemExtActivity;
import com.example.madhu.management.sampledata.ChemIntActivity;
import com.example.madhu.management.sampledata.PhyExtActivity;
import com.example.madhu.management.sampledata.PhyIntActivity;

import java.util.zip.Inflater;

/**
 * Created by Chowdary on 04/03/2018.
 */

public class InternalQuestionFragment extends Fragment {
View v;
    public InternalQuestionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       v = inflater.inflate(R.layout.internal_question_fragment, container,false);

        CardView intphycard = (CardView) v.findViewById(R.id.int_phy_Id);
        CardView intchemcard = (CardView) v.findViewById(R.id.int_che_Id);
        intphycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PhyIntActivity.class);
                startActivity(intent);
            }
        });
        intchemcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChemIntActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }
}
