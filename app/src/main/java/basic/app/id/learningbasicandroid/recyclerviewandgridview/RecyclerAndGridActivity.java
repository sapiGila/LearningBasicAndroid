package basic.app.id.learningbasicandroid.recyclerviewandgridview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

import basic.app.id.learningbasicandroid.R;

public class RecyclerAndGridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_and_grid);
        ((Switch) findViewById(R.id.switchView)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isCheckedChanged) {
                switchFragment(isCheckedChanged);
            }
        });
        switchFragment(false);
    }

    private void switchFragment(boolean gridView) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;
        if (gridView) {
            fragment = new GridViewFragment();
            this.setTitle("GridView Example");
        } else {
            fragment = new RecyclerViewFragment();
            this.setTitle("RecyclerView Example");
        }
        fragmentManager.beginTransaction().replace(R.id.content, fragment).commit();
    }
}
