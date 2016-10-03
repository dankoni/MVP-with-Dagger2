package com.androidmeetupdemo.di;

import android.content.Context;

import dagger.Component;

/**
 * Created by danko.misic on 10/2/16.
 */
@ActivityScope
@Component(modules = {ActivityModule.class})
public interface ActivityComponent {
    Context getContext();
}

