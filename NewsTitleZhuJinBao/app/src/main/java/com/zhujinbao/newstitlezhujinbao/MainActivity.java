package com.zhujinbao.newstitlezhujinbao;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

//import adapter.FragmentActivityAdapter;
import fragment.AttentionFragment;
import fragment.HomeFragment;
import fragment.MyFragment;
import fragment.VideoFragment;

public class MainActivity extends FragmentActivity {
    private Fragment fragment;
    private HomeFragment hf;
    private AttentionFragment af;
    private VideoFragment vf;
    private MyFragment mf;
    private FrameLayout fl;
    private RadioGroup rg;
    private RadioButton home;
    private RadioButton video;
    private RadioButton attention;
    private RadioButton my;
   public List<Fragment> fragments=new ArrayList<Fragment>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rg = (RadioGroup) findViewById(R.id.rg);
        fl = (FrameLayout) findViewById(R.id.fl);
        home = (RadioButton) findViewById(R.id.home);
        video = (RadioButton) findViewById(R.id.video);
        attention = (RadioButton) findViewById(R.id.attention);
        my = (RadioButton) findViewById(R.id.my);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new HomeFragment()).commit();
      rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
          @Override
          public void onCheckedChanged(RadioGroup group, int checkedId) {
              switch (checkedId){
                  case R.id.home:
                  getSupportFragmentManager().beginTransaction().replace(R.id.fl,new HomeFragment()).commit();
                      break;
                  case R.id.video:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fl,new VideoFragment()).commit();
                      break;
                  case R.id.attention:
                      getSupportFragmentManager().beginTransaction().replace(R.id.fl,new AttentionFragment()).commit();
                      break;
                  case R.id.my:
                  getSupportFragmentManager().beginTransaction().replace(R.id.fl,new MyFragment()).commit();
                      break;
              }
          }
      });
//        fragments.add(new HomeFragment());
//        fragments.add(new AttentionFragment());
//        fragments.add(new VideoFragment());
//        fragments.add(new VideoFragment());
//        FragmentActivityAdapter fragmentTabAdapter = new FragmentActivityAdapter(this, fragments, R.id.fl, rg);
//      fragmentTabAdapter.setOnRgsExtraCheckedChangedListener(new FragmentActivityAdapter.OnRgsExtraCheckedChangedListener(){
//          @Override
//          public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index) {
//              super.OnRgsExtraCheckedChanged(radioGroup, checkedId, index);
//  }
//      });
    }

}
