package com.example.saad.traveljournal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import static com.facebook.FacebookSdk.getApplicationContext;

/**
 * Created by saad on 09/12/2018.
 */

public class Post_viewholder extends RecyclerView.ViewHolder {

    ImageView img;
    TextView txt;
    TextView txt2;
    RatingBar rtn;

    public Post_viewholder(View itemView) {
        super(itemView);
        img=itemView.findViewById(R.id.img);
        txt=itemView.findViewById(R.id.description);
        txt2=itemView.findViewById(R.id.location);
        rtn=itemView.findViewById(R.id.ratingbar2);
    }

    public void bindData(Post p)
    {
        new ImageDownloaderAsync(img,getApplicationContext()).execute(p.getUrl());
        txt.setText(p.getDescription().trim());
        txt2.setText(p.getLocation().trim());
        rtn.setRating(p.getRating());
    }
}
