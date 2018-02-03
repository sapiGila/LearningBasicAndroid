package basic.app.id.learningbasicandroid.recyclerviewandgridview;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;
import java.util.List;

import basic.app.id.learningbasicandroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class GridViewFragment extends Fragment {

    private GridView gridView;
    private List<String> items;

    public GridViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        gridView = view.findViewById(R.id.grid);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();

        final GridViewItemAdapter adapter = new GridViewItemAdapter(getContext(), getItems());
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Snackbar
                        .make(getActivity().findViewById(android.R.id.content), items.get(i), Snackbar.LENGTH_SHORT)
                        .show();
            }
        });
    }

    public List<String> getItems() {
        if (items == null)
            items = new ArrayList<>();
        items.clear();
        for (int i = 1; i < 16; i++) {
            items.add("Item " + i);
        }
        return items;
    }
}
