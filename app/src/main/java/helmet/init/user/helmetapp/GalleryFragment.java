package helmet.init.user.helmetapp;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;


import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class GalleryFragment extends Activity {

	 ArrayList<GalleryDataBean> data=new ArrayList<GalleryDataBean>();
	GalleryArrayAdapter adapter;
	ProgressBar prog;
	static int pos;
	//AdView mAdView;
	public GalleryFragment(){

	}
	boolean flag=true;
	RecyclerView.LayoutManager 	mLayoutManager;
	//VideosLoading videosLoading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

		setContentView(R.layout.gallery_fragment);
       prog=(ProgressBar)findViewById(R.id.progress_bar);
		prog.setVisibility(View.GONE);
		/*mAdView = (AdView) rootView.findViewById(R.id.adView);
		//mAdView.setAdSize(AdSize.SMART_BANNER);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.setAdListener(new AdListener() {
			@Override
			public void onAdLoaded() {
				super.onAdLoaded();
				mAdView.setVisibility(View.VISIBLE);
			}
		});
		mAdView.loadAd(adRequest);
		*/
		RecyclerView gridView = (RecyclerView) findViewById(R.id.recycler_view);
		gridView.setHasFixedSize(true);
			mLayoutManager = new GridLayoutManager(GalleryFragment.this, 2);
		gridView.setLayoutManager(mLayoutManager);
		adapter=new GalleryArrayAdapter(GalleryFragment.this, data);
		gridView.setAdapter(adapter);

		String url="http://52.74.238.77/android/wallpaper.php?start=0";

		JsonObjectRequest object=new JsonObjectRequest(url, new Response.Listener<JSONObject>() {
			@Override
			public void onResponse(JSONObject response) {
				// Log.d(TAG, response.toString());
				prog.setVisibility(View.GONE);


				try{

					data.clear();
					//JSONObject jobj=response.getJSONObject("wallpaper");


					JSONArray obj = response.getJSONArray("wallpaper");
					// if(obj.length()<10)
					//   flag=false;
					for(int i=0;i<obj.length();i++) {
						JSONObject object = obj.getJSONObject(i);
						GalleryDataBean rb=new GalleryDataBean();
						rb.setId(object.getString("wallpaper_id"));
						rb.setName(object.getString("wallpaper_title"));
						rb.setUrl(object.getString("wallpaper_url"));
						data.add(rb);
					}

					adapter.notifyDataSetChanged();

					Log.e("error1" , obj + "");



				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
			// notifying list adapter about data changes
			// so that it renders the list view with updated data
//                        adapter.notifyDataSetChanged();

		}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				//VolleyLog.d(TAG, "Error: " + error.getMessage());
				//hidePDialog();
				prog.setVisibility(View.GONE);
			}
		});

		// Adding request to request queue
		AppController.getInstance().addToRequestQueue(object);

		//if(data.size()==0)
	//	videosLoading.execute();

/*		gridView.setOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {

				int visibleItemCount = mLayoutManager.getChildCount();
				int totalItemCount = mLayoutManager.getItemCount();
				int pastVisiblesItems = ((GridLayoutManager) mLayoutManager).findFirstVisibleItemPosition();


				if ((visibleItemCount + pastVisiblesItems) >= totalItemCount && (flag == true)) {
                    if( videosLoading.getStatus()!= AsyncTask.Status.RUNNING) {
                        videosLoading = new VideosLoading();
                        videosLoading.execute();
                    }

				}
			}

		});
*/
    }

}
