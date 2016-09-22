package com.foo.databinding;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;

/**
 * @Desc: TODO
 * @Author: Major
 * @Since: 2016/9/22 23:49
 */

public class Person extends BaseObservable{

    private String name;
    private int age;
    private boolean isBoy;

    public ObservableField<String> like = new ObservableField<>();
    public ObservableInt count = new ObservableInt();

    @Bindable
    public boolean isBoy() {
        return isBoy;
    }

    public void setBoy(boolean boy) {
        isBoy = boy;
        notifyPropertyChanged(BR.boy);
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }
    @Bindable
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        notifyPropertyChanged(BR.age);
    }
}
