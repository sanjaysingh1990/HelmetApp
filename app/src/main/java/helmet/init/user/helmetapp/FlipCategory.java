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

public class FlipCategory extends AppCompatActivity {


    LinearLayout dream;
    TextView dreamcategory,categoryname;
    ImageView dreamimg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_flip_category);

        dreamcategory=(TextView)findViewById(R.id.dreamcategory);
        dreamimg=(ImageView)findViewById(R.id.dreamimg);
        dream=(LinearLayout)findViewById(R.id.dream);


        setHeightWidth(dreamimg);

        // changeBackgound();
        Typeface custom= Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibold.ttf");
        dreamcategory.setTypeface(custom);

      //  dream=(RelativeLayout)findViewById(R.id.dream);



        dream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

        //        dream.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                dreamcategory.setTextColor(Color.parseColor("#ff0000"));


                Intent activity=new Intent(FlipCategory.this,TabActivity.class);
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
