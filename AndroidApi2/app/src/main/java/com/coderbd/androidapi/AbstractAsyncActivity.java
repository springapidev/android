package com.coderbd.androidapi;
import android.app.Activity;
import android.app.ProgressDialog;
/**
 * Created by Rajail Islam on 11/26/2017.
 */



/**
 * @author Roy Clarkson
 * @author Pierre-Yves Ricau
 */
public abstract class AbstractAsyncActivity extends Activity {

    protected static final String TAG = AbstractAsyncActivity.class.getSimpleName();

    private ProgressDialog progressDialog;

    private boolean destroyed = false;

    // ***************************************
    // Activity methods
    // ***************************************
    @Override
    protected void onDestroy() {
        super.onDestroy();
        destroyed = true;
    }

    // ***************************************
    // Public methods
    // ***************************************
    public void showLoadingProgressDialog() {
        this.showProgressDialog("Loading. Please wait...");
    }

    public void showProgressDialog(CharSequence message) {
        if (progressDialog == null) {
            progressDialog = new ProgressDialog(this);
            progressDialog.setIndeterminate(true);
        }

        progressDialog.setMessage(message);
        progressDialog.show();
    }

    public void dismissProgressDialog() {
        if (progressDialog != null && !destroyed) {
            progressDialog.dismiss();
        }
    }

}