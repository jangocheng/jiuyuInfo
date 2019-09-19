package com.jiuyuInfo.business.controller;

import com.jiuyuInfo.business.domain.Fans;
import com.jiuyuInfo.business.service.IFansService;
import com.jiuyuInfo.common.annotation.Log;
import com.jiuyuInfo.common.core.controller.BaseController;
import com.jiuyuInfo.common.core.domain.AjaxResult;
import com.jiuyuInfo.common.core.page.TableDataInfo;
import com.jiuyuInfo.common.enums.BusinessType;
import com.jiuyuInfo.common.utils.poi.ExcelUtil;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 粉丝信息Controller
 *
 * @author jiuyuInfo
 * @date 2019-09-18
 */
@Controller
@RequestMapping("/business/fans")
public class FansController extends BaseController
{
    private String prefix = "business/fans";

    @Autowired
    private IFansService fansService;

    @RequiresPermissions("business:fans:view")
    @GetMapping()
    public String fans()
    {
        return prefix + "/fans";
    }

    /**
     * 查询粉丝信息列表
     */
    @RequiresPermissions("business:fans:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Fans fans)
    {
        startPage();
        List<Fans> list = fansService.selectFansList(fans);
        return getDataTable(list);
    }

    /**
     * 导出粉丝信息列表
     */
    @RequiresPermissions("business:fans:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Fans fans)
    {
        List<Fans> list = fansService.selectFansList(fans);
        ExcelUtil<Fans> util = new ExcelUtil<Fans>(Fans.class);
        return util.exportExcel(list, "fans");
    }

    /**
     * 新增粉丝信息
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存粉丝信息
     */
    @RequiresPermissions("business:fans:add")
    @Log(title = "粉丝信息", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Fans fans)
    {
        return toAjax(fansService.insertFans(fans));
    }

    /**
     * 修改粉丝信息
     */
    @GetMapping("/edit/{openId}")
    public String edit(@PathVariable("openId") String openId, ModelMap mmap)
    {
        Fans fans = fansService.selectFansById(openId);
        mmap.put("fans", fans);
        return prefix + "/edit";
    }

    /**
     * 修改保存粉丝信息
     */
    @RequiresPermissions("business:fans:edit")
    @Log(title = "粉丝信息", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Fans fans)
    {
        return toAjax(fansService.updateFans(fans));
    }

    /**
     * 删除粉丝信息
     */
    @RequiresPermissions("business:fans:remove")
    @Log(title = "粉丝信息", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(fansService.deleteFansByIds(ids));
    }
}
