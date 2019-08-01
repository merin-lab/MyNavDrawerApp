package navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.impl;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.PopularArticleDao;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.api.BackendApi;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.util.RetrofitUtil;

public class PopularArticleDaoImpl implements PopularArticleDao {
    @Override
    public Observable<PopularArticlesResponse> getPopularArticles(String apiKey) {
         return RetrofitUtil.getRetrofit().create(BackendApi.class)
                .getPopularArticles(apiKey)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
