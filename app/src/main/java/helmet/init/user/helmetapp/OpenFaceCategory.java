package helmet.init.user.helmetapp;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class OpenFaceCategory extends AppCompatActivity {

    TextView host,z_way,z_way_super,essex_hit,essex_hot,essex_wave,youth,storm;
    RelativeLayout host_layout,z_way_layout,z_way_super_layout,essex_hit_layout,essex_hot_layout,essex_wave_layout,youth_layout,storm_layout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_open_face_category);

        host=(TextView)findViewById(R.id.host);
        z_way=(TextView)findViewById(R.id.zway);
        z_way_super=(TextView)findViewById(R.id.z_way_super);
        essex_hit=(TextView)findViewById(R.id.essex_hit);
        essex_hot=(TextView)findViewById(R.id.essex_hot);
        essex_wave=(TextView)findViewById(R.id.essex_wave);
        youth=(TextView)findViewById(R.id.youth);
        storm=(TextView)findViewById(R.id.storm);

        host_layout=(RelativeLayout)findViewById(R.id.hostlayout);
        z_way_layout=(RelativeLayout)findViewById(R.id.z_way_layout);
        z_way_super_layout=(RelativeLayout)findViewById(R.id.z_way_super_layout);
        essex_hit_layout=(RelativeLayout)findViewById(R.id.essex_hit_layout);
        essex_hot_layout=(RelativeLayout)findViewById(R.id.essex_hot_layout);
        essex_wave_layout=(RelativeLayout)findViewById(R.id.essex_wave_layout);
        youth_layout=(RelativeLayout)findViewById(R.id.youth_layout);
        storm_layout=(RelativeLayout)findViewById(R.id.storm_layout);




        Typeface custom= Typeface.createFromAsset(getAssets(), "fonts/gillsanssemibold.ttf");
        host.setTypeface(custom);
        z_way.setTypeface(custom);
        z_way_super.setTypeface(custom);
        essex_hit.setTypeface(custom);
        essex_hot.setTypeface(custom);
        essex_wave.setTypeface(custom);
        youth.setTypeface(custom);
        storm.setTypeface(custom);

        host_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                host.setTextColor(Color.parseColor("#ff0000"));
              //  host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
                //z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
                //z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
                //essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
//                essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
  //              essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
//                youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
  //              storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);

                act.putExtra("category",5);
                startActivity(act);
            }
        });
        z_way_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(OpenFaceCategory.this,"clicked z_way",Toast.LENGTH_LONG).show();
                z_way.setTextColor(Color.parseColor("#ff0000"));
//                z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                host.setTextColor(Color.parseColor("#ffffff"));
  //              host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
//                z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
  //              essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
    //            essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
      //          essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
        //        youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
          //      storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",6);

                startActivity(act);
            }
        });

        z_way_super_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(OpenFaceCategory.this,"clicked",Toast.LENGTH_LONG).show();

                z_way_super.setTextColor(Color.parseColor("#ff0000"));
//                z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                host.setTextColor(Color.parseColor("#ffffff"));
  //              host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
    //            z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
     //           essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
      //          essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
      //          essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
        //        essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
          //      youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
//                storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",7);

                startActivity(act);
            }
        });
        essex_hit_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                essex_hit.setTextColor(Color.parseColor("#ff0000"));
  //              essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
    //            z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
      //          z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                host.setTextColor(Color.parseColor("#ffffff"));
        //        host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
          //      essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
            //    essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
             //   youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
             //   storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",8);

                startActivity(act);
            }
        });
        essex_hot_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                essex_hot.setTextColor(Color.parseColor("#ff0000"));
//                essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
  //              z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
    //            z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
      //          essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                host.setTextColor(Color.parseColor("#ffffff"));
     //           host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
      //          essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
       //         youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
         //       storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",9);

                startActivity(act);
            }
        });
        essex_wave_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                essex_wave.setTextColor(Color.parseColor("#ff0000"));
//                essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
  //              z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
   //             z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
     //           essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
      //          essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                host.setTextColor(Color.parseColor("#ffffff"));
//                host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
  //              youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
//                storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",10);

                startActivity(act);
            }
        });
        youth_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youth.setTextColor(Color.parseColor("#ff0000"));
             //   youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
               // z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
               // z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
               // essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
                //essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
                //essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                host.setTextColor(Color.parseColor("#ffffff"));
                //host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                storm.setTextColor(Color.parseColor("#ffffff"));
               // storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",11);

                startActivity(act);
            }
        });
        storm_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storm.setTextColor(Color.parseColor("#ff0000"));
              //  storm_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.red_background));

                z_way.setTextColor(Color.parseColor("#ffffff"));
                //z_way_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                z_way_super.setTextColor(Color.parseColor("#ffffff"));
                //z_way_super_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hit.setTextColor(Color.parseColor("#ffffff"));
                //essex_hit_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_hot.setTextColor(Color.parseColor("#ffffff"));
                //essex_hot_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                essex_wave.setTextColor(Color.parseColor("#ffffff"));
                //essex_wave_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                youth.setTextColor(Color.parseColor("#ffffff"));
              //  youth_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));

                host.setTextColor(Color.parseColor("#ffffff"));
                //host_layout.setBackgroundDrawable(getResources().getDrawable(R.drawable.white_background));




                Intent act=new Intent(OpenFaceCategory.this,TabActivity.class);
                act.putExtra("category",12);

                startActivity(act);
            }
        });


    }
}
