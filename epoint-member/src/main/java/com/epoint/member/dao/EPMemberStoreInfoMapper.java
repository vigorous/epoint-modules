package com.epoint.member.dao;

import com.epoint.dao.BaseMapper;
import com.epoint.member.entity.MemberStoreInfo;

public interface EPMemberStoreInfoMapper extends BaseMapper<MemberStoreInfo> {
    /**
     * 根据条件查询门店会员信息
     * @param memberStoreInfo
     * @return MemberStoreInfo
     */
    MemberStoreInfo selectByCondition(MemberStoreInfo memberStoreInfo);
}