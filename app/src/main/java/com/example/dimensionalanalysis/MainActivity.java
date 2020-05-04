package com.example.dimensionalanalysis;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.os.Vibrator;


public class MainActivity extends AppCompatActivity {
    //Initial class declarations
    private MediaPlayer mp;
    EditText editText;
    TextView textView, textView2, textView3, valueininches;
    Button button;
    Vibrator vibrator;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mp = MediaPlayer.create(this, R.raw.arc1);


        //First text view
        textView = findViewById(R.id.textView);
        //Second text view
        textView2 = findViewById(R.id.textView2);
        //Third text view
        textView3 = findViewById(R.id.textView3);
        //Fourth text view
        valueininches = findViewById(R.id.valueOfInches);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        //Adding a new activity
        button.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= 26) {
                    vibrator.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE));
                } else {
                    vibrator.vibrate(1000);
                }
                mp.start();
                convertFromMMtoIn();
            }
        }));




    }

    private void convertFromMMtoIn() {
        String valueEntered = editText.getText().toString();

        double Mili = Double.parseDouble(valueEntered);

        double inches = Mili * 0.0393701;
        valueininches.setText("" + inches);
    }
}
