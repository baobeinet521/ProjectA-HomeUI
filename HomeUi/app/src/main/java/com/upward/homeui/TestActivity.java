package com.upward.homeui;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.upward.homeui.Utils.DealDataUtils;
import com.upward.homeui.adapter.HomeDataAdapter;
import com.upward.homeui.data.HomeDataBean;
import com.upward.homeui.data.ItemData;
import com.upward.homeui.data.ShowHomeData;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class TestActivity extends AppCompatActivity {

    @BindView(R.id.recycle_view)
    RecyclerView recycleView;
    @BindView(R.id.nested_scroll_view)
    NestedScrollView nestedScrollView;

    public static String TAG = "TestActivity";

    private HomeDataAdapter recycleAdapter;
    private List<HomeDataBean> listData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recycleView.setLayoutManager(layoutManager);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        getData();
        List<ShowHomeData> datas = DealDataUtils.showData(listData);
        recycleAdapter = new HomeDataAdapter(listData, datas);
        recycleAdapter.setHasStableIds(true);
        //设置Adapter
        recycleView.setAdapter(recycleAdapter);

        nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {

                return false;
            }
        });

        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {

            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY > oldScrollY) {
                    Log.e(TAG, "下滑");
                    int top = nestedScrollView.getTop();
                    if(top > 0){
                        int offset = scrollY - oldScrollY;
                        Log.e(TAG, "下滑距离  " + offset);
                    }
                }
                if (scrollY < oldScrollY) {
                    Log.e(TAG, "上滑");
                }
                if (scrollY == 0) {
                    Log.e(TAG, "滑倒顶部");
                }
                if (scrollY == (v.getChildAt(0).getMeasuredHeight() - v.getMeasuredHeight())) {
                    Log.e(TAG, "滑倒底部");
                }
            }
        });
    }

    public void getData() {
        listData = new ArrayList<>();

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
            mItemData.setDescription("张三是一个好人啊");
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData1.add(mItemData);
        }
        mHomeDataBean.setmItemData(itemData1);

        listData.add(mHomeDataBean);

//        HomeDataBean mHomeDataBean1 = new HomeDataBean();
//        mHomeDataBean1.setDataType(HomeDataAdapter.ITEM_DATA);
//        List<ItemData> itemData1 = new ArrayList<>();
//        for (int i = 0; i < 3; i++) {
//            ItemData mItemData = new ItemData();
//            mItemData.setName("张三" + (i + 1));
//            mItemData.setDescription("张三是一个好人啊");
//            if (i < 3) {
//                mItemData.setShow(true);
//            } else {
//                mItemData.setShow(false);
//            }
//            itemData1.add(mItemData);
//        }
//        mHomeDataBean1.setmItemData(itemData1);
//        listData.add(mHomeDataBean1);


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
            mItemData.setDescription("张三四是一个好人啊");
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData2.add(mItemData);
        }
        mHomeDataBean2.setmItemData(itemData2);

        listData.add(mHomeDataBean2);

//        HomeDataBean mHomeDataBean3 = new HomeDataBean();
//        mHomeDataBean3.setDataType(HomeDataAdapter.ITEM_DATA);
//        List<ItemData> itemData2 = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            ItemData mItemData = new ItemData();
//            mItemData.setName("张四" + (i + 1));
//            mItemData.setDescription("张三四是一个好人啊");
//            if (i < 3) {
//                mItemData.setShow(true);
//            } else {
//                mItemData.setShow(false);
//            }
//            itemData2.add(mItemData);
//        }
//        mHomeDataBean3.setmItemData(itemData2);
//        listData.add(mHomeDataBean3);


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
            mItemData.setDescription("王五 是一个好人啊");
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData3.add(mItemData);
        }
        mHomeDataBean4.setmItemData(itemData3);

        listData.add(mHomeDataBean4);

//        HomeDataBean mHomeDataBean5 = new HomeDataBean();
//        mHomeDataBean5.setDataType(HomeDataAdapter.ITEM_DATA);
//        List<ItemData> itemData3 = new ArrayList<>();
//        for (int i = 0; i < 6; i++) {
//            ItemData mItemData = new ItemData();
//            mItemData.setName("王五" + (i + 1));
//            mItemData.setDescription("王五 是一个好人啊");
//            if (i < 3) {
//                mItemData.setShow(true);
//            } else {
//                mItemData.setShow(false);
//            }
//            itemData3.add(mItemData);
//        }
//        mHomeDataBean5.setmItemData(itemData3);
//        listData.add(mHomeDataBean5);


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
            mItemData.setDescription("是的啊 是一个好人啊");
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData4.add(mItemData);
        }
        mHomeDataBean7.setmItemData(itemData4);
        listData.add(mHomeDataBean7);

//        HomeDataBean mHomeDataBean6 = new HomeDataBean();
//        mHomeDataBean6.setDataType(HomeDataAdapter.ITEM_DATA);
//        List<ItemData> itemData4 = new ArrayList<>();
//        for (int i = 0; i < 7; i++) {
//            ItemData mItemData = new ItemData();
//            mItemData.setName("是的啊" + (i + 1));
//            mItemData.setDescription("是的啊 是一个好人啊");
//            if (i < 3) {
//                mItemData.setShow(true);
//            } else {
//                mItemData.setShow(false);
//            }
//            itemData4.add(mItemData);
//        }
//        mHomeDataBean6.setmItemData(itemData4);
//        listData.add(mHomeDataBean6);


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
            mItemData.setDescription("刘思钰 是个乖宝宝啊");
            if (i < 3) {
                mItemData.setShow(true);
            } else {
                mItemData.setShow(false);
            }
            itemData5.add(mItemData);
        }
        mHomeDataBean8.setmItemData(itemData5);
        listData.add(mHomeDataBean8);

//        HomeDataBean mHomeDataBean9 = new HomeDataBean();
//        mHomeDataBean9.setDataType(HomeDataAdapter.ITEM_DATA);
//        List<ItemData> itemData5 = new ArrayList<>();
//        for (int i = 0; i < 8; i++) {
//            ItemData mItemData = new ItemData();
//            mItemData.setName("刘思钰" + (i + 1));
//            mItemData.setDescription("刘思钰 是个乖宝宝啊");
//            if (i < 3) {
//                mItemData.setShow(true);
//            } else {
//                mItemData.setShow(false);
//            }
//            itemData5.add(mItemData);
//        }
//        mHomeDataBean9.setmItemData(itemData5);
//        listData.add(mHomeDataBean9);
    }


}