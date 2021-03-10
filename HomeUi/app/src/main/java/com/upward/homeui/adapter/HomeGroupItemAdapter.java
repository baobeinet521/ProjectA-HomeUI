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
    private boolean isShowAll = false;

    public HomeGroupItemAdapter(List<ItemData> datas) {
        mItemDatas = datas;
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
        Log.e("test", "onBindViewHolder == ");
        if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).mTitleTv.setText(mItemDatas.get(position).name);
            ((ItemHolder) holder).mMessageTv.setText(mItemDatas.get(position).description);
            if (isShowAll) {
                Log.e("test", " onBindViewHolder isShowAll    =  " + isShowAll);
                if (mItemDatas.get(position).isShow) {
                    Log.e("test", "  isShowMore   全部显示    mHeaderPosition =  ");
                    ((ItemHolder) holder).itemView.setVisibility(View.VISIBLE);
                } else {
                    ((ItemHolder) holder).itemView.setVisibility(View.GONE);
                }
//
            } else {
                if (position > 2) {
                    ((ItemHolder) holder).wholeLayout.setVisibility(View.GONE);
                } else {
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
        if (isShowAll) {
            return mItemDatas.size();
        } else {
            if (mItemDatas.size() > 3) {
                return 3;
            } else {
                return mItemDatas.size();
            }
        }
    }

    @Override
    public void showMore(List<ItemData> datas, boolean showAll) {
        Log.e("test", " 子item  showMore   show  " + showAll);
        isShowAll = showAll;
        mItemDatas = datas;
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
