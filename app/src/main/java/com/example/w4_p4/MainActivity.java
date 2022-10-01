package com.example.w4_p4;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GestureDetectorCompat;
import androidx.core.view.MotionEventCompat;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import androidx.core.view.GestureDetectorCompat;

import com.example.w4_p4.R;

public class MainActivity extends Activity implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private GestureDetectorCompat mDetector;
    private TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = new GestureDetectorCompat(this,this);
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this);
        tv = (TextView) findViewById(R.id.homepage);

    }

    private static final int thresh = 100;
    private static final int velocity = 100;

    @Override
    public boolean onTouchEvent(MotionEvent event){
        if (this.mDetector.onTouchEvent(event)) {
            return true;
        }
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onDown(MotionEvent event) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        boolean result = false;
        try {
            float diffY = e2.getY() - e1.getY();
            float diffX = e2.getX() - e1.getX();
            if (Math.abs(diffX) > Math.abs(diffY)) {
                if (Math.abs(diffX) > thresh && Math.abs(velocityX) > velocity) {
                    if (diffX > 0) {
                        onFlingRight();
                    } else {
                        onFlingLeft();
                    }
                    result = true;
                }
            }
            else if (Math.abs(diffY) > thresh && Math.abs(velocityY) > velocity) {
                if (diffY > 0) {
                    onFlingBottom();
                } else {
                    onFlingTop();
                }
                result = true;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return result;
    }

    public void onFlingRight() {
        Intent intentright = new Intent (MainActivity.this, EastActivity.class);
        startActivity(intentright);
    }

    public void onFlingLeft() {
        Intent intentleft = new Intent (MainActivity.this, WestActivity.class);
        startActivity(intentleft);
    }

    public void onFlingTop() {
        Intent intentnorth = new Intent (MainActivity.this, NorthActivity.class);
        startActivity(intentnorth);
    }

    public void onFlingBottom() {
        Intent intentsouth = new Intent (MainActivity.this, SouthActivity.class);
        startActivity(intentsouth);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}