package ek.zhou.crm.service;

import java.util.List;

import ek.zhou.crm.domain.Dictionary;

public interface DictionaryService {

	List<Dictionary> findByTypeCode(String dict_type_code);

}
