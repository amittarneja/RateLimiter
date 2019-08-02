package org.booktickets;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.google.common.util.concurrent.RateLimiter;


/**
 * Adding JUnit testcases for testing the RateLimiter guava library
 *
 */
public class RateLimiterFilterTest {
	
	@Test
	 public void testTryAcquire() {
		    RateLimiter r = RateLimiter.create(1);
		    assertTrue("Unable to acquire initial permit", r.tryAcquire());
		    assertFalse("Capable of acquiring secondary permit", r.tryAcquire());
		  }
	
	@Test
	 public void testTryAcquireWithWait() throws InterruptedException {
	    RateLimiter r = RateLimiter.create(1);
	    assertTrue("Unable to acquire initial permit", r.tryAcquire());
	    Thread.sleep(1000);
	    assertTrue("Unable to acquire initial permit", r.tryAcquire());
	  }
}
