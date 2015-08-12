package pl.michalstawarz.movies.projectone;

import android.content.Context;
import android.content.Intent;
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
    private final String LOG_TAG = FetchMoviesTask.class.getSimpleName();
    String MOVIE_DB_API_KEY = "xxx";

    @Override
    public void onStart() {
        super.onStart();
        downloadMoviesData();
    }

    public void downloadMoviesData() {
        new FetchMoviesTask(new FetchMoviesTask.FetchMoviesListener() {
            @Override
            public void onNewMoviesData(MovieModel[] moviesArr) {
                //TODO:
                mMovies = moviesArr;
                Log.e(LOG_TAG, "Will display " + moviesArr.length +" movies");
            }

        }, MOVIE_DB_API_KEY, true).execute(null, null, null);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        moviesAdapter = new MoviePosterAdapter(getActivity(), mMovies);

        ListView listView = (ListView) rootView.findViewById(R.id.listview_movies);
        listView.setAdapter(moviesAdapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
////                Context context = getActivity();
////                String text = (String) adapterView.getAdapter().getItem(i);
////
////                startDetailedActivity(context, text);
//            }
//        });

        return rootView;
    }
    public void startDetailedActivity(Context context, String forecast) {
//        Intent detailsIntent = new Intent(context, DetailActivity.class).putExtra(Intent.EXTRA_TEXT, forecast);
//        startActivity(detailsIntent);
    }
}
