package navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.api;

import io.reactivex.Observable;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface BackendApi {

    @GET("mostviewed/all-sections/7.json")
    Observable<PopularArticlesResponse> getPopularArticles(@Query("api-key") String api_key);

}
