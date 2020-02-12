package ek.zhou.crm.service.imp;

import java.util.List;

import ek.zhou.crm.dao.DictionaryDao;
import ek.zhou.crm.domain.Dictionary;
import ek.zhou.crm.service.DictionaryService;

public class DictionaryServiceImp implements DictionaryService {
	//注入dao对象
	DictionaryDao dictionaryDao;
	/**
	 * 调用dao查询字典数据
	 */
	@Override
	public List<Dictionary> findByTypeCode(String dict_type_code) {
		return dictionaryDao.findByTypeCode(dict_type_code);
	}
	
	public DictionaryDao getDictionaryDao() {
		return dictionaryDao;
	}

	public void setDictionaryDao(DictionaryDao dictionaryDao) {
		this.dictionaryDao = dictionaryDao;
	}

	
}
