package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;
import java.util.List;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.M001HomepageFrgBinding;

public class M001HomePageFrg extends Fragment{
    private M001HomepageFrgBinding binding;
    private MovieAdapter adapter, adapter1, adapter2, adapter3;
    private List<Integer> imageList, vnList, hrList, animeList;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M001HomepageFrgBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        imageList = new ArrayList<>();
        imageList.add(R.drawable.nowayhome);

        animeList = new ArrayList<>();
        animeList.add(R.drawable.jujutsu_kaisen);
        animeList.add(R.drawable.demon_slayer);
        animeList.add(R.drawable.bonk);
        animeList.add(R.drawable.design);

        vnList = new ArrayList<>();
        vnList.add(R.drawable.phim2);

        hrList = new ArrayList<>();
        hrList.add(R.drawable.phim1);
        hrList.add(R.drawable.phim3);
        hrList.add(R.drawable.phim4);

// Gán adapter cho từng RecyclerView
        binding.recyclerTrending.setAdapter(null);
        adapter = setupRecycler(binding.recyclerTrending, imageList);
        adapter2 = setupRecycler(binding.recyclerAnime, animeList);
        adapter1 = setupRecycler(binding.recyclerVietnam, vnList);
        adapter3 = setupRecycler(binding.recycleKinhDi, hrList);

        binding.btnNoti.setOnClickListener(v -> {
            BottomSheetDialog dialog = new BottomSheetDialog(requireContext());
            View sheetView = LayoutInflater.from(getContext()).inflate(R.layout.layout_notifications, null);
            dialog.setContentView(sheetView);
            dialog.show();
        });

        binding.btnDown.setOnClickListener(v -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, new DownLoadFrg())
                    .addToBackStack(null)
                    .commit();
        });
    }
    private MovieAdapter setupRecycler(RecyclerView recyclerView, List<Integer> imageList) {
        GridLayoutManager layoutManager = new GridLayoutManager(
                getContext(),
                1,
                GridLayoutManager.HORIZONTAL,
                false
        );
        recyclerView.setLayoutManager(layoutManager);

        MovieAdapter adapter = new MovieAdapter(imageList, imageResId -> {
            requireActivity()
                    .getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.frame_container, new MovieDetailFragment())
                    .addToBackStack(null)
                    .commit();
        });

        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        return adapter;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
