package com.jk.adv.mapper;

import com.jk.adv.model.Adv;
import com.jk.adv.model.AdvType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName AdvMapper
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:44
 * @Version V1.0
 **/
public interface AdvMapper {
    List<AdvType> queryAdvType();

    void deleteAdvByIds(@Param("ids") String ids);

    void addAdvType(AdvType advType);

    AdvType queryAdvTypeById(Integer id);

    void updAdvType(AdvType advType);

    List<Adv> queryAdv();

    void deleteAdv(@Param("ids")String ids);

    void updateAdvTopStatus(@Param("id")Integer id, @Param("flag")Integer flag);

    void addAdv(Adv adv);

    Adv queryAdvById(Integer id);

    void updAdv(Adv adv);
}
