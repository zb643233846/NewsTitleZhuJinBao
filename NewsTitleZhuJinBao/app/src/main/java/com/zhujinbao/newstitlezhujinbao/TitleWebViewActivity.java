package com.zhujinbao.newstitlezhujinbao;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import modle.WebViewEventBus;

/**
 * Created by LX-PC on 2017/2/25.
 */

public class TitleWebViewActivity extends Activity {
    private String url;
    private WebView titlewebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.titlewebview_activity);
        initView();
    // EventBus.getDefault().register(this);
        Intent intent=getIntent();
       url= intent.getStringExtra("bb");
        titlewebview.loadUrl(url);
        titlewebview.setWebChromeClient(new WebChromeClient());
    }

    private void initView() {
        titlewebview = (WebView) findViewById(R.id.titlewebview);
    }
//    @Subscribe(threadMode = ThreadMode.MAIN)
//   public String getMessage(WebViewEventBus webViewEventBus){
//          url=webViewEventBus.getMsg();
//       return url;
//    }
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//      EventBus.getDefault().unregister(this);
//    }
}
