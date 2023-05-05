package com.ruoyi.project.biz.service.impl;

import com.ruoyi.common.core.text.Convert;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.project.biz.domain.BizPersonalCard;
import com.ruoyi.project.biz.mapper.BizPersonalCardMapper;
import com.ruoyi.project.biz.service.IBizPersonalCardService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
        return bizPersonalCardMapper.selectBizPersonalCardList(bizPersonalCard);
    }

    /**
     * 新增业务-个人名片
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 结果
     */
    @Override
    public int insertBizPersonalCard(BizPersonalCard bizPersonalCard) {
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
