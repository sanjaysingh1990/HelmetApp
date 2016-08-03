package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity {

    TextView flip_up,full_face,open_face,moto_cross;
    RelativeLayout flip_uplayout,full_face_layout,open_face_layout,moto_cross_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main2);


        flip_up=(TextView)findViewById(R.id.flip_up);
        full_face=(TextView)findViewById(R.id.full_face);
        open_face=(TextView)findViewById(R.id.open_face);
        moto_cross=(TextView)findViewById(R.id.moto_cross);

        flip_uplayout=(RelativeLayout)findViewById(R.id.flipuplayout);
        full_face_layout=(RelativeLayout)findViewById(R.id.full_face_layout);
        open_face_layout=(RelativeLayout)findViewById(R.id.open_face_layout);
        moto_cross_layout=(RelativeLayout)findViewById(R.id.moto_cross_layout);

        Typeface custom=Typeface.createFromAsset(getAssets(),"fonts/gillsans-light-italic.ttf");
        flip_up.setTypeface(custom);
        full_face.setTypeface(custom);
        open_face.setTypeface(custom);
        moto_cross.setTypeface(custom);

        changeBackground();




        flip_uplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Drawable res=getResources().
                // Toast.makeText(CategoryActivity.this,"clicked",Toast.LENGTH_LONG).show();
                flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                flip_up.setTextColor(Color.parseColor("#ff0000"));

                full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                moto_cross.setTextColor(Color.parseColor("#ffffff"));

                Intent open=new Intent(CategoryActivity.this,FlipCategory.class);
                startActivity(open);
            }
        });
        open_face_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Drawable res=getResources().
                // Toast.makeText(CategoryActivity.this,"clicked",Toast.LENGTH_LONG).show();
                flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                open_face.setTextColor(Color.parseColor("#ff0000"));

                moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                moto_cross.setTextColor(Color.parseColor("#ffffff"));

                Intent open=new Intent(CategoryActivity.this,OpenFaceCategory.class);
                startActivity(open);
            }
        });

        full_face_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Drawable res=getResources().
                // Toast.makeText(CategoryActivity.this,"clicked",Toast.LENGTH_LONG).show();
                flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                full_face.setTextColor(Color.parseColor("#ff0000"));

                open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                moto_cross.setTextColor(Color.parseColor("#ffffff"));

                Intent open=new Intent(CategoryActivity.this,FullFaceCategory.class);
                startActivity(open);
            }
        });


        moto_cross_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Drawable res=getResources().
                // Toast.makeText(CategoryActivity.this,"clicked",Toast.LENGTH_LONG).show();
                flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                moto_cross.setTextColor(Color.parseColor("#ff0000"));

                Intent open=new Intent(CategoryActivity.this,MotoCrossCategory.class);
                startActivity(open);
            }
        });


}

    private void changeBackground() {

        flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
    }
}
