package navdrawer.navdrawer.com.mynavdrawerapp.usecase.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;
import navdrawer.navdrawer.com.mynavdrawerapp.usecase.PopularArticlesUsecase;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PopularArticlesUsecaseImplTest {
    private static final String API_KEY = "apikey";

    @Mock
    PopularArticleRepo repo;
    PopularArticlesUsecase popularArticlesUsecase;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        popularArticlesUsecase = new PopularArticlesUsecaseImpl(repo);
    }

    @Test
    public void test_onGetPopularArticlesCalled_whenResponseSuccessful_thenVerifyRepoCalled() {

        //given
        PopularArticlesResponse popularArticlesResponse = new PopularArticlesResponse();
        when(repo.getPopularArticles(API_KEY)).thenReturn(Observable.just(popularArticlesResponse));

        //when
        popularArticlesUsecase.getPopularArticles(API_KEY);

        //then
        verify(repo, times(1)).getPopularArticles(API_KEY);

    }
}
