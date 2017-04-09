package cn.nibiru.dialogfragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * 作者:dick
 * 公司:nibiru
 * 邮箱:dick.zhang@inibiru.com
 * 描述:
 */

public class LoginDialog extends DialogFragment {

    private EditText username;
    private EditText password;

    public interface loginInputListener {
        void onLoginInputComplete(String username, String password);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.login, null);

        username = (EditText) view.findViewById(R.id.et_username);
        password = (EditText) view.findViewById(R.id.password);
        builder.setView(view).setPositiveButton("sign in", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                loginInputListener listener = (loginInputListener) getActivity();
                listener.onLoginInputComplete(username.getText().toString().trim(), password
                        .getText().toString().trim());
            }
        }).setNegativeButton("Cancel", null);
        return builder.create();
    }


}
