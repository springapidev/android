package coderbd.com.ex01_simplecounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private int mCount=0;
    private TextView mShowCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mShowCount=(TextView)findViewById(R.id.show_count);
    }

    public void countUp(View view){
        mCount++;
        if(mCount != 0){
            mShowCount.setText(Integer.toString(mCount));
        }

    }

    public void showToast(View view){
        Toast toast= Toast.makeText(this, R.string.toast_button_toast,Toast.LENGTH_LONG);
        toast.show();
    }
}
