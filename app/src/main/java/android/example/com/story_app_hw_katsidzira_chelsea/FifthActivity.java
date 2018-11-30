package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.FourthActivity.NAME_STRING;
import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;


public class FifthActivity extends AppCompatActivity {
    public static final String RELATIVE_STRING = "Relative type";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);

        Intent intent = getIntent();
        String nameText = intent.getStringExtra(NAME_STRING);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.fifth_activity_button);
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
        EditText editText = findViewById(R.id.relative_edittext);
        String relativeText = editText.getText().toString().trim();
        userVars.add(4, relativeText);

        Intent intent = new Intent(this, SixthActivity.class);
        intent.putExtra(RELATIVE_STRING, relativeText);
        startActivity(intent);
    }
}
