package android.example.com.retrofitexercise;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DogAdapter extends RecyclerView.Adapter<DogAdapter.DogViewHolder> {
    private static final String TAG = "DOG ADAPTER";
    private static final String BASE_URL = "https://dog.ceo/";
    DogViewHolder holder;
    private ArrayList <String> dogImageURLS = new ArrayList<>();
    private Context context;

    @NonNull
    @Override
    public DogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int position) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.puppy_listitem, parent, false);
        holder = new DogViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull DogViewHolder dogViewHolder, int position) {
        Log.d(TAG, "OnBindViewHolder: called");

//        Picasso.with(context)
//                .load(dogImageURLS.get(position))
//                .into(holder.dogView);
    }

    @Override
    public int getItemCount() {
        return dogImageURLS.size();
    }

    public class DogViewHolder extends RecyclerView.ViewHolder {
        ImageView dogView;

        public DogViewHolder(@NonNull View itemView) {
            super(itemView);
            dogView = itemView.findViewById(R.id.dogView);
        }
    }
}
