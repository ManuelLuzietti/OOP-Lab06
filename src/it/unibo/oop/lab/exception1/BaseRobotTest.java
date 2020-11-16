package it.unibo.oop.lab.exception1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import junit.framework.Assert;



/**
 * Testing class for PositionOutOfBound.
 * 
 */
@SuppressWarnings("deprecation")
public final class BaseRobotTest {

    /**
     * Simple test for testing a robot moving, wandering the available
     * environment.
     * 
     */
	@Test
    public void testRobotMovementBase() {
        /*
         * FIRST OF ALL, take a look to "TestWithExceptions". Read the source and the
         * comments very carefully.
         */
        /*
         *  1) Create a Robot with battery level 100
         */
        final Robot r1 = new Robot("SimpleRobot", 100);
        // checking if robot is in position x=0; y=0
        assertEquals("[CHECKING ROBOT INIT POS X]", 0, r1.getEnvironment().getCurrPosX());
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r1.getEnvironment().getCurrPosY());
        
        try {
        	int i = 0;
        	while(i < RobotEnvironment.WORLD_X_UPPER_LIMIT + 20) {
        		r1.moveRight();
        	}
        	Assert.fail("ops");
            
        } catch(PositionOutOfBoundException e) {
        	Assert.assertNotNull(e.getMessage());
        	System.out.println(e.getMessage());
        }
        
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", 0, r1.getEnvironment().getCurrPosY());
                    
        
        
        try {
        	int i = 0;
        	while(i < RobotEnvironment.WORLD_Y_UPPER_LIMIT + 20) {
        		r1.moveUp();
        	}
        	Assert.fail("ops");
        } catch(PositionOutOfBoundException e) {
        	Assert.assertNotNull(e.getMessage());
        	System.out.println(e.getMessage());

        }
        
        assertEquals("[MOVING RIGHT ROBOT POS X]", RobotEnvironment.WORLD_X_UPPER_LIMIT, r1.getEnvironment().getCurrPosX());
        assertEquals("[MOVING RIGHT ROBOT POS Y]", RobotEnvironment.WORLD_Y_UPPER_LIMIT, r1.getEnvironment().getCurrPosY());
    }

    /**
     * Simple test for testing robot battery.
     * 
     */
	@Test
	public void testRobotBatteryBase() {
		final Robot r2 = new Robot("SimpleRobot2", 20);
		/*
		 * Repeatedly move the robot up and down until the battery is completely
		 * exhausted.
		 */
		try {
			while (true) {
				r2.moveUp();
				r2.moveDown();
			}
		}catch(NotEnoughBatteryException e) {
			assertNotNull(e.getMessage());
			System.out.println(e.getMessage());
		}
		// verify battery level:
		// expected, actual, delta (accepted error as we deal with decimal
        // values: in this case we accept NO ERROR, which is generally bad)
        assertEquals(0d, r2.getBatteryLevel(), 0);
        // verify position: same as start position
        assertEquals("[CHECKING ROBOT INIT POS Y]", 0, r2.getEnvironment().getCurrPosY());
        // out of world: returns false
        // recharge battery
        r2.recharge();
        // verify battery level
        assertEquals(100, r2.getBatteryLevel(), 0);
    }
}
