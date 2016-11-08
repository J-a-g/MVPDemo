
package com.example.sj.mydemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sj.interfaces.ArticleViewInterface;
import com.example.sj.presenter.ArticlePresenter;

public class MainActivity extends AppCompatActivity implements ArticleViewInterface,View.OnClickListener{

    ArticlePresenter articlePresenter;
    Button btn1,btn2,btn3;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        //此时ArtclePresenter持有MainActivity的引用
        articlePresenter = new ArticlePresenter(this);
        articlePresenter.fetchArticles();

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
    public void showArticlesInitView(String[] strs) {
        btn1.setText(strs[0]);
        btn2.setText(strs[1]);
        btn3.setText(strs[2]);

    }

    @Override
    public void setTextViewData(String str) {
        tv.setText(str);
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
                articlePresenter.loadArticleFromDB(0);
                break;
            case R.id.btn2:
                Log.v("TAG","onclick....2");
                articlePresenter.loadArticleFromDB(1);
                break;
            case R.id.btn3:
                Log.v("TAG","onclick....3");
                articlePresenter.loadArticleFromDB(2);
                break;
            default:
                break;
        }
    }
}
