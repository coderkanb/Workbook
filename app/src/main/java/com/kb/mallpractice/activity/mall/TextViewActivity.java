package com.kb.mallpractice.activity.mall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import com.kb.mallpractice.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView = (TextView) findViewById(R.id.textview);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
    }
}
