package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jk.HttpClient.HttpClient;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Blogs;
import com.jk.blogs.model.Fans;
import com.jk.blogs.model.SlideShow;
import com.jk.blogs.model.SolrShow;
import com.jk.comment.model.Comment;
import com.jk.user.model.User;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;


@Service(version = "1.0")
public class BlogsServiceImpl implements BlogsService{

    @Autowired
    private BlogsMapper blogsMapper;
    @Autowired
    private SolrClient solrClient;
    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Override
    public List<Blogs> HotBlogs(){
        String Key = "HotBlogs";
        List<Blogs> list = new ArrayList<Blogs>();
        Boolean aBoolean = redisTemplate.hasKey(Key);
        if(aBoolean){
            String s = redisTemplate.opsForValue().get(Key);
            list = JSON.parseArray(s, Blogs.class);
        }else{
            list = blogsMapper.HotBlogs();
            redisTemplate.opsForValue().set(Key,JSON.toJSONString(list));
            redisTemplate.expire(Key,2, TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public Map<String, Object> DailySentence() {
        String Key = "DailySentence";
        Map<String, Object> result = new HashMap<>();
        Boolean aBoolean = redisTemplate.hasKey(Key);
        if(aBoolean){
            Map<Object, Object> entries = redisTemplate.opsForHash().entries(Key);
            for (Map.Entry<Object, Object> entry : entries.entrySet()) {
                result.put(entry.getKey().toString(), entry.getValue().toString());
            }
        }else{
            result = HttpClient.DailySentence();
            redisTemplate.opsForHash().putAll(Key,result);
            redisTemplate.expire(Key,30, TimeUnit.MINUTES);
        }
        return result;
    }

    @Override
    public List<Blogs> WeekHotBlogs() {
        String Key = "WeekHotBlogs";
        List<Blogs> list = new ArrayList<Blogs>();
        Boolean aBoolean = redisTemplate.hasKey(Key);
        if(aBoolean){
            String s = redisTemplate.opsForValue().get(Key);
            list = JSON.parseArray(s, Blogs.class);
        }else{
            list = blogsMapper.WeekHotBlogs();
            redisTemplate.opsForValue().set(Key,JSON.toJSONString(list));
            redisTemplate.expire(Key,1, TimeUnit.DAYS);
        }
        return list;
    }

    @Override
    public List<SlideShow> slideShow() {
        List<SlideShow> list = blogsMapper.slideShow();
        return list;
    }

    @Override
    public Map<String, Object> queryzhangAll(Blogs z, int page, int rows) {
        int sum = blogsMapper.querysum(z);
        int start = (page-1)*rows;
        List<Blogs> userList = blogsMapper.queryzhangAll(z,start,rows);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",sum);
        map.put("rows",userList);

        return map;
    }

    @Override
    public Blogs queryblogsById(Integer blogs_id) {
        return blogsMapper.queryblogsById(blogs_id);
    }

    @Override
    public void updateblogs(Blogs z) {
        blogsMapper.updateblogs(z);
    }

    @Override
    public void updateblogsautus(Integer blogs_id) {
        blogsMapper.updateblogsautus(blogs_id);
    }

    @Override
    public Map<String, Object> queryzhanghui(Blogs z, int page, int rows) {
        int sum = blogsMapper.querysum1(z);
        int start = (page-1)*rows;
        List<Blogs> userList = blogsMapper.queryzhanghui(z,start,rows);
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("total",sum);
        map.put("rows",userList);

        return map;
    }

    @Override
    public List<Blogs> queryBlogsNews() {
        return blogsMapper.queryBlogsNews();
    }

    @Override
    public List<Comment> NewComment() {
        return blogsMapper.NewComment();
    }

    @Override   //solrClient
    public Map<String, Object> SolrBlogs(String context,Integer page,Integer rows) {
        Map<String, Object> map1 =new HashMap<>();
        try {
            SolrQuery params = new SolrQuery();
            //查询条件, 这里的 q 对应 下面图片标红的地方
            if(context != null && !"".equals(context)){
                params.set("q",context);
            }
            //排序
            params.addSort("look", SolrQuery.ORDER.desc);
            //分页
            if(page==null){
                params.setStart(0);
            }else{
                params.setStart((page-1)*rows);
            }
            if(rows==null){
                params.setRows(5);
            }else{
                params.setRows(rows);
            }
            //默认域
            params.set("df", "title");
            //高亮
            //打开开关
            params.setHighlight(true);
            //指定高亮域
            params.addHighlightField("title");
            //设置前缀
            params.setHighlightSimplePre("<span style='color:red'>");
            //设置后缀
            params.setHighlightSimplePost("</span>");
            //查询后返回的对象
            QueryResponse queryResponse = solrClient.query("core1",params);
            //查询后返回的对象 获得真正的查询结果
            SolrDocumentList results = queryResponse.getResults();
            //查询的总条数
            long numFound = results.getNumFound();
            System.out.println("查询到的总条数为："+numFound);
            //获取高亮显示的结果, 高亮显示的结果和查询结果是分开放的
            Map<String, Map<String, List<String>>> highlight = queryResponse.getHighlighting();
            List<SolrShow> list = new ArrayList<SolrShow>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            for (SolrDocument result : results){
                SolrShow ss = new  SolrShow();
                String highFile="";
                Map<String, List<String>> map = highlight.get(result.get("id"));
                List<String> list1 = map.get("title");
                if(list1==null){
                    highFile= result.get("title").toString();
                }else {
                    highFile=list1.get(0);
                }
                ss.setId(Integer.parseInt(result.get("id").toString()));
                ss.setTitle(highFile);
                ss.setContent(result.get("content").toString());
                ss.setNickname(result.get("nickname").toString());
                Date time = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US).parse(result.get("time").toString());
                ss.setTime(sdf.format(time));
                ss.setLook(Integer.parseInt(result.get("look").toString()));
                ss.setUrl(result.get("url").toString());
                ss.setImg(result.get("img").toString());
                list.add(ss);
            }
            map1.put("total",numFound);
            map1.put("rows",list);
            return map1;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Blogs queryBlogsById(String id) {
        blogsMapper.addBlogsLookById(id);
        Blogs b = blogsMapper.queryBlogsById(id);
        return b;
    }

    @Override
    public User queryUserById(String id) {
        return blogsMapper.queryUserById(id);
    }

    @Override
    public Integer queryFansState(String id) {
        Integer state = 0;
        Integer userid = 1;
        Fans f =  blogsMapper.queryFansState(userid,id);
        if(f != null && f.getAnd_id() == 1){
            state = 2;
        }else if (f != null && f.getAnd_id() == 0){
            state = 1;
        }else if(f == null){
            state = 0;
        }
        return state;
    }

    @Override
    public Integer SetFansState(String id,String state) {
        Integer userid = 1;
        Integer andid = 0;
        if("2".equals(state)){
            blogsMapper.deleteFans(userid,id);
            blogsMapper.updateHeAndId(userid,id,0);
            return 3;
        }else if("1".equals(state)){
            //查询对方是否关注了自己
            Fans fans = blogsMapper.queryFansAndState(userid,id);
            //根据andid设置是否相互关注   0.未相互关注，1.相互关注
            if(fans != null){
                andid= 1 ;
                //修改要明星对当前用户的关注状态
                blogsMapper.updateFansState(userid,id,andid);
            }
            //将关注信息加入表中
            blogsMapper.SetFansState(userid,id,andid);
        }
        Fans f =  blogsMapper.queryFansState(userid,id);
        if(f.getAnd_id() == 0){
            return 0;
        }
        return 1;
    }

    @Override
    public Integer queryBlogsLikeButtonState(String blogsid) {
        Integer userid = 1;
        Integer count = blogsMapper.queryBlogsLikeButtonState(userid,blogsid);
        return count;
    }

    @Override
    public void updateLikeButtonState(String blogsid, String state) {
        Integer userid = 1;
        if("1".equals(state)){
            Integer count = blogsMapper.queryBlogsLikeButtonState(userid,blogsid);
            if(count ==0){
                blogsMapper.addLikeTableLike(blogsid,userid);
                blogsMapper.updateBlogsTableLike(blogsid,"+1");
            }
        }else if("2".equals(state)){
            blogsMapper.deleteLikeTableLike(blogsid,userid);
            blogsMapper.updateBlogsTableLike(blogsid,"-1");
        }
    }

    @Override
    public Integer queryBlogsLikeByBlogsId(String id) {
        return blogsMapper.queryBlogsLikeByBlogsId(id);
    }

    @Override
    public Integer queryUserBlogsCount(String id) {
        return  blogsMapper.queryUserBlogsCount(id);
    }

    @Override
    public Integer queryUserFansCount(String id) {
        return  blogsMapper.queryUserFansCount(id);
    }


}
