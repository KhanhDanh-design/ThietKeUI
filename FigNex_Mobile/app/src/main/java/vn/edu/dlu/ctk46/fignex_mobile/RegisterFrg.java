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

public class RegisterFrg extends Fragment {
    private EditText edtUser,edtPass, edtRepass;
    private Button btnDangKy;
    private TextView s;
    private Context mContext;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.register_frg, container, false);
        initView(rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String text = "Đã có tài khoản? Đăng nhập";
        SpannableString spannable = new SpannableString(text);

        spannable.setSpan(new ForegroundColorSpan(Color.parseColor("#EF672D")),
                text.indexOf("Đăng nhập"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        s.setText(spannable);

        s.setOnClickListener(v -> {
            gotoLoginScreen();
        });

        btnDangKy.setOnClickListener(v -> {
            gotoLoginScreen();
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
        edtRepass = v.findViewById(R.id.re_password);
        btnDangKy = v.findViewById(R.id.btn_register);
        s = v.findViewById(R.id.tv_login);
    }

    private void gotoLoginScreen() {
        ((MainActivity) mContext).gotoLoginScreen();
    }
}
