package navdrawer.navdrawer.com.mynavdrawerapp.contract;

import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;

public class PopularArticlesContract {
    public interface PopularArticlesView {

        void showToast(String s);

        void showProgressBar();

        void hideProgressBar();

        void displayPopularArticles(PopularArticlesResponse articlesResponse);

        void displayError(String s);
    }

    public interface PopularArticlePresenter {
        void getPopularArticles();

    }
}
