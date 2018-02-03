package basic.app.id.learningbasicandroid.recyclerviewandgridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import basic.app.id.learningbasicandroid.R;

/**
 * Created by Mahdi on 31/01/18.
 * Part of RecyclerGridViewExample
 */

public class GridViewItemAdapter extends BaseAdapter {

    private final Context context;
    private final List<String> items;

    public GridViewItemAdapter(Context context, List<String> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView text;
        View background;
        if (view == null) {
            // if it's not recycled, initialize some attributes
            view = LayoutInflater.from(context).inflate(R.layout.layout_item, null);
        }

        text = view.findViewById(R.id.text);
        background = view.findViewById(R.id.background);

        text.setText(items.get(i));
        background.setBackgroundColor(MaterialColors.get(context, "500", i));
        return view;
    }
}
