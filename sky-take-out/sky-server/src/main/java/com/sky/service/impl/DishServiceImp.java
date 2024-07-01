package com.sky.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sky.dto.DishDTO;
import com.sky.entity.Dish;
import com.sky.entity.DishFlavor;
import com.sky.mapper.DishFlavorMapper;
import com.sky.mapper.DishMapper;
import com.sky.service.DishSerivce;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DishServiceImp implements DishSerivce {

    @Autowired
    private DishMapper dishMapper;

    @Autowired
    private DishFlavorMapper dishFlavorMapper;
/*
 * 新增菜品和对应的口味
 * @param DishDTO
 */
@Transactional
    public void saveWithFlavor(DishDTO dishDTO) {

        Dish dish = new Dish();
        BeanUtils.copyProperties(dishDTO, dish);

        //向菜品表加入一条数据  
        dishMapper.insert(dish);

        //获取insert语句生成的主键值
        Long dishId = dish.getId();


        //向口味表加入多条数据
        List<DishFlavor> flavors = dishDTO.getFlavors();
        flavors.forEach(flavor -> {
            flavor.setDishId(dishId);
        });
        if(flavors != null && flavors.size() > 0) {
            dishFlavorMapper.insertBatch(flavors);
        }
    }

}
