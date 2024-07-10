package com.ruoyi.hcare.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.hcare.domain.Sleepdata;
import com.ruoyi.hcare.service.ISleepdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 睡眠数据
Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/sleepdata")
public class SleepdataController extends BaseController
{
    @Autowired
    private ISleepdataService sleepdataService;

    /**
     * 查询睡眠数据列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(Sleepdata sleepdata)
    {
        startPage();
        List<Sleepdata> list = sleepdataService.selectSleepdataList(sleepdata);
        return getDataTable(list);
    }

    /**
     * 导出睡眠数据列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:export')")
    @Log(title = "睡眠数据 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sleepdata sleepdata)
    {
        List<Sleepdata> list = sleepdataService.selectSleepdataList(sleepdata);
        ExcelUtil<Sleepdata> util = new ExcelUtil<Sleepdata>(Sleepdata.class);
        util.exportExcel(response, list, "睡眠数据 数据");
    }

    /**
     * 获取睡眠数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:query')")
    @GetMapping(value = "/{hcDataid}")
    public AjaxResult getInfo(@PathVariable("hcDataid") Long hcDataid)
    {
        return success(sleepdataService.selectSleepdataByHcDataid(hcDataid));
    }

    /**
     * 新增睡眠数据

     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:add')")
    @Log(title = "睡眠数据 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sleepdata sleepdata)
    {
        return toAjax(sleepdataService.insertSleepdata(sleepdata));
    }

    /**
     * 修改睡眠数据

     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:edit')")
    @Log(title = "睡眠数据 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sleepdata sleepdata)
    {
        return toAjax(sleepdataService.updateSleepdata(sleepdata));
    }

    /**
     * 删除睡眠数据

     */
    @PreAuthorize("@ss.hasPermi('hcare:sleepdata:remove')")
    @Log(title = "睡眠数据 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcDataids}")
    public AjaxResult remove(@PathVariable Long[] hcDataids)
    {
        return toAjax(sleepdataService.deleteSleepdataByHcDataids(hcDataids));
    }
}
