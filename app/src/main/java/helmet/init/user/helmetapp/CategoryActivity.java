package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Typeface;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CategoryActivity extends AppCompatActivity {

    TextView flip_up,full_face,open_face,moto_cross;
    RelativeLayout flip_uplayout,full_face_layout,open_face_layout,moto_cross_layout;
    ImageView flip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_category);


        flip_up=(TextView)findViewById(R.id.flip_up);
        full_face=(TextView)findViewById(R.id.full_face);
        open_face=(TextView)findViewById(R.id.open_face);
        moto_cross=(TextView)findViewById(R.id.moto_cross);

        flip_uplayout=(RelativeLayout)findViewById(R.id.flipuplayout);
        full_face_layout=(RelativeLayout)findViewById(R.id.full_face_layout);
        open_face_layout=(RelativeLayout)findViewById(R.id.open_face_layout);
        moto_cross_layout=(RelativeLayout)findViewById(R.id.moto_cross_layout);

      //  flip=(ImageView)findViewById(R.id.flip);
       // flip.setImageBitmap(highlightImage(BitmapFactory.decodeResource(getResources(), R.drawable.flip_up_category)));


        Typeface custom=Typeface.createFromAsset(getAssets(),"newfonts/GOTHIC_0.TTF");
        flip_up.setTypeface(custom);
        full_face.setTypeface(custom);
        open_face.setTypeface(custom);
        moto_cross.setTypeface(custom);

       // changeBackground();




        flip_uplayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Drawable res=getResources().
                // Toast.makeText(CategoryActivity.this,"clicked",Toast.LENGTH_LONG).show();
             //   flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                flip_up.setTextColor(Color.parseColor("#ff0000"));

               // full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                //open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                //moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
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
               // flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                //full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                //open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                open_face.setTextColor(Color.parseColor("#ff0000"));

               // moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
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
                //flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                //full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                full_face.setTextColor(Color.parseColor("#ff0000"));

                //open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                //moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
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
               // flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                flip_up.setTextColor(Color.parseColor("#ffffff"));

                //full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                full_face.setTextColor(Color.parseColor("#ffffff"));

                //open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
                open_face.setTextColor(Color.parseColor("#ffffff"));

                //moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));
                moto_cross.setTextColor(Color.parseColor("#ff0000"));

                Intent open=new Intent(CategoryActivity.this,MotoCrossCategory.class);
                startActivity(open);
            }
        });


}

    public Bitmap highlightImage(Bitmap src) {
        // create new bitmap, which will be painted and becomes result image
        Bitmap bmOut = Bitmap.createBitmap(src.getWidth() + 20, src.getHeight() + 20, Bitmap.Config.ARGB_8888);
        // setup canvas for painting
        Canvas canvas = new Canvas(bmOut);
        // setup default color
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        // create a blur paint for capturing alpha
        Paint ptBlur = new Paint();
        ptBlur.setMaskFilter(new BlurMaskFilter(40, BlurMaskFilter.Blur.NORMAL));
        int[] offsetXY = new int[2];
        // capture alpha into a bitmap
        Bitmap bmAlpha = src.extractAlpha(ptBlur, offsetXY);
        // create a color paint
        Paint ptAlphaColor = new Paint();
        ptAlphaColor.setColor(0xFFFFFFFF);
        // paint color for captured alpha region (bitmap)
        canvas.drawBitmap(bmAlpha, offsetXY[0], offsetXY[1], ptAlphaColor);
        // free memory
        bmAlpha.recycle();

        // paint the image source
        canvas.drawBitmap(src, 0, 0, null);

        // return out final image
        return bmOut;
    }

    private void changeBackground() {

        flip_uplayout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        full_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        open_face_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
        moto_cross_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));
    }
}
