package test.id_generator;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.drinkjava2.BeanBox;
import com.github.drinkjava2.jsqlbox.id.IdGenerator;
import com.github.drinkjava2.jsqlbox.id.IdentityGenerator;

import test.config.TestPrepare;
import test.config.po.User;

public class IdentityGeneratorTest {

	@Before
	public void setup() {
		TestPrepare.dropAndRecreateTables();
	}

	@After
	public void cleanUp() {
		TestPrepare.closeBeanBoxContext();
	}

	@Test
	public void insertUser() {
		User u = new User();
		u.box().configIdGenerator("id", (IdGenerator) new BeanBox(IdentityGenerator.class).getBean());
		u.setUserName("User1");
		for (int i = 0; i < 10; i++) {
			u.dao().insert();
		}
		Assert.assertEquals(10, (int) u.dao().queryForInteger("select count(*) from ", u.table()));
	}

}