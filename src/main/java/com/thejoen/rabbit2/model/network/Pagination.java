package com.thejoen.rabbit2.model.network;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class Pagination {
	private int totalPages;
	private long totalElement;
	private int currentPage;
	private int currentElements;
}
