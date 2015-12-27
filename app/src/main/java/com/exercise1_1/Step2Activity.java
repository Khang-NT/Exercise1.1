package com.exercise1_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class Step2Activity extends AppCompatActivity implements SeekBar.OnSeekBarChangeListener, CompoundButton.OnCheckedChangeListener {
    private static final String TAG = "Step2Activity";

    TextView salary;
    int vsalary = 0;
    int checkedSportCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step2);

        salary = (TextView)findViewById(R.id.tv_salary);
        ((SeekBar) findViewById(R.id.sb_salary)).setOnSeekBarChangeListener(this);
        ((CheckBox) findViewById(R.id.cb1)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.cb2)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.cb3)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.cb4)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.cb5)).setOnCheckedChangeListener(this);
        ((CheckBox) findViewById(R.id.cb6)).setOnCheckedChangeListener(this);
        findViewById(R.id.b_done).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkedSportCount > 0) {
                    Intent step3 = new Intent(getApplicationContext(), Step3Activity.class);
                    step3.putExtras(getIntent().getExtras());
                    step3.putExtra("salary", vsalary);

                    startActivity(step3);
                }
                else Toast.makeText(Step2Activity.this, "User must select one kind of sports", Toast.LENGTH_SHORT).show();
            }
        });
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ((SnowEffect) findViewById(R.id.snowEffect)).passGesture(event);
        return super.onTouchEvent(event);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        vsalary = progress * 100;
        if (fromUser)
            salary.setText("Your salary: " + vsalary + " dollars");

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (isChecked) checkedSportCount ++;
            else checkedSportCount--;
    }
}
