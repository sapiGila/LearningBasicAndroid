package basic.app.id.learningbasicandroid.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import basic.app.id.learningbasicandroid.R;

public class TutorialFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutorial_fragment);
        ViewPager viewPager = findViewById(R.id.container);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new SectionFragment().newInstance("SECTION 1"));
        adapter.addFragment(new SectionFragment().newInstance("SECTION 2"));
        adapter.addFragment(new SectionFragment().newInstance("SECTION 3"));
        viewPager.setAdapter(adapter);
    }
}