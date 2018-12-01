package android.example.com.story_app_hw_katsidzira_chelsea;

import android.content.Intent;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

import static android.example.com.story_app_hw_katsidzira_chelsea.MainActivity.userVars;
import static android.example.com.story_app_hw_katsidzira_chelsea.R.string.show_story;

public class FinalActivity extends AppCompatActivity {
    String strShowStoryText = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        getSupportActionBar().setTitle("Restart Game");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String animalText = userVars.get(0);
        String stateText = userVars.get(1);
        String verbText = userVars.get(2);
        String nameText = userVars.get(3);
        String relativeText = userVars.get(4);
        String objectText = userVars.get(5);
        String bodyPartText = userVars.get(6);

        String strShowStoryFormat = getResources().getString(show_story);
        strShowStoryText = String.format(strShowStoryFormat, animalText, stateText, verbText, nameText, relativeText, objectText, bodyPartText);

        final TextView textView = findViewById(R.id.story_textview);
        String message = textView.getText().toString();

        Button button = findViewById(R.id.show_story_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText(strShowStoryText);
                textView.setVisibility(View.VISIBLE);
            }
        });

        Button shareButton = findViewById(R.id.share_button);
        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareStory();
            }
        });

        int[] activityColors = getResources().getIntArray(R.array.activityColors);
        int randomActivityColor = activityColors[new Random().nextInt(activityColors.length)];
        findViewById(android.R.id.content).setBackgroundColor(randomActivityColor);
    }

    public void shareStory() {
        Intent share = new Intent(Intent.ACTION_SEND);
        share.setType("text/plain");
        share.putExtra(Intent.EXTRA_SUBJECT, "My Stringify Story!");
        share.putExtra(Intent.EXTRA_TEXT, "Too " + strShowStoryText);
        startActivity(Intent.createChooser(share, strShowStoryText));
    }
}
