package navdrawer.navdrawer.com.mynavdrawerapp.usecase;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;

public interface PopularArticlesUsecase {
    Observable<PopularArticlesResponse> getPopularArticles(String apiKey);

}
