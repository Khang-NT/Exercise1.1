package com.exercise1_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import static android.text.TextUtils.isEmpty;

public class Step1Activity extends AppCompatActivity {

    EditText fname, lname, email, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1);

        fname = (EditText) findViewById(R.id.ed_fname);
        lname = (EditText) findViewById(R.id.ed_lname);
        email = (EditText) findViewById(R.id.ed_email);
        phone = (EditText) findViewById(R.id.ed_phone);

        findViewById(R.id.b_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    Intent step2 = new Intent(getApplicationContext(), Step2Activity.class);
                    startActivity(step2);
                    finish();
                }
            }
        });
    }

    private boolean checkInput(){
        boolean isOk = true;

        if (isEmpty(fname.getText())){
            fname.setError("Please enter your name");
            isOk = false;
        } else fname.setError(null);

        if (isEmpty(lname.getText())){
            lname.setError("Please enter your name");
            isOk = false;
        } else lname.setError(null);

        if (!isValidEmail(email.getText())){
            email.setError("Your email is invalid");
            isOk = false;
        } else email.setError(null);

        if (!isValidPhone(phone.getText())){
            phone.setError("Your phone number is invalid");
            isOk = false;
        } else phone.setError(null);

        return isOk;
    }

    public boolean isValidEmail(CharSequence target) {
        return !isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    public boolean isValidPhone(CharSequence target) {
        final String regex = "^[+|0][0-9]{10,13}$";
        return !isEmpty(target) && target.toString().matches(regex);
    }
}
