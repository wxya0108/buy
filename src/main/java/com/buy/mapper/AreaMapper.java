package com.buy.mapper;

import com.buy.entity.Area;
import com.buy.utils.MyMapper;

import java.util.List;

/**
 * Created by win7 on 2018/8/8.
 */
public interface AreaMapper extends MyMapper<Area> {

    List<Area> findArea();

    Area getAreas(int areaId);

    int insert(Area area);

    int update(Area area);

    int del(int areaId);
}
