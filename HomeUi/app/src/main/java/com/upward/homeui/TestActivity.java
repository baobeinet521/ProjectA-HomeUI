package com.upward.homeui;

import android.os.Bundle;

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
    private LinearLayoutManager mLinearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);

        mLinearLayoutManager = new LinearLayoutManager(this);
        //设置布局管理器
        recycleView.setLayoutManager(mLinearLayoutManager);
        //设置为垂直布局，这也是默认的
        mLinearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        listData = DealDataUtils.getData();
        List<ShowHomeData> datas = DealDataUtils.showData(listData);
        recycleAdapter = new HomeDataAdapter(listData, datas);
        recycleAdapter.setHasStableIds(true);
        //设置Adapter
        recycleView.setAdapter(recycleAdapter);
//        recycleView.setNestedScrollingEnabled(false);

//        nestedScrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//            @Override
//            public void onScrollChange(View view, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                int top = recycleView.getTop();
//                Log.e(TAG, "recycleView  距离顶部" + top);
//                if (scrollY > oldScrollY) {
//                    Log.e(TAG, "下滑");
//                    if(top > 0){
//                        mLinearLayoutManager = new LinearLayoutManager(TestActivity.this, LinearLayoutManager.VERTICAL, false) {
//                            @Override
//                            public boolean canScrollVertically() {
//                                return true;
//                            }
//                        };
//                        recycleView.setLayoutManager(mLinearLayoutManager);
//                    }else{
//                        mLinearLayoutManager = new LinearLayoutManager(TestActivity.this, LinearLayoutManager.VERTICAL, false) {
//                            @Override
//                            public boolean canScrollVertically() {
//                                return false;
//                            }
//                        };
//                        recycleView.setLayoutManager(mLinearLayoutManager);
//                    }
//                }
//                if (scrollY < oldScrollY) {
//                    Log.e(TAG, "上滑");
//                }
//                if (scrollY == 0) {
//                    Log.e(TAG, "滑倒顶部");
//                }
//
//            }
//        });
    }

}