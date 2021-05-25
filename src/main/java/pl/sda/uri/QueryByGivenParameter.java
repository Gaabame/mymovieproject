package pl.sda.uri;

import pl.sda.parameter.IdParameter;
import pl.sda.parameter.TitleParameter;
import pl.sda.query.QueryByMovieId;
import pl.sda.query.QueryByMovieTitle;

public class QueryByGivenParameter {

    private String title;
    private String id;

    public String queryByTitle(String title) {
        QueryByMovieTitle query = new QueryByMovieTitle();
         query.addTitle(new TitleParameter(title));
        return title;
    }
    public void queryById(String id) {
       QueryByMovieId query = new QueryByMovieId();
        query.addId(new IdParameter(id));
    }
}
