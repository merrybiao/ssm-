package com.accp.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import com.accp.entity.Animal;
public interface ResultMapMapper {
	
	
	@Select("SELECT * FROM animal a,bird b WHERE a.id = b.bid and id=#{animalId}")
	@ResultMap("com.accp.dao.ResultMapMapper.AnimalResultMap")
	Animal findAnimalById(@Param("animalId") Long animalId);
	
}
