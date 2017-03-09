package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zhujinbao.newstitlezhujinbao.R;

import java.util.ArrayList;

import adapter.VideoMenuAdapter;
import application.ApplicationConstants;
import application.VideoURL;
import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import modle.CallbackNewsData;
import modle.HttpUtils;
import modle.VideoContent;

/**
 * Created by LX-PC on 2017/2/24.
 */

public class VideoMenuFragment extends Fragment implements CallbackNewsData<VideoContent>,PullToRefreshListView.OnRefreshListener2<ListView>{

    private View view;
    private PullToRefreshListView video_lv;
    private String video_type;
    private String url;
    private boolean isNeedClear = false;
    private VideoMenuAdapter videoMenuAdapter;
    private int pager=10;
    private int startpager=0;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_video_menu,container,false);

        Bundle arguments = getArguments();
        if (arguments!=null){
            video_type = arguments.getString("bb");
        }
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();

        url= VideoURL.getVideoURL(video_type,startpager,pager);
       HttpUtils.loadDataFromServer(url,VideoContent.class,this);
    }

    private void initData() {
        videoMenuAdapter = new VideoMenuAdapter(getActivity());
        video_lv.setAdapter(videoMenuAdapter);
    }

    private void initView() {
        video_lv = (PullToRefreshListView) getActivity().findViewById(R.id.Video_lv);
        video_lv.setMode(PullToRefreshBase.Mode.BOTH);
        video_lv.setOnRefreshListener(this);
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase refreshView) {
         startpager=0;
        isNeedClear=true;
        url= ApplicationConstants.getURL(video_type,startpager,pager);
        HttpUtils.loadDataFromServer(url,VideoContent.class,this);
    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase refreshView) {
              pager+=10;
        isNeedClear=false;
        url=ApplicationConstants.getURL(video_type,startpager,pager);
        HttpUtils.loadDataFromServer(url,VideoContent.class,this);
    }
    @Override
    public void success(ArrayList<VideoContent> newsContents) {
        videoMenuAdapter.addData(newsContents,false);
        videoMenuAdapter.notifyDataSetChanged();
    }
    @Override
    public void onPause() {

            super.onPause();
        JCVideoPlayer.releaseAllVideos();
    }


}
