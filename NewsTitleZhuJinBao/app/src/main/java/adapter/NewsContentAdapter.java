package adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhujinbao.newstitlezhujinbao.R;
import modle.NewsContent;

import java.util.ArrayList;

/**
 * Created by LX-PC on 2017/2/20.
 */

public class NewsContentAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NewsContent> dataBeans=new ArrayList<NewsContent>();
    private DisplayImageOptions options;
    private int TYPE_1 = 0;
    private int TYPE_2 = 1;

     public   NewsContentAdapter(Context context){
    this.context=context;
         options = new DisplayImageOptions.Builder()
                 .showImageOnLoading(R.mipmap.ic_launcher)
                 .showImageForEmptyUri(R.mipmap.ic_launcher)
                 .showImageOnFail(R.mipmap.ic_launcher)
                 .cacheInMemory(true)
                 .cacheOnDisk(true)
                 .considerExifParams(true)
                 .build();
}
    public void addData(ArrayList<NewsContent> datas, boolean isNeedClear){
        if (datas!=null){
            if (isNeedClear){
                dataBeans.clear();
            }
            dataBeans.addAll(datas);
        }
    };

    @Override
    public int getViewTypeCount() {

        return 2;
    }

    @Override
    public int getItemViewType(int position) {
       NewsContent item=getItem(position);
       if (item.getImgextra()!=null && item.getImgextra().size()>0){
           return TYPE_1;
       }else {
           return TYPE_2;
       }


    }

    @Override
    public int getCount() {
        return dataBeans.size();
    }

    @Override
    public NewsContent getItem(int position) {

        return dataBeans.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
             ViewHolder1 viewHolder1=null;
             ViewHolder2 viewHolder2=null;
        if (convertView==null){
            if (getItemViewType(position)==TYPE_1){
                viewHolder1=new ViewHolder1();
                convertView=View.inflate(context,R.layout.newscontent_item1,null);
                viewHolder1.textView1=(TextView) convertView.findViewById(R.id.newscontentItem1_tv1);
                viewHolder1.textView2=(TextView) convertView.findViewById(R.id.newscontentItem1_tv2);
                viewHolder1.imageView1= (ImageView) convertView.findViewById(R.id.newscontentItem1_iv1);
                viewHolder1.imageView2= (ImageView) convertView.findViewById(R.id.newscontentItem1_iv2);
                viewHolder1.imageView3= (ImageView) convertView.findViewById(R.id.newscontentItem1_iv3);
                convertView.setTag(viewHolder1);
            }else {
                viewHolder2=new ViewHolder2();
                convertView=View.inflate(context,R.layout.newscontent_item2,null);
                viewHolder2.textView1= (TextView) convertView.findViewById(R.id.newscontentItem2_tv1);
                viewHolder2.textView2= (TextView) convertView.findViewById(R.id.newscontentItem2_tv2);
                viewHolder2.imageView= (ImageView) convertView.findViewById(R.id.newscontentItem2_iv1);
                 convertView.setTag(viewHolder2);
            }

        }else {
            if (getItemViewType(position)==TYPE_1){
                viewHolder1= (ViewHolder1) convertView.getTag();
            }else {
                viewHolder2= (ViewHolder2) convertView.getTag();
            }
        }
          if (getItemViewType(position)==TYPE_1){
              viewHolder1.textView1.setText(dataBeans.get(position).getTitle());
              viewHolder1.textView2.setText(dataBeans.get(position).getSource());
              //String url1=getItem(position).getImgextra().get(0).getImgsrc();
              ///String url2=getItem(position).getImgextra().get(1).getImgsrc();
              //String url3=getItem(position).getImgsrc();
              ImageLoader.getInstance().displayImage(getItem(position).getImgextra().get(0).getImgsrc(),viewHolder1.imageView1,options);
              ImageLoader.getInstance().displayImage(getItem(position).getImgextra().get(1).getImgsrc(),viewHolder1.imageView2,options);
              ImageLoader.getInstance().displayImage(getItem(position).getImgsrc(),viewHolder1.imageView3,options);
          }else {
              viewHolder2.textView1.setText(dataBeans.get(position).getTitle());
              viewHolder2.textView2.setText(dataBeans.get(position).getSource());
              ImageLoader.getInstance().displayImage(getItem(position).getImgsrc(),viewHolder2.imageView,options);
          }

        return convertView;
    }
static class ViewHolder1{
    private TextView textView1;
    private TextView textView2;
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
}
 static class ViewHolder2{
     private TextView textView1;
     private TextView textView2;
     private ImageView imageView;
 }

}
