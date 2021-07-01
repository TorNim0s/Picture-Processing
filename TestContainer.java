package Ex4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TestContainer {

	@Test
	void test1() {
		//sort
		
		int[][] pic1 = {

				{ 1, 1, 1, 1, 1},
				{ 1, 1, 1, 1, 1},
				{ 1, 1, 1, 1, 1},
				{ 1, 1, 1, 1, 1}, 

		};
		Frame Pic1 = new GrayImage(pic1);

		int[][] pic3 = { 
				{ 1, 1, 1},
				{ 1, 1, 1},       
		};
		Frame Pic3 = new GrayImage(pic3);
		
		int[][] pic2 = {
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 },
				{ 1, 1, 1, 1 } ,     
		};
		Frame Pic2 = new GrayImage(pic2);
		

		int[][] pic4 = { 
				{ 1 },
				{ 1 },
				{ 1 },
				{ 1 },         
		};
		Frame Pic4 = new GrayImage(pic4);

		Frame[] ArrayOfFrames = { Pic1, Pic2, Pic3, Pic4 };

		FrameContainer frameContainer = new FrameContainer();
		for (int i = 0; i < ArrayOfFrames.length; i++) {
			frameContainer.add(ArrayOfFrames[i]);
		}
		frameContainer.sort();

		int arr9[][] = ((GrayImage)frameContainer.get(0)).getFrame(); 

		Assertions.assertArrayEquals(pic4, arr9);

	}

	@Test
	void test2() {
		
		// remove
		
		int[][] arr = { { 2,1,6,8}, {1,1,1,1} };
		Frame frame1 = new GrayImage(arr);

		int[][] arr2 = { { 1, 1, 1, 1 }, {1,1,1,1}};
		Frame frame2 = new GrayImage(arr2);

		int[][] arr3 = { { 1, 3,3,1 }, {1,1,1,1}, {1,1,1,1}};
		Frame frame3 = new GrayImage(arr3);

		int[][] arr4 = { { 1, 1 }, { 3, 2 }, { 2, 2 }};

		Frame frame4 = new GrayImage(arr4);

		int[][] arr5 = { { 1,3 }, { 1,4 }, { 1,5 }};
		Frame frame5 = new GrayImage(arr5);

		Frame[] ArrayOfFrame = { frame1, frame2, frame3, frame4, frame5, };

		FrameContainer frameContainer = new FrameContainer();
		for (int i = 0; i < ArrayOfFrame.length; i++) {
			frameContainer.add(ArrayOfFrame[i]);
		}

		frameContainer.remove(frame3);

		Assertions.assertEquals(frame1, frameContainer.get(0));
		Assertions.assertEquals(frame2, frameContainer.get(1));
		Assertions.assertEquals(frame4, frameContainer.get(2));
		Assertions.assertEquals(frame5, frameContainer.get(3));

	}

	@Test
	void test3() {
		// rotate all
		
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
		//rotate all

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
	void test5() {
		// smooth all
		
		int[][] arr1 = { 
				{ 1, 2, 3 },
				{ 4, 5, 6 },
				{ 7, 8, 9 },
		};
		Frame frame1 = new GrayImage(arr1);

		Frame frame2 = new GrayImage(arr1);

		Frame frame3 = new GrayImage(arr1);
		
		FrameContainer fc = new FrameContainer();
		fc.add(frame1);
		fc.add(frame2);
		fc.add(frame3);
		
		fc.smoothAll(3);
		
		int[][] arr2 = { 
				{ 3, 3, 4 }, { 4, 5, 5 }, { 6, 6, 7 }
		};
		
		int result[][] = ((GrayImage)fc.get(0)).getFrame();
		
		Assertions.assertArrayEquals(arr2, result);
		result = ((GrayImage)fc.get(1)).getFrame();
		Assertions.assertArrayEquals(arr2, result);
		result = ((GrayImage)fc.get(2)).getFrame();
		Assertions.assertArrayEquals(arr2, result);
		
	}

}
