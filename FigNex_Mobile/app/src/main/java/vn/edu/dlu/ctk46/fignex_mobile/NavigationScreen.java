package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.NavigationScreenBinding;

public class NavigationScreen extends Fragment {
    private final Fragment m0001MainFrg = new M001HomePageFrg();
    private final Fragment m0002Library1Frg = new M002UserFrg();
    private NavigationScreenBinding binding;
    private Fragment activeFragment = m0001MainFrg;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = NavigationScreenBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        FragmentManager fm = getChildFragmentManager();
        fm.beginTransaction()
                .add(R.id.frame_container, m0002Library1Frg, "2").hide(m0002Library1Frg)
                .add(R.id.frame_container, m0001MainFrg, "1")
                .commit();

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.nav_home) {
                fm.beginTransaction().hide(activeFragment).show(m0001MainFrg).commit();
                activeFragment = m0001MainFrg;
                return true;
            } else if (id == R.id.nav_user) {
                fm.beginTransaction().hide(activeFragment).show(m0002Library1Frg).commit();
                activeFragment = m0002Library1Frg;
                return true;
            }
            return false;
        });
    }
}
