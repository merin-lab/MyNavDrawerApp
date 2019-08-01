package navdrawer.navdrawer.com.mynavdrawerapp;

import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.PopularArticleDao;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.impl.PopularArticleDaoImpl;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.impl.PopularArticleRepoImpl;
import navdrawer.navdrawer.com.mynavdrawerapp.ui.presenter.impl.PopularArticlePresenterImpl;
import navdrawer.navdrawer.com.mynavdrawerapp.usecase.PopularArticlesUsecase;
import navdrawer.navdrawer.com.mynavdrawerapp.usecase.impl.PopularArticlesUsecaseImpl;

public class PresenterFactory {

    public static PopularArticlePresenterImpl createMainPresenter() {
        PopularArticleDao popularArticleDao = new PopularArticleDaoImpl();
        PopularArticleRepo repo = new PopularArticleRepoImpl(popularArticleDao);
        PopularArticlesUsecase usecase = new PopularArticlesUsecaseImpl(repo);
        return new PopularArticlePresenterImpl(usecase);
    }
}
