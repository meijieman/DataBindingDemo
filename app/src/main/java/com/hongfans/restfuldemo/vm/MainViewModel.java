package com.hongfans.restfuldemo.vm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;

/**
 * Created by Administrator on 2016/9/22.
 */
public class MainViewModel extends BaseObservable{

    private String text;
    private boolean pb;

    @Bindable
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
        notifyPropertyChanged(BR.text);
    }

    @Bindable
    public boolean isPb() {
        return pb;
    }

    public void setPb(boolean pb) {
        this.pb = pb;
        notifyPropertyChanged(BR.pb);
    }
}
