package Ex4;

import java.io.*;
import java.util.Scanner;

public class FrameContainer implements ContainerFunctions{

	private final int INIT_SIZE = 5, RESIZE = 5;
	Frame[] frames;
	private int size;

	public FrameContainer(){
		frames = new Frame[INIT_SIZE];
		size = 0;
	}

	public FrameContainer(String FileName){
		frames = new Frame[INIT_SIZE];
		size = 0;
		try {
			File TextFile = new File(FileName);
			Scanner sc = new Scanner(TextFile);

			while(sc.hasNext()) {
				if ((frames.length + 1) == size) resize();
				frames[size++] = MyImageIO.readImageFromFile(sc.nextLine(), false);
			}
		}
		catch(Exception ex) {
			ex.printStackTrace();
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

		boolean removed = false;

		for (int i = 0; i<size && !removed; i++) {

			if (f instanceof RGBImage) {

				if (frames[i] instanceof GrayImage) {
					continue;
				}

				if (((RGBImage) f).compareTo(frames[i]) == 0){

					int delete_Arr[][][] = ((RGBImage) f).getFrame();
					int my_arr[][][] = ((RGBImage)frames[i]).getFrame();	

					boolean same = true;

					for (int height = 0; height<my_arr[0].length && same; height++) {
						for (int weight = 0; weight<my_arr[0][0].length && same; weight++) {
							if (my_arr[0][height][weight] != delete_Arr[0][height][weight] || 
									my_arr[1][height][weight] != delete_Arr[1][height][weight] ||
									my_arr[2][height][weight] != delete_Arr[2][height][weight]) {
								same = false;
							}
						}	
					}

					if (same) {
						removed = true;
					}		
				}
			}

			else{
				if (frames[i] instanceof RGBImage) {
					continue;
				}

				if (((GrayImage)f).compareTo(frames[i]) == 0){
					int delete_Arr[][] = ((GrayImage) f).getFrame();
					int my_arr[][] = ((GrayImage)frames[i]).getFrame();	

					boolean same = true;

					for (int height = 0; height<my_arr.length && same; height++) {
						for (int weight = 0; weight<my_arr[0].length && same; weight++) {
							if (my_arr[height][weight] != delete_Arr[height][weight]) {
								same = false;
							}
						}	
					}

					if (same) {
						removed = true;
					}		
				}		
			}

			if (removed) {
				frames[i] = null;

				for (int j = i+1; j<size; j++) {
					frames[j-1] = frames[j];
					frames[j] = null;
				}

				size--;
			}
		}
	}

	@Override
	public void sort(Frame[] f) {
		// TODO Auto-generated method stub

		for (int i = 0; i<size - 1; i++) {

			for (int j = i+1; j<size; j++) {	
				int answer = 0;

				if (f[i] instanceof GrayImage) {
					answer = ((GrayImage)f[i]).compareTo(f[j]);
				}

				else {
					answer = ((RGBImage)f[i]).compareTo(f[j]);
				}

				if (answer == 1) {

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
			f[z].rotate90();
		}
	}

	@Override
	public void smoothAll(Frame[] f, int n) {
		// TODO Auto-generated method stub

		for (int s = 0; s<size; s++) {
			f[s].smooth(n);
		}
	}

}
