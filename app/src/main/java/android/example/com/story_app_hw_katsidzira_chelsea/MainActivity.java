package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    public static final String ANIMAL_STRING = "Animal type";
    public static ArrayList<String> userVars = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.second_activity_button);
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

    protected void MoveToNextActivity() {
        EditText editText = findViewById(R.id.animal_edittext);
        String animalText = editText.getText().toString().trim();
        userVars.add(0, animalText);

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra(ANIMAL_STRING, animalText);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("Instance state", "onSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        savedInstanceState.getString("Instance state");
    }
}
