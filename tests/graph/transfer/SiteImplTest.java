package graph.transfer;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class SiteImplTest {
	
	private SiteImpl s1;
	private SiteImpl s2;
	private SiteImpl s3;
	private List<SiteItf> l;
	
	@Before
	public void before() throws RemoteException{
		
		s1 = new SiteImpl();
		s2 = new SiteImpl();
		s3 = new SiteImpl();
		l = new ArrayList<SiteItf>();
	}


	@Test
	public void testSetNeighbours() throws RemoteException {
		
		l.add(s2);
		l.add(s3);
		s1.setNeighbours(l);
		
		assertTrue("Failed setting neighbours - Neighbours size", s1.getNeighbours().size() == 2);
		assertEquals("Failed setting neighbours - Neighbours first object", s1.getNeighbours().get(0), s2 );
		assertEquals("Failed setting neighbours - Neighbours second object", s1.getNeighbours().get(1), s3 );
	}

	@Test
	public void testAddNeighbour() throws RemoteException {
		
		s1.addNeighbour(s2);
		
		assertTrue("Failed adding neighbours - Neighbours size", s1.getNeighbours().size() == 1);
		assertEquals("Failed adding neighbours - Neighbours first object", s1.getNeighbours().get(0), s2 );
	}

	@Test
	public void testReceive() throws RemoteException {
		
		l.add(s2);
		l.add(s3);
		s1.setNeighbours(l);
		s1.receive(new String("message").getBytes());
		
		assertEquals("Fail transfer message",s1.getMsg(),"message");
		assertEquals("Fail transfer message - son one",s2.getMsg(),"message");
		assertEquals("Fail transfer message - son two",s3.getMsg(),"message");
		
	}



}
