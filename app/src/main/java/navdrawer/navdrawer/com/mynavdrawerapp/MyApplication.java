package navdrawer.navdrawer.com.mynavdrawerapp;


import android.app.Application;

import navdrawer.navdrawer.com.mynavdrawerapp.di.components.ApplicationComponent;
import navdrawer.navdrawer.com.mynavdrawerapp.di.components.DaggerApplicationComponent;
import navdrawer.navdrawer.com.mynavdrawerapp.di.modules.ApplicationModule;

public class MyApplication extends Application {

    private static ApplicationComponent applicationComponent;

    public MyApplication() {

    }

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();

    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
