package Ex4;

import java.io.*;

public class FrameContainer implements ContainerFunctions{

	private final int INIT_SIZE = 5, RESIZE = 5;
	private Frame[] frames;
	private int size;

	public FrameContainer(int n){
		frames = new Frame[n];
		size = 0;
	}

	public FrameContainer(String FileName){
		frames = new Frame[INIT_SIZE];
		size = 0;

		try {
			FileReader fr = new FileReader(FileName);
			BufferedReader br = new BufferedReader(fr);

			String str;
			str = br.readLine();
			for(int i=1; str!=null; i=i+1) {

				if (i > size) resize();
				frames[size++] = MyImageIO.readImageFromFile(str, false);

				str = br.readLine();
			}
			br.close();
			fr.close();
		}
		catch(IOException ex) {
			System.out.print("Error writing file\n" + ex);
		}
	}

	@Override
	public Frame get(int i) {
		if (i >= size || i<0)
			return null;

		return frames[i];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void add(Frame f) {
		// TODO Auto-generated method stub
		if (size == frames.length) resize();
		frames[size++] = f;
	}

	public void resize(){
		Frame temp[] = new Frame[frames.length+RESIZE];
		for(int i=0; i<frames.length; i++){
			temp[i] = frames[i];
		}
		frames = temp;
	}

	@Override
	public void remove(Frame f) {
		// TODO Auto-generated method stub

		for (int i = 0; i<size; i++) {
			if (frames[i] == f) {
				frames[i] = null;
				for (int j = i+1; j<size; j++) {
					frames[j-1] = frames[j];
				}
				size--;
				break;
			}
		}

	}

	@Override
	public void sort(Frame[] f) {
		// TODO Auto-generated method stub

		int size1;
		int size2;

		int arr1[][][];
		int arr2[][];

		for (int i = 0; i<size - 1; i++) {

			if (f[i] instanceof GrayImage) {
				arr2 = ((GrayImage)f[i]).getFrame();

				size1 = arr2.length * arr2[0].length;
			}

			else {

				arr1 = ((RGBImage)f[i]).getFrame();

				size1 = arr1[0].length * arr1[0][0].length;
			}

			for (int j = i+1; j<size; j++) {	

				if (f[j] instanceof GrayImage) {
					arr2 = ((GrayImage)f[j]).getFrame();

					size2 = arr2.length * arr2[0].length;
				}

				else {

					arr1 = ((RGBImage)f[j]).getFrame();

					size2 = arr1[0].length * arr1[0][0].length;
				}

				if (size1 < size2) {

					Frame hold;

					if (f[i] instanceof GrayImage) {
						hold = new GrayImage((GrayImage)f[i]);	
					}

					else {
						hold = new RGBImage((RGBImage)f[i]);		
					}

					f[i] = f[j];
					f[j] = hold;
				}

			}	
		}

	}

	@Override
	public void rotateAll(Frame[] f) {
		// TODO Auto-generated method stub

		for (int z = 0; z<size; z++) {
			if (f[z] instanceof RGBImage) {
				int[][][] frame =((RGBImage)f[z]).getFrame();
				int[][][] rotate = new int[3][frame[0][0].length][frame[0].length];

				for (int x = 0; x < rotate[0][0].length; x++) {
					for (int y = 0; y < rotate[0].length; y++) {
						rotate[0][y][x] = frame[0][frame[0].length - x - 1][y];
						rotate[1][y][x] = frame[1][frame[1].length - x - 1][y];
						rotate[2][y][x] = frame[2][frame[2].length - x - 1][y];
					}
				} 

				frame = rotate;

				f[z] = new RGBImage(rotate);
			}

			else {
				int[][] frame =((GrayImage)f[z]).getFrame();
				int[][] rotate = new int[frame[0].length][frame.length];

				for (int x = 0; x < rotate[0].length; x++) {
					for (int y = 0; y < rotate.length; y++) {
						rotate[y][x] = frame[frame.length - x - 1][y];
					}
				} 

				f[z] = new GrayImage(rotate);
			}
		}
	}

	public boolean isInside(int test[][], int x, int y) {

		if (x < 0 || y < 0 || x >= test.length || y >= test[0].length){
			return false;
		}

		return true;
	}

	public boolean isInside(int test[][][], int x, int y) {

		if (x < 0 || y < 0 || x >= test[0].length || y >= test[0][0].length){
			return false;
		}

		return true;
	}

	@Override
	public void smoothAll(Frame[] f, int n) {
		// TODO Auto-generated method stub

		if (n <= 2) {
			return;
		}

		if (n%2 == 0) {
			n--;
		}

		for (int s = 0; s<size; s++) {

			if (f[s] instanceof RGBImage) {
				int[][][] frame =((RGBImage)f[s]).getFrame();

				for (int z = 0; z < frame.length; z++) {
					for (int i = 0; i < frame[0].length; i++) {
						for (int j = 0; j < frame[0][0].length; j++) {
							int counter = 0;
							int avg = 0;

							for (int a = i-n; a<= i+n; a++) {
								for (int b = j-n; b<= j+n; b++) {
									if (isInside(frame, a, b)) {
										counter++;
										avg += frame[z][a][b];
									}
								}
							}

							frame[z][i][j] = avg/(counter);
						}
					}
				}

				f[s] = new RGBImage(frame);
			}

			else {
				int[][] frame =((GrayImage)f[s]).getFrame();

				for (int i = 0; i < frame.length; i++) {
					for (int j = 0; j < frame[0].length; j++) {
						int counter = 0;
						int avg = 0;

						for (int a = i-n; a<= i+n; a++) {
							for (int b = j-n; b<= j+n; b++) {
								if (isInside(frame, a, b)) {
									counter++;
									avg += frame[a][b];
								}
							}
						}

						frame[i][j] = avg/(counter-1);
					}
				}
			}
		}
	}

}
