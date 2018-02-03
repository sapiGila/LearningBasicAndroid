package basic.app.id.learningbasicandroid.optionchooser;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import basic.app.id.learningbasicandroid.R;

public class OptionChooserActivity extends AppCompatActivity {

    private List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option_chooser);
        Spinner spinner = findViewById(R.id.spinner);
        LinearLayout leftPanel = findViewById(R.id.leftPanel);
        LinearLayout rightPanel = findViewById(R.id.rightPanel);
        LinearLayout leftPanelRadio = findViewById(R.id.leftPanelRadio);
        LinearLayout rightPanelRadio = findViewById(R.id.rightPanelRadio);
        generateLeftCheckBoxes(leftPanel);
        generateRightCheckBoxes(rightPanel);
        generateLeftRadios(leftPanelRadio);
        generateRightRadios(rightPanelRadio);
        ArrayAdapter<String> itemAdapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item, getItems());
        itemAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(itemAdapter);
    }

    private void generateRightRadios(LinearLayout rightPanelRadio) {
        for (int i = 2; i < 6; i++) {
            if (i % 2 == 0) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText("Item " + i);
                rightPanelRadio.addView(radioButton);
            }
        }
    }

    private void generateLeftRadios(LinearLayout leftPanelRadio) {
        for (int i = 1; i < 5; i++) {
            if (i % 2 != 0) {
                RadioButton radioButton = new RadioButton(this);
                radioButton.setText("Item " + i);
                leftPanelRadio.addView(radioButton);
            }
        }
    }

    private void generateRightCheckBoxes(LinearLayout rightPanel) {
        for (int i = 2; i < 6; i++) {
            if (i % 2 == 0) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText("Item " + i);
                rightPanel.addView(checkBox);
            }
        }
    }

    private void generateLeftCheckBoxes(LinearLayout leftPanel) {
        for (int i = 1; i < 5; i++) {
            if (i % 2 != 0) {
                CheckBox checkBox = new CheckBox(this);
                checkBox.setText("Item " + i);
                leftPanel.addView(checkBox);
            }
        }
    }

    private List<String> getItems() {
        if (items == null) items = new ArrayList<>();
        for (int i = 1; i < 16; i++) {
            items.add("Item " + i);
        }
        return items;
    }
}
