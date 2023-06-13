package com.yavdev.section12.students;

import java.util.ArrayList;
import java.util.List;

public class QueryList<T extends QueryItem> extends ArrayList<T> {
    public QueryList() {}
    public QueryList(List<T> list) {
        super(list);
    }

    public QueryList<T> filter(String field, String value) {
        QueryList<T> filteredQueryList = new QueryList<>();

        for (var item : this) {
            if(item.matchFieldValue(field, value)) {
                filteredQueryList.add(item);
            };
        }

        return filteredQueryList;
    }
}
