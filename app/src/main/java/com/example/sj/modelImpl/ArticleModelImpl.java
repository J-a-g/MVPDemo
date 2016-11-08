package com.example.sj.modelImpl;

import android.util.Log;

import com.example.sj.Util.DataUtil;
import com.example.sj.model.ArticleModelInterface;

/**
 * Created by SJ on 2016.10.30.
 */

public class ArticleModelImpl implements ArticleModelInterface {

    /*@Override
    public void saveArticles() {
        Log.v("TAG","保存数据操作。。。。");

    }

    @Override
    public void loadArticlesFromCache() {
        Log.v("TAG","读取数据操作。。。。");
    }*/


    @Override
    public String[] loadArticleFromStr1() {
        return DataUtil.str;
    }

    @Override
    public String loadArticlesFromStr2(int i) {
        Log.v("TAG","点击事件后的数据");
        return DataUtil.str2[i];
    }
}
