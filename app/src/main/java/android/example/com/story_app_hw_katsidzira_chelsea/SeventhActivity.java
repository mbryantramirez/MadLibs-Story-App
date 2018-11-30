package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;
import static android.example.com.story_app_hw_katsidzira_chelsea.SixthActivity.OBJECT_STRING;

public class SeventhActivity extends AppCompatActivity {
    public static final String BODY_PART_STRING = "Body part";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seventh);

        Intent intent = getIntent();
        String objectText = intent.getStringExtra(OBJECT_STRING);

        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Button button = findViewById(R.id.seventh_activity_button);
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
        EditText editText = findViewById(R.id.body_part_edittext);
        String bodyPartText = editText.getText().toString().trim();
        userVars.add(6, bodyPartText);

        Intent intent = new Intent(this, FinalActivity.class);
        intent.putExtra(BODY_PART_STRING, bodyPartText);
        startActivity(intent);
    }
}
