package cn.maizz.widget.mbanner.sample;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.sollyu.android.mbanner.MBanner;
import com.sollyu.android.mbanner.MBannerTextView;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MBanner mBanner = findViewById(R.id.mBanner);

        mBanner.setAutoScroll(true);
        mBanner.getAdapter().getViewList().clear();
        for (int i = 0; i < 5; i++) {
            MBannerTextView textView = new MBannerTextView(this);
            textView.setText("我是天才" + i + "号");
            textView.setGravity(Gravity.CENTER);
            textView.setTextSize(20);
            textView.setInterval(3000);
            mBanner.getAdapter().getViewList().add(textView);
        }

        mBanner.notifyDataSetChanged();
    }

}
