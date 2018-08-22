package com.buy.service;

import com.buy.entity.Area;

import java.util.List;

/**
 * Created by win7 on 2018/8/9.
 */
public interface IAreaService{
    List<Area> findArea(int pageIndex,int pageSiz);

    Area getAreasById(int areaId);

    int addArea(Area area);

    int editArea(Area area);

    int delArea(int areaId);
}
