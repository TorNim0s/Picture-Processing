package Ex4;


public class GrayImage implements Frame, Comparable<Frame> {

	private int[][] frame;
	private int size;
	
	public GrayImage(int[][] frame) {
		this.frame = new int[frame.length][frame[0].length];

		this.size = frame.length * frame[0].length;
		
		for (int i = 0; i<frame.length; i++) {
			for (int j = 0; j<frame[0].length; j++) {
				this.frame[i][j] = frame[i][j];
			}	
		}
	}

	public GrayImage(GrayImage new_frame) {
		this.frame = new int[new_frame.frame.length][new_frame.frame[0].length];

		this.size = new_frame.frame.length * new_frame.frame[0].length;
		
		for (int i = 0; i<new_frame.frame.length; i++) {
			for (int j = 0; j<new_frame.frame[0].length; j++) {
				this.frame[i][j] = new_frame.frame[i][j];
			}	
		}

	}

	public int[][] getFrame(){
		return this.frame;
	}

	public boolean isInside(int test[][], int x, int y) {

		if (x < 0 || y < 0 || x >= test.length || y >= test[0].length){
			return false;
		}

		return true;
	}

	@Override
	public int compareTo(Frame f) {

		if (f == null) {
			return -1;
		}
		
		if (f instanceof RGBImage) {
			int arr[][][];

			arr = ((RGBImage)f).getFrame();

			int my_size = this.size;
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

			int my_size = this.size;
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

		int[][] rotate = new int[this.frame[0].length][this.frame.length];

		for (int x = 0; x < rotate[0].length; x++) {
			for (int y = 0; y < rotate.length; y++) {
				rotate[y][x] = this.frame[this.frame.length - x - 1][y];
			}
		} 

		this.frame = rotate;

	}

	@Override
	public void smooth(int n) {
		// TODO Auto-generated method stub

		int arr[][] = new int[this.frame.length][this.frame[0].length];

		if (n <= 2) {
			return;
		}

		if (n%2 == 0) {
			n--;
		}

		for (int i = 0; i < this.frame.length; i++) {
			for (int j = 0; j < this.frame[0].length; j++) {
				int counter = 0;
				int avg = 0;

				for (int a = i-(n/2); a<= i+(n/2); a++) {
					for (int b = j-(n/2); b<= j+(n/2); b++) {
						if (isInside(this.frame, a, b)) {
							counter++;
							avg += this.frame[a][b];
						}
					}
				}

				arr[i][j] = avg/(counter);
			}
		}

		this.frame = arr;
	}

	@Override
	public int[] getPixel(int x, int y) {
		if (!isInside(this.frame, x, y)) {
			return null;
		}

		int a[] = new int [1];
		a[0] = this.frame[x][y];

		return a;
	}

	@Override
	public void crop(int x, int y) {
		// TODO Auto-generated method stub

		if (x >= this.frame.length || y >= this.frame[0].length) {
			return;
		}
		
		int[][] new_frame = new int[x+1][y+1];

		for (int i = 0; i <=x; i++) {
			for (int j = 0; j <=y; j++) {

				if(isInside(this.frame, i,j)) {
					new_frame[i][j] = this.frame[i][j];
				}


			}
		}
		this.frame = new_frame;
	}

	@Override
	public void addFrom(Frame f) {
		// TODO Auto-generated method stub
		int arr[][];

		if (f instanceof GrayImage) {
			arr = ((GrayImage)f).getFrame();
		}

		else {
			return;
		}

		int x[] = new int[1];

		if (arr.length == this.frame.length && arr[0].length == this.frame[0].length) {
			for (int i = 0; i<this.frame.length;i++) {
				for (int j = 0; j<this.frame[0].length;j++) {
					x = f.getPixel(i, j);
					if ( this.frame[i][j] + x[0] > 255*255) {
						this.frame[i][j] =  255*255;
					}
					else {
						this.frame[i][j] = this.frame[i][j] + x[0];
					}
				}
			}
		}

	}
}
