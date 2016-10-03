package com.androidmeetupdemo.di;

import android.content.Context;

import dagger.Module;
import dagger.Provides;

/**
 * Created by danko.misic on 10/2/16.
 */
@Module
public class ActivityModule {
    private final Context mContext;
    public ActivityModule(Context mContext) {
        this.mContext = mContext;
    }

    @Provides
    @ActivityScope
    Context provideActivityContext() {
        return mContext;
    }
}
