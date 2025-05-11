package vn.edu.dlu.ctk46.fignex_mobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private final List<Integer> movieImageList; // Danh sách ID của hình ảnh cục bộ trong drawable
    private OnMovieClickListener listener;

    public interface OnMovieClickListener {
        void onMovieClick(int imageResId);
    }

    public MovieAdapter(List<Integer> imageList, OnMovieClickListener listener) {
        this.movieImageList = imageList;
        this.listener = listener;
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_movies, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        int imageResId = movieImageList.get(position);
        Glide.with(holder.itemView.getContext())
                .load(imageResId)
                .placeholder(R.drawable.placeholder)// Load ảnh từ drawable
                .into(holder.imageView);  // Set ảnh vào ImageView
        holder.itemView.setOnClickListener(v -> {
            if (listener != null) {
                listener.onMovieClick(imageResId);
            }
        });
    }

    @Override
    public int getItemCount() {
        return (movieImageList != null) ? movieImageList.size() : 0;
    }

    // ViewHolder để giữ các view cho mỗi item trong RecyclerView
    public static class MovieViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.img); // Gán ImageView từ layout
        }
    }
}

