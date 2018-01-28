package basic.app.id.learningbasicandroid.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import basic.app.id.learningbasicandroid.R;

/**
 * Created by Dell on 1/28/2018.
 */

public class SectionFragment extends Fragment {

    private TextView sectionLabelTextView;
    private String sectionLabel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        sectionLabelTextView = view.findViewById(R.id.section_label);
        sectionLabelTextView.setText(sectionLabel);
        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sectionLabel = getArguments().getString("SectionLabel", "");
    }

    public static SectionFragment newInstance(String sectionLabel) {
        SectionFragment sectionFragment = new SectionFragment();
        Bundle bundle = new Bundle();
        bundle.putString("SectionLabel", sectionLabel);
        sectionFragment.setArguments(bundle);
        return sectionFragment;
    }
}
