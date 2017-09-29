package coderbd.com.simplealert;

import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Builds a standard alert dialog,
     *    using setTitle to set its title, setMessage to set its message,
     *    and setPositiveButton and setNegativeButton to set its buttons.
     * Defines toast messages to appear depending on which alert
     *    button is clicked.
     * Shows the alert.
     * @param view  The activity's view in which the alert will appear.
     */
    public void onClickShowAlert(View view) {
        //Build the dialog for alert
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(MainActivity.this);
        //set the dialog title
        alertDialog.setTitle(R.string.alert_title);
        //set the dialog the message
        alertDialog.setMessage(R.string.alert_message);
        //add the buttons
        alertDialog.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // if user clicks ok button, then.....
                Toast.makeText(getApplicationContext(),R.string.pressed_ok,Toast.LENGTH_SHORT).show();
            }
        });
        alertDialog.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),R.string.pressed_cancel, Toast.LENGTH_SHORT).show();
            }
        });
        // Create and show the AlertDialog.
        alertDialog.show();

    }
}
