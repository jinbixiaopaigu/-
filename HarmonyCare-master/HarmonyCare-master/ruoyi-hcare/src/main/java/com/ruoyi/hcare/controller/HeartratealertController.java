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
import com.ruoyi.hcare.domain.Heartratealert;
import com.ruoyi.hcare.service.IHeartratealertService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 心率异常Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/heartratealert")
public class HeartratealertController extends BaseController
{
    @Autowired
    private IHeartratealertService heartratealertService;

    /**
     * 查询心率异常列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:list')")
    @GetMapping("/list")
    public TableDataInfo list(Heartratealert heartratealert)
    {
        startPage();
        List<Heartratealert> list = heartratealertService.selectHeartratealertList(heartratealert);
        return getDataTable(list);
    }

    /**
     * 导出心率异常列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:export')")
    @Log(title = "心率异常", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Heartratealert heartratealert)
    {
        List<Heartratealert> list = heartratealertService.selectHeartratealertList(heartratealert);
        ExcelUtil<Heartratealert> util = new ExcelUtil<Heartratealert>(Heartratealert.class);
        util.exportExcel(response, list, "心率异常数据");
    }

    /**
     * 获取心率异常详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:query')")
    @GetMapping(value = "/{hcDataid}")
    public AjaxResult getInfo(@PathVariable("hcDataid") Long hcDataid)
    {
        return success(heartratealertService.selectHeartratealertByHcDataid(hcDataid));
    }

    /**
     * 新增心率异常
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:add')")
    @Log(title = "心率异常", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Heartratealert heartratealert)
    {
        return toAjax(heartratealertService.insertHeartratealert(heartratealert));
    }

    /**
     * 修改心率异常
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:edit')")
    @Log(title = "心率异常", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Heartratealert heartratealert)
    {
        return toAjax(heartratealertService.updateHeartratealert(heartratealert));
    }

    /**
     * 删除心率异常
     */
    @PreAuthorize("@ss.hasPermi('hcare:heartratealert:remove')")
    @Log(title = "心率异常", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcDataids}")
    public AjaxResult remove(@PathVariable Long[] hcDataids)
    {
        return toAjax(heartratealertService.deleteHeartratealertByHcDataids(hcDataids));
    }
}
