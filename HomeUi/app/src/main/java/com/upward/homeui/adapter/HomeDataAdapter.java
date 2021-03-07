package com.upward.homeui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upward.homeui.MaxRecyclerView;
import com.upward.homeui.R;
import com.upward.homeui.data.HomeDataBean;
import com.upward.homeui.data.ItemData;

import java.util.List;

public class HomeDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int ITEM_HEADER = 1;
    public static int ITEM_DATA = 2;
    private List<HomeDataBean> mListDatas;
    private Context mContext;
    private HomeGroupItemAdapter mHomeGroupItemAdapter;

    public HomeDataAdapter(List<HomeDataBean> datas){
        mListDatas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if(mContext == null){
            mContext = parent.getContext();
        }
        if(viewType == ITEM_HEADER){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_group_header_layout,parent,false);
            return new headerViewHolder(view);
        }else if(viewType == ITEM_DATA){
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_group_body_layout,parent,false);
            return new bodyViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof headerViewHolder){
            ((headerViewHolder) holder).mAddressTv.setText(mListDatas.get(position).getAddress());
            ((headerViewHolder) holder).mMoreImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    boolean showMore = mListDatas.get(position).isShowMore();
                    Log.e("test","   showMore   " + showMore);
                    if(showMore){
                        mListDatas.get(position).setShowMore(false);
                    }else{
                        mListDatas.get(position).setShowMore(true);
                    }
                    if(mHomeGroupItemAdapter != null){
                        mHomeGroupItemAdapter.showMore(mListDatas,position);
                    }
                    notifyDataSetChanged();
                }
            });

        }else if(holder instanceof bodyViewHolder){

//            ((bodyViewHolder) holder).mRecycleView.setNestedScrollingEnabled(false);
            LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
            //设置为垂直布局，这也是默认的
            layoutManager.setOrientation(RecyclerView.VERTICAL);
            //设置布局管理器
            ((bodyViewHolder) holder).mRecycleView.setLayoutManager(layoutManager);
            List<ItemData> datas = mListDatas.get(position).getmItemData();
            mHomeGroupItemAdapter = new HomeGroupItemAdapter(mListDatas,position);
            //设置Adapter
            ((bodyViewHolder) holder).mRecycleView.setAdapter(mHomeGroupItemAdapter);
        }

    }

    @Override
    public int getItemCount() {
        if (mListDatas == null)
            return 0;
        return mListDatas.size();
    }

    @Override
    public int getItemViewType(int position) {
        if(mListDatas == null){
            return ITEM_DATA;
        }
        if(mListDatas != null && mListDatas.get(position) == null){
            return ITEM_DATA;
        }
        return mListDatas.get(position).dataType;
    }

    public int getViewTypeCount(){
        return 2;
    }

    private static class headerViewHolder extends RecyclerView.ViewHolder{
        ImageView mapImage;
        TextView mAddressTv;
        ImageView mMoreImage;
        public headerViewHolder(@NonNull View itemView) {
            super(itemView);
            mapImage = itemView.findViewById(R.id.map_image);
            mAddressTv = itemView.findViewById(R.id.address_text);
            mMoreImage = itemView.findViewById(R.id.more_image);
        }
    }

    private static class bodyViewHolder extends RecyclerView.ViewHolder{
        RecyclerView mRecycleView;

        public bodyViewHolder(@NonNull View itemView) {
            super(itemView);
            mRecycleView = itemView.findViewById(R.id.group_item_recycler);
        }
    }
}
