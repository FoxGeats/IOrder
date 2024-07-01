package com.sky.service;

import com.sky.dto.DishDTO;

public interface DishSerivce {
    /**
     * 新增菜品和对应的口味
     * @param DishDTO
     */
    public void saveWithFlavor(DishDTO dishDTO);
}
