package com.a9be.annuar.mylibrary;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Rows {

    private List<Row> rows;

    public List<Row> getRows() {
        if (rows==null) {
            rows = new ArrayList<>();
        }
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public class Row {

        @SerializedName("row")
        List<String> inRow;

        public List<String> getInRow() {
            if (inRow==null) {
                inRow = new ArrayList<>();
            }

            return inRow;
        }
    }

}
