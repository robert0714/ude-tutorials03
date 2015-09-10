package com.iisigroup.jtd.ude.tutorials02.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

//import com.google.common.collect.Lists;
import com.iisigroup.jtd.ude.tutorials02.dao.ContactDao;
import com.iisigroup.jtd.ude.tutorials02.model.Contact;

//@Repository
//@Transactional
//@Service("contactService")
public class ContactServiceForHibernateImpl implements ContactService {
//    private ContactRepository contactRepository;
	
	@Autowired
	private ContactDao contactDao;

    @Override
    @Transactional(readOnly=true)
    public List<Contact> findAll() {
//    	return Lists.newArrayList(contactDao.findAll());
    	return contactDao.findAll();
    }

    @Override
    @Transactional(readOnly=true)
    public Contact findById(Long id) {
    	return contactDao.findById(id);
    }

    @Override
    public Contact save(Contact contact) {
    	return contactDao.save(contact);    	
    }

    @Override
    @Transactional(readOnly=true)
    public Page<Contact> findAllByPage(Pageable pageable) {
//        return contactRepository.findAll(pageable);
    	return contactDao.findAll(pageable);
    }

}
