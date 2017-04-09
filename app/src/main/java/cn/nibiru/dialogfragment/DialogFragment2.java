package cn.nibiru.dialogfragment;

import android.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 作者:dick
 * 公司:nibiru
 * 邮箱:dick.zhang@inibiru.com
 * 描述:
 */

public class DialogFragment2 extends DialogFragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog, null);
        return view;
    }

}
