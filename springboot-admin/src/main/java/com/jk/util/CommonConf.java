package com.jk.util;


/**
 * 
 * <pre>项目名称：user    
 * 类名称：CommonConf    
 * 类描述：    
 * 创建人：郑晋虎
 * 创建时间：2019年10月15日 上午10:19:47    
 * 修改人：郑晋虎
 * 修改时间：2019年10月15日 上午10:19:47    
 * 修改备注：       
 * @version </pre>
 */
public class CommonConf {
	/*
	 * 常量名规则：所有字母必须全部大写，单词与单词之间使用 _ 下划线  隔开
	 * 
	 * 缓存左侧树
	 */
	public static final String TREE_CACHE_KEY = "tree_cache";
	
	
	/*
	 * 用户权限url
	 */
	public static final String POWERURL_CACHE_KEY = "powerUrl_cache";
	
	/*
	 * 设置用户权限缓存失效时间
	 */
	public static final Long POWERURL_CACHE_TIMEOUT = 30L;
	
    public static final String LOGIN_CACHE_KEY = "login_cache";
    
    public static final Long LOGIN_CACHE_TIMEOUT = 15l;
}
