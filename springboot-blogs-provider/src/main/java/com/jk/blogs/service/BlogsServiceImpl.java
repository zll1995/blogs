package com.jk.blogs.service;


import com.alibaba.dubbo.config.annotation.Service;
import com.jk.HttpClient.HttpClient;
import com.jk.blogs.mapper.BlogsMapper;
import com.jk.blogs.model.Adv;
import com.jk.blogs.model.Blogs;
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

import java.text.SimpleDateFormat;
import java.util.*;


@Service(version = "1.0")
public class BlogsServiceImpl implements BlogsService{

    @Autowired
    private BlogsMapper blogsMapper;
    @Autowired
    private SolrClient solrClient;

    @Override
    public List<Blogs> HotBlogs(){
        List<Blogs> list = blogsMapper.HotBlogs();
        return list;
    }

    @Override
    public Map<String, Object> DailySentence() {

        return HttpClient.DailySentence();
    }

    @Override
    public List<Blogs> WeekHotBlogs() {
        List<Blogs> list = blogsMapper.WeekHotBlogs();
        return list;
    }

    @Override
    public List<Adv> slideShow() {
        List<Adv> list = blogsMapper.slideShow();
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
        Blogs b = blogsMapper.queryBlogsById(id);
        return b;
    }

    @Override
    public User queryUserById(String id) {
        return blogsMapper.queryUserById(id);
    }

    @Override
    public void addblogs(Blogs z) {
        z.setBlogs_status(1);
        blogsMapper.addblogs(z);
    }
}
