package jp.suntech.s22027.myconstraintlayoutsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btsend = findViewById(R.id.btSend);

        HelloListener listener = new HelloListener();

        btsend.setOnClickListener(listener);

        Button btclear = findViewById(R.id.btClear);

        btclear.setOnClickListener(listener);

        Button btconfirm = findViewById(R.id.btConfirm);

        btconfirm.setOnClickListener(listener);

    }

    private class HelloListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            OrderConfirmDialogFragment dialogFragment = new OrderConfirmDialogFragment();

            int id = view.getId();

            EditText inputcomment = findViewById(R.id.etComment);

            EditText inputname = findViewById(R.id.etName);

            EditText inputtitle = findViewById(R.id.etMail);

            EditText inputmail = findViewById(R.id.etMailtitle);

            String inputcommentStr = inputcomment.getText().toString();

            String inputnameStr = inputname.getText().toString();

            String inputtitleStr = inputtitle.getText().toString();

            String inputmailStr = inputmail.getText().toString();

            String show = inputnameStr + "," + inputtitleStr + "," + inputmailStr + "," + inputcommentStr;

            if(id==R.id.btSend) {
                Snackbar.make(view, "送信しました   " + inputnameStr + "," + inputtitleStr + "," + inputmailStr + "," + inputcommentStr, Snackbar.LENGTH_LONG).show();
            }else if(id == R.id.btClear){
                inputname.setText("");
                inputtitle.setText("");
                inputmail.setText("");
                inputcomment.setText("");
            }else if(id == R.id.btConfirm){
                dialogFragment.show(getSupportFragmentManager(),"OrderConfirmDialogFragment");
            }
        }
    }
}