package com.yuanchanglin.yapi.base;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiModel;

import java.util.Collection;
import java.util.Map;

/**
 * @author ycl
 * @since 2018-07-17
 */
@ApiModel(value="通用多条件查询对象")
public class BaseQuery {
    private Map<String,String> allEq;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> eq;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> ne;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> gt;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> ge;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> lt;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> le;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> like;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> notLike;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> likeLeft;
//    @Size(max = 1,message = "只允许1个参数")
    private Map<String,String> likeRight;
    private String nullColum;
    private String notNullColum;
    private Map<String, Collection<?>> in;
    private Map<String, Collection<?>> notIn;
    private String[] groupBy;
    private String[] orderByAsc;
    private String[] orderByDesc;
    private String[] select;
    private boolean needPaging = false;
    private boolean searchCount = true;
    private int pageSize = 10;
    private int current = 1;

    private Map<String,String> toLine(Map<String,String> map){
        for(String key : map.keySet()){
            String newKey= humpToUnderline(key);
            map.put(newKey,map.get(key));
            map.remove(key);
        }
        return map;
    }

    /**
     * 驼峰转下划线 可以放入工具类
     * @param para
     * @return
     */
    public static String humpToUnderline(String para){
        StringBuilder sb=new StringBuilder(para);
        int temp=0;//定位
        if (!para.contains("_")) {
            for(int i=0;i<para.length();i++){
                if(Character.isUpperCase(para.charAt(i))){
                    sb.insert(i+temp, "_");
                    temp+=1;
                }
            }
        }
        return sb.toString().toLowerCase();
    }
    public static String[] humpToUnderline(String... para){
        String[] parms = new String[para.length];
        for(int i =0; i < para.length; i++) {
            String humpToUnderline = humpToUnderline(para[i]);
            parms[i] = humpToUnderline;
        }
        return parms;
    }

    /**
     * 分页参数
     * @return
     */
    public Page page(){
        Page page = new Page();
        page.setSize(pageSize);
        page.setDesc(orderByDesc);
        page.setAsc(orderByAsc);
        page.setCurrent(current);
        page.setSearchCount(searchCount);
        return page;
    }

    /**
     * 获取QueryWrapper
     * @return QueryWrapper 要排除的条件
     */

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public QueryWrapper queryWrapper() {
        QueryWrapper queryWrapper = new QueryWrapper();
        if(allEq != null) {
            queryWrapper.allEq(allEq);
        }
        if(eq != null) {
            queryWrapper.eq(humpToUnderline(getKeyOrNull(eq)),eq.get(getKeyOrNull(eq)));
        }
        if(ne != null) {
            queryWrapper.ne(humpToUnderline(getKeyOrNull(ne)),ne.get(getKeyOrNull(ne)));
        }
        if(gt != null) {
            queryWrapper.gt(humpToUnderline(getKeyOrNull(gt)),gt.get(getKeyOrNull(gt)));
        }
        if(ge != null) {
            queryWrapper.ge(humpToUnderline(getKeyOrNull(ge)),ge.get(getKeyOrNull(ge)));
        }
        if(lt != null) {
            queryWrapper.lt(humpToUnderline(getKeyOrNull(lt)),lt.get(getKeyOrNull(lt)));
        }
        if(le != null) {
            queryWrapper.le(humpToUnderline(getKeyOrNull(le)),le.get(getKeyOrNull(le)));
        }
        if(like != null) {
            queryWrapper.like(humpToUnderline(getKeyOrNull(like)),like.get(getKeyOrNull(like)));
        }
        if(notLike != null) {
            queryWrapper.notLike(humpToUnderline(getKeyOrNull(notLike)),notLike.get(getKeyOrNull(notLike)));
        }
        if(likeLeft != null) {
            queryWrapper.likeLeft(humpToUnderline(getKeyOrNull(likeLeft)),likeLeft.get(getKeyOrNull(likeLeft)));
        }
        if(likeRight != null) {
            queryWrapper.likeRight(humpToUnderline(getKeyOrNull(likeRight)),likeRight.get(getKeyOrNull(likeRight)));
        }
        if(nullColum != null) {
            queryWrapper.isNull(humpToUnderline(nullColum));
        }
        if(notNullColum != null) {
            queryWrapper.isNotNull(humpToUnderline(notNullColum));
        }
        if(in != null) {
            queryWrapper.in(humpToUnderline(getKeyOrNulle(in)),in.get(getKeyOrNulle(in)));
        }
        if(notIn != null) {
            queryWrapper.notIn(humpToUnderline(getKeyOrNulle(notIn)),notIn.get(getKeyOrNulle(notIn)));
        }
        if(groupBy != null) {
            queryWrapper.groupBy(humpToUnderline(groupBy));
        }
        if(orderByAsc != null) {
            queryWrapper.orderByDesc(humpToUnderline(orderByAsc));
        }
        if(orderByDesc != null) {
            queryWrapper.orderByAsc(humpToUnderline(orderByDesc));
        }
        if(select != null) {
            queryWrapper.select(humpToUnderline(select));
        }
        return queryWrapper;
    }

