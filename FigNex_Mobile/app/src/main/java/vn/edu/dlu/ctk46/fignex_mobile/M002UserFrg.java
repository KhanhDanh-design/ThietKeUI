package vn.edu.dlu.ctk46.fignex_mobile;

import android.content.Context;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupMenu;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.M001HomepageFrgBinding;
import vn.edu.dlu.ctk46.fignex_mobile.databinding.M002FrgUserFrgBinding;

public class M002UserFrg extends Fragment {
    private M002FrgUserFrgBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M002FrgUserFrgBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView menuButton = view.findViewById(R.id.menu);
        Context wrapper = new ContextThemeWrapper(requireContext(), R.style.PopupMenuStyle);
        binding.back.setOnClickListener(v -> {
            requireActivity().getSupportFragmentManager().popBackStack();
        });
        menuButton.setOnClickListener(v -> {
            PopupMenu popup = new PopupMenu(wrapper, v);
            popup.getMenuInflater().inflate(R.menu.menu_options, popup.getMenu());
            popup.setOnMenuItemClickListener(item -> {
                if (item.getItemId() == R.id.menu_edit_account) {
                    FragmentTransaction transaction = requireActivity()
                            .getSupportFragmentManager()
                            .beginTransaction();
                    transaction.replace(R.id.frame_container, new EditAccountFragment());
                    transaction.addToBackStack(null);
                    transaction.commit();
                    return true;
                } else if (item.getItemId() == R.id.menu_logout) {
                    // Xoá toàn bộ back stack
                    requireActivity().getSupportFragmentManager().popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);

                    // Chuyển về màn hình đăng nhập
                    requireActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.ln_main, new LoginFrg())
                            .commit();
                    return true;
                }
                return false;
            });
            popup.show();
        });
        binding.btnsuggest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, new FilmLikedAndSuggestFrg());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        binding.btnlike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, new FilmLikedAndSuggestFrg());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        binding.search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = requireActivity()
                        .getSupportFragmentManager()
                        .beginTransaction();
                transaction.replace(R.id.frame_container, new SearchFrg());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }

}
