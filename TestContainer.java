package Ex4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestContainer {

	@Test
	void test1() {
		//TODO sort

		// sort !!!
		int[][] arr = {

				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 }, 

		};
		Frame Gray = new GrayImage(arr);

		int[][] arr2 = {
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 } ,     
		};
		Frame Gray2 = new GrayImage(arr2);

		int[][] arr3 = { 
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 },       
		};
		Frame Gray3 = new GrayImage(arr3);

		int[][] arr5 = { 
				{ 1 },
				{ 1 },
				{ 1 },
				{ 1 },         
		};
		Frame Gray5 = new GrayImage(arr5);

		Frame[] ArrayOfFrame = { Gray2, Gray, Gray5, Gray3 };

		FrameContainer frameContainer = new FrameContainer();
		for (int i = 0; i < ArrayOfFrame.length; i++) {
			frameContainer.add(ArrayOfFrame[i]);
		}
		frameContainer.sort();

		//	        int[][][] ArrayOfmatrix = new int[5][][];
		//	        for (int i = 0; i < ArrayOfFrame.length; i++) {
		//	            ArrayOfmatrix[i] = ((GrayImage) ArrayOfFrame[i]).getFrame();
		//	        }

		int arr9[][] = ((GrayImage)frameContainer.get(0)).getFrame(); 

		Assertions.assertArrayEquals(arr5, arr9);

	}

	@Test
	void test2() {
		int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray = new GrayImage(arr);

		int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray2 = new GrayImage(arr2);

		int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray3 = new GrayImage(arr3);

		int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

		Frame gray4 = new GrayImage(arr4);

		int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
		Frame gray5 = new GrayImage(arr5);

		Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

		FrameContainer frameContainer = new FrameContainer();
		for (int i = 0; i < ArrayOfFrame.length; i++) {
			frameContainer.add(ArrayOfFrame[i]);
		}

		frameContainer.remove(gray3);

		Assertions.assertEquals(gray, frameContainer.get(0));
		Assertions.assertEquals(gray2, frameContainer.get(1));
		Assertions.assertEquals(gray4, frameContainer.get(2));
		Assertions.assertEquals(gray5, frameContainer.get(3));

	}

	@Test
	void test3() {
		int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray = new GrayImage(arr);

		int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray2 = new GrayImage(arr2);

		int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray3 = new GrayImage(arr3);

		int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

		Frame gray4 = new GrayImage(arr4);

		int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
		Frame gray5 = new GrayImage(arr5);

		Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

		FrameContainer frameContainer = new FrameContainer();
		
		frameContainer.add(gray);
		frameContainer.add(gray2);
		frameContainer.add(gray3);
		frameContainer.add(gray4);
		frameContainer.add(gray5);
		
		frameContainer.rotateAll();
		int[][][] ArrayOfmatrix = { ((GrayImage)frameContainer.get(0)).getFrame(), ((GrayImage) frameContainer.get(1)).getFrame(),
				((GrayImage) frameContainer.get(2)).getFrame(), ((GrayImage) frameContainer.get(3)).getFrame(), ((GrayImage) frameContainer.get(4)).getFrame(), };

		int[][][] arr10 = { { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, },

				{ { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

				{ { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

				{ { 1, 1, 1, 1 }, { 2, 2, 2, 2 } },

				{ { 1, 1, 1, 1 } }

		};

		Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

	}

	@Test
	void test4() {
		//TODO add 

		int[][] arr = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray = new GrayImage(arr);

		int[][] arr2 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray2 = new GrayImage(arr2);

		int[][] arr3 = { { 1, 2, 3, 4 }, { 1, 2, 3, 4 }, };
		Frame gray3 = new GrayImage(arr3);

		int[][] arr4 = { { 1, 2 }, { 1, 2 }, { 1, 2 }, { 1, 2 }, };

		Frame gray4 = new GrayImage(arr4);

		int[][] arr5 = { { 1 }, { 1 }, { 1 }, { 1 }, };
		Frame gray5 = new GrayImage(arr5);

		Frame[] ArrayOfFrame = { gray, gray2, gray3, gray4, gray5, };

		FrameContainer frameContainer = new FrameContainer();
		
		frameContainer.add(gray);
		frameContainer.add(gray2);
		frameContainer.add(gray3);
		frameContainer.add(gray4);
		frameContainer.add(gray5);
		
		frameContainer.rotateAll();
		int[][][] ArrayOfmatrix = { ((GrayImage)frameContainer.get(0)).getFrame(), ((GrayImage) frameContainer.get(1)).getFrame(),
				((GrayImage) frameContainer.get(2)).getFrame(), ((GrayImage) frameContainer.get(3)).getFrame(), ((GrayImage) frameContainer.get(4)).getFrame(), };

		int[][][] arr10 = { { { 1, 1, 1, 1 }, { 2, 2, 2, 2 }, { 3, 3, 3, 3 }, { 4, 4, 4, 4 }, },

				{ { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 }, { 4, 4, 4 }, },

				{ { 1, 1 }, { 2, 2 }, { 3, 3 }, { 4, 4 }, },

				{ { 1, 1, 1, 1 }, { 2, 2, 2, 2 } },

				{ { 1, 1, 1, 1 } }

		};

		Assertions.assertArrayEquals(arr10, ArrayOfmatrix);

	}
	/*
	 * @Test void test5() { int[][] arr = {
	 * 
	 * { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 },
	 * 
	 * };
	 * 
	 * Frame Gray = new GrayImage(arr);
	 * 
	 * int[][] arr2 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 } ,
	 * 
	 * }; Frame Gray2 = new GrayImage(arr2);
	 * 
	 * int[][] arr3 = { { 1, 1, 1, 1 }, { 1, 1, 1, 1 },
	 * 
	 * };
	 * 
	 * Frame Gray3 = new GrayImage(arr3);
	 * 
	 * FrameContainer a = new FrameContainer();
	 * 
	 * a.add(Gray); a.add(Gray3); a.add(Gray2);
	 * 
	 * a.sort(a.frames);
	 * 
	 * int arr5[][] = ((GrayImage)a.get(0)).getFrame();
	 * 
	 * Assertions.assertArrayEquals(arr5, arr3);
	 * 
	 * }
	 */

}
