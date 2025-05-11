package vn.edu.dlu.ctk46.fignex_mobile;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Locale;


public class WatchMovieFragment extends Fragment {

    private VideoView videoView;
    private SeekBar seekBar;
    private TextView tvCurrentTime, tvDuration;
    private ImageButton btnPlayPause, btnForward, btnRewind, btnExit;

    private Handler handler = new Handler();
    private Runnable updateSeekBar;

    private boolean isPlaying = false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_watch_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        videoView = view.findViewById(R.id.videoView);
        seekBar = view.findViewById(R.id.seekBar);
        tvCurrentTime = view.findViewById(R.id.tvCurrentTime);
        tvDuration = view.findViewById(R.id.tvDuration);
        btnPlayPause = view.findViewById(R.id.btnPlayPause);
        btnForward = view.findViewById(R.id.btnForward);
        btnRewind = view.findViewById(R.id.btnRewind);

        // Thêm nút thoát (nếu bạn đã thêm vào layout)
        btnExit = new ImageButton(getContext());
        btnExit.setImageResource(android.R.drawable.ic_menu_close_clear_cancel);
        btnExit.setBackgroundColor(Color.TRANSPARENT);
        btnExit.setColorFilter(Color.WHITE);
        FrameLayout.LayoutParams exitParams = new FrameLayout.LayoutParams(
                100, 100, Gravity.TOP | Gravity.END);
        exitParams.setMargins(16, 16, 16, 16);
        ((FrameLayout) view).addView(btnExit, exitParams);

        btnExit.setOnClickListener(v -> requireActivity().onBackPressed());

        // Video sample từ raw folder
        String path = "android.resource://" + requireContext().getPackageName() + "/" + R.raw.test;
        videoView.setVideoURI(Uri.parse(path));

        videoView.setOnPreparedListener(mp -> {
            seekBar.setMax(videoView.getDuration());
            tvDuration.setText(formatTime(videoView.getDuration()));
            playVideo();
        });

        btnPlayPause.setOnClickListener(v -> {
            if (videoView.isPlaying()) {
                pauseVideo();
            } else {
                playVideo();
            }
        });

        btnForward.setOnClickListener(v -> {
            int current = videoView.getCurrentPosition();
            videoView.seekTo(Math.min(current + 10000, videoView.getDuration()));
        });

        btnRewind.setOnClickListener(v -> {
            int current = videoView.getCurrentPosition();
            videoView.seekTo(Math.max(current - 10000, 0));
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) videoView.seekTo(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Cập nhật thời gian
        updateSeekBar = new Runnable() {
            @Override
            public void run() {
                if (videoView != null && videoView.isPlaying()) {
                    seekBar.setProgress(videoView.getCurrentPosition());
                    tvCurrentTime.setText(formatTime(videoView.getCurrentPosition()));
                    handler.postDelayed(this, 500);
                }
            }
        };
    }

    private void playVideo() {
        videoView.start();
        isPlaying = true;
        btnPlayPause.setImageResource(android.R.drawable.ic_media_pause);
        handler.post(updateSeekBar);
    }

    private void pauseVideo() {
        videoView.pause();
        isPlaying = false;
        btnPlayPause.setImageResource(android.R.drawable.ic_media_play);
        handler.removeCallbacks(updateSeekBar);
    }

    private String formatTime(int milliseconds) {
        int minutes = milliseconds / 60000;
        int seconds = (milliseconds % 60000) / 1000;
        return String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        handler.removeCallbacks(updateSeekBar);
    }
    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("current_position", videoView.getCurrentPosition());
        outState.putBoolean("is_playing", videoView.isPlaying());
    }
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        if (savedInstanceState != null) {
            int position = savedInstanceState.getInt("current_position", 0);
            boolean wasPlaying = savedInstanceState.getBoolean("is_playing", false);

            videoView.seekTo(position);
            if (wasPlaying) {
                videoView.start();
                btnPlayPause.setImageResource(android.R.drawable.ic_media_pause);
            } else {
                btnPlayPause.setImageResource(android.R.drawable.ic_media_play);
            }
        }
    }
}


