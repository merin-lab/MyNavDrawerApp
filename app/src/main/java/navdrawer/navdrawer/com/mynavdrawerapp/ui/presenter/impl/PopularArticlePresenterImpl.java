package navdrawer.navdrawer.com.mynavdrawerapp.ui.presenter.impl;


import android.util.Log;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;
import navdrawer.navdrawer.com.mynavdrawerapp.common.constant.Constants;
import navdrawer.navdrawer.com.mynavdrawerapp.contract.PopularArticlesContract;
import navdrawer.navdrawer.com.mynavdrawerapp.dataaccess.network.dto.PopularArticlesResponse;
import navdrawer.navdrawer.com.mynavdrawerapp.repo.PopularArticleRepo;


public class PopularArticlePresenterImpl implements PopularArticlesContract.PopularArticlePresenter {

    PopularArticlesContract.PopularArticlesView view;
    private String TAG = "PopularArticlePresenterImpl";
    private PopularArticleRepo repo;
    DisposableObserver<PopularArticlesResponse> disposableObserver;

    public PopularArticlePresenterImpl(PopularArticleRepo repo) {
        this.repo = repo;
    }

    public void setView(PopularArticlesContract.PopularArticlesView view) {
        this.view = view;
    }

    @Override
    public void getPopularArticles() {
        DisposableObserver<PopularArticlesResponse> callback = getObserver();
        disposableObserver = repo.getPopularArticles(Constants.API_KEY)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(callback);
    }

    public DisposableObserver<PopularArticlesResponse> getObserver() {
        if (view != null) {
            view.showProgressBar();
        }
        return new DisposableObserver<PopularArticlesResponse>() {

            @Override
            public void onNext(@NonNull PopularArticlesResponse popularArticleResponse) {
                Log.d(TAG, "OnNext" + popularArticleResponse.getNumResults());
                view.displayPopularArticles(popularArticleResponse);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                Log.d(TAG, "Error" + e);
                e.printStackTrace();
                view.displayError("Error fetching Data");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "Completed");
                view.hideProgressBar();
            }
        };
    }

}
