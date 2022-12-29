package com.thejoen.rabbit2.model.network;

import java.util.List;

import org.springframework.data.domain.Page;

import lombok.Getter;

@Getter
public class PaginationDTO<T> {

    private List<T> data;

    private Pagination pagination;

    public PaginationDTO (Page<T> page) {
        this.data = page.getContent();
        this.pagination = Pagination.builder()
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .currentPage(page.getNumber())
                .currentElements(page.getNumberOfElements())
                .build();;
    }
}
