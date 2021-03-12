package com.upward.homeui.Utils;

import android.util.Log;

import com.google.gson.Gson;
import com.upward.homeui.adapter.HomeDataAdapter;
import com.upward.homeui.data.HomeDataBean;
import com.upward.homeui.data.ItemData;
import com.upward.homeui.data.ShowHomeData;

import java.util.ArrayList;
import java.util.List;

public class DealDataUtils {
    public static List<ShowHomeData> showData(List<HomeDataBean> datas) {
        List<ShowHomeData> mShowHomeDatas = new ArrayList<>();
        if (datas != null) {
            for (int i = 0; i < datas.size(); i++) {
                HomeDataBean mHomeDataBean = datas.get(i);
                ShowHomeData mShowHomeData = new ShowHomeData();
                if (mHomeDataBean != null) {
                    mShowHomeData.setDataType(HomeDataAdapter.ITEM_HEADER);
                    mShowHomeData.setAddress(mHomeDataBean.getAddress());
                    mShowHomeDatas.add(mShowHomeData);
                    List<ItemData> itemDatas = mHomeDataBean.getmItemData();
                    for (int j = 0; j < itemDatas.size(); j++) {
                        if (itemDatas.get(j).isShow()) {
                            ShowHomeData mShowHomeDataTemp = new ShowHomeData();
                            mShowHomeDataTemp.setDataType(HomeDataAdapter.ITEM_DATA);
                            mShowHomeDataTemp.setName(itemDatas.get(j).getName());
                            mShowHomeDataTemp.setDescription(itemDatas.get(j).getDescription());
                            mShowHomeDatas.add(mShowHomeDataTemp);
                        }
                    }
                }
            }
        }

        if (mShowHomeDatas != null) {
            Gson gson = new Gson();
            String mListDatasStr = gson.toJson(mShowHomeDatas);
            Log.e("test", "重组后的数据  " + mListDatasStr);
        }
        return mShowHomeDatas;
    }
}
