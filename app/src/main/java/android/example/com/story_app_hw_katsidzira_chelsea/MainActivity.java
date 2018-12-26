package android.example.com.story_app_hw_katsidzira_chelsea;

import static java.util.stream.Collectors.joining;

import android.content.Intent;
import android.os.Build.VERSION_CODES;
import android.support.annotation.RequiresApi;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class MainActivity extends AppCompatActivity {
    public static final String ANIMAL_STRING = "Animal type";

    /**
     * You should almost never have public static objects if you need to access this data structure in multiple classes pass them in
     * they can be freed unexpectedly and can also take on unexpected values.
     */
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

        /**
         * This could be split off into its own method
         */
        int[] activityColors = getResources().getIntArray(R.array.activityColors);
        int randomActivityColor = activityColors[new Random().nextInt(activityColors.length)];
        findViewById(android.R.id.content).setBackgroundColor(randomActivityColor);

        List<String> l = new ArrayList(Arrays.asList("one", "two"));
        Stream<String> sl = l.stream();
        l.add("three");
        String s = sl.collect(joining(" "));

    }

    /**
     * Overridden methods at the top, followed by public, then protected, then private.
     */
    protected void MoveToNextActivity() {

        /**
         *  Have the logic stick to the function name, If this function moves to next activity it shouldn't be initializing edit text in the activity this
         *  should be done before logic
         */
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
