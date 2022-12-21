package com.thejoen.rabbit2.model.enumclass;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum CategoryType {
	
	
    COMPUTER(0, "컴퓨터-전자제품"),
    
    CLOTHING(1, "의류"),
    
    INTERIOR(2, "인테리어"),
    
    FOOD(3, "음식"),
    
    SPORTS(4, "스포츠"),
    
    BEAUTY(5, "화장품");
	
	private Integer id;
	
	private String title;
	
}
