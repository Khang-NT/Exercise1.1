package com.exercise1_1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Step1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1);

        findViewById(R.id.b_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent step2 = new Intent(getApplicationContext(), Step2Activity.class);
                startActivity(step2);
                finish();
            }
        });
    }
}
