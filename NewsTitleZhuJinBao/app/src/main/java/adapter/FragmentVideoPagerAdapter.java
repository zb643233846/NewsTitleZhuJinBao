package adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by LX-PC on 2017/2/24.
 */

public class FragmentVideoPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> list;
    private Context context;
    private  String[] video;

    public FragmentVideoPagerAdapter(FragmentManager fm, List<Fragment> list, Context context, String[] video) {
        super(fm);
        this.list=list;
        this.context=context;
        this.video=video;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return video[position];
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
