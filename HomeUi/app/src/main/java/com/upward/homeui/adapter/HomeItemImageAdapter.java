package com.upward.homeui.adapter;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.controller.ControllerListener;
import com.facebook.drawee.drawable.ProgressBarDrawable;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.interfaces.DraweeHierarchy;
import com.facebook.drawee.view.DraweeHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import com.upward.homeui.R;

import java.util.List;

public class HomeItemImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private List<String> mImages;

    public HomeItemImageAdapter(List<String> mImages) {
        this.mImages = mImages;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_image_layout, parent, false);
        return new HomeItemImageAdapter.ItemImageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if(holder instanceof  ItemImageHolder){
            loadImage(mImages.get(position),((ItemImageHolder) holder).mImageView);
        }

    }

    @Override
    public int getItemCount() {
        return mImages.size();
    }


    public void loadImage(String url,SimpleDraweeView simpleDraweeView) {
        Uri uri = Uri.parse(url);

        PipelineDraweeControllerBuilder sdcb = Fresco.newDraweeControllerBuilder();

        sdcb.setUri(uri);
        //加载失败之后，点击提示重新加载的图片资源重新加载

        sdcb.setTapToRetryEnabled(true);
        //图片下载完之后自动播放动画

        sdcb.setAutoPlayAnimations(true);
        //在指定一个新的controller的时候，使用setOldController，这可节省不必要的内存分配。

//        DraweeHolder<DraweeHierarchy> simpleDraweeView;
        sdcb.setOldController(simpleDraweeView.getController());

        ControllerListener listener = new BaseControllerListener() {

            @Override

            public void onSubmit(String id, Object callerContext) {
                //提交请求之前调用的方法
                Log.d("", "onSubmit: " + id);
            }

            @Override
            public void onFinalImageSet(String id, Object imageInfo, Animatable animatable) {
                super.onFinalImageSet(id, imageInfo, animatable);
                // 所有图片都加载成功时触发的方法
                Log.d("", "onFinalImageSet: " + id);
                Toast.makeText(mContext, "加载图片成功", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onIntermediateImageSet(String id, Object imageInfo) {
                super.onIntermediateImageSet(id, imageInfo);
            }

            @Override

            public void onIntermediateImageFailed(String id, Throwable throwable) {
                //当中间图片下载失败的时候触发，用于多图请求
            }

            @Override

            public void onFailure(String id, Throwable throwable) {
                // 加载图片失败时回调的方法
                Log.d("加载图片失败", "onFailure: " + id);
                Toast.makeText(mContext, "加载图片失败", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onRelease(String id) {
                //释放图片资源时加载的方法
                Log.d("", "onRelease: " + id);
            }

        };

        sdcb.setControllerListener(listener);

        DraweeController controller = sdcb.build();

        GenericDraweeHierarchyBuilder builder =

                new GenericDraweeHierarchyBuilder(mContext.getResources());

        GenericDraweeHierarchy hierarchy = builder

                .setFadeDuration(300)

                .setProgressBarImage(new ProgressBarDrawable()).build();//进度展示

        simpleDraweeView.setHierarchy(hierarchy);

        simpleDraweeView.setController(controller);
    }

    public class ItemImageHolder extends RecyclerView.ViewHolder {
        public SimpleDraweeView mImageView;

        public ItemImageHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);
        }
    }
}
