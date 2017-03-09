package application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatDelegate;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.zhujinbao.newstitlezhujinbao.R;

import org.xutils.x;

import java.util.HashMap;

/**
 * Created by LX-PC on 2017/2/20.
 */

public class MyApplication extends Application {
    public static HashMap<String, Integer> mResourceMap = new HashMap<>();
    private static SharedPreferences mSharedPreferences;
    private static Context mApplicationContext;
    //public static int MMODE = 0;
    @Override
    public void onCreate() {
        super.onCreate();
        mApplicationContext = this.getApplicationContext();
        mApplicationContext.getSharedPreferences("config",MODE_PRIVATE);
//        MMODE=mSharedPreferences.getInt("mode",0);
       x.Ext.init(this);
        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .threadPoolSize(2)
                .threadPriority(4)
                .build();
        ImageLoader.getInstance().init(configuration);
  }
//    public static void saveMode() {
//        SharedPreferences.Editor edit = mSharedPreferences.edit();
//        edit.putInt("mode", MMODE);
//        edit.commit();
//    }
    public static void swithMode(int mode) {
        switch (mode){
            case 0:
            mResourceMap.put("div", R.color.textColor);
            mResourceMap.put("bac",R.color.backgroundColor);
            mResourceMap.put("tvc",R.color.textColor);
            break;
            case 1:
                mResourceMap.put("div",R.color.backgroundColor);
                mResourceMap.put("bac", R.color.textColor);
                mResourceMap.put("tvc",R.color.backgroundColor);
                break;
        }
    }
}
