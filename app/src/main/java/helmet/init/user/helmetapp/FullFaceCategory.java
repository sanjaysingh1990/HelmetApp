package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class FullFaceCategory extends AppCompatActivity {


    RelativeLayout elex,leo,water;
    TextView elexcategory,leocategory,watercategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_full_face_category);

        elexcategory=(TextView)findViewById(R.id.elexcategory);
        leocategory=(TextView)findViewById(R.id.leocategory);
        watercategory=(TextView)findViewById(R.id.watercategory);

        Typeface custom= Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibold.ttf");
        elexcategory.setTypeface(custom);
        leocategory.setTypeface(custom);
        watercategory.setTypeface(custom);



        elex=(RelativeLayout)findViewById(R.id.elex);
        leo=(RelativeLayout)findViewById(R.id.leo);

        water=(RelativeLayout)findViewById(R.id.water);


        

        elex.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                elexcategory.setTextColor(Color.parseColor("#ff0000"));

                leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                leocategory.setTextColor(Color.parseColor("#ffffff"));

                water.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                watercategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",2);
                startActivity(activity);
            }
        });

        leo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                leocategory.setTextColor(Color.parseColor("#ff0000"));

                elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                elexcategory.setTextColor(Color.parseColor("#ffffff"));

                water.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                watercategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",3);
                startActivity(activity);
            }
        });

        water.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                water.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                watercategory.setTextColor(Color.parseColor("#ff0000"));

                leo.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                leocategory.setTextColor(Color.parseColor("#ffffff"));

                elex.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                elexcategory.setTextColor(Color.parseColor("#ffffff"));

                Intent activity=new Intent(FullFaceCategory.this,TabActivity.class);
                activity.putExtra("category",4);
                startActivity(activity);
            }
        });

    }
}
