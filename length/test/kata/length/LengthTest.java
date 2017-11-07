package kata.length;

import org.junit.Test;

import static kata.length.LengthFactory.*;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class LengthTest {
    @Test
    public void test_1_meter_equals_1_meter() throws Exception {
        assertTrue(m(1).eq(m(1)));
    }

    @Test
    public void test_1_meter_NOT_equals_2_meter() throws Exception {
        assertFalse(m(1).eq(m(2)));
    }

    @Test
    public void test_1_centimeter_equals_1_centimeter() throws Exception {
        assertTrue(cm(1).eq(cm(1)));
    }

    @Test
    public void test_2_centimeter_NOT_equals_2_centimeter() throws Exception {
        assertFalse(cm(1).eq(cm(2)));
    }

    @Test
    public void test_1_meter_equals_100_centimeters() throws Exception {
        assertTrue(m(1).eq(cm(100)));
    }

    @Test
    public void test_1_meter_NOT_equals_200_centimeters() throws Exception {
        assertFalse(m(1).eq(cm(200)));
    }

    @Test
    public void test_1_meter_equals_10_decimeters() throws Exception {
        assertTrue(m(1).eq(dm(10)));
    }

    @Test
    public void test_1_decimeter_NOT_equals_1_centimeter() throws Exception {
        assertFalse(dm(1).eq(cm(1)));
    }

    @Test
    public void test_1_meter_less_than_20_decimeters() throws Exception {
        assertTrue(m(1).lt(dm(20)));
    }

    @Test
    public void test_2_decimeters_greater_than_10_centimeter() throws Exception {
        assertTrue(dm(2).gt(cm(10)));
    }

    @Test
    public void test_1_meter_changeTo_1m() throws Exception {
        assertThat(m(1).convert(), is("1m"));
    }

    @Test
    public void test_1_decimeter_changeTo_1dm() throws Exception {
        assertThat(dm(1).convert(), is("1dm"));
    }

    @Test
    public void test_101_centimeter_transform_1m1cm() throws Exception {
        assertThat(cm(101).convert(), is("1m1cm"));
    }

    @Test
    public void test_111_centimeter_transform_1m1dm1cm() throws Exception {
        assertThat(cm(111).convert(), is("1m1dm1cm"));
    }

    @Test
    public void test_123_decimeter_transform_12m3dm() throws Exception {
        assertThat(dm(123).convert(), is("12m3dm"));
    }

    @Test
    public void test_1_meter_plus_1_meter_equals_2_meters() throws Exception {
        assertThat(m(1).add(m(1)), is("2m"));
    }

    @Test
    public void test_1_meter_plus_11_decimeter_equals_2_meters_1_decimeter() throws Exception {
        assertThat(m(1).add(dm(11)), is("2m1dm"));
    }
}
