package org.hse.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class DemoActivity extends AppCompatActivity {

    private TextView result;
    private EditText number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        number = findViewById(R.id.editText);
        View button1 = findViewById(R.id.button);
        View button2 = findViewById(R.id.button2);
        result = findViewById(R.id.textView2);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){clickButton1();}
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){clickButton2();}
        });
    }
    private void clickButton1(){
        int count = parseEditText();
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i<count; i++){
            list.add(i+1);
        }

        int sum = list.stream().mapToInt(Integer::intValue).sum();
        result.setText(String.format("Result1: %d", sum));
    }
    private void clickButton2(){
        int count = parseEditText();
        if(count == 0){
            result.setText(String.format("Result2: %d", 0));
            return;
        }
        int sum = 1;

        for(int i = 1; i<=count; i++){
            if(i%2 == 0) sum *= i;
        }

        result.setText(String.format("Result2: %d", sum));
    }
    private int parseEditText(){
        String numberVal = number.getText().toString();
        if (numberVal.isEmpty()){
            numberVal = "0";
        }

        int num = Integer.parseInt(numberVal);
        if(num < 0 || num > 20) {
            Context context = getApplicationContext();
            String text = getString(R.string.ToastStr);
            int duration = Toast.LENGTH_LONG;
            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
            return 0;
        }
        return num;
    }
}