    private static String getKeyOrNull(Map<String, String> map) {
        if(map==null) {
            return null;
        }
        String obj = null;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }
    private static String getKeyOrNulle(Map<String, Collection<?>> map) {
        if(map==null) {
            return null;
        }
        String obj = null;
        for (Map.Entry<String, Collection<?>> entry : map.entrySet()) {
            obj = entry.getKey();
            if (obj != null) {
                break;
            }
        }
        return  obj;
    }

    public Map<String, String> getAllEq() {
        return allEq;
    }

    public void setAllEq(Map<String, String> allEq) {
        this.allEq = allEq;
    }

    public Map<String, String> getEq() {
        return eq;
    }

    public void setEq(Map<String, String> eq) {
        this.eq = eq;
    }

    public Map<String, String> getNe() {
        return ne;
    }

    public void setNe(Map<String, String> ne) {
        this.ne = ne;
    }

    public Map<String, String> getGt() {
        return gt;
    }

    public void setGt(Map<String, String> gt) {
        this.gt = gt;
    }

    public Map<String, String> getGe() {
        return ge;
    }

    public void setGe(Map<String, String> ge) {
        this.ge = ge;
    }

    public Map<String, String> getLt() {
        return lt;
    }

    public void setLt(Map<String, String> lt) {
        this.lt = lt;
    }

    public Map<String, String> getLe() {
        return le;
    }

    public void setLe(Map<String, String> le) {
        this.le = le;
    }

    public Map<String, String> getLike() {
        return like;
    }

    public void setLike(Map<String, String> like) {
        this.like = like;
    }

    public Map<String, String> getNotLike() {
        return notLike;
    }

    public void setNotLike(Map<String, String> notLike) {
        this.notLike = notLike;
    }

    public Map<String, String> getLikeLeft() {
        return likeLeft;
    }

    public void setLikeLeft(Map<String, String> likeLeft) {
        this.likeLeft = likeLeft;
    }

    public Map<String, String> getLikeRight() {
        return likeRight;
    }

    public void setLikeRight(Map<String, String> likeRight) {
        this.likeRight = likeRight;
    }

    public void setNullColum(String nullColum) {
        this.nullColum = nullColum;
    }

    public void setNotNullColum(String notNullColum) {
        this.notNullColum = notNullColum;
    }

    public Map<String, Collection<?>> getIn() {
        return in;
    }

    public void setIn(Map<String, Collection<?>> in) {
        this.in = in;
    }

    public Map<String, Collection<?>> getNotIn() {
        return notIn;
    }

    public void setNotIn(Map<String, Collection<?>> notIn) {
        this.notIn = notIn;
    }

    public String[] getGroupBy() {
        return groupBy;
    }

    public void setGroupBy(String[] groupBy) {
        this.groupBy = groupBy;
    }

    public String[] getOrderByAsc() {
        return orderByAsc;
    }

    public void setOrderByAsc(String[] orderByAsc) {
        this.orderByAsc = orderByAsc;
    }

    public String[] getOrderByDesc() {
        return orderByDesc;
    }

    public void setOrderByDesc(String[] orderByDesc) {
        this.orderByDesc = orderByDesc;
    }

    public String[] getSelect() {
        return select;
    }

    public void setSelect(String[] select) {
        this.select = select;
    }

    public boolean isNeedPaging() {
        return needPaging;
    }

    public void setNeedPaging(boolean needPaging) {
        this.needPaging = needPaging;
    }

    public boolean isSearchCount() {
        return searchCount;
    }

    public void setSearchCount(boolean searchCount) {
        this.searchCount = searchCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

}