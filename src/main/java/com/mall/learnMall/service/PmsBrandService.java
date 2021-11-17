package com.mall.learnMall.service;

import com.mall.learnMall.mbg.model.PmsBrand;

import java.util.List;

/**
 * @author ycd20
 * @date 2021/11/16
 * @time 22:13
 */
public interface PmsBrandService {
    List<PmsBrand> listAllBrand();

    int createBrand(PmsBrand brand);

    int updateBrand(Long id, PmsBrand brand);

    int deleteBrand(Long id);

    List<PmsBrand> listBrand(int pageNum, int pageSize);

    PmsBrand getBrand(Long id);
}
