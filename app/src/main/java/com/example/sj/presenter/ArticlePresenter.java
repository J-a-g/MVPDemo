package com.example.sj.presenter;

import com.example.sj.interfaces.ArticleViewInterface;
import com.example.sj.model.ArticleModelInterface;
import com.example.sj.modelImpl.ArticleModelImpl;

/**
 * Created by SJ on 2016.10.30.
 */

public class ArticlePresenter {

    ArticleViewInterface mArticleView;
    ArticleModelInterface mArticleModel = new ArticleModelImpl();

    //ArticleAPI mArticleApi = new ArticleAPIImpl();

    public ArticlePresenter(ArticleViewInterface viewInterface){
        mArticleView = viewInterface;
    }
    //获取文章，也就是我们的业务逻辑
    public void fetchArticles(){
        mArticleView.showLoading();

        mArticleView.showArticlesInitView(mArticleModel.loadArticleFromStr1());

        mArticleView.hideLoading();


    }

    public void loadArticleFromDB(int i ){
        mArticleView.setTextViewData(mArticleModel.loadArticlesFromStr2(i));
    }

}
