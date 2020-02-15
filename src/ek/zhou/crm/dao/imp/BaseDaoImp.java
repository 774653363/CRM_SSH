package ek.zhou.crm.dao.imp;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.HibernateTemplate;

import ek.zhou.crm.dao.BaseDao;
/**
 * BaseDao的实现类
 * @author lhm
 *
 * @param <T>
 */
public class BaseDaoImp<T> extends HibernateDaoSupport implements BaseDao<T>{
	
	private Class clazz;
	//构造方法中获取子类的泛型具体Class
	public BaseDaoImp() {
		Class c = this.getClass();//获取子类Class 如:CustomerDaoImp的Class对象等
		//调用Class的方法带有泛型的父类  如:BaseDaoImp<Customer>等
		Type type = c.getGenericSuperclass();
		if(type instanceof ParameterizedType){
			ParameterizedType pType = (ParameterizedType)type;//参数化类型BaseDaoImp<Customer>
			Type[] types = pType.getActualTypeArguments();//获取实际类型参数
			//获取某一个实际类型参数
			this.clazz = (Class)types[0];
			
		}
	}


	@Override
	public void add(T t) {
		this.getHibernateTemplate().save(t);
	}

	@Override
	public T findById(int id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
	
	@Override
	public void update(T t){
		this.getHibernateTemplate().update(t);
	}


	@Override
	public void delete(T t) {
		this.getHibernateTemplate().delete(t);
	}


	@Override
	public List<T> findAll() {
		return (List<T>)this.getHibernateTemplate().find("from "+clazz.getSimpleName());
	}


	@Override
	public List<T> findPageByCondition(DetachedCriteria detachedCriteria,int startIndex,int pageSize) {
		detachedCriteria.setProjection(null);
		return  (List<T>)this.getHibernateTemplate().findByCriteria(detachedCriteria, startIndex, pageSize);
	}


	@Override
	public int findCountByCondition(DetachedCriteria detachedCriteria) {
		detachedCriteria.setProjection(Projections.rowCount());
		List<Long> l = (List<Long>)this.getHibernateTemplate().findByCriteria(detachedCriteria);
		if(l.size()>0){
			return l.get(0).intValue();
		}
		return 0;
	}


	@Override
	public T findById(String id) {
		return (T) this.getHibernateTemplate().get(clazz, id);
	}
}