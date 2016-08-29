package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FullFaceCategory extends AppCompatActivity {


    LinearLayout elex,leo,water;
    TextView elexcategory,leocategory,watercategory,categoryname;
    ImageView eleximg,leoimg,walterimg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_full_face_category);

        elexcategory=(TextView)findViewById(R.id.elexcategory);
        leocategory=(TextView)findViewById(R.id.leocategory);
        watercategory=(TextView)findViewById(R.id.watercategory);

        eleximg=(ImageView)findViewById(R.id.eleximg);
        leoimg=(ImageView)findViewById(R.id.leoimg);
        walterimg=(ImageView)findViewById(R.id.walterimg);

        categoryname=(TextView)findViewById(R.id.categoryname);
        Typeface custom1= Typeface.createFromAsset(getAssets(), "newfonts/GOTHICB_0.TTF");
        categoryname.setTypeface(custom1);


        Typeface custom= Typeface.createFromAsset(getAssets(), "newfonts/GOTHIC_0.TTF");
        elexcategory.setTypeface(custom);
        leocategory.setTypeface(custom);
        watercategory.setTypeface(custom);


        setHeightWidth(eleximg);
        setHeightWidth(leoimg);
        setHeightWidth(walterimg);



        elex=(LinearLayout)findViewById(R.id.elex);
        leo=(LinearLayout)findViewById(R.id.leo);

        water=(LinearLayout)findViewById(R.id.water);


        

        elex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               // elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                elexcategory.setTextColor(Color.parseColor("#ff0000"));

                //leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                leocategory.setTextColor(Color.parseColor("#ffffff"));

                //water.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                watercategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",2);
                startActivity(activity);
            }
        });

        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                leocategory.setTextColor(Color.parseColor("#ff0000"));

                //elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                elexcategory.setTextColor(Color.parseColor("#ffffff"));

                //water.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                watercategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",3);
                startActivity(activity);
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //water.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                watercategory.setTextColor(Color.parseColor("#ff0000"));

                //leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                leocategory.setTextColor(Color.parseColor("#ffffff"));

                //elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                elexcategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",4);
                startActivity(activity);
            }
        });

    }

    public void setHeightWidth(ImageView img){
        AppController app= (AppController) getApplication();
        android.view.ViewGroup.LayoutParams layoutParams = img.getLayoutParams();
        layoutParams.width = (app.width * 50) / 100;
        layoutParams.height = (app.width * 50) / 100;
        img.setLayoutParams(layoutParams);


    }

}
