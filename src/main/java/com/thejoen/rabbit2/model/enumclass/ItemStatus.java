package com.thejoen.rabbit2.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ItemStatus {
	
	ON_SALE(0, "판매중"),
	SHARING(1, "나눔중"),
	COMPLTED(2, "거래 완료");
	
	private Integer id;
	
	private String title;
	
}
