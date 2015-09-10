package com.iisigroup.jtd.ude.tutorials02.services;
  
import java.util.Iterator;
import java.util.List; 
 
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder; 
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists; 
import com.iisigroup.jtd.ude.tutorials02.model.Contact;
import com.iisigroup.ude.db.DBFacade;
import com.iisigroup.ude.db.DBFacadeFactory; 
import com.iisigroup.ude.db.dbaccess.common.PagedList;
import com.iisigroup.ude.db.dbaccess.common.PagedQueryResults; 
import com.iisigroup.ude.db.dbaccess.common.query.PageParams;
import com.iisigroup.ude.db.dbaccess.common.query.QueryParams;
import com.iisigroup.ude.db.dbaccess.common.query.SqlType;

@Repository
@Transactional
@Service("contactServiceForUDEDBImpl")
public class ContactServiceForUDEDBImpl implements ContactService {
	
    /** Logger Object. */
    private static final org.slf4j.Logger LOGGER = org.slf4j.LoggerFactory.getLogger(ContactServiceForUDEDBImpl.class);
	
    @Autowired
    @Qualifier("dbFacadeFactoryImpl")
    private DBFacadeFactory dbFacadeFactory;

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
    	List<Contact> init =null;
    	try (DBFacade facade = this.dbFacadeFactory.create()) {
    		init = facade.queryForList(Contact.class ,"select * from CONTACT  ");
        }
        return Lists.newArrayList(init); 
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findById(Long id) {
    	Contact result = null; 
    	try (DBFacade facade = this.dbFacadeFactory.create()) {
    		QueryParams params = new QueryParams();
    		params.addParam(SqlType.DOUBLE, Long.valueOf(id));    		
			List<Contact> init = facade.queryForList(Contact.class ,"select * from CONTACT where CONTACT.ID = ? ",params);
			if(CollectionUtils.isNotEmpty(init)){
				result = init.get(0);
			}
        }
    	return result;
    }

    @Override
    public Contact save(Contact contact) {
    	Contact result = new Contact();
    	BeanUtils.copyProperties(contact, result);
    	
    	LOGGER.debug("save {}",ReflectionToStringBuilder.toString(result));    	
    	
    	try (DBFacade facade = this.dbFacadeFactory.create()) {
    		//判別是否有UID了
    		if(result.getId() == null ){
    			facade.insert(result);
    		}else{
    			facade.update(result);    			
    		}  
        }
    	
    	return result;
    }
 

    @Override
    @Transactional(readOnly=true)
    public Page<Contact> findAllByPage(Pageable pageable) {
    	Page<Contact> result =null ; 
    	 
    	final QueryParams params = new QueryParams();
    	final PageParams pageParams = convert(pageable);
		final String orderDesc = getOrderDesc(pageable);
		final String originalSQL = "select * from CONTACT  ";
		final String finalSql ; 
		if(StringUtils.isEmpty(orderDesc)){
			finalSql = originalSQL;
		}else{
			finalSql=String.format("select * from CONTACT  %s ", orderDesc) ;
		}
    	try (DBFacade facade = this.dbFacadeFactory.create()) {
			final PagedQueryResults initData = facade.queryForList(finalSql,  params  , pageParams);
			 
			final PagedList<Contact> data = initData.convertToObjects( new ContactConvertor4UDE() ) ;			
			
			result = convertByPagedQueryResults(data);	
			
        }
    	return result;
    }
    
    private Page<Contact> convertByPagedQueryResults(PagedList<Contact> data){   	
    	 
    	final Page<Contact> result =new PageImpl<Contact>(data);
    	return result ;
    }
    
    private PageParams convert(final Pageable pageable){    	
    	final PageParams result = new PageParams();
    	result.setPageSize(pageable.getPageSize());    	
    	result.setDataCount(pageable.getPageNumber());
    	result.setPageNo(pageable.getPageNumber());
    	
    	return result ;
    }
    
    private String getOrderDesc (final Pageable pageable){
    	String result = null;
    	Sort sort = pageable.getSort();
    	if(sort==null){
    		return result;
    	}
    	final 	Iterator<Order> iterator = sort.iterator();
    	while(iterator.hasNext()){
    		final	Order order = iterator.next();
    		order.getProperty();
    	}
    	return result ;
    }
    
}
