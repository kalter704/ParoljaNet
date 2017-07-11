package net.parolja.paroljanet;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class AddLoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Новый логин");
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        findViewById(R.id.btnClear).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((EditText) findViewById(R.id.edtDomain)).setText("");
                ((EditText) findViewById(R.id.edtLogin)).setText("");
                ((EditText) findViewById(R.id.edtPassword)).setText("");
            }
        });

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar("Логин добавлен! Спасибо!");
            }
        });
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

}
