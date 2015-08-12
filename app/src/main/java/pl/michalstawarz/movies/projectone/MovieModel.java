package pl.michalstawarz.movies.projectone;

/**
 * Created by Mychal on 2015-08-12.
 */
public class MovieModel {

    String backdrop_path;
    String release_date;
    String title;
    double vote_average;
    String plot_overview;

    public MovieModel() {}

    public String getBackdrop_path() {
        return backdrop_path;
    }

    public MovieModel(String backdrop_path, String release_date, String title, double vote_average, String plot_overview) {
        this.backdrop_path = backdrop_path;
        this.release_date = release_date;
        this.title = title;
        this.vote_average = vote_average;
        this.plot_overview = plot_overview;
    }

    public void setBackdrop_path(String backdrop_path) {
        this.backdrop_path = backdrop_path;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getPlot_overview() {
        return plot_overview;
    }

    public void setPlot_overview(String plot_overview) {
        this.plot_overview = plot_overview;
    }

}
