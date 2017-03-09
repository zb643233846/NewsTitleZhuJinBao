package adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhujinbao.newstitlezhujinbao.R;

import java.util.ArrayList;

import fm.jiecao.jcvideoplayer_lib.JCVideoPlayer;
import modle.VideoContent;

/**
 * Created by LX-PC on 2017/2/27.
 */

public class VideoMenuAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<VideoContent> list=new ArrayList<>();
    public VideoMenuAdapter(Context context){
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
              if (convertView==null){
                  convertView=View.inflate(context, R.layout.video_lv_item,null);
              }
         TextView tv1= (TextView) convertView.findViewById(R.id.video_lv_tv1);
         TextView tv2= (TextView) convertView.findViewById(R.id.video_lv_tv2);
       JCVideoPlayer videoplayer= (JCVideoPlayer) convertView.findViewById(R.id.videoplayer);
        videoplayer.setUp(list.get(position).getMp4_url(),list.get(position).getTitle());
        //videoplayer.ivThumb.setThumbInCustomProject();
        ImageLoader.getInstance().displayImage(list.get(position).getTopicImg(),videoplayer.ivThumb);
        tv1.setText(list.get(position).getTopicDesc());
        tv2.setText(list.get(position).getVideosource());

        return convertView;
    }

    public void addData(ArrayList<VideoContent> newsContents, boolean b) {
        if (newsContents!=null){
            if (b){
                list.clear();
            }
            list.addAll(newsContents);
        }

    }
}
