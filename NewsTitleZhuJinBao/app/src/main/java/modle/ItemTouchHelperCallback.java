package modle;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;

/**
 * Created by LX-PC on 2017/3/2.
 */

public class ItemTouchHelperCallback extends ItemTouchHelper.Callback {

    private OnItemPositionChangeListener  mListener;

    //通过构造函数，设置接口实例
    public ItemTouchHelperCallback(OnItemPositionChangeListener mListener)
    {
        this.mListener = mListener;
    }

    @Override
    public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
        //支持哪些操作，这里支持的是左右和按下抬起
        final int dragFlags = ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT
                | ItemTouchHelper.UP | ItemTouchHelper.DOWN;


        //使用
        return makeMovementFlags(dragFlags, 0);


    }

    @Override
    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {

        if(mListener != null) {
            return mListener.onItemMove(viewHolder.getAdapterPosition(), target.getAdapterPosition());
        }

        return false;
    }

    @Override
    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

    }
    public interface OnItemPositionChangeListener
    {
        boolean onItemMove(int fromPos, int toPos);
    }
}
