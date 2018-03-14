package com.sollyu.android.mbanner;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;

/**
 * 作者：sollyu
 * 时间：2018/3/14
 * 说明：
 */
public class MBanner extends ViewPager {

    private static final String TAG = "MBanner";

    private MBannerHandler mBannerHandler;
    private boolean        isAutoScroll     = false;
    private MBannerAdapter mBannerAdapter   = new MBannerAdapter();
    private int            currentPageIndex = -1;

    public MBanner(@NonNull Context context) {
        super(context);
        initView(context, null);
    }

    public MBanner(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(@NonNull Context context, @Nullable AttributeSet attrs) {
        setAdapter(mBannerAdapter);
        mBannerHandler = new MBannerHandler(this);
    }

    public void notifyDataSetChanged() {
        getAdapter().notifyDataSetChanged();
    }

    @Override
    public MBannerAdapter getAdapter() {
        return (MBannerAdapter) super.getAdapter();
    }

    public boolean isAutoScroll() {
        return isAutoScroll;
    }

    public void setAutoScroll(boolean autoScroll) {
        isAutoScroll = autoScroll;
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        super.onPageScrolled(position, offset, offsetPixels);
        if (currentPageIndex != position) {
            currentPageIndex = position;
            if (isAutoScroll()) {
                int nextPosition = position == (getAdapter().getViewList().size() - 1) ? 0 : position + 1;
                mBannerHandler.postDelayed(position, nextPosition, getAdapter().getViewList().get(position).getInterval());
            }

            /* 通知试图你已经被选中 */
            getAdapter().getViewList().get(position).onSelected();
        }
    }

}
