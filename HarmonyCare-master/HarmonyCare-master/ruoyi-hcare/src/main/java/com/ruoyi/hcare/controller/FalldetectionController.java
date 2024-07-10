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
import com.ruoyi.hcare.domain.Falldetection;
import com.ruoyi.hcare.service.IFalldetectionService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 摔倒检测Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/falldetection")
public class FalldetectionController extends BaseController
{
    @Autowired
    private IFalldetectionService falldetectionService;

    /**
     * 查询摔倒检测列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:list')")
    @GetMapping("/list")
    public TableDataInfo list(Falldetection falldetection)
    {
        startPage();
        List<Falldetection> list = falldetectionService.selectFalldetectionList(falldetection);
        return getDataTable(list);
    }

    /**
     * 导出摔倒检测列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:export')")
    @Log(title = "摔倒检测", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Falldetection falldetection)
    {
        List<Falldetection> list = falldetectionService.selectFalldetectionList(falldetection);
        ExcelUtil<Falldetection> util = new ExcelUtil<Falldetection>(Falldetection.class);
        util.exportExcel(response, list, "摔倒检测数据");
    }

    /**
     * 获取摔倒检测详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:query')")
    @GetMapping(value = "/{hcDataid}")
    public AjaxResult getInfo(@PathVariable("hcDataid") Long hcDataid)
    {
        return success(falldetectionService.selectFalldetectionByHcDataid(hcDataid));
    }

    /**
     * 新增摔倒检测
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:add')")
    @Log(title = "摔倒检测", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Falldetection falldetection)
    {
        return toAjax(falldetectionService.insertFalldetection(falldetection));
    }

    /**
     * 修改摔倒检测
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:edit')")
    @Log(title = "摔倒检测", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Falldetection falldetection)
    {
        return toAjax(falldetectionService.updateFalldetection(falldetection));
    }

    /**
     * 删除摔倒检测
     */
    @PreAuthorize("@ss.hasPermi('hcare:falldetection:remove')")
    @Log(title = "摔倒检测", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcDataids}")
    public AjaxResult remove(@PathVariable Long[] hcDataids)
    {
        return toAjax(falldetectionService.deleteFalldetectionByHcDataids(hcDataids));
    }
}
