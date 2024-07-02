package com.sky.service;

import java.util.List;

import com.sky.dto.DishDTO;
import com.sky.dto.DishPageQueryDTO;
import com.sky.result.PageResult;

public interface DishSerivce {
    /**
     * 新增菜品和对应的口味
     * @param DishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);

    /**
     * 菜品分页查询
     * @param dishPageQueryDTO
     * @return
     */
    public PageResult pageQuery(DishPageQueryDTO dishPageQueryDTO);


    /**
     * 删除菜品
     * @param ids
     */
    public void deleteBatch(List<Long> ids);


    
    
}
