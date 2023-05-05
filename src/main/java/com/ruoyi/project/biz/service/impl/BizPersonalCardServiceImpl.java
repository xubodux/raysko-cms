package com.ruoyi.project.biz.service.impl;

import com.ruoyi.common.constant.HttpStatus;
import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.exception.ServiceException;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.framework.config.RuoYiConfig;
import com.ruoyi.project.biz.domain.BizPersonalCard;
import com.ruoyi.project.biz.mapper.BizPersonalCardMapper;
import com.ruoyi.project.biz.service.IBizPersonalCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 业务-个人名片Service业务层处理
 *
 * @author qtrade
 * @date 2023-04-28
 */
@Service
public class BizPersonalCardServiceImpl implements IBizPersonalCardService {
    @Resource
    private BizPersonalCardMapper bizPersonalCardMapper;

    @Resource
    private RuoYiConfig ruoYiConfig;

    /**
     * 查询业务-个人名片
     *
     * @param id 业务-个人名片主键
     * @return 业务-个人名片
     */
    @Override
    public BizPersonalCard selectBizPersonalCardById(Long id) {
        return bizPersonalCardMapper.selectBizPersonalCardById(id);
    }

    /**
     * 查询业务-个人名片列表
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 业务-个人名片
     */
    @Override
    public List<BizPersonalCard> selectBizPersonalCardList(BizPersonalCard bizPersonalCard) {
        List<BizPersonalCard> list = bizPersonalCardMapper.selectBizPersonalCardList(bizPersonalCard);
        // 处理名片二维码和头像的url地址
        if (list != null && list.size() > 0) {
            list.forEach(s -> {
                if (StringUtils.isNotEmpty(s.getQrCode())){
                    s.setQrCode(ruoYiConfig.getAdminDomain() + s.getQrCode());
                }
                if (StringUtils.isNotEmpty(s.getAvatar())){
                    s.setAvatar(ruoYiConfig.getAdminDomain() + s.getAvatar());
                }
            });
        }
        return list;
    }

    /**
     * 新增业务-个人名片
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 结果
     */
    @Override
    public int insertBizPersonalCard(BizPersonalCard bizPersonalCard) {
        //查询出全量ID列表，判断数量是否超过100，不超过的的话，选出1-100中未被占用的
        bizPersonalCard.setCreateTime(DateUtils.getNowDate());
        return bizPersonalCardMapper.insertBizPersonalCard(bizPersonalCard);
    }

    /**
     * 修改业务-个人名片
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 结果
     */
    @Override
    public int updateBizPersonalCard(BizPersonalCard bizPersonalCard) {
        bizPersonalCard.setUpdateTime(DateUtils.getNowDate());
        //修改时如果url是完整带域名的，去掉前面的域名
        if (StringUtils.isNotEmpty(bizPersonalCard.getQrCode()) && bizPersonalCard.getQrCode().contains(ruoYiConfig.getAdminDomain())){
            bizPersonalCard.setQrCode(bizPersonalCard.getQrCode().replace(ruoYiConfig.getAdminDomain(), ""));
        }
        if (StringUtils.isNotEmpty(bizPersonalCard.getAvatar()) && bizPersonalCard.getAvatar().contains(ruoYiConfig.getAdminDomain())){
            bizPersonalCard.setAvatar(bizPersonalCard.getAvatar().replace(ruoYiConfig.getAdminDomain(), ""));
        }
        return bizPersonalCardMapper.updateBizPersonalCard(bizPersonalCard);
    }

    /**
     * 批量删除业务-个人名片
     *
     * @param ids 需要删除的业务-个人名片主键
     * @return 结果
     */
    @Override
    public int deleteBizPersonalCardByIds(String ids) {
        return bizPersonalCardMapper.deleteBizPersonalCardByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除业务-个人名片信息
     *
     * @param id 业务-个人名片主键
     * @return 结果
     */
    @Override
    public int deleteBizPersonalCardById(Long id) {
        return bizPersonalCardMapper.deleteBizPersonalCardById(id);
    }
}
