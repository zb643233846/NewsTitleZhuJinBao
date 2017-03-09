package fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.zhujinbao.newstitlezhujinbao.R;

import org.json.JSONObject;

import application.MyApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {

    private View view;
    private ImageView qq_iv;
    private Tencent mTencent;
    private IUiListener loginListener;
    private ImageView phone;
    private ImageView weixin;
    private TextView qq_name;
    private Switch mSwitch;
    private View myBackgroud;
    private TextView shopNews;
    private TextView shopNewsss;
    private TextView jingDong;
    private TextView wybl;
    private TextView yhfk;
    private TextView xtfk;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_my, container, false);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

         initView();

         qqOnClickListener();
    }

    private void initView() {

        qq_iv = (ImageView) view.findViewById(R.id.qq_iv);
        phone = (ImageView) view.findViewById(R.id.phone);
        weixin = (ImageView) view.findViewById(R.id.weixin);
        qq_name = (TextView) view.findViewById(R.id.qq_name);
        mSwitch = (Switch) view.findViewById(R.id.mSwitch);
        myBackgroud = view.findViewById(R.id.my_fragment);

        shopNews = (TextView) view.findViewById(R.id.shopNews);
        shopNewsss = (TextView) view.findViewById(R.id.shopNewsss);
        jingDong = (TextView) view.findViewById(R.id.jingDong);
        wybl = (TextView) view.findViewById(R.id.wybl);
        yhfk = (TextView) view.findViewById(R.id.yhfk);
        xtfk = (TextView) view.findViewById(R.id.xtfk);
        MyApplication.swithMode(0);

        mSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    MyApplication.swithMode(1);
                }else {
                    MyApplication.swithMode(0);
                }

                switchMode();
            }

        });
    }
    private void qqOnClickListener() {

        qq_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mTencent = Tencent.createInstance("1105939499", getActivity());
                 mTencent.login(MyFragment.this, "all", loginListener);

                loginListener = new IUiListener() {

                    @Override

                    public void onComplete(Object o) {

                        //登录成功后回调该方法,可以跳转相关的页面

                        Toast.makeText(getActivity(), "登录成功", Toast.LENGTH_SHORT).show();

                        JSONObject object = (JSONObject) o;

                        try {

                            String accessToken = object.getString("access_token");

                            String expires = object.getString("expires_in");

                            String openID = object.getString("openid");

                            mTencent.setAccessToken(accessToken, expires);

                            mTencent.setOpenId(openID);


                        } catch (Exception e) {

                            e.printStackTrace();

                        }
                    }

                    @Override
                    public void onError(UiError uiError) {

                    }

                    @Override
                    public void onCancel() {

                    }


                };

            }
        });
    }



    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);
        if (requestCode == Constants.REQUEST_LOGIN) {

            if (resultCode == -1) {

                Tencent.onActivityResultData(requestCode, resultCode, data, loginListener);

                Tencent.handleResultData(data, loginListener);

                UserInfo info = new UserInfo(getActivity(), mTencent.getQQToken());

                info.getUserInfo(new IUiListener() {

                    @Override

                    public void onComplete(Object o) {

                        try {

                            JSONObject info = (JSONObject) o;

                            String nickName = info.getString("nickname");//获取用户昵称
                            String iconUrl = info.getString("figureurl_qq_2");//获取用户头像的url
                            Toast.makeText(getActivity(), "昵称：" + nickName, Toast.LENGTH_SHORT).show();
                            ImageLoader.getInstance().displayImage(iconUrl,qq_iv);
                            qq_name.setText(nickName);
                            phone.setVisibility(View.GONE);
                            weixin.setVisibility(View.GONE);

                        } catch (Exception e) {

                            e.printStackTrace();

                        }

                    }


                    @Override

                    public void onError(UiError uiError) {


                    }


                    @Override

                    public void onCancel() {


                    }

                });

            }

        }

    }
    public void switchMode() {

        myBackgroud.setBackgroundColor(getResources().getColor(MyApplication.mResourceMap.get("bac")));
        qq_name.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        shopNews.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        shopNewsss.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        jingDong.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        wybl.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        yhfk.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        xtfk.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
        mSwitch.setTextColor(getResources().getColor(MyApplication.mResourceMap.get("tvc")));
    }
}




