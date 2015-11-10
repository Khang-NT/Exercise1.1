package com.exercise1_1;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Step3Activity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "Step3Activity";

    String fname, lname, email, phone;
    int salary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step3);

        Bundle bundle = getIntent().getExtras();

        fname = bundle.getString("fname");
        lname = bundle.getString("lname");
        email = bundle.getString("email");
        phone = bundle.getString("phone");
        salary = bundle.getInt("salary");

        findViewById(R.id.b_restart).setOnClickListener(this);
        findViewById(R.id.b_sendmail).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.b_restart:
                Intent step1 = new Intent(this, Step1Activity.class);
                step1.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(step1);
                finish();
                break;
            case R.id.b_sendmail:
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", email, null));
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "User's registration info");

                String content = fname + "_" + lname + "\n";
                content += phone + "\n";
                content += salary + " dollars";

                emailIntent.putExtra(Intent.EXTRA_TEXT, content);
                startActivity(Intent.createChooser(emailIntent, "Send email..."));
        }
    }
}
