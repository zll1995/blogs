package com.jk.adv.service;

import com.jk.adv.model.Adv;
import com.jk.adv.model.AdvType;

import java.util.List;

/**
 * @ClassName AdvService
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:43
 * @Version V1.0
 **/
public interface AdvService {
    List<AdvType> queryAdvType();

    void deleteAdvByIds(String ids);

    void addAdvType(AdvType advType);

    AdvType queryAdvTypeById(Integer id);

    void updAdvType(AdvType advType);

    List<Adv> queryAdv();

    void deleteAdv(String ids);

    void updateAdvTopStatus(Integer id, Integer flag);

    void addAdv(Adv adv);

    Adv queryAdvById(Integer id);

    void updAdv(Adv adv);
}
