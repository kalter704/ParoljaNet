package net.parolja.paroljanet;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class LoginsAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    private Context mContext;
    private List<Login> mLogins;

    public LoginsAdapter(Context context, List<Login> logins) {
        mContext = context;
        mLogins = logins;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mLogins.size();
    }

    @Override
    public Object getItem(int i) {
        return mLogins.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mInflater.inflate(R.layout.item_logins_list, viewGroup, false);
        }

        Login login = mLogins.get(i);
        ((TextView) view.findViewById(R.id.tvLogin)).setText(login.getLogin());
        ((TextView) view.findViewById(R.id.tvPassword)).setText(login.getPassword());
        view.findViewById(R.id.tvLogin).setTag(i);
        view.findViewById(R.id.tvPassword).setTag(i);
        view.findViewById(R.id.tvLogin).setOnClickListener(mLoginOnClickListener);
        view.findViewById(R.id.tvPassword).setOnClickListener(mPasswordOnClickListener);

        view.findViewById(R.id.btnYes).setTag(i);
        view.findViewById(R.id.btnNo).setTag(i);
        view.findViewById(R.id.btnYes).setOnClickListener(mYesOnClickListener);
        view.findViewById(R.id.btnNo).setOnClickListener(mNoOnClickListener);

        TextView tvPercent = view.findViewById(R.id.tvPercent);
        String success = "Шанс успеха ";
        if (login.isMore()) {
            success += ">";
            tvPercent.setTextColor(mContext.getResources().getColor(R.color.colorGreenText));
        } else {
            success += "<";
            tvPercent.setTextColor(mContext.getResources().getColor(R.color.colorRedText));
        }
        success += " " + String.valueOf(login.getPercent()) + "%";
        tvPercent.setText(success);

        return view;
    }

    private View.OnClickListener mLoginOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", mLogins.get((Integer) view.getTag()).getLogin());
            clipboard.setPrimaryClip(clip);
            ((ShowLoginsActivity) mContext).showSnackBar("Логин скопирован!");
        }
    };

    private View.OnClickListener mPasswordOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ClipboardManager clipboard = (ClipboardManager) mContext.getSystemService(Context.CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText("", mLogins.get((Integer) view.getTag()).getPassword());
            clipboard.setPrimaryClip(clip);
            ((ShowLoginsActivity) mContext).showSnackBar("Пароль скопирован!");
        }
    };

    private View.OnClickListener mYesOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            view.getTag();
            ((ShowLoginsActivity) mContext).showSnackBar("Спасибо <3");
        }
    };

    private View.OnClickListener mNoOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            view.getTag();
            ((ShowLoginsActivity) mContext).showSnackBar("Мы это скоро исправим!");
        }
    };
}
