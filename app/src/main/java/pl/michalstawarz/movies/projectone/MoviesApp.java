package pl.michalstawarz.movies.projectone;

import android.app.Application;
import android.content.Context;

/**
 * Created by Mycha³ on 2015-08-12.
 */
public class MoviesApp extends Application {
    private  static MoviesApp sInstance;
    public static Context getAppContext() { return  sInstance; };

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }
}
