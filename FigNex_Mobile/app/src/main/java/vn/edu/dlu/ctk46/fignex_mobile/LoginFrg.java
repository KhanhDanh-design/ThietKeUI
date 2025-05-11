package vn.edu.dlu.ctk46.fignex_mobile;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class LoginFrg extends Fragment {
    private EditText edtUser,edtPass;
    private Button btnDangKy;
    private TextView s;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.login_frg, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String text = "Chưa có tài khoản? Đăng kí";
        SpannableString spannable = new SpannableString(text);

        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#EF672D")),
                text.indexOf("Đăng kí"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        s.setText(spannable);

        s.setOnClickListener(v -> {
            gotoRegisterScreen();
        });

        btnDangKy.setOnClickListener(v -> {
            gotoMainScreen();
        });

    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        mContext = context;
    }
    private void initView(View v) {
        edtUser = v.findViewById(R.id.username);
        edtPass = v.findViewById(R.id.password);
        btnDangKy = v.findViewById(R.id.btn_register);
        s = v.findViewById(R.id.tv_login);
    }

    private void gotoRegisterScreen() {
        ((MainActivity) mContext).gotoRegisterScreen();
    }

    private void gotoMainScreen() {
        ((MainActivity) mContext).gotoMainScreen();
    }
}
