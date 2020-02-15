package ek.zhou.crm.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

/**
 * 通用dao接口
 * @author lhm
 *
 * @param <T>
 */
public interface BaseDao<T> {
public void add(T t);//添加方法
public void delete(T t);//删除方法
public void update(T t);//更新方法
public T findById(int id);//查找方法
public List<T> findAll();//查询所有方法
public List<T> findPageByCondition(DetachedCriteria detachedCriteria,int startIndex,int pageSize);//分页条件查询
public int findCountByCondition(DetachedCriteria detachedCriteria);//条件查询总数
}
