package com.iisigroup.jtd.ude.tutorials02.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iisigroup.jtd.ude.tutorials02.model.Contact;

public interface ContactDao {
    List<Contact> findAll();
    List<Contact> findAllWithDetail();
    Contact findById(Long id);
    Contact save(Contact contact);
    void delete(Contact contact);
	Page<Contact> findAll(Pageable pageable);	
}
