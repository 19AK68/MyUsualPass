package com.ak.user.myusualpass;

import android.content.Context;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

   TextInputEditText pass;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addOnUsualPass();

    }

    private void addOnUsualPass() {

        pass = (TextInputEditText) findViewById(R.id.etPass);
        pass.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
            {
                if(keyEvent != null&&(keyEvent.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                {
                    InputMethodManager inputMethodManager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(pass.getApplicationWindowToken(),InputMethodManager.HIDE_NOT_ALWAYS);
                }
                return false;
            }
        });
        btn =  (Button)findViewById(R.id.btnPass);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pass.getText().toString().trim().isEmpty())
                {
                    Toast.makeText(
                            MainActivity.this, "Пароль не может быть пустым",
                            Toast.LENGTH_LONG
                    ).show();
                }
                else
                    Toast.makeText(
                            MainActivity.this,"Your password:" + " " + pass.getText(),
                            Toast.LENGTH_LONG
                    ).show();
            }
        });
    }
}
