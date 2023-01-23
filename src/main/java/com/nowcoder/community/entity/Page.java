package com.nowcoder.community.entity;


// encapsulate page information
public class Page {

    // current page number
    private int current = 1;

    // default shown page numbers
    private int limit = 10;

    // total number of page numbers
    private int rows;

    // query url
    private String path;

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if (current >= 1) {
            this.current = current;
        }
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100) {
            this.limit = limit;
        }
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if (rows >= 0) {
            this.rows = rows;
        }

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * get current page starting line
     * @return offset
     */
    public int getOffset() {
        return (current - 1) * limit;
    }

    public int getTotal() {
        if (rows % limit == 0) {
            return rows / limit;
        } else {
            return rows / limit + 1;
        }
    }

    /**
     *
     * @return from page number
     */
    public int getFrom() {
    int from = current - 2;
    return Math.max(from, 1);
    }

    /**
     *
     * @return to page number
     */
    public int getTo() {
        int to = current + 2;
        int total = getTotal();
        return Math.min(to, total);
    }





}
