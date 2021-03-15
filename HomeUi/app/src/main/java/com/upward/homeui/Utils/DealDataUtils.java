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


    private void mockAvatarList() {
        List<String> avatarList = new ArrayList<>();
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201811/04/20181104223950_vygmz.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201807/11/20180711091152_FakCJ.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201811/04/20181104223952_zfhli.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201810/30/20181030153225_mixve.thumb.700_0.jpg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201807/08/20180708095827_SYPL3.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201811/01/20181101093301_u2NKu.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201811/04/20181104223950_vygmz.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201807/11/20180711091152_FakCJ.thumb.700_0.jpeg");
        avatarList.add("https://b-ssl.duitang.com/uploads/item/201811/04/20181104223952_zfhli.thumb.700_0.jpeg");
    }
}
