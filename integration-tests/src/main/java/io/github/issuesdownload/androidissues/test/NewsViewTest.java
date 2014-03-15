

package io.github.issuesdownload.androidissues.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import io.github.issuesdownload.androidissues.core.News;
import io.github.issuesdownload.androidissues.ui.CarouselActivity;

import static io.github.issuesdownload.androidissues.core.Constants.Extra.NEWS_ITEM;


/**
 * Tests for displaying a specific {@link News} item
 */
public class NewsViewTest extends ActivityInstrumentationTestCase2<CarouselActivity> {

    /**
     * Create test for {@link io.github.issuesdownload.androidissues.ui.CarouselActivity}
     */
    public NewsViewTest() {
        super(CarouselActivity.class);
    }

    /**
     * Configure intent used to display a {@link News}
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent intent = new Intent();
        // TODO: BUILD News item for testing.
        News news = new News();
        news.setTitle("Foo");
        news.setObjectId("Bar");
        intent.putExtra(NEWS_ITEM, news);
        setActivityIntent(intent);
    }

    /**
     * Verify activity exists
     */
    public void testActivityExists() {
        assertNotNull(getActivity());
    }
}
