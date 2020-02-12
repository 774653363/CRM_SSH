package ek.zhou.crm.dao.imp;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import ek.zhou.crm.dao.DictionaryDao;
import ek.zhou.crm.domain.Dictionary;

public class DictionaryDaoImp extends HibernateTemplate implements DictionaryDao{

	@Override
	public List<Dictionary> findByTypeCode(String dict_type_code) {
		return (List<Dictionary>) super.find("from Dictionary d where d.dict_type_code=?", dict_type_code);
	}

}
