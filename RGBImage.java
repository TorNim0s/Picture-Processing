package Ex4;

public class RGBImage implements Frame, Comparable<Frame>{

	int frame[][][];

	public RGBImage(int[][][] frame) {
		this.frame = frame.clone();
	}

	public RGBImage(RGBImage new_frame) {
		this.frame = new_frame.frame.clone();
	}

	public int[][][] getFrame(){
		return this.frame;
	}

	public boolean isInside(int test[][][], int x, int y) {

		if (x < 0 || y < 0 || x >= test[0].length || y >= test[0][0].length){
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Frame f) {

		if (f instanceof RGBImage) {
			int arr[][][];

			arr = ((RGBImage)f).getFrame();

			int my_size = this.frame[0].length * this.frame[0][0].length;
			int other = arr[0].length * arr[0][0].length;

			if (my_size > other)
				return 1;

			if (my_size < other)
				return -1;

			return 0;
		}

		else {
			int arr[][];

			arr = ((GrayImage)f).getFrame();

			int my_size = this.frame[0].length * this.frame[0][0].length;
			int other = arr.length * arr[0].length;

			if (my_size > other)
				return 1;

			if (my_size < other)
				return -1;

			return 0;
		}	
	}

	@Override
	public void rotate90() {
		// TODO Auto-generated method stub

		int[][][] rotate = new int[3][this.frame[0][0].length][this.frame[0].length];

		for (int x = 0; x < rotate[0][0].length; x++) {
			for (int y = 0; y < rotate[0].length; y++) {
				rotate[0][y][x] = this.frame[0][this.frame[0].length - x - 1][y];
				rotate[1][y][x] = this.frame[1][this.frame[1].length - x - 1][y];
				rotate[2][y][x] = this.frame[2][this.frame[2].length - x - 1][y];
			}
		} 

		this.frame = rotate;

	}

	@Override
	public void smooth(int n) {
		// TODO Auto-generated method stub
		if (n <= 2) {
			return;
		}

		if (n%2 == 0) {
			n--;
		}

		for (int z = 0; z < this.frame.length; z++) {
			for (int i = 0; i < this.frame[0].length; i++) {
				for (int j = 0; j < this.frame[0][0].length; j++) {
					int counter = 0;
					int avg = 0;

					for (int a = i-n; a<= i+n; a++) {
						for (int b = j-n; b<= j+n; b++) {
							if (isInside(this.frame, a, b)) {
								counter++;
								avg += this.frame[z][a][b];
							}
						}
					}

					this.frame[z][i][j] = avg/(counter);
				}
			}
		}
	}

	@Override
	public int[] getPixel(int x, int y) {
		// TODO Auto-generated method stub
		if (!isInside(this.frame, x, y)) {
			return null;
		}

		int a[] = new int[3];

		for (int i = 0 ;i<3 ;i++) {
			a[i] = this.frame[i][x][y];
		}

		return a;
	}

	@Override
	public void crop(int x, int y) {
		// TODO Auto-generated method stub

		int[][][] new_frame = new int[3][x][y];

		for (int i = 0; i <x; i++) {
			for (int j = 0; j <y; j++) {
				for (int z = 0; z<3; z++) {

					if(isInside(this.frame, i,j)) {
						new_frame[z][i][j] = this.frame[z][i][j];
					}

				}
			}
		}

		this.frame = new_frame;
	}

	@Override
	public void addFrom(Frame f) {
		// TODO Auto-generated method stub
		int arr[][][];

		int x[] = new int[3];

		if (f instanceof RGBImage) {
			arr = ((RGBImage)f).getFrame();
		}

		else {
			return;
		}

		if (arr[0].length == this.frame[0].length && arr[0][0].length == this.frame[0][0].length) {
			for (int i = 0; i<this.frame[0].length;i++) {
				for (int j = 0; j<this.frame[0][0].length;j++) {
					x = f.getPixel(i, j);

					this.frame[0][i][j] = this.frame[0][i][j] + x[0];
					this.frame[1][i][j] = this.frame[1][i][j] + x[1];
					this.frame[2][i][j] = this.frame[2][i][j] + x[2];

					if (this.frame[0][i][j] > 255)
						this.frame[0][i][j] = 255;
					if (this.frame[1][i][j] > 255)
						this.frame[1][i][j] = 255;
					if (this.frame[2][i][j] > 255)
						this.frame[2][i][j] = 255;

				}
			}
		}

	}
}
