package com.edu.finance.es;

import java.util.List;
import java.util.Map;

public class CRUTES {

	public static void main(String[] args) {  
        try {  
            ElasticSearchService service = new ElasticSearchService("elasticsearch", "10.10.4.212", 9300);
            //service.createIndex("test_index");
            //Map<String,String> map = new HashMap<String,String>();
            //map.put("key", "key1");
           //map.put("name", "name1");
            //service.insertData("test_index", "tableName1", JSON.toJSONString(map));
            ESQueryBuilderConstructor constructor = new ESQueryBuilderConstructor();  
            constructor.must(new ESQueryBuilders().term("key", "key1"));  
            //constructor.should(new ESQueryBuilders().term("gender", "f").range("age", 20, 50).fuzzy("age", 20));  
            //constructor.mustNot(new ESQueryBuilders().term("gender", "m"));  
            constructor.setSize(15);  //查询返回条数，最大 10000  
            constructor.setFrom(0);  //分页查询条目起始位置， 默认0  
            //constructor.setAsc("empname"); //排序  
  
            List<Map<String, Object>> list = service.search("test_index", "tableName1", constructor); 
            System.out.println("------"+list);
//            Map<Object, Object> map = service.statSearch("dept", "employee", constructor, "state");  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
}
