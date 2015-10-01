package com.iisigroup.jtd.ude.tutorials03.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import com.iisigroup.jtd.ude.tutorials03.model.Contact;

public interface ContactRepository extends PagingAndSortingRepository<Contact, Long> {
}
