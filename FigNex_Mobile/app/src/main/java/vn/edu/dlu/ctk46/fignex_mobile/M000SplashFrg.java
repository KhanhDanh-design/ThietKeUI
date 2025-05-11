package vn.edu.dlu.ctk46.fignex_mobile;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import vn.edu.dlu.ctk46.fignex_mobile.databinding.M000FrgSplashBinding;

public class M000SplashFrg extends Fragment{
    private M000FrgSplashBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = M000FrgSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        Glide.with(this)
                .load(R.drawable.fignex_1080_2400)
                .into(binding.splashLogo);

        new Handler().postDelayed(() -> {
            // Bắt đầu hiệu ứng fade out
            Animation fadeOut = AnimationUtils.loadAnimation(getContext(), R.anim.fade_out);
            getView().startAnimation(fadeOut);

            fadeOut.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {}

                @Override
                public void onAnimationEnd(Animation animation) {
                    gotoM001Screen();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {}
            });
        },5000);
    }

    private void gotoM001Screen() {
        ((MainActivity) getActivity()).gotoLoginScreen();
    }
}
