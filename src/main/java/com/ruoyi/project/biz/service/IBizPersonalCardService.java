package com.ruoyi.project.biz.service;

import com.ruoyi.project.biz.domain.BizPersonalCard;

import java.util.List;

/**
 * 业务-个人名片Service接口
 *
 * @author qtrade
 * @date 2023-04-28
 */
public interface IBizPersonalCardService {
    /**
     * 查询业务-个人名片
     *
     * @param id 业务-个人名片主键
     * @return 业务-个人名片
     */
    BizPersonalCard selectBizPersonalCardById(Long id);

    /**
     * 查询业务-个人名片列表
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 业务-个人名片集合
     */
    List<BizPersonalCard> selectBizPersonalCardList(BizPersonalCard bizPersonalCard);

    /**
     * 新增业务-个人名片
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 结果
     */
    int insertBizPersonalCard(BizPersonalCard bizPersonalCard);

    /**
     * 修改业务-个人名片
     *
     * @param bizPersonalCard 业务-个人名片
     * @return 结果
     */
    int updateBizPersonalCard(BizPersonalCard bizPersonalCard);

    /**
     * 批量删除业务-个人名片
     *
     * @param ids 需要删除的业务-个人名片主键集合
     * @return 结果
     */
    int deleteBizPersonalCardByIds(String ids);

    /**
     * 删除业务-个人名片信息
     *
     * @param id 业务-个人名片主键
     * @return 结果
     */
    int deleteBizPersonalCardById(Long id);
}
