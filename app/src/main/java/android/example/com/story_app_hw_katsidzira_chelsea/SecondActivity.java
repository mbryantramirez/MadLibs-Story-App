package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.ANIMAL_STRING;
import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;


public class SecondActivity extends AppCompatActivity {
    public static final String STATE_STRING = "US State";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String animalText = intent.getStringExtra(ANIMAL_STRING);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.third_activity_button);
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
        EditText editText = findViewById(R.id.us_state_edittext);
        String stateText = editText.getText().toString().trim();
        userVars.add(1, stateText);

        Intent intent = new Intent(this, ThirdActivity.class);
        intent.putExtra(STATE_STRING, stateText);
        startActivity(intent);
    }
}
