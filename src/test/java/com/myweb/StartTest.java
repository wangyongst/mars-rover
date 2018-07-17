package com.myweb;

import org.junit.Assert;
import org.junit.Test;

public class StartTest {
    @Test
    public void case1() throws Exception {
        Area area = new Area();
        area.setMaxX(5);
        area.setMaxY(5);
        Rover rover = Start.init(area, 1, 2, "N");
        rover.setArea(area);
        Start.start(rover,"LMLMLMLMM");
        Assert.assertEquals(1,rover.getX());
        Assert.assertEquals(3,rover.getY());
        Assert.assertEquals("N",rover.getDirect());
    }

    @Test
    public void case2() throws Exception {
        Area area = new Area();
        area.setMaxX(5);
        area.setMaxY(5);
        Rover rover = Start.init(area, 3, 3, "E");
        rover.setArea(area);
        Start.start(rover,"MMRMMRMRRM");
        Assert.assertEquals(5,rover.getX());
        Assert.assertEquals(1,rover.getY());
        Assert.assertEquals("E",rover.getDirect());
    }

}