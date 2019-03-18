package com.example.sharedpreferences;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    TextView textView;

    public static String SHARE_PREFS = "sharedprefs";
    public static String TEXT = "text";
    public static String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final Button applyTextButton = findViewById(R.id.apply_text_button);
        textView = findViewById(R.id.editText);
        TextView textAffich = findViewById(R.id.textView);

        final SharedPreferences sharedPreferences = getSharedPreferences(SHARE_PREFS,MODE_PRIVATE);
        text = sharedPreferences.getString(TEXT,"");

        textAffich.setText(text);

        applyTextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(TEXT,textView.getText().toString());
                editor.apply();


            }

        });


    }
}