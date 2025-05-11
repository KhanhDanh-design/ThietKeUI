package vn.edu.dlu.ctk46.fignex_mobile;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.FilmLikedFrgBinding;
public class FilmLikedAndSuggestFrg  extends Fragment {
    private FilmLikedFrgBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout using ViewBinding
        binding = FilmLikedFrgBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

}
