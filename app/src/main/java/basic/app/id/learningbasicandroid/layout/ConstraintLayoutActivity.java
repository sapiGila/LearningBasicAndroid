package basic.app.id.learningbasicandroid.layout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import basic.app.id.learningbasicandroid.R;
import basic.app.id.learningbasicandroid.helper.ShowValueHelper;

public class ConstraintLayoutActivity extends AppCompatActivity {

    private EditText input1;
    private EditText input2;
    private Button button;
    private TextView value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
        input1 = findViewById(R.id.input1);
        input2 = findViewById(R.id.input2);
        button = findViewById(R.id.button);
        value = findViewById(R.id.value);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShowValueHelper.inputValue(input1.getText().toString(), input2.getText().toString());
                value.setText(ShowValueHelper.getValue());
            }
        });
    }
}