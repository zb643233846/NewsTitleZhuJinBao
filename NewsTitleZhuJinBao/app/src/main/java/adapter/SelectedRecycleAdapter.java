package adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.zhujinbao.newstitlezhujinbao.MentManageActivity;
import com.zhujinbao.newstitlezhujinbao.R;

import java.util.Collections;
import java.util.List;

import modle.ItemTouchHelperCallback;

/**
 * Created by LX-PC on 2017/3/2.
 */

public class SelectedRecycleAdapter extends RecyclerView.Adapter<SelectedRecycleAdapter.MyViewHolder> implements
        ItemTouchHelperCallback.OnItemPositionChangeListener{
    private List<String> mDatas;
    private MentManageActivity mContext;


    public interface OnItemClickListener {
        void onItemClickListener(MyViewHolder viewHolder, int pos);

        void onItemLongClickListener(MyViewHolder viewHolder, int pos);
    }
    public interface OnDeleteIconClickListener {
        void onDeleteIconClick(int pos);
    }

    private OnItemClickListener mListener;
    private OnDeleteIconClickListener mDeleteListener;
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mListener = listener;
    }

    public void setOnDeleteIconClickListener(OnDeleteIconClickListener listener) {
        mDeleteListener = listener;
    }

    public SelectedRecycleAdapter(Context context, List<String> datas) {
        mDatas = datas;
        mContext = (MentManageActivity) context;
    }
    @Override
    public SelectedRecycleAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(mContext).inflate(R.layout.item, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(itemView);


        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final SelectedRecycleAdapter.MyViewHolder holder,final int position) {
        holder.tv.setText(mDatas.get(position));

        if (mContext.isDeleteIconsShow()) {
            holder.ivDelete.setVisibility(View.VISIBLE);
        } else {
            holder.ivDelete.setVisibility(View.INVISIBLE);
        }

        holder.ivDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDeleteListener != null) {
                    mDeleteListener.onDeleteIconClick(holder.getLayoutPosition());
                }
            }
        });

        if (mListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mListener.onItemClickListener(holder, position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mListener.onItemLongClickListener(holder, position);
                    return false;
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public boolean onItemMove(int fromPos, int toPos) {
        Collections.swap(mDatas, fromPos, toPos);
        notifyItemMoved(fromPos, toPos);
        return true;
    }
    public void addData(String data, int pos) {
        mDatas.add(pos, data);
        notifyItemInserted(pos);
    }

    public void removeData(int pos) {
        mDatas.remove(pos);

        notifyDataSetChanged();
        notifyItemRemoved(pos);
    }

  public   class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView ivDelete;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.tv);
            ivDelete = (ImageView) itemView.findViewById(R.id.delelte);
        }
    }
}
