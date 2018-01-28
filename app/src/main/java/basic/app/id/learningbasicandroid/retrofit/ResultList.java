package basic.app.id.learningbasicandroid.retrofit;

import com.google.gson.annotations.Expose;

/**
 * Created by user on 6/8/2017.
 */

public class ResultList extends Result {

    @Expose
    private String pages;

    @Expose
    private String elements;

    public String getPages() {
        return pages;
    }

    public String getElements() {
        return elements;
    }
}
