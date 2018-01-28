package basic.app.id.learningbasicandroid.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import basic.app.id.learningbasicandroid.R;

public class ActivityNext extends AppCompatActivity {

    private TextView name;
    private TextView email;
    private EditText reply;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        name = findViewById(R.id.name_text_view);
        email = findViewById(R.id.email_text_view);
        reply = findViewById(R.id.reply_edit_text);
        name.setText(getIntent().getStringExtra("Name"));
        email.setText(getIntent().getStringExtra("Email"));
        findViewById(R.id.submit_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent result = new Intent();
                        result.putExtra("Reply", reply.getText().toString());
                        setResult(RESULT_OK, result);
                        finish();
                    }
                });
    }
}
