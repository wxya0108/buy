package com.buy.service.impl;

import com.buy.entity.Area;
import com.buy.mapper.AreaMapper;
import com.buy.service.IAreaService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by win7 on 2018/8/9.
 */

@Service
public class AreaServiceImpl implements IAreaService {
    @Autowired
    private AreaMapper areaMapper;

    @Override
    public List<Area> findArea(int pageIndex,int pageSize) {
        if(pageSize!=0){
            PageHelper.startPage(pageIndex,pageSize);
        }
        return areaMapper.findArea();
    }

    @Override
    public Area getAreasById(int areaId) {
        return areaMapper.getAreas(areaId);
    }

    @Override
    public int addArea(Area area) {
        area.setCreateTime(new Date());
        return areaMapper.insert(area);
    }

    @Override
    public int editArea(Area area) {
        return areaMapper.update(area);
    }

    @Override
    public int delArea(int areaId) {
        return areaMapper.del(areaId);
    }
}
