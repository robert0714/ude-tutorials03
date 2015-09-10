package com.iisigroup.jtd.ude.tutorials02.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.iisigroup.jtd.ude.tutorials02.model.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
