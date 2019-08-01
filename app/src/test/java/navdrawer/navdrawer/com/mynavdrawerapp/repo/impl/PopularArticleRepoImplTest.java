package navdrawer.navdrawer.com.mynavdrawerapp.repo.impl;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.PopularArticleDao;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PopularArticleRepoImplTest {
    private static final String API_KEY = "apikey";

    @Mock
    PopularArticleDao dao;
    PopularArticleRepo repo;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        repo = new PopularArticleRepoImpl(dao);
    }

    @Test
    public void test_onGetPopularArticlesCalled_whenResponseSuccessful_thenVerifyDaoCalled() {

        //given
        PopularArticlesResponse popularArticlesResponse = new PopularArticlesResponse();
        when(dao.getPopularArticles(API_KEY)).thenReturn(Observable.just(popularArticlesResponse));

        //when
        repo.getPopularArticles(API_KEY);

        //then
        verify(dao, times(1)).getPopularArticles(API_KEY);

    }
}
