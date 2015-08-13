package pl.michalstawarz.movies.projectone;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Movie;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Modifier;
import java.util.ArrayList;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    private MoviePosterAdapter moviesAdapter;
    private MovieModel[] mMovies;
    private ListView listView;

    private final String LOG_TAG = FetchMoviesTask.class.getSimpleName();
    String MOVIE_DB_API_KEY = "";

    @Override
    public void onStart() {
        super.onStart();
        downloadMoviesData();
    }

    public void downloadMoviesData() {
        new FetchMoviesTask(new FetchMoviesTask.FetchMoviesListener() {
            @Override
            public void onNewMoviesData(MovieModel[] moviesArr) {

                mMovies = moviesArr;
                if (getActivity() != null && mMovies != null) {
                    moviesAdapter = new MoviePosterAdapter(getActivity(), mMovies);
                } else {
                    Log.e(LOG_TAG, "null context");
                }
                listView.setAdapter(moviesAdapter);

                Log.v(LOG_TAG, "Will display " + moviesArr.length + " movies");
            }

        }, MOVIE_DB_API_KEY, true).execute(null, null, null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        this.listView = (ListView) rootView.findViewById(R.id.listview_movies);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Context context = getActivity();
                //String text = (String) adapterView.getAdapter().getItem(i);

                startDetailedActivity(context, "test");
            }
        });

        return rootView;
    }
    public void startDetailedActivity(Context context, String forecast) {
        Intent detailsIntent = new Intent(context, MovieDetailsFragment.class).putExtra(Intent.EXTRA_TEXT, forecast);
        startActivity(detailsIntent);
    }
}
