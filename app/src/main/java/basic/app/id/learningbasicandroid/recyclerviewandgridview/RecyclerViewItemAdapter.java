package basic.app.id.learningbasicandroid.recyclerviewandgridview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import basic.app.id.learningbasicandroid.R;

/**
 * Created by Mahdi on 31/01/18.
 * Part of RecyclerGridViewExample
 */

public class RecyclerViewItemAdapter extends RecyclerView.Adapter<RecyclerViewItemAdapter.ViewHolder> {

    private RecyclerViewFragment fragment;
    private List<Contact> items = new ArrayList<>();

    public RecyclerViewItemAdapter(RecyclerViewFragment fragment, List<Contact> items) {
        this.fragment = fragment;
        this.items = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(fragment.getContext());
        View view = inflater.inflate(R.layout.layout_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        if (items.size() > 0) {
            holder.loadBind(position);
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        View background;
        TextView text;

        public ViewHolder(View itemView) {
            super(itemView);
            background = itemView.findViewById(R.id.background);
            text = itemView.findViewById(R.id.text);
        }

        public void loadBind(final int position) {
            final Contact phoneBook = items.get(position);
            text.setText(phoneBook.getName() + ", " + phoneBook.getPhoneNumber());
            background.setBackgroundColor(MaterialColors.get(fragment.getContext(), "500", position));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    fragment.showContact(items.get(position));
                }
            });
        }
    }
}