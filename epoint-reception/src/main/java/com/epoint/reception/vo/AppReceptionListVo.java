package com.epoint.reception.vo;

import com.epoint.reception.entity.AppReceptionList;

/**
 * 表名:app_reception_list
 */
public class AppReceptionListVo extends AppReceptionList{
    private String brandName;
    private String seriesName;
    private String modelName;
    private String carLogo;

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSeriesName() {
        return seriesName;
    }

    public void setSeriesName(String seriesName) {
        this.seriesName = seriesName;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getCarLogo() {
        return carLogo;
    }

    public void setCarLogo(String carLogo) {
        this.carLogo = carLogo;
    }
}