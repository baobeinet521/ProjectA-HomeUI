package com.upward.homeui.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

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

    public HomeDataAdapter(List<HomeDataBean> datas) {
        mListDatas = datas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_home_group_header_layout, parent, false);
        return new headerViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((headerViewHolder) holder).mAddressTv.setText(mListDatas.get(position).getAddress());
        ((headerViewHolder) holder).mMoreImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(mContext,"点击到了",Toast.LENGTH_LONG).show();
                boolean showAll = mListDatas.get(position).isShowAll();
                Log.e("test", "   showAll   " + showAll);
                List<ItemData> itemDatas = mListDatas.get(position).getmItemData();
                if (showAll) {
                    mListDatas.get(position).setShowAll(false);
                    for (int i = 0; i < itemDatas.size(); i++) {
                        if (i < 3) {
                            itemDatas.get(i).setShow(true);
                        } else {
                            itemDatas.get(i).setShow(false);
                        }
                    }
                } else {
                    mListDatas.get(position).setShowAll(true);
                    for (int i = 0; i < itemDatas.size(); i++) {
                        itemDatas.get(i).setShow(true);
                    }
                }
                if (mHomeGroupItemAdapter != null) {
                    mHomeGroupItemAdapter.showMore(itemDatas, mListDatas.get(position).isShowAll);
                }
                notifyItemChanged(position,mListDatas.get(position));
            }
        });

        LinearLayoutManager layoutManager = new LinearLayoutManager(mContext);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        //设置布局管理器
        ((headerViewHolder) holder).mItemDataRecycleView.setLayoutManager(layoutManager);
        List<ItemData> datas = mListDatas.get(position).getmItemData();
        mHomeGroupItemAdapter = new HomeGroupItemAdapter(datas);
        //设置Adapter
        ((headerViewHolder) holder).mItemDataRecycleView.setAdapter(mHomeGroupItemAdapter);

    }

    @Override
    public int getItemCount() {
        if (mListDatas == null)
            return 0;
        return mListDatas.size();
    }

    private static class headerViewHolder extends RecyclerView.ViewHolder {
        ImageView mapImage;
        TextView mAddressTv;
        ImageView mMoreImage;
        RecyclerView mItemDataRecycleView;

        public headerViewHolder(@NonNull View itemView) {
            super(itemView);
            mapImage = itemView.findViewById(R.id.map_image);
            mAddressTv = itemView.findViewById(R.id.address_text);
            mMoreImage = itemView.findViewById(R.id.more_image);
            mItemDataRecycleView = itemView.findViewById(R.id.group_item_recycler);
        }
    }
}
