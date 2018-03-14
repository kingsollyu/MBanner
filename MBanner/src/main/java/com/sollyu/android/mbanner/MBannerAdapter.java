package com.sollyu.android.mbanner;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.LinkedList;
import java.util.List;

/**
 * 作者：sollyu
 * 时间：2018/3/14
 * 说明：
 */
public class MBannerAdapter extends PagerAdapter {

    private List<IMBannerView> viewList = new LinkedList<>();

    @Override
    public int getCount() {
        return getViewList().size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = (View) getViewList().get(position);
        container.addView(view);
        return view;
    }

    public List<IMBannerView> getViewList() {
        return viewList;
    }
}
