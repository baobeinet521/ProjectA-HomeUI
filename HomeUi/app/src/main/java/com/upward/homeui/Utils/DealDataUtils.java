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
                            mShowHomeDataTemp.setMessages(itemDatas.get(j).getMessages());
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


    public static List<HomeDataBean> getData() {
        List<HomeDataBean> listData = new ArrayList<>();

        HomeDataBean mHomeDataBean = new HomeDataBean();
        mHomeDataBean.setDataType(HomeDataAdapter.ITEM_HEADER);
        mHomeDataBean.setAddress("shanghai");
        mHomeDataBean.setShowAll(false);


//        mHomeDataBean.setDataType(HomeDataAdapter.ITEM_DATA);
        List<ItemData> itemData1 = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            ItemData mItemData = new ItemData();
            mItemData.setDataType(HomeDataAdapter.ITEM_DATA);
            mItemData.setName("张三" + (i + 1));
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String messageTemp = "不知道说啥呢，算了，张三是一个好人啊" + j;
                messages.add(messageTemp);
            }
            mItemData.setMessages(messages);
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData1.add(mItemData);
        }
        mHomeDataBean.setmItemData(itemData1);

        listData.add(mHomeDataBean);


        HomeDataBean mHomeDataBean2 = new HomeDataBean();
//        mHomeDataBean2.setDataType(HomeDataAdapter.ITEM_HEADER);
        mHomeDataBean2.setAddress("beijing");
        mHomeDataBean2.setShowAll(false);

//        mHomeDataBean2.setDataType(HomeDataAdapter.ITEM_DATA);
        List<ItemData> itemData2 = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ItemData mItemData = new ItemData();
            mItemData.setDataType(HomeDataAdapter.ITEM_DATA);
            mItemData.setName("张四" + (i + 1));
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String messageTemp = "啊，原来你是张四啊，昨天还说你呢" + j;
                messages.add(messageTemp);
            }
            mItemData.setMessages(messages);
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData2.add(mItemData);
        }
        mHomeDataBean2.setmItemData(itemData2);

        listData.add(mHomeDataBean2);


        HomeDataBean mHomeDataBean4 = new HomeDataBean();
//        mHomeDataBean4.setDataType(HomeDataAdapter.ITEM_HEADER);
        mHomeDataBean4.setAddress("sichuan");
        mHomeDataBean4.setShowAll(false);

//        mHomeDataBean4.setDataType(HomeDataAdapter.ITEM_DATA);
        List<ItemData> itemData3 = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            ItemData mItemData = new ItemData();
            mItemData.setDataType(HomeDataAdapter.ITEM_DATA);
            mItemData.setName("王五" + (i + 1));
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String messageTemp = "啊，原来认错了啊，你是王五啊，我昨天把你认成张四了" + j;
                messages.add(messageTemp);
            }
            mItemData.setMessages(messages);
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData3.add(mItemData);
        }
        mHomeDataBean4.setmItemData(itemData3);

        listData.add(mHomeDataBean4);


        HomeDataBean mHomeDataBean7 = new HomeDataBean();
//        mHomeDataBean7.setDataType(HomeDataAdapter.ITEM_HEADER);
        mHomeDataBean7.setAddress("chengdou");
        mHomeDataBean7.setShowAll(false);
//        mHomeDataBean7.setDataType(HomeDataAdapter.ITEM_DATA);
        List<ItemData> itemData4 = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            ItemData mItemData = new ItemData();
            mItemData.setDataType(HomeDataAdapter.ITEM_DATA);
            mItemData.setName("是的啊" + (i + 1));
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String messageTemp = "弄的我也不知道说啥好，原来这几天一直下雨，啥时候出太阳啊" + j;
                messages.add(messageTemp);
            }
            mItemData.setMessages(messages);
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData4.add(mItemData);
        }
        mHomeDataBean7.setmItemData(itemData4);
        listData.add(mHomeDataBean7);


        HomeDataBean mHomeDataBean8 = new HomeDataBean();
//        mHomeDataBean8.setDataType(HomeDataAdapter.ITEM_HEADER);
        mHomeDataBean8.setAddress("chongqing");
        mHomeDataBean8.setShowAll(false);
//        mHomeDataBean9.setDataType(HomeDataAdapter.ITEM_DATA);
        List<ItemData> itemData5 = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            ItemData mItemData = new ItemData();
            mItemData.setDataType(HomeDataAdapter.ITEM_DATA);
            mItemData.setName("刘思钰" + (i + 1));
            List<String> messages = new ArrayList<>();
            for (int j = 0; j < 2; j++) {
                String messageTemp = "这周出太阳的话，带我们的思钰乖宝贝出去玩吧，去哪好呢，去公园吧" + j;
                messages.add(messageTemp);
            }
            mItemData.setMessages(messages);
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData5.add(mItemData);
        }
        mHomeDataBean8.setmItemData(itemData5);
        listData.add(mHomeDataBean8);

        return listData;
    }


    public static List<String> mockAvatarList() {
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
        return avatarList;
    }
}
