package com.exercise1_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

import static android.text.TextUtils.isEmpty;

public class Step1Activity extends AppCompatActivity {

    EditText fname, lname, email, phone;
    RadioGroup rg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.step1);

        fname = (EditText) findViewById(R.id.ed_fname);
        lname = (EditText) findViewById(R.id.ed_lname);
        email = (EditText) findViewById(R.id.ed_email);
        phone = (EditText) findViewById(R.id.ed_phone);
        rg = (RadioGroup)findViewById(R.id.rg_sex);

        findViewById(R.id.b_next).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkInput()) {
                    Intent step2 = new Intent(getApplicationContext(), Step2Activity.class);
                    step2.putExtra("fname", fname.getText().toString());
                    step2.putExtra("lname", lname.getText().toString());
                    step2.putExtra("email", email.getText().toString());
                    step2.putExtra("phone", phone.getText().toString());
                    step2.putExtra("sex", rg.getCheckedRadioButtonId() == R.id.rb_female ? 1 : 0);
                    startActivity(step2);
                }
            }
        });
        overridePendingTransition(R.anim.slide_in_up, R.anim.slide_out_down);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        ((SnowEffect) findViewById(R.id.snowEffect)).passGesture(event);
        return super.onTouchEvent(event);
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
