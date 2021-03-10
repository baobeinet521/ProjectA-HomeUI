package com.upward.homeui.data;

import java.util.List;

public class HomeDataBean {
    public List<ItemData> mItemData;
    public int dataType;
    public String address;
    public boolean isShowAll;

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<ItemData> getmItemData() {
        return mItemData;
    }

    public void setmItemData(List<ItemData> mItemData) {
        this.mItemData = mItemData;
    }

    public boolean isShowAll() {
        return isShowAll;
    }

    public void setShowAll(boolean showAll) {
        this.isShowAll = showAll;
    }
}


