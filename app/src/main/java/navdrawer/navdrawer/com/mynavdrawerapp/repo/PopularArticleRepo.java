package navdrawer.navdrawer.com.mynavdrawerapp.repo;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;

public interface PopularArticleRepo {
    Observable<PopularArticlesResponse> getPopularArticles(String apiKey);
}
