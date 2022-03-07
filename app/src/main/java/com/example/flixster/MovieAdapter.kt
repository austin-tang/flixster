package com.example.flixster

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import jp.wasabeef.glide.transformations.BlurTransformation
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

const val MOVIE_EXTRA = "MOVIE_EXTRA"
class MovieAdapter(private val context: Context, private val movies: List<Movie>)
    : RecyclerView.Adapter<MovieAdapter.ViewHolder>()
{
    val orientation = context.resources.configuration.orientation

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movies[position]
        holder.bind(movie)
    }

    override fun getItemCount() = movies.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnClickListener {

        private val ivPoster = itemView.findViewById<ImageView>(R.id.ivPoster)
        private val tvTitle = itemView.findViewById<TextView>(R.id.tvTitle)
        private val tvOverview = itemView.findViewById<TextView>(R.id.tvOverview)
        private val ivPlayButton = itemView.findViewById<ImageView>(R.id.ivPlayButton)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(movie: Movie) {
            tvTitle.text = movie.title
            tvOverview.text = movie.overview
            val radius = 15;
            val margin = 0;

            if (orientation == Configuration.ORIENTATION_PORTRAIT) {
                Glide.with(context)
                    .load(movie.posterImageUrl)
                    .placeholder(R.drawable.poster_loading)
                    .error(R.drawable.poster_not_found)
                    .centerCrop()
                    .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(radius, margin)))
                    .into(ivPoster)
            }
            else {
                Glide.with(context)
                    .load(movie.backdropImageUrl)
                    .placeholder(R.drawable.poster_loading_land)
                    .error(R.drawable.poster_not_found_land)
                    .apply(RequestOptions.bitmapTransform(RoundedCornersTransformation(radius, margin)))
                    .into(ivPoster)
            }
            if (movie.voteAverage <= 5.0) {
                ivPlayButton.visibility = View.INVISIBLE
            }
        }

        override fun onClick(p0: View?) {
            // get notified of the movie clicked
            val movie = movies[adapterPosition]

            // use the intent system to navigate to the new activity
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra("MOVIE_EXTRA", movie)
            context.startActivity(intent)
        }
    }
}
