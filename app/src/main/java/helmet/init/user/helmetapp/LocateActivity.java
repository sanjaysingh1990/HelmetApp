
package helmet.init.user.helmetapp;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.TextView;

import org.w3c.dom.Text;

public class LocateActivity extends AppCompatActivity {

    TextView locateMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_locate);

    locateMap=(TextView)findViewById(R.id.locate);

        Typeface descfont=Typeface.createFromAsset(getAssets(),"fonts/gillsans.ttf");
       locateMap.setTypeface(descfont);

    }
}
