package com.future.SixPrinciple.opencolse;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: zcd
 * @date: 2019/3/1 15:56
 */
public class JavaDiscountCourseTest {
    private static final Logger logger = LoggerFactory.getLogger(JavaDiscountCourseTest.class);
    private ICourse iCourse;

    @Before
    public void setUp() throws Exception {
        logger.info("init iCourse");
        iCourse = new JavaDiscountCourse(1, "java", 399d);
    }

    @After
    public void tearDown() throws Exception {
        logger.info("end test-suite");
    }

    @Test
    public void getCoursePrice() {
        System.out.println("coursePrice: " + iCourse.getCoursePrice());
    }

    @Test
    public void getOriginPrice() {
        JavaDiscountCourse javaDiscountCourse = (JavaDiscountCourse) iCourse;
        System.out.println("coursePrice: " + javaDiscountCourse.getOriginPrice());
    }
}