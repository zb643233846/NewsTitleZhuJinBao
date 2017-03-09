package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import com.nostra13.universalimageloader.core.DisplayImageOptions;

import java.util.List;

/**
 * Created by LX-PC on 2017/2/12.
 */

public class RollMenuAdapter extends FragmentPagerAdapter {
     private List<Fragment> list;
    private Context context;
    private  String[] title;

    public RollMenuAdapter(FragmentManager fm,List<Fragment> list,Context context,String[] title) {
        super(fm);
        this.list=list;
        this.context=context;
        this.title=title;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }

    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
