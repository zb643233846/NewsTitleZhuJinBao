package adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.widget.RadioGroup;

import com.zhujinbao.newstitlezhujinbao.R;

import java.util.List;

/**
 * Created by LX-PC on 2017/2/23.
 */

//public class FragmentActivityAdapter implements RadioGroup.OnCheckedChangeListener {
//        private List<Fragment> fragments;
//        private RadioGroup radioGroup;
//        private FragmentActivity fragmentActivity;
//        private int fragmentContentId;
//        private int currentTab;
//    private OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener;
//    private Fragment fagment;

//    public FragmentActivityAdapter(FragmentActivity fragmentActivity, List<Fragment> fragments, int fragmentContentId, RadioGroup radioGroup){
//        this.fragments = fragments;
//        this.radioGroup = radioGroup;
//        this.fragmentActivity = fragmentActivity;
//        this.fragmentContentId = fragmentContentId;
//        FragmentTransaction ft=fragmentActivity.getSupportFragmentManager().beginTransaction();
//        ft.add(fragmentContentId,fragments.get(0));
//        ft.commit();
//
//        radioGroup.setOnCheckedChangeListener(this);
//    }
//
//    @Override
//    public void onCheckedChanged(RadioGroup group, int checkedId) {
//        for (int i = 0; i < radioGroup.getChildCount(); i++) {
//           if (radioGroup.getChildAt(i).getId()==checkedId){
//               fagment = fragments.get(i);
//               FragmentTransaction ft=obtainFragmentTransaction(i);
//               getCurrentFragment().onPause();
//              if (fagment.isAdded()){
//                  fagment.onResume();
//              }else {
//                  ft.add(fragmentContentId,fagment);
//              }
//               showTab(i);
//               ft.commit();
//               if(null != onRgsExtraCheckedChangedListener){
//                   onRgsExtraCheckedChangedListener.OnRgsExtraCheckedChanged(radioGroup, checkedId, i);
//               }
//           }
//        }
//    }
//
//    private void showTab(int inx) {
//        for (int i = 0; i < fragments.size(); i++) {
//            Fragment fragment=fragments.get(i);
//            FragmentTransaction ft=obtainFragmentTransaction(inx);
//            if (inx ==i){
//                ft.show(fragment);
//            }else {
//                ft.hide(fragment);
//            }
//            ft.commit();
//        }
//        currentTab =inx;
//    }
//
//    public FragmentTransaction obtainFragmentTransaction(int index){
//        FragmentTransaction ft = fragmentActivity.getSupportFragmentManager().beginTransaction();
//        // 设置切换动画
//        if(index > currentTab){
//            ft.setCustomAnimations(R.anim.slide_left_in,R.anim.slide_left_out);
//        }else{
//            ft.setCustomAnimations(R.anim.slide_right_in,R.anim.slide_right_out);
//        }
//        return ft;
//    }
//    public int getCurrentTab() {
//        return currentTab;
//    }
//
//    public Fragment getCurrentFragment(){
//        return fragments.get(currentTab);
//    }
//
//    public OnRgsExtraCheckedChangedListener getOnRgsExtraCheckedChangedListener() {
//        return onRgsExtraCheckedChangedListener;
//    }
//
//    public void setOnRgsExtraCheckedChangedListener(OnRgsExtraCheckedChangedListener onRgsExtraCheckedChangedListener) {
//        this.onRgsExtraCheckedChangedListener = onRgsExtraCheckedChangedListener;
//    }
//    public static class OnRgsExtraCheckedChangedListener{
//        public void OnRgsExtraCheckedChanged(RadioGroup radioGroup, int checkedId, int index){
//
//        }
//
//    }
//}
