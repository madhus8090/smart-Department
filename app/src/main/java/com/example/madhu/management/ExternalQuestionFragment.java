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
import com.example.madhu.management.sampledata.PhyExtActivity;

/**
 * Created by Chowdary on 04/03/2018.
 */

public class ExternalQuestionFragment extends Fragment {
View v;
    public ExternalQuestionFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.external_question_fragment, container,false);
        CardView extphycard = (CardView) v.findViewById(R.id.ext_phy_Id);
        CardView extchemcard = (CardView) v.findViewById(R.id.ext_che_Id);
        extphycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), PhyExtActivity.class);
                startActivity(intent);
            }
        });
        extchemcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ChemExtActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

}
