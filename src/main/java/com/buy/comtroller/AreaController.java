package com.buy.comtroller;

import com.buy.entity.Area;
import com.buy.entity.IMoocJSONResult;
import com.buy.service.IAreaService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by win7 on 2018/8/9.
 */

@RestController
@RequestMapping("/area/")
public class AreaController {
    @Autowired
    private IAreaService areaService;

    @RequestMapping(value = "findArea",method = RequestMethod.GET)
    public Map<String,Object> findArea(int pageIndex,int pageSize){
        Map<String,Object> map = new HashMap();

        //获取分页后的记录集
        List<Area> list = areaService.findArea(pageIndex,pageSize);

        //获取分页信息
        PageInfo page = new PageInfo(list);

        map.put("list",list);
        map.put("page",page);
        return map;
    }

    @RequestMapping(value = "getAreasById")
    public Area getAreasById(int areaId){
        return areaService.getAreasById(areaId);
    }

    @RequestMapping(value = "addArea",method = RequestMethod.POST)
    public IMoocJSONResult addArea(@RequestBody Area area){
        IMoocJSONResult result = new IMoocJSONResult();

        int i = areaService.addArea(area);
        if(i>0){
            result.setStatus(1);
            result.setMsg("添加成功");
        }else{
            result.setStatus(0);
            result.setMsg("添加失败111");
        }
        return result;
    }

    @RequestMapping(value = "editArea",method = RequestMethod.POST)
    public IMoocJSONResult editArea(@RequestBody Area area){
        IMoocJSONResult result = new IMoocJSONResult();

        int i = areaService.editArea(area);
        if(i>0){
            result.setStatus(1);
            result.setMsg("修改成功");
        }else{
            result.setStatus(0);
            result.setMsg("修改失败");
        }
        return result;
    }

    @RequestMapping(value = "delArea",method = RequestMethod.GET)
    public IMoocJSONResult delArea(Integer areaId){
        IMoocJSONResult result = new IMoocJSONResult();

        int i = areaService.delArea(areaId);
        if(i>0){
            result.setStatus(1);
            result.setMsg("删除成功");
        }else{
            result.setStatus(0);
            result.setMsg("删除失败");
        }
        return result;
    }

}
