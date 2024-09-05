package com.sebastian.powerup.emazon.application;

public interface PageableQuery {
    Integer getPageNumber();
    Integer getPageSize();
    String getSort();
    String getOrder();
}
