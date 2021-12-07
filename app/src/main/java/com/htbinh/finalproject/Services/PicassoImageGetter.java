package com.htbinh.finalproject.Services;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.Html;
import android.util.DisplayMetrics;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

public class PicassoImageGetter implements Html.ImageGetter {

    private TextView textView = null;
    private Context mContext = null;
    private DisplayMetrics dp;


    public PicassoImageGetter() {

    }

    public PicassoImageGetter(TextView target, Context context) {
        textView = target;
        mContext = context;
        this.dp = SessionServices.getAppMetrics();
    }

    @Override
    public Drawable getDrawable(String source) {
        BitmapDrawablePlaceHolder drawable = new BitmapDrawablePlaceHolder();
        PicassoCache.getPicassoInstance(mContext).load(source).into(drawable);
        return drawable;
    }

    private class BitmapDrawablePlaceHolder extends BitmapDrawable implements Target {

        protected Drawable drawable;

        @Override
        public void draw(final Canvas canvas) {
            if (drawable != null) {
                drawable.draw(canvas);
            }
        }

        public void setDrawable(Drawable drawable) {

            this.drawable = drawable;
            double percent = dp.widthPixels * 1.0 / drawable.getIntrinsicWidth();
            int width = dp.widthPixels;
            int height = (int)(drawable.getIntrinsicHeight() * percent);
            drawable.setBounds(0, 0, width, height);
            setBounds(0, 0, width, height);
            if (textView != null) {
                textView.setText(textView.getText());
            }
        }

        @Override
        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
            setDrawable(new BitmapDrawable(mContext.getResources(), bitmap));
        }

        @Override
        public void onBitmapFailed(Exception e, Drawable errorDrawable) {

        }

        @Override
        public void onPrepareLoad(Drawable placeHolderDrawable) {

        }

    }
}
