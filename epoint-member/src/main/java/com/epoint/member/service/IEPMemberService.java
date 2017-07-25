package com.epoint.member.service;

import com.epoint.member.dto.MemberDTO;

/**
 * package:com.epoint.member.service
 *
 * @Author smallc on 2017/5/23.
 */
public interface IEPMemberService {
    /**
     * 查询会员相关信息
     * @param storeId 门店ID
     * @param memberId 会员ID
     * @param carNo 车牌号
     * @Exception MemberException
     * @return
     */
    MemberDTO getMemberInfo(Long storeId,Long memberId,String carNo);
}
