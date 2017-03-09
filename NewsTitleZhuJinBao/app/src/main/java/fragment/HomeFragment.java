package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zhujinbao.newstitlezhujinbao.MentManageActivity;
import com.zhujinbao.newstitlezhujinbao.R;

import java.util.ArrayList;
import java.util.List;

import adapter.RollMenuAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private String[] title = {"推荐", "笑话", "游戏", "科技", "彩票", "时尚", "情感", "精选"};
    private String[] title1 = {"T1348647909107", "T1350383429665", "T1348654151579", "T1348649580692", "T1356600029035", "T1348650593803", "T1348650839000", "T1370583240249"};
    private View view;
    private TabLayout tablayout_title;
    private ViewPager viewpager;
    private List<Fragment> list;
    private Fragment rollmenufragment;
    private ImageView jiahao_iv;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tablayout_title = (TabLayout) view.findViewById(R.id.tablayout_title);
        viewpager = (ViewPager) view.findViewById(R.id.viewpager);
        jiahao_iv = (ImageView) view.findViewById(R.id.jiahao_iv);
        inData();
        RollMenuAdapter rollmenuadapter = new RollMenuAdapter(getActivity().getSupportFragmentManager(), list, getActivity(), title);
        viewpager.setAdapter(rollmenuadapter);
        tablayout_title.setTabMode(TabLayout.MODE_SCROLLABLE);
        tablayout_title.setupWithViewPager(viewpager);
          imgOnClick();
    }

    private void imgOnClick() {
        jiahao_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), MentManageActivity.class);
                getActivity().startActivity(intent);
                getActivity().finish();
            }
        });
    }

    private void inData() {
        list = new ArrayList<Fragment>();
        for (int i = 0; i < title.length; i++) {
            rollmenufragment = new RollMenuFragment();

            Bundle bundle = new Bundle();
            bundle.putString("aa", title1[i]);
           rollmenufragment.setArguments(bundle);
            list.add(rollmenufragment);
        }

    }


}
