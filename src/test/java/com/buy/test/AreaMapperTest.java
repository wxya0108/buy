package com.buy.test;

import com.buy.entity.Area;
import com.buy.mapper.AreaMapper;
import com.github.pagehelper.PageHelper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by win7 on 2018/8/8.
 * demo测试类
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaMapperTest {
    @Autowired
    private AreaMapper areaMapper;

    @Test
    public void findArea() throws Exception {
        PageHelper.startPage(1,2);
        List<Area> list = areaMapper.findArea();
        assertEquals(2,list.size());
    }

    @Test
    public void getAreas() throws Exception {
        Area area = areaMapper.getAreas(1);
        assertEquals("south",area.getAreaName());
    }

    @Test
    public void insert() throws Exception {
        Area area = new Area();
        area.setAreaName("删除");
        area.setPriority(2);
        area.setCreateTime(new Date());
        int i = areaMapper.insert(area);
        assertEquals(1,i);
    }

    @Test
    public void update() throws Exception {
        Area area = new Area();
        area.setAreaId(2);
        area.setAreaName("冯韵婷");
        int i = areaMapper.update(area);
        assertEquals(1,i);
    }

    @Test
    public void del() throws Exception {
        int i = areaMapper.del(4);
        assertEquals(1,i);
    }

}