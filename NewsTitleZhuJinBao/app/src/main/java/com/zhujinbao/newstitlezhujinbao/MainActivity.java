package com.zhujinbao.newstitlezhujinbao;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import fragment.AttentionFragment;
import fragment.HomeFragment;
import fragment.MyFragment;
import fragment.VideoFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FrameLayout fl =  (FrameLayout) findViewById(R.id.fl);
        RadioGroup rg=(RadioGroup) findViewById(R.id.rg);
        RadioButton home=(RadioButton) findViewById(R.id.home);
        RadioButton video=(RadioButton) findViewById(R.id.video);
       RadioButton attention=(RadioButton) findViewById(R.id.attention);
        RadioButton my=(RadioButton) findViewById(R.id.my);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.home:
                 getSupportFragmentManager().beginTransaction().replace(R.id.fl,new HomeFragment()).commit();
                    case R.id.video:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new VideoFragment()).commit();
                    case R.id.attention:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new AttentionFragment()).commit();
                    case R.id.my:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fl,new MyFragment()).commit();
                }

            }
        });
    }
}
