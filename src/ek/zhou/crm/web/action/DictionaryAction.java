package ek.zhou.crm.web.action;

import java.io.IOException;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

import ek.zhou.crm.domain.Dictionary;
import ek.zhou.crm.service.DictionaryService;
import net.sf.json.JSONArray;

public class DictionaryAction extends ActionSupport{
	//注入Service
	DictionaryService dictionaryService;
	//Dictionary
	Dictionary dictionary;
	/**
	 * ajax查询数据字典
	 * @return
	 * @throws IOException 
	 */
	public String findByTypeCode() throws IOException{
		//调用业务层查询
		List<Dictionary> list = dictionaryService.findByTypeCode(dictionary.getDict_type_code());
		//转换成json
		JSONArray jsonArray = JSONArray.fromObject(list);
		//使用response返回json
		ServletActionContext.getResponse().setContentType("text/html;charset=UTF-8");
		ServletActionContext.getResponse().getWriter().write(jsonArray.toString());
		return NONE;
	}
	
	public DictionaryService getDictionaryService() {
		return dictionaryService;
	}

	public void setDictionaryService(DictionaryService dictionaryService) {
		this.dictionaryService = dictionaryService;
	}

	public Dictionary getDictionary() {
		return dictionary;
	}

	public void setDictionary(Dictionary dictionary) {
		this.dictionary = dictionary;
	}
	
}
