package basic.app.id.learningbasicandroid.recyclerviewandgridview;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import basic.app.id.learningbasicandroid.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecyclerViewFragment extends Fragment {

    private RecyclerView recyclerView;
    private List<Contact> items = new ArrayList<>();


    public RecyclerViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        RecyclerViewItemAdapter adapter = new RecyclerViewItemAdapter(this, getItems());
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    public List<Contact> getItems() {
        if (items == null)
            items = new ArrayList<>();
        items.clear();
        for (int i = 1; i < 16; i++) {
            Contact contact = new Contact("User " + i, "02123456" + i);
            items.add(contact);
        }
        return items;
    }

    public void showContact(Contact contact) {
        new AlertDialog.Builder(getContext())
                .setTitle("Hai...")
                .setMessage("Nama : " + contact.getName() + "\n" + "Nomor Telepon : " + contact.getPhoneNumber())
                .setPositiveButton("Tutup", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }
}