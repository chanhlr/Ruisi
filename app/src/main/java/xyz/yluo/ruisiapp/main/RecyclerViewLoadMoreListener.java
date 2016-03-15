package xyz.yluo.ruisiapp.main;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class RecyclerViewLoadMoreListener extends RecyclerView.OnScrollListener {

    private LinearLayoutManager linearLayoutManager;
    private OnLoadMoreListener onLoadMoreListener;

    public RecyclerViewLoadMoreListener(@NonNull LinearLayoutManager linearLayoutManager, @NonNull OnLoadMoreListener onLoadMoreListener) {
        super();
        this.linearLayoutManager = linearLayoutManager;
        this.onLoadMoreListener = onLoadMoreListener;
    }

    @Override
    public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
        if (linearLayoutManager.findLastVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {

                // 向下滑动，判断最后一个item是不是显示中
                onLoadMoreListener.onLoadMore();
        }
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }

}
