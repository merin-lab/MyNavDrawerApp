package navdrawer.navdrawer.com.mynavdrawerapp.repo.impl;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.PopularArticleDao;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;

public class PopularArticleRepoImpl implements PopularArticleRepo {
    private PopularArticleDao popularArticleDao;

    public PopularArticleRepoImpl(PopularArticleDao popularArticleDao) {
        this.popularArticleDao = popularArticleDao;
    }

    @Override
    public Observable<PopularArticlesResponse> getPopularArticles(String apiKey) {
        return popularArticleDao.getPopularArticles(apiKey);
    }
}
