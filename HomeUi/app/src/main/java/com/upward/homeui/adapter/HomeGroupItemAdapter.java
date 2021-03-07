package com.upward.homeui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.upward.homeui.R;
import com.upward.homeui.data.HomeDataBean;
import com.upward.homeui.data.ItemData;
import com.upward.homeui.inter.showMoreInterface;

import java.util.List;

public class HomeGroupItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> implements showMoreInterface {
    private Context mContext;
    private List<ItemData> mItemDatas;
    private List<HomeDataBean> mHomeDatas;
    private int mHeaderPosition;

    public HomeGroupItemAdapter(List<HomeDataBean> homeDatas, int position) {
        this.mHomeDatas = homeDatas;
        mItemDatas = mHomeDatas.get(position).mItemData;
        this.mHeaderPosition = position;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_item_data_layout, null);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).mTitleTv.setText(mItemDatas.get(position).name);
            ((ItemHolder) holder).mMessageTv.setText(mItemDatas.get(position).description);
            if(mHomeDatas != null){
                if(mHomeDatas.get(mHeaderPosition).isShowMore()){
                    ((ItemHolder) holder).itemView.setVisibility(View.VISIBLE);
                }else {
                    if(mItemDatas.size() > 2){
                        ((ItemHolder) holder).itemView.setVisibility(View.GONE);
                    }else{
                        ((ItemHolder) holder).itemView.setVisibility(View.VISIBLE);
                    }
                }

            }else{
                if(position > 2){
                    ((ItemHolder) holder).wholeLayout.setVisibility(View.GONE);
                }else{
                    ((ItemHolder) holder).wholeLayout.setVisibility(View.VISIBLE);
                }
            }

//            if (position > 2) {
//                Log.d("test","大于3 不显示" + position );
//                ((ItemHolder) holder).wholeLayout.setVisibility(View.GONE);
//            }
        }

    }

    @Override
    public int getItemCount() {
        if (mItemDatas == null) {
            return 0;
        }
        return mItemDatas.size();
    }

    @Override
    public void showMore(List<HomeDataBean> datas, int position) {
        Log.e("test", "  showMore ===  show  " + datas.get(position).isShowMore());
        this.mHomeDatas = datas;
        this.mHeaderPosition = position;
        mItemDatas = mHomeDatas.get(position).mItemData;
        notifyDataSetChanged();
    }

    private static class ItemHolder extends RecyclerView.ViewHolder {
        LinearLayout wholeLayout;
        TextView mTitleTv;
        ImageView mImageViews;
        TextView mMessageTv;
        ImageView mImageViewNew;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            wholeLayout = itemView.findViewById(R.id.item_whole_layout);
            mTitleTv = itemView.findViewById(R.id.title_text);
            mImageViews = itemView.findViewById(R.id.images_view);
            mMessageTv = itemView.findViewById(R.id.message_now);
            mImageViewNew = itemView.findViewById(R.id.image_new);
        }
    }
}
