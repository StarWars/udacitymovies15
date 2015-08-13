package pl.michalstawarz.movies.projectone;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Mycha³ on 2015-08-13.
 */
public class GridAdapter extends BaseAdapter{
    private Activity mContext;
    private MovieModel[] mMovies;

    public GridAdapter(Activity context, MovieModel[] movies)  {
        mContext = context;
        mMovies = movies;
    }
    @Override
    public int getCount() {
        return mMovies.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            // if it's not recycled, initialize some attributes
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(85, 85));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(8, 8, 8, 8);
        } else {
            imageView = (ImageView) convertView;
        }
        MovieModel model = mMovies[position];
        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/" + model.backdrop_path).into(imageView);

        return imageView;
    }
}
