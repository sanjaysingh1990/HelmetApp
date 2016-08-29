package helmet.init.user.helmetapp;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class ToDoListApplication extends Application {


public static DisplayImageOptions options;
public static ImageLoader imageLoader;
	@Override
	public void onCreate() {
		super.onCreate();
			/*ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
		 defaultACL.setPublicReadAccess(true);
		 defaultACL.setPublicWriteAccess(true);
		ParseACL.setDefaultACL(defaultACL, true);*/
		options = new DisplayImageOptions.Builder()

		.showImageForEmptyUri(R.drawable.loading)
		.showImageOnFail(R.drawable.loading)
		.cacheInMemory(true)
		.cacheOnDisk(true)
		.considerExifParams(true)
		.bitmapConfig(Bitmap.Config.RGB_565)
		.build();

		imageLoader= ImageLoader.getInstance();
		this.imageLoader.init(ImageLoaderConfiguration.createDefault(this));

	}

}
