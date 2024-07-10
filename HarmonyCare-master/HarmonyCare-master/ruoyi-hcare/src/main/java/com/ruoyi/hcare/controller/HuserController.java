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
import com.ruoyi.hcare.domain.Huser;
import com.ruoyi.hcare.service.IHuserService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * Hcare用户Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/huser")
public class HuserController extends BaseController
{
    @Autowired
    private IHuserService huserService;

    /**
     * 查询Hcare用户列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:list')")
    @GetMapping("/list")
    public TableDataInfo list(Huser huser)
    {
        startPage();
        List<Huser> list = huserService.selectHuserList(huser);
        return getDataTable(list);
    }

    /**
     * 导出Hcare用户列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:export')")
    @Log(title = "Hcare用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Huser huser)
    {
        List<Huser> list = huserService.selectHuserList(huser);
        ExcelUtil<Huser> util = new ExcelUtil<Huser>(Huser.class);
        util.exportExcel(response, list, "Hcare用户数据");
    }

    /**
     * 获取Hcare用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:query')")
    @GetMapping(value = "/{hcUserid}")
    public AjaxResult getInfo(@PathVariable("hcUserid") Long hcUserid)
    {
        return success(huserService.selectHuserByHcUserid(hcUserid));
    }

    /**
     * 新增Hcare用户
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:add')")
    @Log(title = "Hcare用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Huser huser)
    {
        return toAjax(huserService.insertHuser(huser));
    }

    /**
     * 修改Hcare用户
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:edit')")
    @Log(title = "Hcare用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Huser huser)
    {
        return toAjax(huserService.updateHuser(huser));
    }

    /**
     * 删除Hcare用户
     */
    @PreAuthorize("@ss.hasPermi('hcare:huser:remove')")
    @Log(title = "Hcare用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcUserids}")
    public AjaxResult remove(@PathVariable Long[] hcUserids)
    {
        return toAjax(huserService.deleteHuserByHcUserids(hcUserids));
    }
}
