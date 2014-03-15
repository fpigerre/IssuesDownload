package io.github.issuesdownload.androidissues;

import android.accounts.AccountManager;
import android.content.Context;
import com.squareup.otto.Bus;
import dagger.Module;
import dagger.Provides;
import io.github.issuesdownload.androidissues.authenticator.BootstrapAuthenticatorActivity;
import io.github.issuesdownload.androidissues.authenticator.LogoutService;
import io.github.issuesdownload.androidissues.core.TimerService;
import io.github.issuesdownload.androidissues.ui.*;

import javax.inject.Singleton;

/**
 * Dagger module for setting up provides statements.
 * Register all of your entry points below.
 */
@Module
        (
                complete = false,

                injects = {
                        BootstrapApplication.class,
                        BootstrapAuthenticatorActivity.class,
                        CarouselActivity.class,
                        BootstrapTimerActivity.class,
                        CheckInsListFragment.class,
                        NewsActivity.class,
                        NewsListFragment.class,
                        UserActivity.class,
                        UserListFragment.class,
                        TimerService.class
                }

        )
public class BootstrapModule {

    @Singleton
    @Provides
    Bus provideOttoBus() {
        return new Bus();
    }

    @Provides
    @Singleton
    LogoutService provideLogoutService(final Context context, final AccountManager accountManager) {
        return new LogoutService(context, accountManager);
    }

}
