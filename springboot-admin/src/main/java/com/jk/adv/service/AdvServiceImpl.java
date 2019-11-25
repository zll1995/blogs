package com.jk.adv.service;

import com.jk.adv.mapper.AdvMapper;
import com.jk.adv.model.Adv;
import com.jk.adv.model.AdvType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName AdvServiceImpl
 * @Description: TODO
 * @Author zjh
 * @Date 2019/11/19 11:44
 * @Version V1.0
 **/
@Service
public class AdvServiceImpl implements AdvService {

    @Autowired
    private AdvMapper advMapper;

    @Override
    public List<AdvType> queryAdvType() {
        return advMapper.queryAdvType();
    }

    @Override
    public void deleteAdvByIds(String ids) {
        advMapper.deleteAdvByIds(ids);
    }

    @Override
    public void addAdvType(AdvType advType) {
        advMapper.addAdvType(advType);
    }

    @Override
    public AdvType queryAdvTypeById(Integer id) {
        return advMapper.queryAdvTypeById(id);
    }

    @Override
    public void updAdvType(AdvType advType) {
        advMapper.updAdvType(advType);
    }

    @Override
    public List<Adv> queryAdv() {
        return advMapper.queryAdv();
    }

    @Override
    public void deleteAdv(String ids) {
        advMapper.deleteAdv(ids);
    }

    @Override
    public void updateAdvTopStatus(Integer id, Integer flag) {
        advMapper.updateAdvTopStatus(id,flag);
    }

    @Override
    public void addAdv(Adv adv) {
        advMapper.addAdv(adv);
    }

    @Override
    public Adv queryAdvById(Integer id) {
        return advMapper.queryAdvById(id);
    }

    @Override
    public void updAdv(Adv adv) {
        advMapper.updAdv(adv);
    }
}
