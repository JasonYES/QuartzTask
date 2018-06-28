package com.jd.dbw.timer;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.*;

public class QuartzTaskTest {

    @Test
    public void run() {
        List list = Mockito.mock(List.class);
        list.add(new Object());
        list.get(0);
        System.out.println(Mockito.when(list.get(0)).thenReturn("list got"));
        System.out.println(Mockito.verify(list).get(0));
    }
}