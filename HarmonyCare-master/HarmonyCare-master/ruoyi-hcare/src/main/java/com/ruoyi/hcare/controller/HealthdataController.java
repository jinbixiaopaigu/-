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
import com.ruoyi.hcare.domain.Healthdata;
import com.ruoyi.hcare.service.IHealthdataService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 健康数据Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/healthdata")
public class HealthdataController extends BaseController
{
    @Autowired
    private IHealthdataService healthdataService;

    /**
     * 查询健康数据列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:list')")
    @GetMapping("/list")
    public TableDataInfo list(Healthdata healthdata)
    {
        startPage();
        List<Healthdata> list = healthdataService.selectHealthdataList(healthdata);
        return getDataTable(list);
    }

    /**
     * 导出健康数据列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:export')")
    @Log(title = "健康数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Healthdata healthdata)
    {
        List<Healthdata> list = healthdataService.selectHealthdataList(healthdata);
        ExcelUtil<Healthdata> util = new ExcelUtil<Healthdata>(Healthdata.class);
        util.exportExcel(response, list, "健康数据数据");
    }

    /**
     * 获取健康数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:query')")
    @GetMapping(value = "/{hcDataid}")
    public AjaxResult getInfo(@PathVariable("hcDataid") Long hcDataid)
    {
        return success(healthdataService.selectHealthdataByHcDataid(hcDataid));
    }

    /**
     * 新增健康数据
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:add')")
    @Log(title = "健康数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Healthdata healthdata)
    {
        return toAjax(healthdataService.insertHealthdata(healthdata));
    }

    /**
     * 修改健康数据
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:edit')")
    @Log(title = "健康数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Healthdata healthdata)
    {
        return toAjax(healthdataService.updateHealthdata(healthdata));
    }

    /**
     * 删除健康数据
     */
    @PreAuthorize("@ss.hasPermi('hcare:healthdata:remove')")
    @Log(title = "健康数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcDataids}")
    public AjaxResult remove(@PathVariable Long[] hcDataids)
    {
        return toAjax(healthdataService.deleteHealthdataByHcDataids(hcDataids));
    }
}
