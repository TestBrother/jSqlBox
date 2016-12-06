package test.jdbc;

import static com.github.drinkjava2.jsqlbox.SqlHelper.e;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.github.drinkjava2.BeanBox;
import com.github.drinkjava2.jsqlbox.Dao;
import com.github.drinkjava2.jsqlbox.SqlBox;
import com.github.drinkjava2.jsqlbox.SqlHelper;

import test.config.InitializeDatabase;
import test.config.po.User;

public class BatchInsertTest {
	@Before
	public void setup() {
		InitializeDatabase.dropAndRecreateTables();
	}

	public void tx_BatchInsertDemo() {
		User u = SqlBox.createBean(User.class);
		for (int i = 0; i < 1000; i++)
			Dao.dao().cacheSQL("insert ", u.table(), " (", u.userName(), e("user" + i), ",", u.age(), e("70"), ") ",
					SqlHelper.questionMarks());
		Dao.dao().executeCachedSQLs();
	}

	@Test
	public void doTest() {
		User u = SqlBox.createBean(User.class);
		BatchInsertTest t = BeanBox.getBean(BatchInsertTest.class);
		t.tx_BatchInsertDemo();
		Assert.assertEquals(1000, (int) Dao.dao().queryForInteger("select count(*) from ", u.table()));
	}

}