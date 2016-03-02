package com.admin;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.admin.dot.DoTView;
import com.admin.dot.Dot;
import com.admin.dot.R;
import com.adutils.ABNumberUtil;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DoTView doTView;
    private Dot dot;
    private int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doTView = (DoTView) findViewById(R.id.dotView);
        dot = (Dot) findViewById(R.id.dot);
        index = doTView.getCurrentposition();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                if (ABNumberUtil.isOdd(index))
                    dot.setColor(getResources().getColor(R.color.cl_Blue));
                else dot.setColor(getResources().getColor(R.color.cl_Red));
                dot.postInvalidate();
                if (index < doTView.getChildCount() - 1)
                    index++;
                else if (index == doTView.getChildCount() - 1)
                    index = 0;
                doTView.setSelectPosition(index);
                break;
            default:
                break;
        }
    }
}
