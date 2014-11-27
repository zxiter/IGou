/**
 * 
 */
package com.xiter.igou.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.xiter.igou.R;

/**
 * Description:图片处理
 * 
 * @author liufeihua
 * @date 2014-11-26上午11:01:25
 * @version 1.0
 * 
 */
public class ImageUtil {

	/**
	 * 获取imageloader 对象
	 * 
	 * @return
	 */
	public static ImageLoader getImageLoader() {
		return ImageLoader.getInstance();
	}

	/**
	 * 初始化配置
	 * 
	 * @param context
	 * @return
	 */
	public static ImageLoaderConfiguration initConfig(Context context) {
		// This configuration tuning is custom. You can tune every option, you
		// may tune some of them,
		// or you can create default configuration by
		// ImageLoaderConfiguration.createDefault(this);
		// method.
		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
				context).threadPriority(Thread.NORM_PRIORITY - 2)
				.denyCacheImageMultipleSizesInMemory()
				.diskCacheFileNameGenerator(new Md5FileNameGenerator())
				.diskCacheSize(50 * 1024 * 1024)
				// 50 Mb
				.tasksProcessingOrder(QueueProcessingType.LIFO)
				.writeDebugLogs() // Remove for release app
				.build();

		return config;
	}

	/**
	 * 初始化显示
	 * 
	 * @return
	 */
	public static DisplayImageOptions initDisplayImageOptions() {
		DisplayImageOptions options = new DisplayImageOptions.Builder()
				.showImageOnLoading(R.drawable.ic_stub)
				.showImageForEmptyUri(R.drawable.ic_empty)
				.showImageOnFail(R.drawable.ic_error)
				//
				.cacheInMemory(true).cacheOnDisk(true)
				//
				.imageScaleType(ImageScaleType.EXACTLY)
				.bitmapConfig(Bitmap.Config.RGB_565)//
				.considerExifParams(true)
				// .displayer(new FadeInBitmapDisplayer(300))
				.build();
		return options;
	}

	public static void setImage(String url, ImageView imageView) {
		ImageLoader.getInstance().displayImage(Config.STRURL + url, imageView,
				ImageUtil.initDisplayImageOptions(),
				new SimpleImageLoadingListener() {

					@Override
					public void onLoadingStarted(String imageUri, View view) {

					}

					@Override
					public void onLoadingFailed(String imageUri, View view,
							FailReason failReason) {

					}

					@Override
					public void onLoadingComplete(String imageUri, View view,
							Bitmap loadedImage) {

					}
				}, new ImageLoadingProgressListener() {
					@Override
					public void onProgressUpdate(String imageUri, View view,
							int current, int total) {

					}
				});
	}
}
