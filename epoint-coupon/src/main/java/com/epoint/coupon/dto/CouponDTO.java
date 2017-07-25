package com.epoint.coupon.dto;

import com.epoint.coupon.entity.Coupon;
import com.epoint.utils.DateUtil;

import java.util.Date;
import java.util.List;

/**
 * package:com.epoint.coupon.dto
 *
 * @Author smallc on 2017/4/14.
 */
public class CouponDTO extends Coupon {

    //开始时间
    private String startTimeCn;

    //结束时间
    private String endTimeCn;

    //可用的适用门店集合
    private List<StoreCouponDTO> storeCouponDTOList;

    //适用门店总数
    private Integer totalStoreNum;

    public String getStartTimeCn() {
        if(getStartTime() != null){
            return DateUtil.getDay(getStartTime());
        } else {
            return "";
        }

    }

    public String getEndTimeCn() {
        if(getEndTime() != null){
            return DateUtil.getDay(getEndTime());
        }else {
            return "";
        }

    }

    public List<StoreCouponDTO> getStoreCouponDTOList() {
        return storeCouponDTOList;
    }

    public void setStoreCouponDTOList(List<StoreCouponDTO> storeCouponDTOList) {
        this.storeCouponDTOList = storeCouponDTOList;
    }

    public Integer getTotalStoreNum() {
        return totalStoreNum;
    }

    public void setTotalStoreNum(Integer totalStoreNum) {
        this.totalStoreNum = totalStoreNum;
    }
}
