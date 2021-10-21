package com.nowcoder.community.entity;

public class Page {

    private int current = 1;//当前页码
    private int limit = 10;//每一页上限
    private int rows;//数据总数
    private String path;//查询路径

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        if(current >= 1)
            this.current = current;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        if (limit >= 1 && limit <= 100)
        this.limit = limit;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        if(rows >= 0)
            this.rows = rows;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
    public int getOffset() {
        return current * limit - limit;
    }
    public int getTotal() {
        if (rows % limit == 0)
            return rows / limit;
        else
            return rows / limit + 1;
    }
    public int getFrom() {
        if (current - 2 < 1)
            return 1;
        else
            return current - 2;
    }
    public int getTo() {
        if (current + 2 > getTotal())
            return getTotal();
        else
            return current + 2;
    }
}
