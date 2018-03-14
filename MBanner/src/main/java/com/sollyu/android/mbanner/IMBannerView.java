package com.sollyu.android.mbanner;

/**
 * 作者：sollyu
 * 时间：2018/3/14
 * 说明：
 */
public interface IMBannerView {

    /**
     * @return 本界面停留时间
     */
    long getInterval();

    /**
     * 当界面被选中
     */
    void onSelected();

    /**
     * 界面失去焦点
     */
    void onDeselect();
}
