package com.upward.homeui.adapter;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import androidx.annotation.NonNull;;
import androidx.recyclerview.widget.RecyclerView;

import com.google.gson.Gson;
import com.upward.homeui.Animation.TextSwitcherAnimation;
import com.upward.homeui.R;
import com.upward.homeui.Utils.DealDataUtils;
import com.upward.homeui.data.HomeDataBean;
import com.upward.homeui.data.ItemData;
import com.upward.homeui.data.ShowHomeData;

import java.util.ArrayList;
import java.util.List;

public class HomeDataAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    public static int ITEM_HEADER = 1;
    public static int ITEM_DATA = 2;
    private List<HomeDataBean> mListDatas;
    private List<ShowHomeData> mShowDatas;
    private Context mContext;

    public HomeDataAdapter(List<HomeDataBean> datas, List<ShowHomeData> showDatas) {
        this.mListDatas = datas;
        this.mShowDatas = showDatas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        if (viewType == ITEM_HEADER) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_group_header_layout, parent, false);
            return new headerViewHolder(view);
        } else if (viewType == ITEM_DATA) {
            View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_item_data_layout, parent, false);
            return new ItemHolder(view);
        }
        return null;

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof headerViewHolder) {
            ((headerViewHolder) holder).mAddressTv.setText(mShowDatas.get(position).getAddress());
            ((headerViewHolder) holder).mMoreImage.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "点击到了", Toast.LENGTH_LONG).show();
                    if (mShowDatas.get(position).getDataType() == ITEM_HEADER) {
                        Log.e("test","点击的是header数据=====");
                        String address = mShowDatas.get(position).getAddress();
                        for (int i = 0;i < mListDatas.size();i++){
                            if (address.equals(mListDatas.get(i).getAddress())) {
                                dealData(i);
                                break;
                            }
                        }


                        mShowDatas = DealDataUtils.showData(mListDatas);
                        notifyDataSetChanged();
                    }else{
                        Log.e("test","点击的是item数据");
                    }

                }
            });
        } else if (holder instanceof ItemHolder) {
            ((ItemHolder) holder).mTitleTv.setText(mShowDatas.get(position).getName());
            List<String> texts = mShowDatas.get(position).getMessages();
            if(((ItemHolder) holder).mMessageTv.getChildCount() < 2){
                if(texts != null && texts.size() > 0){
                    ((ItemHolder) holder).mMessageTv.setFactory(new ViewSwitcher.ViewFactory() {
                        @Override
                        public View makeView() {
                            TextView tv = new TextView(mContext);
                            return tv;
                        }
                    });
                }
            }
            new TextSwitcherAnimation(((ItemHolder) holder).mMessageTv,texts).create();
        }


    }


    public void dealData(int homePosition){
        boolean showAll = mListDatas.get(homePosition).isShowAll();
        Log.e("test", "   showAll   " + showAll);
        List<ItemData> itemDatas = mListDatas.get(homePosition).getmItemData();
        if (showAll) {
            mListDatas.get(homePosition).setShowAll(false);
            for (int i = 0; i < itemDatas.size(); i++) {
                if (i < 3) {
                    itemDatas.get(i).setShow(true);
                } else {
                    itemDatas.get(i).setShow(false);
                }
            }
        } else {
            mListDatas.get(homePosition).setShowAll(true);
            for (int i = 0; i < itemDatas.size(); i++) {
                itemDatas.get(i).setShow(true);
            }
        }
        Gson gson = new Gson();
        String mListDatasStr = gson.toJson(mListDatas);

        Log.e("test", "onClick:   点击后数据   " + mListDatasStr);
    }

    @Override
    public int getItemCount() {
        if (mShowDatas == null)
            return 0;
        return mShowDatas.size();
    }

    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getItemViewType(int position) {
        return mShowDatas.get(position).getDataType();
    }

    private static class headerViewHolder extends RecyclerView.ViewHolder {
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

    private static class ItemHolder extends RecyclerView.ViewHolder {
        LinearLayout wholeLayout;
        TextView mTitleTv;
        ImageView mImageViews;
        TextSwitcher mMessageTv;
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
