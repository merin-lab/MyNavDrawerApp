package navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;

public interface PopularArticleDao {
    Observable<PopularArticlesResponse> getPopularArticles(String apiKey);

}
