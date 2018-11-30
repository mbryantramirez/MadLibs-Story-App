package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;
import static android.example.com.story_app_hw_katsidzira_chelsea.ThirdActivity.VERB_STRING;

public class FourthActivity extends AppCompatActivity {
    public static final String NAME_STRING = "Name";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        Intent intent = getIntent();
        String verbText = intent.getStringExtra(VERB_STRING);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.fourth_activity_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MoveToNextActivity();
            }
        });

        int[] activityColors = getResources().getIntArray(R.array.activityColors);
        int randomActivityColor = activityColors[new Random().nextInt(activityColors.length)];
        findViewById(android.R.id.content).setBackgroundColor(randomActivityColor);
    }

    public void MoveToNextActivity() {
        EditText editText = findViewById(R.id.name_edittext);
        String nameText = editText.getText().toString().trim();
        userVars.add(3, nameText);

        Intent intent = new Intent(this, FifthActivity.class);
        intent.putExtra(NAME_STRING, nameText);
        startActivity(intent);
    }
}
