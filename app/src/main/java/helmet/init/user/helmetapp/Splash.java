package helmet.init.user.helmetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class Splash extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_splash);

    Thread th=new Thread(new Runnable() {
        @Override
        public void run() {

            try {
                Thread.sleep(3000);
                Intent activity=new Intent(Splash.this,CategoryActivity.class);
                startActivity(activity);
                finish();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    });
        th.start();
    }
}
