package com.upward.homeui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AppCompatActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.frame_layout)
    FrameLayout frameLayout;
    @BindView(R.id.home_image)
    ImageView homeImage;
    @BindView(R.id.home_linear_layout)
    LinearLayout homeLinearLayout;
    @BindView(R.id.home_relative_layout)
    RelativeLayout homeRelativeLayout;
    @BindView(R.id.active_image)
    ImageView activeImage;
    @BindView(R.id.active_linear_layout)
    LinearLayout activeLinearLayout;
    @BindView(R.id.active_relative_layout)
    RelativeLayout activeRelativeLayout;
    @BindView(R.id.publish_image)
    ImageView publishImage;
    @BindView(R.id.publish_linear_layout)
    LinearLayout publishLinearLayout;
    @BindView(R.id.publish_relative_layout)
    RelativeLayout publishRelativeLayout;
    @BindView(R.id.message_image)
    ImageView messageImage;
    @BindView(R.id.message_linear_layout)
    LinearLayout messageLinearLayout;
    @BindView(R.id.message_relative_layout)
    RelativeLayout messageRelativeLayout;
    @BindView(R.id.mine_image)
    ImageView mineImage;
    @BindView(R.id.mine_linear_layout)
    LinearLayout mineLinearLayout;
    @BindView(R.id.mine_relative_layout)
    RelativeLayout mineRelativeLayout;
    @BindView(R.id.bottom_layout)
    LinearLayout bottomLayout;
    @BindView(R.id.test_btn)
    Button testBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        setSelectHome();
    }

    @OnClick({R.id.home_relative_layout, R.id.active_relative_layout, R.id.publish_relative_layout, R.id.message_relative_layout,
            R.id.mine_relative_layout,R.id.test_btn})
    public void onViewClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.home_relative_layout:
                setSelectHome();
                break;
            case R.id.active_relative_layout:
                setSelectActive();
                break;
            case R.id.publish_relative_layout:
                setSelectPublish();
                break;
            case R.id.message_relative_layout:
                setSelectMessage();
                break;
            case R.id.mine_relative_layout:
                setSelectMine();
                break;
            case R.id.test_btn:
                Intent intent = new Intent(this,TestActivity.class);
                startActivity(intent);
                break;
        }

    }

    public void setSelectHome() {
        homeImage.setSelected(true);
        activeImage.setSelected(false);
        publishImage.setSelected(false);
        messageImage.setSelected(false);
        mineImage.setSelected(false);
    }

    public void setSelectActive() {
        homeImage.setSelected(false);
        activeImage.setSelected(true);
        publishImage.setSelected(false);
        messageImage.setSelected(false);
        mineImage.setSelected(false);
    }

    public void setSelectPublish() {
        homeImage.setSelected(false);
        activeImage.setSelected(false);
        publishImage.setSelected(true);
        messageImage.setSelected(false);
        mineImage.setSelected(false);
    }

    public void setSelectMessage() {
        homeImage.setSelected(false);
        activeImage.setSelected(false);
        publishImage.setSelected(false);
        messageImage.setSelected(true);
        mineImage.setSelected(false);
    }

    public void setSelectMine() {
        homeImage.setSelected(false);
        activeImage.setSelected(false);
        publishImage.setSelected(false);
        messageImage.setSelected(false);
        mineImage.setSelected(true);
    }
}