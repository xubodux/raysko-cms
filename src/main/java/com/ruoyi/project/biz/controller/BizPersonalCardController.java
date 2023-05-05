package com.ruoyi.project.biz.controller;

import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.framework.aspectj.lang.annotation.Log;
import com.ruoyi.framework.aspectj.lang.enums.BusinessType;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.framework.web.domain.AjaxResult;
import com.ruoyi.framework.web.page.TableDataInfo;
import com.ruoyi.project.biz.domain.BizPersonalCard;
import com.ruoyi.project.biz.service.IBizPersonalCardService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


/**
 * 业务-个人名片Controller
 *
 * @author qtrade
 * @date 2023-04-28
 */
@Api("名片管理")
@RestController
@RequestMapping("/biz/card")
public class BizPersonalCardController extends BaseController {

    @Resource
    private IBizPersonalCardService bizPersonalCardService;

    @Resource
    RuoYiConfig ruoYiConfig;

    /**
     * 查询业务-个人名片列表
     */
    @ApiOperation("名片列表")
    @PreAuthorize("@ss.hasPermi('card:manage:list')")
    @PostMapping("/list")
    public TableDataInfo list(BizPersonalCard bizPersonalCard) {
        startPage();
        List<BizPersonalCard> list = bizPersonalCardService.selectBizPersonalCardList(bizPersonalCard);
        return getDataTable(list);
    }

    /**
     * 导出业务-个人名片列表
     */
    @ApiOperation("名片列表导出")
    @Log(title = "业务-个人名片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public AjaxResult export(BizPersonalCard bizPersonalCard) {
        List<BizPersonalCard> list = bizPersonalCardService.selectBizPersonalCardList(bizPersonalCard);
        ExcelUtil<BizPersonalCard> util = new ExcelUtil<>(BizPersonalCard.class);
        return util.exportExcel(list, "业务-个人名片数据");
    }

    /**
     * 新增保存业务-个人名片
     */
    @ApiOperation("新增名片")
    @Log(title = "业务-个人名片", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    public AjaxResult addSave(@Validated @RequestBody BizPersonalCard bizPersonalCard) {
        return toAjax(bizPersonalCardService.insertBizPersonalCard(bizPersonalCard));
    }

    /**
     * 修改保存业务-个人名片
     */
    @ApiOperation("修改名片")
    @Log(title = "业务-个人名片", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    public AjaxResult editSave(@Validated @RequestBody BizPersonalCard bizPersonalCard) {
        return toAjax(bizPersonalCardService.updateBizPersonalCard(bizPersonalCard));
    }

    /**
     * 删除业务-个人名片
     */
    @ApiOperation("删除名片")
    @Log(title = "业务-个人名片", businessType = BusinessType.DELETE)
    @PostMapping("/remove")
    public AjaxResult remove(String ids) {
        return toAjax(bizPersonalCardService.deleteBizPersonalCardByIds(ids));
    }
}
