package basic.app.id.learningbasicandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import basic.app.id.learningbasicandroid.layout.ConstraintLayoutActivity;
import basic.app.id.learningbasicandroid.layout.LinearLayoutActivity;
import basic.app.id.learningbasicandroid.layout.RelativeLayoutActivity;
import basic.app.id.learningbasicandroid.recyclerviewandgridview.RecyclerAndGridActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go_to_relative_layout_sample_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, RelativeLayoutActivity.class));
                    }
                });
        findViewById(R.id.go_to_linear_layout_sample_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, LinearLayoutActivity.class));
                    }
                });
        findViewById(R.id.go_to_constraint_layout_sample_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, ConstraintLayoutActivity.class));
                    }
                });
        findViewById(R.id.go_to_recycler_and_grid_view_sample_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, RecyclerAndGridActivity.class));
                    }
                });
    }
}