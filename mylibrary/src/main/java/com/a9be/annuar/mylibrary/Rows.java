package com.a9be.annuar.mylibrary;

import java.util.ArrayList;
import java.util.List;

public class Rows {

    private List<Row> rows;

    public List<Row> getRows() {
        return rows;
    }

    public class Row {

        List<String> inRow;

        public List<String> getInRow() {
            if (inRow==null) {
                inRow = new ArrayList<>();
            }

            return inRow;
        }
    }

}
