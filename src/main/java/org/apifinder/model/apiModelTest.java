package org.apifinder.model;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;

import javax.sql.DataSource;


import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import jakarta.annotation.Resource;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class apiModelTest {
	

	@Resource(name="jdbc/project")
	public DataSource dataSource;
	
	

	@Test
	public void test2() {
		
		
		//fail("Not yet implemented");
		System.out.println("Inside Testing Read User");
		
		apiModel read = new apiModel();
		int count = read.listApi(dataSource,"Varun").size();
		boolean isgreater = false;
		if (count>0)
			isgreater=true;
		assertEquals(true,isgreater);
	}

	@Test
	public void test1() {
		//fail("Not yet implemented");
		apiData data = new apiData(100000, "Varun", "Test Desc", "Test auth", "Test https", "Test cors", "Test link",
				"Test category"); 
		apiModel add = new apiModel();
		boolean issuccess = add.addApi(dataSource, data);
		assertEquals(true,issuccess);
	}

	@Test
	public void test3() {
		//fail("Not yet implemented");
		apiData data = new apiData(100000, "Varun Update", "Test Desc", "Test auth", "Test https", "Test cors", "Test link",
				"Test category"); 
		apiModel add = new apiModel();// add return type boolean in update
		boolean issuccess = add.updateApi(dataSource, data);
		assertEquals(true,issuccess);
		
	}

	@Test
	public void test5() {
		//fail("Not yet implemented");
		 
		apiModel add = new apiModel();
		boolean issuccess = add.deleteApi(dataSource, 100000); //add return type boolean in test delete
		assertEquals(true,issuccess);
	}

	@Test
	public void test4() {
		//fail("Not yet implemented");
		apiModel read = new apiModel();
		int count = read.listApi(dataSource,"Varun").size();
		boolean isgreater = false;
		if (count>0)
			isgreater=true;
		assertEquals(true,isgreater);
	}

	

}
