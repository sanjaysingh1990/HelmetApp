package helmet.init.user.helmetapp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;


import java.util.ArrayList;

/**
 * Created by user on 14-07-2015.
 */
public class GalleryArrayAdapter extends RecyclerView.Adapter<GalleryArrayAdapter.ViewHolder> {
    private LayoutInflater mInflater;
     ArrayList<GalleryDataBean> mItems = new ArrayList<GalleryDataBean>();
    ImageLoader imageLoader = AppController.getInstance().getImageLoader();
    GalleryDataBean nature;
    Context con;
    int position;

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
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
      nature= mItems.get(i);
      //  viewHolder.whatappshare.setOnClickListener(new Onclick(i));
       // viewHolder.shareall.setOnClickListener(new Onclick(i));

        Typeface custom =Typeface.createFromAsset(con.getAssets(), "fonts/gillsanssemibolditalic.ttf");
        viewHolder.name.setTypeface(custom);

        viewHolder.imgThumbnail.setImageUrl(nature.getHelmet_image(),imageLoader);

//        ToDoListApplication.imageLoader.displayImage(nature.getHelmet_image(),viewHolder.imgThumbnail,ToDoListApplication.options);
        viewHolder.name.setText(nature.getHelmet_name());
//        ToDoListApplication.imageLoader.displayImage(nature.getUrl(), viewHolder.imgThumbnail, ToDoListApplication.options);


        viewHolder.imgThumbnail.setOnClickListener(new Onclick(i));
        viewHolder.shareall.setOnClickListener(new Onclick(i));
           }

    @Override
    public int getItemCount() {

        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ImageButton whatappshare, shareall;
        NetworkImageView imgThumbnail;
        TextView name;


        // public TextView tvspecies;
        public ViewHolder(View itemView) {
            super(itemView);
            if (imageLoader == null)
                imageLoader = AppController.getInstance().getImageLoader();

            imgThumbnail = (NetworkImageView) itemView
                    .findViewById(R.id.img_thumbnail);
            shareall = (ImageButton) itemView.findViewById(R.id.shareall);
            name = (TextView)itemView.findViewById(R.id.name);
        }
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
