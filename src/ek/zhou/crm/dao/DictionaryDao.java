package ek.zhou.crm.dao;

import java.util.List;

import ek.zhou.crm.domain.Dictionary;

public interface DictionaryDao {

	List<Dictionary> findByTypeCode(String dict_type_code);

}
