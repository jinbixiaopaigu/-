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
import com.ruoyi.hcare.domain.Medicationreminder;
import com.ruoyi.hcare.service.IMedicationreminderService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用药提醒Controller
 * 
 * @author ruoyi
 * @date 2024-05-07
 */
@RestController
@RequestMapping("/hcare/medicationreminder")
public class MedicationreminderController extends BaseController
{
    @Autowired
    private IMedicationreminderService medicationreminderService;

    /**
     * 查询用药提醒列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:list')")
    @GetMapping("/list")
    public TableDataInfo list(Medicationreminder medicationreminder)
    {
        startPage();
        List<Medicationreminder> list = medicationreminderService.selectMedicationreminderList(medicationreminder);
        return getDataTable(list);
    }

    /**
     * 导出用药提醒列表
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:export')")
    @Log(title = "用药提醒", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Medicationreminder medicationreminder)
    {
        List<Medicationreminder> list = medicationreminderService.selectMedicationreminderList(medicationreminder);
        ExcelUtil<Medicationreminder> util = new ExcelUtil<Medicationreminder>(Medicationreminder.class);
        util.exportExcel(response, list, "用药提醒数据");
    }

    /**
     * 获取用药提醒详细信息
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:query')")
    @GetMapping(value = "/{hcReminderid}")
    public AjaxResult getInfo(@PathVariable("hcReminderid") Long hcReminderid)
    {
        return success(medicationreminderService.selectMedicationreminderByHcReminderid(hcReminderid));
    }

    /**
     * 新增用药提醒
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:add')")
    @Log(title = "用药提醒", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Medicationreminder medicationreminder)
    {
        return toAjax(medicationreminderService.insertMedicationreminder(medicationreminder));
    }

    /**
     * 修改用药提醒
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:edit')")
    @Log(title = "用药提醒", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Medicationreminder medicationreminder)
    {
        return toAjax(medicationreminderService.updateMedicationreminder(medicationreminder));
    }

    /**
     * 删除用药提醒
     */
    @PreAuthorize("@ss.hasPermi('hcare:medicationreminder:remove')")
    @Log(title = "用药提醒", businessType = BusinessType.DELETE)
	@DeleteMapping("/{hcReminderids}")
    public AjaxResult remove(@PathVariable Long[] hcReminderids)
    {
        return toAjax(medicationreminderService.deleteMedicationreminderByHcReminderids(hcReminderids));
    }
}
