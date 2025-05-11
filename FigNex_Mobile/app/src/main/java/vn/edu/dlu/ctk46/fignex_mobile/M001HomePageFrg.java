package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.M001HomepageFrgBinding;

public class M001HomePageFrg extends Fragment{
    private M001HomepageFrgBinding binding;
    private MovieAdapter adapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M001HomepageFrgBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        List<Integer> imageList = new ArrayList<>();
        imageList.add(R.drawable.nowayhome);

        // Cấu hình RecyclerView
        GridLayoutManager movieManager = new GridLayoutManager(
                getContext(),
                1, // số dòng muốn hiển thị
                GridLayoutManager.HORIZONTAL, // cuộn ngang
                false
        );

        binding.recyclerTrending.setLayoutManager(movieManager);
        adapter = new MovieAdapter(imageList);
        binding.recyclerTrending.setAdapter(adapter);
    }
}
