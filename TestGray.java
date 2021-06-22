package Ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestGray {

	@Test
    void test1() {
		// rotate90
		
        int[][] arr = { { 1, 1, 1},
        				{ 2, 2, 2},
        				{ 3, 3, 3},
        				{ 4, 4, 4} };
        Frame frame = new GrayImage(arr);
        frame.rotate90();
        int[][] result = ((GrayImage) frame).getFrame();

        int[][] arr2 = {{ 4, 3, 2, 1 },
        				{ 4, 3, 2, 1 },
        				{ 4, 3, 2, 1 }};

        Assertions.assertArrayEquals(arr2, result);
    }

    @Test
    void test2() {
    	//smooth
    	
        int[][] arr = { { 5, 2, 4 },
        	        	{ 3, 4, 2 }, 
        		        { 7, 3, 1 } };
        Frame gray = new GrayImage(arr);
        gray.smooth(3);
        int[][] result = ((GrayImage) gray).getFrame();

        int[][] arr2 = { { 3, 3, 3 },
        			     { 4, 3, 2 },
        				 { 4, 3, 2 }, };
        Assertions.assertArrayEquals(arr2, result);
    }

    @Test
    void test3() {
        int[][] arr = { { 1, 2, 3 },
        				{ 4, 5, 6 },
        				{ 7, 8, 9 } };
        Frame gray = new GrayImage(arr);
        gray.crop(1, 1);

        int[][] result = ((GrayImage) gray).getFrame();

        int[][] arr2 = {    { 1, 2 },
							{ 4, 5 },
							 };

        Assertions.assertArrayEquals(arr2, result);
    }

    @Test
    void test4() {
        int[][] arr = { { 9, 8, 7 }, { 6, 5, 4 }, { 3, 2, 1 } };
        Frame gray = new GrayImage(arr);

        gray.addFrom(gray);

        int[][] result = ((GrayImage) gray).getFrame();
        int[][] arr2 = { { 18, 16, 14 }, { 12, 10, 8 }, { 6, 4, 2 } };

        Assertions.assertArrayEquals(arr2, result);
    }

    @Test
    void test5() {

        int[][] arr = { { 1, 2, 3 },
        				{ 4, 5, 6 },
        				{ 7, 8, 9 } };

        Frame gray = new GrayImage(arr);

        int[] a = gray.getPixel(2, 1);

        int[] arr2 = { 8 };

        Assertions.assertArrayEquals(arr2, a);
    }

}
