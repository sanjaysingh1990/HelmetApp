package helmet.init.user.helmetapp;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by user on 8/5/2016.
 */
public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.Myholder>{

  ArrayList<GalleryDataBean> imagelist;
    Context con;

    public ImageAdapter(Context con,ArrayList<GalleryDataBean> images) {

    this.imagelist=images;
        this.con=con;
    }

    @Override
    public Myholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.img_layout,null);
        Myholder holder=new Myholder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(final Myholder holder, int position) {
     GalleryDataBean   nature= imagelist.get(position);
       //Log.e("url",nature.getHelmet_image());
        //Toast.makeText(con,nature.getHelmet_image(),Toast.LENGTH_LONG).show();
        if(nature.getHelmet_image()==null){
            Picasso.with(con).load("http://52.76.68.122/Helmet/images/one.png").into(holder.imgDisplay, new Callback() {
                @Override
                public void onSuccess() {
                    holder.prog.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    holder.prog.setVisibility(View.GONE);
                }
            });
        }
        else{
            Picasso.with(con).load(nature.getHelmet_image()).into(holder.imgDisplay, new Callback() {
                @Override
                public void onSuccess() {
                    holder.prog.setVisibility(View.GONE);
                }

                @Override
                public void onError() {
                    holder.prog.setVisibility(View.GONE);

                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return imagelist.size();
    }

    public class Myholder extends RecyclerView.ViewHolder {

        ImageView imgDisplay;
            ProgressBar prog;
        public Myholder(View itemView) {
            super(itemView);
        imgDisplay=(ImageView)itemView.findViewById(R.id.img);
        prog=(ProgressBar)itemView.findViewById(R.id.progress);
        }
    }
}
