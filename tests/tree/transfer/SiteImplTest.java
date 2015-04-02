package tree.transfer;

import static org.junit.Assert.*;
import tree.transfer.SiteImpl;
import tree.transfer.SiteItf;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SiteImplTest {
	
	
	private SiteItf s1;
	private SiteItf s2;
	private SiteItf s3;
	private List<SiteItf> l;
	
	@Before
	public void before() throws RemoteException{
	
		s1 = new SiteImpl();
		s2 = new SiteImpl();
		s3 = new SiteImpl();
		s2.setFather(s1);
		s3.setFather(s1);
		l = new ArrayList<SiteItf>();
	}

	

	@Test
	public void testIsRoot() throws RemoteException {
		
		assertTrue("Failed isRoot", s1.isRoot());
		assertFalse("Failed isRoot", s2.isRoot());
		assertFalse("Failed isRoot", s3.isRoot());
	}

	@Test
	public void testSetFather() throws RemoteException {
		
		s3.setFather(s2);
		
		assertEquals("Failed set father", s3.getFather(), s2 );
		
	}

	@Test
	public void testSetSons() throws RemoteException {
		
		l.add(s2);
		l.add(s3);
		s1.setSons(l);
		
		assertTrue("Failed setting sons - Sons size", s1.getSons().size() == 2);
		assertEquals("Failed setting sons - Sons first object", s1.getSons().get(0), s2 );
		assertEquals("Failed setting sons - Sons second object", s1.getSons().get(1), s3 );
	}

	@Test
	public void testAddSon() throws RemoteException {
		
		s1.addSon(s2);
		
		assertTrue("Failed adding neighbours - Neighbours size", s1.getSons().size() == 1);
		assertEquals("Failed adding neighbours - Neighbours first object", s1.getSons().get(0), s2 );
	
	}

	@Test
	public void testReceive() throws RemoteException {
	
		l.add(s2);
		l.add(s3);
		s1.setSons(l);
		s1.receive(new String("message").getBytes());
		
		assertEquals("Fail transfer message",s1.getMsg(),"message");
		assertEquals("Fail transfer message - son one",s2.getMsg(),"message");
		assertEquals("Fail transfer message - son two",s3.getMsg(),"message");
		
	}



}
