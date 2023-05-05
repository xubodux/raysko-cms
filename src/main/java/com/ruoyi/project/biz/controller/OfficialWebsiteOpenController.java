package com.ruoyi.project.biz.controller;

import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.framework.web.controller.BaseController;
import com.ruoyi.project.biz.domain.BizPersonalCard;
import com.ruoyi.project.biz.service.IBizPersonalCardService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 *
 */
@RestController
@RequestMapping("/open")
public class OfficialWebsiteOpenController extends BaseController {

    @Resource
    private IBizPersonalCardService bizPersonalCardService;
    @Resource
    RuoYiConfig ruoYiConfig;

    @GetMapping("/id_card/{id}")
    public Object getContentConfig(@PathVariable("id") String id) {
        BizPersonalCard bizPersonalCard = bizPersonalCardService.selectBizPersonalCardById(Long.parseLong(id));
        if (StringUtils.isNotEmpty(bizPersonalCard.getQrCode())){
            bizPersonalCard.setQrCode(ruoYiConfig.getOpenDomain() + bizPersonalCard.getQrCode());
        }
        if (StringUtils.isNotEmpty(bizPersonalCard.getAvatar())){
            bizPersonalCard.setAvatar(ruoYiConfig.getOpenDomain() + bizPersonalCard.getAvatar());
        }
        return success(bizPersonalCard);
    }

}
