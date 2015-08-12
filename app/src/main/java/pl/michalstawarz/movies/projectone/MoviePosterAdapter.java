package pl.michalstawarz.movies.projectone;

import android.content.Context;
import android.graphics.Movie;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by Mychal on 2015-08-12.
 */
public class MoviePosterAdapter extends BaseAdapter {
    private Context mContext;
    private MovieModel[] mMovies;
    LayoutInflater in = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    public MoviePosterAdapter(Context c, MovieModel[] movies) {
        mContext = c;
        mMovies = movies;
    }

    @Override
    public int getCount() {
        return mMovies.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder view = new ViewHolder();
        view.imgView = (ImageView) convertView.findViewById(R.id.poster_layout_imageView);

        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/" + mMovies[position].backdrop_path).into(view.imgView);

        return convertView;
    }

    public static class ViewHolder    {
        public ImageView imgView;
    }
}