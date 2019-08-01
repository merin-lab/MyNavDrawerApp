package navdrawer.navdrawer.com.mynavdrawerapp.usecase.impl;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;
import navdrawer.navdrawer.com.mynavdrawerapp.usecase.PopularArticlesUsecase;

public class PopularArticlesUsecaseImpl implements PopularArticlesUsecase {
    private PopularArticleRepo repo;

    public PopularArticlesUsecaseImpl(PopularArticleRepo repo) {
        this.repo = repo;
    }

    @Override
    public Observable<PopularArticlesResponse> getPopularArticles(String apiKey) {
        return repo.getPopularArticles(apiKey);
    }
}
