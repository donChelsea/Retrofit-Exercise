package android.example.com.retrofitexercise;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private static final String BASE_URL = "https://dog.ceo/";
    private static final String TAG = "RETROFIT EXERCISE";
    ImageView dogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dogView = findViewById(R.id.dogView);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofit.create(puppyAPI.class)
                .getDogUrl()
                .enqueue(new Callback<Puppy>() {
                    @Override
                    public void onResponse(Call<Puppy> call, Response<Puppy> response) {
                        Puppy responsePuppy = response.body();
                        Log.d(TAG, "onCreate: " + responsePuppy.getDogURL());

                        Picasso.with(getApplicationContext())
                                .load(responsePuppy.getDogURL())
                                .into(dogView);
                    }

                    @Override
                    public void onFailure(Call<Puppy> call, Throwable t) {
                        Log.d(TAG, "Not this time!" + t.toString());
                    }
                });
    }
}
