package pl.michalstawarz.movies.projectone;

import android.app.Activity;
import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.Vector;

/**
 * Created by Mychal on 2015-08-12.
 */
public class MoviePosterAdapter extends ArrayAdapter<MovieModel> {
    private Activity mContext;
    private MovieModel[] mMovies;

    public MoviePosterAdapter(Activity context, MovieModel[] movies) {
        super(context, R.layout.movie_poster_layout, movies);

        this.mContext = context;
        this.mMovies = movies;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.movie_poster_layout, null, true);

        ImageView posterView = (ImageView) rowView.findViewById(R.id.poster_layout_imageView);
        MovieModel model = mMovies[position];
        Picasso.with(mContext).load("http://image.tmdb.org/t/p/w185/" + model.backdrop_path).into(posterView);

        return rowView;
    }

}