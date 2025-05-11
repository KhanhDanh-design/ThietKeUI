package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import java.util.ArrayList;
import java.util.List;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.M001HomepageFrgBinding;
import vn.edu.dlu.ctk46.fignex_mobile.databinding.MovieDetailBinding;

public class MovieDetailFragment extends Fragment {
    private MovieDetailBinding binding;
    private MovieAdapter adapter, adapter1, adapter2, adapter3;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = MovieDetailBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        binding.btnBack.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        binding.btnPlay.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, new WatchMovieFragment())
                    .addToBackStack(null)
                    .commit();
        });
    }
}
