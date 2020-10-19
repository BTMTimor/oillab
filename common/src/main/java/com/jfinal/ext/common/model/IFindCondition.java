package com.jfinal.ext.common.model;

/*
    author: 江理网猿
    date: 2020/9/12 0012
*/
public interface IFindCondition extends ICondition{

    default Object getId(){
        throw new UnsupportedOperationException();
    }
    default void setId(String id) { throw new UnsupportedOperationException(); }
    default void setId(Integer id) { throw new UnsupportedOperationException(); }
    default void setId(Long id) { throw new UnsupportedOperationException(); }
    default void setId(Object id) { throw new UnsupportedOperationException(); }

    int getPageSize();
    void setPageSize(int pageSize);

    int getPageNumber();
    void setPageNumber(int pageNumber);
}
