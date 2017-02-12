package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhujinbao.newstitlezhujinbao.R;

import java.util.ArrayList;
import java.util.List;

import adapter.RollMenuAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private  String[] title={"推荐", "热点", "阳光", "体育", "北京", "社会", "娱乐", "财经"};
   private  View view;
    private TabLayout tablayout_title;
    private ViewPager viewpager;
    private List<Fragment> list;
    private Fragment rollmenufragment;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         view=inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        tablayout_title= (TabLayout) view.findViewById(R.id.tablayout_title);
       viewpager= (ViewPager) view.findViewById(R.id.viewpager);
       inData();
        RollMenuAdapter rollmenuadapter=new RollMenuAdapter(getActivity().getSupportFragmentManager(),list,getActivity(),title);
     viewpager.setAdapter(rollmenuadapter);
      tablayout_title.setTabMode(TabLayout.MODE_FIXED);
    }

    private void inData() {
    list=new ArrayList<Fragment>();
        for (int i = 0; i <title.length ; i++) {
            rollmenufragment = new RollMenuFragment();
            list.add(rollmenufragment);
        }

    }

}
