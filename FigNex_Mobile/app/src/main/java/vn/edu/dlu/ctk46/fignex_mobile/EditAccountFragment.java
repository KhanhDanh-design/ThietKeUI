package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.EditAccountFrgBinding;

public class EditAccountFragment extends Fragment {
    private EditAccountFrgBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate layout using ViewBinding
        binding = EditAccountFrgBinding.inflate(inflater, container, false);

        // Ví dụ: Thiết lập sự kiện cho nút "Lưu"
        binding.btnSave.setOnClickListener(v -> {
            // Hiện thông báo
            Toast.makeText(requireContext(), "Đã lưu thông tin", Toast.LENGTH_SHORT).show();

            // Quay về trang user
            requireActivity().getSupportFragmentManager().popBackStack();

        });

        // Ví dụ: Thiết lập sự kiện cho nút "Huỷ"
        binding.btnCancel.setOnClickListener(v -> {
            // Quay lại hoặc hủy thao tác
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return binding.getRoot();
    }
}