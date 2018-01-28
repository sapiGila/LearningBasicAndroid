package basic.app.id.learningbasicandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import basic.app.id.learningbasicandroid.fragment.TutorialFragmentActivity;
import basic.app.id.learningbasicandroid.intents.TutorialIntentsActivity;
import basic.app.id.learningbasicandroid.lifecycle.LifeCycleActivity;
import basic.app.id.learningbasicandroid.retrofit.RetrofitActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.go_to_life_cycle_activity_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
                    }
                });
        findViewById(R.id.go_to_intent_activity)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, TutorialIntentsActivity.class));
                    }
                });
        findViewById(R.id.go_to_fragment_activity)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, TutorialFragmentActivity.class));
                    }
                });
        findViewById(R.id.go_to_retrofit_activity)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(MainActivity.this, RetrofitActivity.class));
                    }
                });
    }
}
