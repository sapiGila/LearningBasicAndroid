package basic.app.id.learningbasicandroid.intents;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import basic.app.id.learningbasicandroid.R;

public class TutorialIntentsActivity extends AppCompatActivity {

    private EditText name;
    private EditText email;
    private TextView reply;
    private final int REQUEST_CODE = 99;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic_android);
        name = findViewById(R.id.name_edit_text);
        email = findViewById(R.id.email_edit_text);
        reply = findViewById(R.id.reply_text_view);
        findViewById(R.id.go_to_next_activity_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent nextScreenIntent = new Intent(TutorialIntentsActivity.this, ActivityNext.class);
                        nextScreenIntent.putExtra("Name", name.getText().toString());
                        nextScreenIntent.putExtra("Email", email.getText().toString());
                        startActivityForResult(nextScreenIntent, REQUEST_CODE);
                    }
                });
        findViewById(R.id.share_button)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        intent.putExtra(Intent.EXTRA_SUBJECT, "Hai!");
                        intent.putExtra(Intent.EXTRA_TEXT, "Salam Kenal");
                        startActivity(Intent.createChooser(intent, "Hai!")
                                .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
                    }
                });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                reply.setText(data.getStringExtra("Reply"));
            }
        }
    }
}
