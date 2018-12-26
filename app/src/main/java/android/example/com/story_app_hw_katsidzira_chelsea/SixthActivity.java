package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.FifthActivity.RELATIVE_STRING;
import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;


public class SixthActivity extends AppCompatActivity {
    public static final String OBJECT_STRING = "Common object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sixth);

        Intent intent = getIntent();
        /**
         * String never used
         */
        String relativeText = intent.getStringExtra(RELATIVE_STRING);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.sixth_activity_button);
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
        EditText editText = findViewById(R.id.object_edittext);
        String objectText = editText.getText().toString().trim();
        userVars.add(5, objectText);

        Intent intent = new Intent(this, SeventhActivity.class);
        intent.putExtra(OBJECT_STRING, objectText);
        startActivity(intent);
    }
}
