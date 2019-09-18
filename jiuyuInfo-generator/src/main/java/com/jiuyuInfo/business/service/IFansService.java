package com.jiuyuInfo.business.service;

import com.jiuyuInfo.business.domain.Fans;
import java.util.List;

/**
 * 粉丝信息Service接口
 * 
 * @author jiuyuInfo
 * @date 2019-09-18
 */
public interface IFansService 
{
    /**
     * 查询粉丝信息
     * 
     * @param openId 粉丝信息ID
     * @return 粉丝信息
     */
    public Fans selectFansById(String openId);

    /**
     * 查询粉丝信息列表
     * 
     * @param fans 粉丝信息
     * @return 粉丝信息集合
     */
    public List<Fans> selectFansList(Fans fans);

    /**
     * 新增粉丝信息
     * 
     * @param fans 粉丝信息
     * @return 结果
     */
    public int insertFans(Fans fans);

    /**
     * 修改粉丝信息
     * 
     * @param fans 粉丝信息
     * @return 结果
     */
    public int updateFans(Fans fans);

    /**
     * 批量删除粉丝信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteFansByIds(String ids);

    /**
     * 删除粉丝信息信息
     * 
     * @param openId 粉丝信息ID
     * @return 结果
     */
    public int deleteFansById(String openId);
}
