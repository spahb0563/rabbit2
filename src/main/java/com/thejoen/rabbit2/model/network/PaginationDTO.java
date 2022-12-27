package com.thejoen.rabbit2.model.network;

import lombok.Getter;

@Getter
public class PaginationDTO<T> {

    private T data;

    private Pagination pagination;

    public PaginationDTO (T data, Pagination pagination) {
        this.data = data;
        this.pagination = pagination;
    }
}
