package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TableLayout;

import com.zhujinbao.newstitlezhujinbao.R;

import java.util.ArrayList;
import java.util.List;

import adapter.FragmentVideoPagerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideoFragment extends Fragment {


    private View view;
    private TabLayout tabLayout_video;
    private ViewPager viewpager_video;
    public List<Fragment> fragmentList;
    String[] video={"热点视频","娱乐视频","搞笑视频","精品视频"};
    String[] videourl={"V9LG4B3A0","V9LG4CHOR","V9LG4E6VR","00850FRB"};
    private VideoMenuFragment videoMenuFragment;
    private FragmentVideoPagerAdapter fragmentVideoPagerAdapter;

    public VideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view = inflater.inflate(R.layout.fragment_video, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        fragmentVideoPagerAdapter = new FragmentVideoPagerAdapter(getActivity().getSupportFragmentManager(), fragmentList, getActivity(), video);
         viewpager_video.setAdapter(fragmentVideoPagerAdapter);
        tabLayout_video.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout_video.setupWithViewPager(viewpager_video);
    }



    private void initView() {
        tabLayout_video = (TabLayout) view.findViewById(R.id.tablayout_video);
        viewpager_video = (ViewPager) view.findViewById(R.id.viewpager_video);

    }
    private void initData() {
        fragmentList=new ArrayList<>();
        for (int i = 0; i <video.length ; i++) {
            videoMenuFragment = new VideoMenuFragment();
            Bundle bundle = new Bundle();
            bundle.putString("bb",videourl[i]);
            videoMenuFragment.setArguments(bundle);
            fragmentList.add(videoMenuFragment);

        }
    }

}
