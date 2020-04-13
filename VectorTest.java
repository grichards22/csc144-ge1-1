/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.eonsahead.swing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author delta
 */
public class VectorTest {
    private static final double EPSILON = 1E-8;
    public VectorTest() {
    }

    @org.junit.jupiter.api.Test
    public void testDot() {
        System.out.println("dot");
        Vector u = new Vector(0, 1, 0);
        Vector v = new Vector(1, 0, 0);
        double expResult = 0.0;
        double result = u.dot(v);
        assertEquals(expResult, result, EPSILON);
    }

    @org.junit.jupiter.api.Test
    public void testMagnitude() {
        System.out.println("magnitude");
        Vector instance = new Vector();
        double expResult = 0.0;
        double result = instance.magnitude();
        assertEquals(expResult, result, 0.0);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testGet() {
        System.out.println("get");
        int choice = 0;
        Vector instance = new Vector(99.0, 0.0, 0.0);
        double expResult = 99.0;
        double result = instance.get(choice);
        assertEquals(expResult, result, EPSILON);
    }

    @org.junit.jupiter.api.Test
    public void testNormalize() {
        System.out.println("normalize");
        Vector instance = new Vector();
        Vector expResult = null;
        Vector result = instance.normalize();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @org.junit.jupiter.api.Test
    public void testCross() {
        System.out.println("cross");
        Vector v = null;
        Vector instance = new Vector();
        Vector expResult = null;
        Vector result = instance.cross(v);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    
}
