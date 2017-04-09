package cn.nibiru.dialogfragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginDialog
        .loginInputListener {

    private Button btn;
    private Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        btn2 = (Button) findViewById(R.id.btn2);
        Button btn3 = (Button) findViewById(R.id.btn3);
        Button btn4 = (Button) findViewById(R.id.btn4);
        btn3.setOnClickListener(this);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn4.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                DialogFragmentActivity dialog = new DialogFragmentActivity();
                dialog.show(getFragmentManager(), "zkk");
                break;
            case R.id.btn2:
                DialogFragment2 dialogFragment2 = new DialogFragment2();
                dialogFragment2.show(getFragmentManager(), "zkk3");
                break;
            case R.id.btn3:
                LoginDialog loginDialog = new LoginDialog();
                loginDialog.show(getFragmentManager(), "zkk3");
                break;
            case R.id.btn4:
                showDialog();
                break;
        }
    }

    @Override
    public void onLoginInputComplete(String username, String password) {
        Toast.makeText(this, "账号:" + username + "密码:" + password, Toast.LENGTH_SHORT).show();
    }

    public void showDialog() {

        FragmentManager fragmentManager = getFragmentManager();
        DialogFragment2 dialog = new DialogFragment2();
        boolean islargeLayout = getResources().getBoolean(R.bool.large_layout);
        if (islargeLayout) {
            dialog.show(fragmentManager, "zkk3");
        } else {

            FragmentTransaction transaction = fragmentManager.beginTransaction();
            //设置一个动画
            transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
            transaction.replace(R.id.id_ly, dialog);
            transaction.commit();
        }
    }
}
