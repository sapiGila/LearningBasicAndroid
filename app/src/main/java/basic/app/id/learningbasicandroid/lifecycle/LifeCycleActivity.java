package basic.app.id.learningbasicandroid.lifecycle;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import basic.app.id.learningbasicandroid.DummyActivity;
import basic.app.id.learningbasicandroid.R;

/**
 * Created by Dell on 1/28/2018.
 */

public class LifeCycleActivity extends AppCompatActivity {

    private TextView lifeCycleTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lifecycle);
        lifeCycleTextView = findViewById(R.id.lifecycle_text_view);
        findViewById(R.id.go_to_next_activity_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(LifeCycleActivity.this, DummyActivity.class));
                    }
                });
        findViewById(R.id.clear_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        lifeCycleTextView.setText(getResources().getString(R.string.lifecycle_text));
                    }
                });
    }

    @Override
    protected void onStart() {
        super.onStart();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonStart Active!");
    }

    @Override
    protected void onResume() {
        super.onResume();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonResume Active!");
    }

    @Override
    protected void onPause() {
        super.onPause();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonPause Active!");
    }

    @Override
    protected void onStop() {
        super.onStop();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonStop Active!");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonRestart Active!");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        lifeCycleTextView.setText(lifeCycleTextView.getText() + "\nonDestroy Active!");
    }
}
