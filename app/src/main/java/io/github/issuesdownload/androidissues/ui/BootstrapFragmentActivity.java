package io.github.issuesdownload.androidissues.ui;

import android.os.Bundle;
import butterknife.Views;
import com.actionbarsherlock.app.SherlockFragmentActivity;
import io.github.issuesdownload.androidissues.Injector;

/**
 * Base class for all Bootstrap Activities that need fragments.
 */
public class BootstrapFragmentActivity extends SherlockFragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Injector.inject(this);
    }

    @Override
    public void setContentView(int layoutResId) {
        super.setContentView(layoutResId);

        Views.inject(this);
    }

}
