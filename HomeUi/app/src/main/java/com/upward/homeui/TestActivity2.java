package com.upward.homeui;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

import butterknife.ButterKnife;

public class TestActivity2 extends AppCompatActivity {

    private SimpleDraweeView mSimpleDraweeView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2_layout);
        ButterKnife.bind(this);

        mSimpleDraweeView = findViewById(R.id.image_view1);



        Uri uri =  Uri.parse("https://b-ssl.duitang.com/uploads/item/201811/04/20181104223950_vygmz.thumb.700_0.jpeg");
//        sdv.setImageURI(uri);

        DraweeController controller = Fresco.newDraweeControllerBuilder()
                .setUri(uri)
                .setAutoPlayAnimations(true)
                .build();
        mSimpleDraweeView.setController(controller);



//        mSimpleDraweeView.setImageURI("res://mipmap/" + R.mipmap.ic_avatar_9);

    }
}
