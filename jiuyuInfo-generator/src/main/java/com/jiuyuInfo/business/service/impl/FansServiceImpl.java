package com.jiuyuInfo.business.service.impl;

import java.util.List;

import com.jiuyuInfo.business.mapper.FansMapper;
import com.jiuyuInfo.business.service.IFansService;
import com.jiuyuInfo.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.jiuyuInfo.business.domain.Fans;
import com.jiuyuInfo.common.core.text.Convert;

/**
 * 粉丝信息Service业务层处理
 * 
 * @author jiuyuInfo
 * @date 2019-09-18
 */
@Service
public class FansServiceImpl implements IFansService
{
    @Autowired
    private FansMapper fansMapper;

    /**
     * 查询粉丝信息
     * 
     * @param openId 粉丝信息ID
     * @return 粉丝信息
     */
    @Override
    public Fans selectFansById(String openId)
    {
        return fansMapper.selectFansById(openId);
    }

    /**
     * 查询粉丝信息列表
     * 
     * @param fans 粉丝信息
     * @return 粉丝信息
     */
    @Override
    public List<Fans> selectFansList(Fans fans)
    {
        return fansMapper.selectFansList(fans);
    }

    /**
     * 新增粉丝信息
     * 
     * @param fans 粉丝信息
     * @return 结果
     */
    @Override
    public int insertFans(Fans fans)
    {
        fans.setCreateTime(DateUtils.getNowDate());
        return fansMapper.insertFans(fans);
    }

    /**
     * 修改粉丝信息
     * 
     * @param fans 粉丝信息
     * @return 结果
     */
    @Override
    public int updateFans(Fans fans)
    {
        fans.setUpdateTime(DateUtils.getNowDate());
        return fansMapper.updateFans(fans);
    }

    /**
     * 删除粉丝信息对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteFansByIds(String ids)
    {
        return fansMapper.deleteFansByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除粉丝信息信息
     * 
     * @param openId 粉丝信息ID
     * @return 结果
     */
    public int deleteFansById(String openId)
    {
        return fansMapper.deleteFansById(openId);
    }
}
