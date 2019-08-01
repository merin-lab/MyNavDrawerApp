package navdrawer.navdrawer.com.mynavdrawerapp.ui.presenter.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;

import io.reactivex.Observable;
import io.reactivex.android.plugins.RxAndroidPlugins;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;
import navdrawer.navdrawer.com.mynavdrawerapp.contract.PopularArticlesContract;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.usecase.PopularArticlesUsecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricTestRunner.class)
public class PopularArticlePresenterImplTest {
    private static final String API_KEY = "apikey";

    @Mock
    PopularArticlesUsecase popularArticlesUsecase;
    @Mock
    PopularArticlesContract.PopularArticlesView popularArticlesView;

    PopularArticlesContract.PopularArticlePresenter popularArticlePresenter;

    @Before
    public void setUp() throws Exception {


        MockitoAnnotations.initMocks(this);
        RxJavaPlugins.reset();
        RxAndroidPlugins.reset();

        RxJavaPlugins.setIoSchedulerHandler(scheduler -> Schedulers.trampoline());

        RxAndroidPlugins.setMainThreadSchedulerHandler(scheduler -> Schedulers.trampoline());

        popularArticlePresenter = new PopularArticlePresenterImpl(popularArticlesUsecase);
        popularArticlePresenter.setView(popularArticlesView);
    }

    @Test
    public void test_onGetPopularArticlesCalled_whenResponseSuccessful_thenCallDisplayPopularArticles() {

        //given
        PopularArticlesResponse popularArticlesResponse = new PopularArticlesResponse();
        popularArticlesResponse.setNumResults(10);
        popularArticlesResponse.setStatus("Success");

        when(popularArticlesUsecase.getPopularArticles(API_KEY)).thenReturn(Observable.just(popularArticlesResponse));

        //when
        popularArticlePresenter.getPopularArticles();

        //then
        verify(popularArticlesView, times(1)).displayPopularArticles(popularArticlesResponse);

    }

    @Test
    public void test_onGetPopularArticlesCalled_whenResponseFail_thenCallOnError() {

        //given

        Exception appException = new Exception();
        when(popularArticlesUsecase.getPopularArticles(API_KEY)).thenReturn(Observable.<PopularArticlesResponse>error(appException));

        //when
        popularArticlePresenter.getPopularArticles();

        //then
        verify(popularArticlesView, times(1)).displayError("Error");

    }
}
