package app.aymanissa.com.moviedb.Adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import app.aymanissa.com.moviedb.Interfaces.MoviesAdapterListener;
import app.aymanissa.com.moviedb.Models.Movie;
import app.aymanissa.com.moviedb.R;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Ayman on 3/2/2018.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder> {

    private List<Movie> moviesList;
    private Context context;
    private MoviesAdapterListener listener;

    public MoviesAdapter(List<Movie> movies, Context context, MoviesAdapterListener listener) {
        this.moviesList = movies;
        this.context = context;
        this.listener = listener;
    }

    @Override
    public MoviesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.moive_item,null);
        return new MoviesViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(MoviesViewHolder holder, int position) {
        final Movie movie = moviesList.get(position);
        Picasso.with(context)
                .load("http://image.tmdb.org/t/p/w185/" + movie.getPosterPath())
                .placeholder(R.drawable.movie_placeholder)
                .into(holder.movieImageView);

        holder.itemView.setOnClickListener(view -> listener.onMovieClickListener(movie));
    }

    @Override
    public int getItemCount() {
        if(moviesList != null)
            return moviesList.size();
        else
            return 0;
    }


    class MoviesViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.movieImageView)
        ImageView movieImageView;

        public MoviesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }

}
