package com.iisigroup.jtd.ude.tutorials03.services;
//package com.iisigroup.jtd.ude.tutorials03.services;
//
////咬我啊
///*喔ｙa*/
//import static org.junit.Assert.*;
//
//import com.google.common.collect.Lists;
//import com.iisigroup.jtd.ude.common.ServiceTestExecutionListener;
//import com.iisigroup.jtd.ude.config.UDEConfig;
//import com.iisigroup.jtd.ude.tutorials03.model.Contact;
//
//import java.util.ArrayList;
//import java.util.List;
// 
//import javax.validation.ConstraintViolationException;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith; 
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.Pageable;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.TestExecutionListeners;
//import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
////
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = { UDEConfig.class })
//@TestExecutionListeners({ServiceTestExecutionListener.class})
//public class ContactServiceForUDEDBImplTest extends AbstractTransactionalJUnit4SpringContextTests{
//	 
//	@Autowired
//	private ContactService contactService ;
//	 
//	
//	@Before
//	public void setUp() throws Exception {
//	}
//
//	@After
//	public void tearDown() throws Exception {
//	}
//
//    @Test
//	public void testFindAll() throws Exception {
//		final List<Contact> result = contactService.findAll();
//		assertNotNull(result);
//		assertNotEquals(0, result.size());
//
//	}
//    
//	@Test	
//	public void testFindById() throws Exception {
//		List<Contact> result = contactService.findAll();
//		Contact contact = contactService.findById(result.get(0).getId());
//		assertNotNull(contact);
//	}
//
//	@Test
//	public void testFindAllByPage() throws Exception {
//		 Pageable pageable = new org.springframework.data.domain.PageRequest(0,10) ;		 
//		 Page<Contact> contactPage = contactService.findAllByPage(pageable);
//		 final int size = contactPage.getNumberOfElements();
//		 ArrayList<Contact> list = Lists.newArrayList(contactPage.iterator());
//		 assertNotNull(list);
//		 assertEquals(10, size);
//	} 
//	
//	@Test
//    public void testSave() throws Exception {
//        deleteFromTables("CONTACT");
//
//        Contact contact = new Contact();
//        contact.setFirstName("Rod");
//        contact.setLastName("Johnson");
//
//        contactService.save(contact);
////        em.flush();
//
//        List<Contact> contacts = contactService.findAll();
//        assertEquals(1, contacts.size());
//    }
//
//    @Test(expected=ConstraintViolationException.class)
//    public void testAddContactWithJSR349Error() throws Exception {
//        deleteFromTables("CONTACT");
//
//        Contact contact = new Contact();
//
//        contactService.save(contact);
////        em.flush();
//
//        List<Contact> contacts = contactService.findAll();
//        assertEquals(0, contacts.size());
//    }
//
//}
// 
