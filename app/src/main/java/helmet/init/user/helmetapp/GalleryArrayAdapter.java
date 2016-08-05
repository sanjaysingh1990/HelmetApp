package helmet.init.user.helmetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.nostra13.universalimageloader.core.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;
import com.nostra13.universalimageloader.core.listener.SimpleImageLoadingListener;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;

/**
 * Created by user on 14-07-2015.
 */
public class GalleryArrayAdapter extends RecyclerView.Adapter<GalleryArrayAdapter.ViewHolder> {
    private LayoutInflater mInflater;
     ArrayList<GalleryDataBean> mItems = new ArrayList<GalleryDataBean>();
   //com.android.volley.toolbox.ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    GalleryDataBean nature;
    Context con;
    int position;
    //public static ImageLoader imageLoader=new ImageLoader().getInstance();

    public GalleryArrayAdapter(Context context, ArrayList<GalleryDataBean> values) {
        con = context;
        mItems = values;
        //position=tabposition;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.single_grid, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, int i) {
      nature= mItems.get(i);

        Typeface custom =Typeface.createFromAsset(con.getAssets(), "fonts/gillsanssemibolditalic.ttf");
        viewHolder.name.setTypeface(custom);

 /*    viewHolder.imgThumbnail.setImageUrl(nature.getHelmet_image(),imageLoader,new SimpleImageLoadingListener() {
        o @Override
         public void onLoadingStarted(String imageUri, View view) {

             ((ItemViewHolder) holder).loader.setVisibility(View.VISIBLE);
         }

         @Override
         public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
             ((ItemViewHolder) holder).loader.setVisibility(View.GONE);
         }

         @Override
         public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
             ((ItemViewHolder) holder).loader.setVisibility(View.GONE);
         }
     }, new ImageLoadingProgressListener() {
         @Override
         public void onPrgressUpdate(String imageUri, View view, int current, int total) {

         }
     });
*/

    /*ToDoListApplication.imageLoader.displayImage(nature.getHelmet_image(),viewHolder.imgThumbnail,ToDoListApplication.options,new SimpleImageLoadingListener(){
    @Override
    public void onLoadingStarted(String imageUri, View view)
    {
        viewHolder.loader.setVisibility(View.VISIBLE);
    }

    @Override
    public void onLoadingFailed(String imageUri, View view, FailReason failReason)
    {
        viewHolder.loader.setVisibility(View.GONE);
    }

    @Override
    public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage)
    {
        viewHolder.loader.setVisibility(View.GONE);
    }
});*/
        viewHolder.name.setText(nature.getHelmet_name());
     //   viewHolder.imgThumbnail.setImageUrl(nature.getHelmet_image(),imageLoader);
       // AppController.imageLoader.displayImage(nature.getHelmet_image(),viewHolder.imgThumbnail,AppController.options);
                //.imageLoader.displayImage(nature.getHelmet_image(), viewHolder.imgThumbnail, ToDoListApplication.options);
        Picasso.with(con).load(nature.getHelmet_image()).into(viewHolder.imgThumbnail, new Callback() {
            @Override
            public void onSuccess() {
                viewHolder.loader.setVisibility(View.GONE);
            }

            @Override
            public void onError() {
                viewHolder.loader.setVisibility(View.GONE);
            }
        });

        viewHolder.imgThumbnail.setOnClickListener(new Onclick(i));
        viewHolder.shareall.setOnClickListener(new Onclick(i));
           }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton whatappshare, shareall;
        ImageView imgThumbnail;
        TextView name;
        ProgressBar loader;


        // public TextView tvspecies;
        public ViewHolder(View itemView) {
            super(itemView);
        //    if (imageLoader == null)
             //   imageLoader = AppController.getInstance().getImageLoader();

            imgThumbnail = (ImageView) itemView
                    .findViewById(R.id.img_thumbnail);
            shareall = (ImageButton) itemView.findViewById(R.id.shareall);
            name = (TextView)itemView.findViewById(R.id.name);
            loader=(ProgressBar)itemView.findViewById(R.id.loader)
;        }
    }

    class Onclick implements View.OnClickListener {
        int pos;

        Onclick(int pos) {
            this.pos = pos;
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.img_thumbnail:

                    Intent detail=new Intent(con,DescriptionActivity.class);
                    detail.putExtra("helmet_id",mItems.get(pos).getHelmet_id());

                    detail.putExtra("helmet_image",mItems.get(pos).getHelmet_image());

                    detail.putExtra("helmet_name",mItems.get(pos).getHelmet_name());

                    detail.putExtra("helmet_feature",mItems.get(pos).getCategory_feature());
                    con.startActivity(detail);

                    //Intent i=new Intent(con, FullDetailActivity.class);
                    //con.startActivity(i);

                    /*Intent i=new Intent(con,GalleryFullScreenActivity.class);
                    i.putExtra("databeans",mItems);
                    i.putExtra("pos",pos);
                    con.startActivity(i);
                    */
                    break;
                case R.id.shareall:
                   // new DifferentShare(con).imageShare(mItems.get(pos).getUrl());

                    //new ImageDownloaderWhatsapp(con, 2).execute(mItems.get(pos).getUrl());

                    Intent share = new Intent(android.content.Intent.ACTION_SEND);
                    share.setType("text/plain");
                    share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

                    // Add data to the intent, the receiving app will decide
                    // what to do with it.
                  //  share.putExtra(Intent.EXTRA_SUBJECT, "Helmet image share");

                    share.putExtra(Intent.EXTRA_TEXT, mItems.get(pos).getHelmet_image());

                    con.startActivity(Intent.createChooser(share, "Share link!"));

                    break;
            }
        }
    }
}
