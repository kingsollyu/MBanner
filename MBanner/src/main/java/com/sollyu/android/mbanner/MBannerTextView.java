package com.sollyu.android.mbanner;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * 作者：sollyu
 * 时间：2018/3/14
 * 说明：
 */
public class MBannerTextView extends android.support.v7.widget.AppCompatTextView implements IMBannerView {

    private long interval = 3000L;

    public MBannerTextView(Context context) {
        super(context);
    }

    public MBannerTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MBannerTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public long getInterval() {
        return interval;
    }

    @Override
    public void onSelected() {

    }

    @Override
    public void onDeselect() {

    }

    public void setInterval(long interval) {
        this.interval = interval;
    }
}
