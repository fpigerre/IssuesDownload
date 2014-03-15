
package io.github.issuesdownload.androidissues;

import android.accounts.AccountsException;
import android.app.Activity;
import io.github.issuesdownload.androidissues.authenticator.ApiKeyProvider;
import io.github.issuesdownload.androidissues.core.BootstrapService;
import io.github.issuesdownload.androidissues.core.UserAgentProvider;

import javax.inject.Inject;
import java.io.IOException;

/**
 * Provider for a {@link io.github.issuesdownload.androidissues.core.BootstrapService} instance
 */
public class BootstrapServiceProvider {

    @Inject
    ApiKeyProvider keyProvider;
    @Inject
    UserAgentProvider userAgentProvider;

    /**
     * Get service for configured key provider
     * <p/>
     * This method gets an auth key and so it blocks and shouldn't be called on the main thread.
     *
     * @return bootstrap service
     * @throws IOException
     * @throws AccountsException
     */
    public BootstrapService getService(Activity activity) throws IOException, AccountsException {
        return new BootstrapService(keyProvider.getAuthKey(activity), userAgentProvider);
    }
}
