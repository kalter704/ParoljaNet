package net.parolja.paroljanet;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShowLoginsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_logins);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("site.com");
        toolbar.setSubtitle("Список логинов");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        LoginsAdapter adapter = new LoginsAdapter(this, getTestLogins());

        ((ListView) findViewById(R.id.lvLogins)).setAdapter(adapter);

    }

    public void showSnackBar(String text) {
        Snackbar snackbar = Snackbar.make(
                findViewById(R.id.mainCoordLayout),
                text,
                Snackbar.LENGTH_SHORT);
        View snackView = snackbar.getView();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            snackView.setBackgroundColor(getColor(R.color.colorSnackbarBackground));
        } else {
            snackView.setBackgroundColor(getResources().getColor(R.color.colorSnackbarBackground));
        }
        snackView.findViewById(android.support.design.R.id.snackbar_text).setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        ((TextView) snackView.findViewById(android.support.design.R.id.snackbar_text)).setTextSize(18);
        snackbar.show();
    }

    private List<Login> getTestLogins() {
        List<Login> logins = new ArrayList<Login>() {{
            add(new Login("qwdasd@mail.ru", "fwfgaw312", 65, true));
            add(new Login("nbfjg31@yandex.ru", "jkdrtyj5", 40, false));
            add(new Login("76vsd@rambler.ru", "ge4gd", 80, true));
            add(new Login("gmailil@gmain.com", "begh3", 15, false));
            add(new Login("vzsdv@mail.ru", "bert34", 10, false));
            add(new Login("89ybjh@mail.ru", "her342", 92, true));
        }};
        return logins;
    }
}
