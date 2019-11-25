package com.jk.integral.controller;

import com.jk.integral.model.Integral;
import com.jk.integral.model.Store;
import com.jk.integral.model.StoreType;
import com.jk.integral.service.IntegralService;
import com.jk.util.ExportExcel;
import com.jk.util.OSSClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName StoreController
 * @Description: TODO
 * @Author duanwf
 * @Date 2019/11/19 10:26
 * @Version V1.0
 **/
@Controller
@RequestMapping("integral")
public class IntegralController {
    @Autowired
    private IntegralService integralService;

    //OSS上传图片
    @RequestMapping("uploadCommImg")
    @ResponseBody
    public Map uploadImg(MultipartFile image) throws IOException {
        if (image == null || image.getSize() <= 0) {
            throw new IOException("file不能为空");
        }
        OSSClientUtil ossClient = new OSSClientUtil();
        String name = ossClient.uploadImg2Oss(image);
        String imgUrl = ossClient.getImgUrl(name);
        //String[] split = imgUrl.split("\\?");
        System.out.println("图片url：" + imgUrl);
        Map map = new HashMap();
        map.put("imgUrl", imgUrl);
        return map;
    }


    //查询用户积分列表      -----段王峰
    @RequestMapping("queryIntegral")
    @ResponseBody
    public Map<String, Object> queryIntegral(Integral integral, Integer page, Integer rows) {

        return integralService.queryIntegral(integral, page, rows);
    }

    //查询积分商城列表      -----段王峰
    @RequestMapping("queryStore")
    @ResponseBody
    public Map<String, Object> queryStore(Store store, Integer page, Integer rows) {

        return integralService.queryStore(store, page, rows);
    }

    //添加积分商品信息      -----段王峰
    @RequestMapping("addStore")
    @ResponseBody
    public void addStore(Store store) {
        integralService.addStore(store);
    }

    //删除积分商品信息      -----段王峰
    @RequestMapping("delStore")
    @ResponseBody
    public void delStore(Store store) {
        integralService.delStore(store);
    }

    //根据商品ID查询回显        -----段王峰
    @RequestMapping("queryStoreById")
    @ResponseBody
    public Store queryStoreById(Integer commId) {
        return integralService.queryStoreById(commId);
    }

    //修改积分商品信息      -----段王峰
    @RequestMapping("updStore")
    @ResponseBody
    public void updStore(Store store) {
        integralService.updStore(store);
    }

    //查询商品类型
    @RequestMapping("queryCommType")
    @ResponseBody
    public List<StoreType> queryCommType() {
        return integralService.queryCommType();
    }

    //上架
    @RequestMapping("upComm")
    @ResponseBody
    public void upComm(Store store) {
        integralService.upComm(store);
    }

    //下架
    @RequestMapping("downComm")
    @ResponseBody
    public void downComm(Store store) {
        integralService.downComm(store);
    }

    @RequestMapping("queryUserComm")
    @ResponseBody
    public List queryUserComm() {
        return integralService.queryUserComm();
    }

    @RequestMapping("export")
    public void export(HttpServletResponse response) {
        List list = new ArrayList();
        try {
            list = integralService.queryUserComm();

            //定义表格的标题
            String title = "1905全体车辆信息";
            //定义列名
            String[] rowName = {"编号", "名称", "介绍", "价格", "日期", "类型"};
            //定义工具类要的数据
            List<Object[]> dataList = new ArrayList<Object[]>();

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

            //循环数据把数据存放到 List<Object[]>
            for (Car car : list) {
                Object[] obj = new Object[rowName.length];
                obj[0] = car.getCarId();
                obj[1] = car.getCarName();
                obj[2] = car.getCarShow();
                obj[3] = car.getCarPrice();
                obj[4] = sdf.format(car.getCarTime());
                if (car.getTypeId() == 1) {
                    obj[5] = "跑车";
                } else {
                    obj[5] = "轿车";
                }

                dataList.add(obj);
            }
            ExportExcel exportExcel = new ExportExcel(title, rowName, dataList, response);
            exportExcel.export();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}