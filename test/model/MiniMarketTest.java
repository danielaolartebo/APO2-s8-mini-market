package model;

import exceptions.NoAgeException;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Calendar;
import java.util.GregorianCalendar;
import exceptions.NoDayException;
import org.junit.jupiter.api.Test;

class MiniMarketTest {

	private MiniMarket shop;
	private User u1;
	private User u2;
	Calendar c = new GregorianCalendar();
	String currentDay = Integer.toString((c.get(Calendar.DATE)));
	String correctImparDay = Integer.toString(c.get(Calendar.DATE) + 10);
	String correctParDay = Integer.toString(c.get(Calendar.DATE) + 20);
	
	public void setupCorrectly() {
		shop = new MiniMarket("SHOP");
		u1 = new User(correctImparDay,"CC");
		u2 = new User(correctParDay,"CC");
	}
	
	public void setupNoAge() {
		shop = new MiniMarket("SHOP");
		u1 = new User("212634","TI");
	}
	
	public void setupNoNumber() {
		shop = new MiniMarket("SHOP");
		u1 = new User(currentDay,"CC");
	}
	
	@Test
	public void testRegister1() {
		setupCorrectly();
		int onlyNumber = c.get(Calendar.DATE)/10;
		if((c.get(Calendar.DATE) % 2 != 0 && onlyNumber == 1 || onlyNumber == 3) || c.get(Calendar.DATE) % 2 == 0 && onlyNumber == 2 ) {
		try {
			shop.Register(u1);
			assertEquals(1, shop.getUsers().size());
		}catch(NoDayException d){	
			fail(d.getMessage());
		}catch(NoAgeException a) {	
			fail(a.getMessage());
		}
		}else {
			try {	
				shop.Register(u2);
				assertEquals(1, shop.getUsers().size());
			}catch(NoDayException d){	
				fail(d.getMessage());
			}catch(NoAgeException a) {	
				fail(a.getMessage());
			}
		}
	}
	
	@Test
	public void testRegister2() {
		setupNoAge();
		try {
			shop.Register(u1);
			assertEquals(1, shop.getUsers().size());
		}catch(NoDayException d){	
			fail(d.getMessage());
		}
		catch(NoAgeException a) {
			assertEquals(0, shop.getUsers().size());
		}
	}
	
	@Test
	public void testRegister3() {
		setupNoNumber();
		try {	
			shop.Register(u1);
			assertEquals(1, shop.getUsers().size());
		}catch(NoDayException d){	
			assertEquals(0, shop.getUsers().size());
		}catch(NoAgeException a) {
			fail(a.getMessage());
		}
	}
}
