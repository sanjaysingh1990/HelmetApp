package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MotoCrossCategory extends AppCompatActivity {


    RelativeLayout dream;
    TextView dreamcategory,categoryname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_moto_cross);
        dreamcategory=(TextView)findViewById(R.id.dreamcategory);
        categoryname=(TextView)findViewById(R.id.categoryname);
        Typeface custom1= Typeface.createFromAsset(getAssets(), "newfonts/GOTHICB_0.TTF");
        categoryname.setTypeface(custom1);


        Typeface custom= Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibold.ttf");
        dreamcategory.setTypeface(custom);

        dream=(RelativeLayout)findViewById(R.id.dream);

        dream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                dream.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                dreamcategory.setTextColor(Color.parseColor("#ff0000"));


                Intent activity=new Intent(MotoCrossCategory.this,TabActivity.class);
                activity.putExtra("category",13);
                startActivity(activity);
            }
        });
    }
}
