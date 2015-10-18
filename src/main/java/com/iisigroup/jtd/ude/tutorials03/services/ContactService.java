package com.iisigroup.jtd.ude.tutorials03.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iisigroup.jtd.ude.tutorials03.model.Contact;

public interface ContactService {
    List<Contact> findAll();
    Contact findById(Long id);
    Contact save(Contact contact);
    Page<Contact> findAllByPage(Pageable pageable);
}
