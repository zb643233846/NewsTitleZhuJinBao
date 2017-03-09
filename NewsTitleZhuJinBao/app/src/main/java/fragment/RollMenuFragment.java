package fragment;

import adapter.NewsContentAdapter;
import adapter.RollMenuAdapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhujinbao.newstitlezhujinbao.R;
import com.zhujinbao.newstitlezhujinbao.TitleWebViewActivity;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import application.ApplicationConstants;
import modle.CallbackNewsData;
import modle.HttpUtils;
import modle.NewsContent;
import modle.WebViewEventBus;

/**
 * Created by LX-PC on 2017/2/12.
 */

public class RollMenuFragment extends Fragment implements PullToRefreshListView.OnRefreshListener2<ListView>, CallbackNewsData<NewsContent> {

    private View view;
    private PullToRefreshListView pullToRefreshListView;
    private String title;
    private NewsContentAdapter newsContentAdapter;
    private boolean isNeedClear = false;
    private String url=ApplicationConstants.getURL(title,0,10);
    private  int startPage;
    private int endPage=10;
    private ArrayList<NewsContent> list=new ArrayList();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view= inflater.inflate(R.layout.fragment_rollmenu,container,false);
        Bundle arguments = getArguments();
        if (arguments!=null){
            title=arguments.getString("aa");
        }


        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
       url = ApplicationConstants.getURL(title,0,20);

        HttpUtils.loadDataFromServer(url,NewsContent.class,this);
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getActivity(), TitleWebViewActivity.class);
                intent.putExtra("bb",list.get(position-1).getUrl());
                getActivity().startActivity(intent);

            }
        });
    }

    private void initData() {
        newsContentAdapter = new NewsContentAdapter(getActivity());
        pullToRefreshListView.setAdapter(newsContentAdapter);

    }

    private void initView() {
        pullToRefreshListView = (PullToRefreshListView) view.findViewById(R.id.pulltoRefreshListView);
         pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
         pullToRefreshListView.setOnRefreshListener(this);
    }

        @Override
        public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
               startPage=0;
                 isNeedClear=true;
                  url=ApplicationConstants.getURL(title,startPage,endPage);
            HttpUtils.loadDataFromServer(url,NewsContent.class,this);

        }

        @Override
        public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
            startPage+=10;
            isNeedClear=false;
            url=ApplicationConstants.getURL(title,startPage,endPage);
            HttpUtils.loadDataFromServer(url,NewsContent.class,this);
        }

    @Override
    public void success(ArrayList<NewsContent> newsContents) {
        newsContentAdapter.addData(newsContents,false);
        newsContentAdapter.notifyDataSetChanged();
         list.addAll(newsContents);
    }


}

