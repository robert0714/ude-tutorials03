package com.iisigroup.jtd.ude.tutorials03.services;

import static org.junit.Assert.*;

import com.google.common.collect.Lists;
import com.iisigroup.jtd.ude.common.DataSets;
import com.iisigroup.jtd.ude.common.ServiceTestExecutionListener;
import com.iisigroup.jtd.ude.config.JPAConfig;
import com.iisigroup.jtd.ude.tutorials03.model.Contact;
import com.iisigroup.jtd.ude.tutorials03.services.ContactService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext; 
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
      
                          
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { JPAConfig.class })
@TestExecutionListeners({ServiceTestExecutionListener.class})
@ActiveProfiles("test")
public class ContactServiceForJPAImplTest  extends AbstractTransactionalJUnit4SpringContextTests{
	@PersistenceContext
	protected EntityManager em;
	
	@Autowired
	@Qualifier("contactServiceJPAImpl")
	private ContactService contactService ;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

    @DataSets(setUpDataSet= "/com/iisigroup/jtd/ude/tutorials02/services/ContactServiceImplTest.xls")
	@Test
	public void testFindAll() throws Exception {
		List<Contact> result = contactService.findAll();

        assertNotNull(result);
        assertEquals(1, result.size());
	}

    @Test
    @DataSets(setUpDataSet="/com/iisigroup/jtd/ude/tutorials02/services/ContactServiceImplTest.xls") 
	public void testFindById() throws Exception {
    	List<Contact> result = contactService.findAll();
    	
    	 Contact contact = contactService.findById(result.get(0).getId());
    	 assertNotNull(  contact);
	}

	 
    @DataSets(setUpDataSet="/com/iisigroup/jtd/ude/tutorials02/services/ContactServiceImplTest.xls") 
	@Test
	public void testFindAllByPage() throws Exception {
		 Pageable pageable = new org.springframework.data.domain.PageRequest(0,10) ;		 
		 Page<Contact> contactPage = contactService.findAllByPage(pageable);
		 final int size = contactPage.getNumberOfElements();
		 ArrayList<Contact> list = Lists.newArrayList(contactPage.iterator());
		 assertNotNull(list);
		 assertEquals(1, size);
	} 
	
	@DataSets(setUpDataSet="/com/iisigroup/jtd/ude/tutorials02/services/ContactServiceImplTest.xls") 
	@Test
    public void testSave() throws Exception {
        deleteFromTables("CONTACT");

        Contact contact = new Contact();
        contact.setFirstName("Rod");
        contact.setLastName("Johnson");

        contactService.save(contact);
        em.flush();

        List<Contact> contacts = contactService.findAll();
        assertEquals(1, contacts.size());
    }

    @Test(expected=ConstraintViolationException.class)
    public void testAddContactWithJSR349Error() throws Exception {
        deleteFromTables("CONTACT");

        Contact contact = new Contact();

        contactService.save(contact);
        em.flush();

        List<Contact> contacts = contactService.findAll();
        assertEquals(0, contacts.size());
    }
}

