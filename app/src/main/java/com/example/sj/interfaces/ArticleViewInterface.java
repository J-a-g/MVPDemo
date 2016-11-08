package com.example.sj.interfaces;

import java.util.List;

/**
 * Created by SJ on 2016.10.30.
 */

public interface ArticleViewInterface {
    public void showArticlesInitView(String[] strs);
    public void setTextViewData(String str);
    public void showLoading();
    public void hideLoading();
}
