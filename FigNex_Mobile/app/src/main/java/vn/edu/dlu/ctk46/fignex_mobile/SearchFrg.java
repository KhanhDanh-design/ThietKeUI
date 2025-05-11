package vn.edu.dlu.ctk46.fignex_mobile;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


import vn.edu.dlu.ctk46.fignex_mobile.databinding.SearchFrgBinding;
public class SearchFrg extends Fragment{
    private SearchFrgBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout using ViewBinding
        binding = SearchFrgBinding.inflate(inflater, container, false);
        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Hiện loading
                binding.loading.setVisibility(View.VISIBLE);
                binding.Hide.setVisibility(View.GONE);

                // Delay 1.5 giây (giả lập đang tìm kiếm)
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Ẩn loading và hiện kết quả
                        binding.loading.setVisibility(View.GONE);
                        binding.Hide.setVisibility(View.VISIBLE);
                    }
                }, 1500); // 1500ms = 1.5s
            }
        });
        return binding.getRoot();
    }


}
