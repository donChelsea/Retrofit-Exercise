package android.example.com.retrofitexercise;

import retrofit2.Call;
import retrofit2.http.GET;

public interface puppyAPI {
     String ENDPOINT_URL = "api/breed/hound/images";

     @GET(ENDPOINT_URL)
     Call<Puppy> getDogUrl();

}
