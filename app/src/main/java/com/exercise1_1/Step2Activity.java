package com.exercise1_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.TextView;

public class Step2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener {
    private static final String TAG = "Step2Activity";

    TextView salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step2);

        ((SeekBar) findViewById(R.id.sb_salary)).setOnSeekBarChangeListener(this);
        salary = (TextView)findViewById(R.id.tv_salary);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (fromUser)
            salary.setText("Your salary: " + progress * 100 + " dollars");
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
}
