package com.huyy.mapper;
 
import java.util.List;

import com.huyy.pojo.Category;
 
public interface CategoryMapper {
 
    public int add(Category category);  
        
    public void delete(int id);  
       
    public Category get(int id);  
     
    public int update(Category category);   
       
    public List<Category> list();
    
    public int count();  
}