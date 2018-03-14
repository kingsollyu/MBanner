package com.sollyu.android.mbanner;

import android.os.Handler;
import android.os.Message;

/**
 * 作者：sollyu
 * 时间：2018/3/14
 * 说明：
 */
class MBannerHandler extends Handler {
    public static final int CHANGE_POSITION = 974;
    
    private MBanner mBanner;

    public MBannerHandler(MBanner mBanner) {
        this.mBanner = mBanner;
    }

    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        switch (msg.what) {
            case CHANGE_POSITION:
                getMBanner().setCurrentItem((Integer) msg.obj);
                break;
        }
    }

    void postDelayed(final int currentPosition, final int nextPosition, long delayMillis) {
        this.postDelayed(new Runnable() {
            @Override
            public void run() {
                mBanner.getAdapter().getViewList().get(currentPosition).onDeselect();
                MBannerHandler.this.sendMessage(MBannerHandler.this.obtainMessage(CHANGE_POSITION, nextPosition));
            }
        }, delayMillis);
    }

    public MBanner getMBanner() {
        return mBanner;
    }
}
