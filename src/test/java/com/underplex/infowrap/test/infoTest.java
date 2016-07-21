package com.underplex.infowrap.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class infoTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public infoTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( infoTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        // mock-up two people
        Person jones = new Person();
        jones.setAge(21);
        jones.setLastName("Jones");
 
        Person gandhi = new Person();
        gandhi.setAge(99);
        gandhi.setLastName("Gandhi");
 
        Person obama = new Person();
        obama.setAge(53);
        obama.setLastName("Obama");
        
        jones.setFriend(gandhi);
        
        assertTrue(jones.getAge() == jones.info().getAge());
        assertTrue(jones.getAge() == jones.myInfo().getAge());
        assertTrue(jones.getLastName() == jones.info().getLastName());
        assertTrue(jones.getLastName() == jones.myInfo().getLastName());
        assertTrue(jones.getFriend().info() == jones.myInfo().getFriend());
               
        jones.setAge(29);
        jones.setLastName("Jones-Smith");
        jones.setFriend(obama);
        // Check that Jones still has the same information via the wrapper.

        assertTrue(jones.getAge() == jones.info().getAge());
        assertTrue(jones.getAge() == jones.myInfo().getAge());
        assertTrue(jones.getLastName() == jones.info().getLastName());
        assertTrue(jones.getLastName() == jones.myInfo().getLastName());
        assertTrue(jones.getFriend().info() == jones.myInfo().getFriend());
        
        // Much of the value of the info-wrapping pattern in this package is that you simply can't get the information wrapped...
        // However, this is hard to test for!
       
    }
}
