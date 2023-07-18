package jp.suntech.s22027.myconstraintlayoutsample;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.DialogFragment;



public class OrderConfirmDialogFragment extends DialogFragment{
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.dialog_title);

        builder.setMessage(R.string.dialog_msg);

        builder.setPositiveButton(R.string.dialog_btn_ok, new DialogButtonClickListener());
        builder.setNegativeButton(R.string.dialog_btn_ng, new DialogButtonClickListener());
        AlertDialog dialog = builder.create();
        return dialog;

    }

    public class DialogButtonClickListener implements DialogInterface.OnClickListener {
        @Override

        public void onClick(DialogInterface dialog, int which) {
            EditText comment = getActivity().findViewById(R.id.etComment);
            EditText name = getActivity().findViewById(R.id.etName);
            EditText title = getActivity().findViewById(R.id.etMail);
            EditText mail = getActivity().findViewById(R.id.etMailtitle);
            String mailStr = mail.getText().toString();
            String titleStr = title.getText().toString();
            String nameStr = name.getText().toString();
            String commentStr = comment.getText().toString();
            String show = "送信しました" +nameStr + "," + titleStr + "," + mailStr + "," + commentStr;
            String msg = "";

            switch (which) {
                case DialogInterface.BUTTON_POSITIVE:

                    msg = show;

                    break;
                case DialogInterface.BUTTON_NEGATIVE:

                    msg = getString(R.string.dialog_ng_toast);

                    break;
            }
            Toast.makeText(getActivity(), msg, Toast.LENGTH_LONG).show();
        }
    }
}