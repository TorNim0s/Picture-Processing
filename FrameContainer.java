package Ex4;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class FrameContainer implements ContainerFunctions {

	private final int INIT_SIZE = 5, RESIZE = 5;
	private Frame[] frames;
	private int size;

	public FrameContainer() {
		this.frames = new Frame[INIT_SIZE];
		this.size = 0;
	}

	public FrameContainer(String FileName) {
		this.frames = new Frame[INIT_SIZE];
		this.size = 0;
		try {
			File TextFile = new File(FileName);
			Scanner sc = new Scanner(TextFile);

			while (sc.hasNext()) {
				if ((this.frames.length + 1) == this.size)
					resize();
				this.frames[size++] = MyImageIO.readImageFromFile(sc.nextLine(), false);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	@Override
	public Frame get(int i) {
		if (i >= this.size || i < 0)
			return null;

		return this.frames[i];
	}

	@Override
	public int size() {
		return this.size;
	}

	@Override
	public void add(Frame f) {
		// TODO Auto-generated method stub
		if (this.size == this.frames.length)
			resize();
		this.frames[this.size++] = f;
	}

	public void resize() {
		Frame temp[] = new Frame[this.frames.length + RESIZE];
		for (int i = 0; i < this.frames.length; i++) {
			temp[i] = this.frames[i];
		}
		this.frames = temp;
	}

	@Override
	public void remove(Frame f) {
		// TODO Auto-generated method stub

		boolean removed = false;

		for (int i = 0; i < this.size && !removed; i++) {

			if (f instanceof RGBImage) {

				if (this.frames[i] instanceof GrayImage) {
					continue;
				}

				if (((RGBImage) f).compareTo(this.frames[i]) == 0) {

					int delete_Arr[][][] = ((RGBImage) f).getFrame();
					int my_arr[][][] = ((RGBImage) this.frames[i]).getFrame();

					boolean same = true;

					for (int height = 0; height < my_arr[0].length && same; height++) {
						for (int weight = 0; weight < my_arr[0][0].length && same; weight++) {
							if (my_arr[0][height][weight] != delete_Arr[0][height][weight]
									|| my_arr[1][height][weight] != delete_Arr[1][height][weight]
											|| my_arr[2][height][weight] != delete_Arr[2][height][weight]) {
								same = false;
							}
						}
					}

					if (same) {
						removed = true;
					}
				}
			}

			else {
				if (this.frames[i] instanceof RGBImage) {
					continue;
				}

				if (((GrayImage) f).compareTo(this.frames[i]) == 0) {
					int delete_Arr[][] = ((GrayImage) f).getFrame();
					int my_arr[][] = ((GrayImage) this.frames[i]).getFrame();

					boolean same = true;

					for (int height = 0; height < my_arr.length && same; height++) {
						for (int weight = 0; weight < my_arr[0].length && same; weight++) {
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
				this.frames[i] = null;

				for (int j = i + 1; j < this.size; j++) {
					this.frames[j - 1] = this.frames[j];
					this.frames[j] = null;
				}

				this.size--;
			}
		}
	}

	@Override
	public void sort() {
		// TODO Auto-generated method stub

		for (int i = 0; i<this.size - 1; i++) {

			for (int j = i+1; j<this.size; j++) { 
				int answer = 0;

				if (this.frames[i] instanceof GrayImage) { 
					answer = ((GrayImage)this.frames[i]).compareTo(this.frames[j]); 
				}

				else { 
					answer = ((RGBImage)this.frames[i]).compareTo(this.frames[j]); 
				}

				if (answer == 1) {

					Frame hold;

					if (this.frames[i] instanceof GrayImage) { 
						hold = new GrayImage((GrayImage)this.frames[i]); 
					}

					else { 
						hold = new RGBImage((RGBImage)this.frames[i]);
					}

					this.frames[i] = this.frames[j]; this.frames[j] = hold; 
				}
			} 
		}
	}

	@Override
	public void rotateAll() {
		// TODO Auto-generated method stub
		
		for (int z = 0; z < this.size; z++) {
			this.frames[z].rotate90();
		}
	}

	@Override
	public void smoothAll(int n) {
		// TODO Auto-generated method stub

		for (int s = 0; s < this.size; s++) {
			this.frames[s].smooth(n);
		}
	}

}
