package com.example.sj.mydemo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sj.BaseImpl.MVPBaseActivity;
import com.example.sj.interfaces.ArticleViewInterface;
import com.example.sj.presenter.ArticlePresenterV2;

/**
 * Created by SJ on 2016.10.30.
 */

public class ArticlesActivity extends MVPBaseActivity<ArticleViewInterface,ArticlePresenterV2> implements  ArticleViewInterface,View.OnClickListener{

   // ArticlePresenterV2 articlePresenterV2;
    Button btn1,btn2,btn3;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mPresenter.fetchArticles();
    }

    private void initView(){
        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        tv = (TextView)findViewById(R.id.tv);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
    }

    @Override
    protected ArticlePresenterV2 createPresenter() {
        return new ArticlePresenterV2(this);
    }

    @Override
    public void showArticlesInitView(String[] strs) {
        btn1.setText(strs[0]);
        btn2.setText(strs[1]);
        btn3.setText(strs[2]);

    }

    @Override
    public void setTextViewData(String str) {
        tv.setText("ArticleActivity"+str);
    }

    @Override
    public void showLoading() {
        Log.v("TAG","MainActivity showLoading...");
    }

    @Override
    public void hideLoading() {
        Log.v("TAG","MainActivity hideLoading...");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case  R.id.btn1:
                Log.v("TAG","onclick....1");
                mPresenter.loadArticleFromDB(0);
                break;
            case R.id.btn2:
                Log.v("TAG","onclick....2");
              //  articlePresenter.loadArticleFromDB(1);
                mPresenter.loadArticleFromDB(1);
                break;
            case R.id.btn3:
                Log.v("TAG","onclick....3");
               // articlePresenter.loadArticleFromDB(2);
                mPresenter.loadArticleFromDB(2);
                break;
            default:
                break;
        }
    }
}
