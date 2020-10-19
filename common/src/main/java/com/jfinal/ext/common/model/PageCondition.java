package com.jfinal.ext.common.model;

/*
    author: Timor
    date: 2020/7/14 0014
*/
public class PageCondition implements ICondition{
    private static final boolean printInfo = false;
    private static final int MAX_PAGE_SIZE = 100;
    private static final int DEFAULT_PAGE_SIZE = 20;
    private static final int DEFAULT_PAGE_NUMBER = 1;
    private int defaultPageNumber;
    private int defaultPageSize;
    private final int maxPageSize;

    private int pageSize = defaultPageSize;
    private int pageNumber = defaultPageNumber;

    public PageCondition() {
        this(DEFAULT_PAGE_SIZE, DEFAULT_PAGE_NUMBER, MAX_PAGE_SIZE);
    }

    public PageCondition(int defaultPageSize, int defaultPageNumber, int maxPageSize) {
        this.pageSize = defaultPageSize;
        this.pageNumber = defaultPageNumber;
        // todo check value
        this.maxPageSize = maxPageSize;
        this.defaultPageSize = defaultPageSize;
        this.defaultPageNumber = defaultPageNumber;
    }

    public void setPageNumber(int pageNumber) {
        if(pageNumber < 1) {
            if(printInfo) System.out.println("[info] PageCondition use default pageNumber: " + defaultPageNumber);
        }else {
            this.pageNumber = pageNumber;
        }
    }

    public void setPageSize(int pageSize) {
        if(pageSize < 1 || pageSize > maxPageSize) {
            if (printInfo) System.out.println("[info] BaseCondition use default pageSize: " + defaultPageSize);
        }else {
            this.pageSize = pageSize;
        }
    }

    @Override
    public String check() {
        // pageNumber和pageSize非法会使用默认值,所以默认校验通过
        /*if(pageNumber < 1) {
            return "pageNumber can't lower than 1.";
        }

        if(pageSize < 1 || pageSize > maxPageSize) {
            return "pageSize must in [1, " + maxPageSize + "].";
        }*/
        return "";
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - -

    public int getPageNumber() {
        return this.pageNumber;
    }

    public int getPageSize() {
        return this.pageSize;
    }

}
