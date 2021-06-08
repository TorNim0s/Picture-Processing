### Picture-Processing
## Computer Science task number 4;

# Stage 1:

I need to Implement the following Classes that implements Frame:

RGBImage:
	Colored image that contain 3 dimensions [3][height][weight].
	the first dimension contain the rgb color = {red, green, blue};

GrayImage:
	Black-White image that contain 2 dimension [height][weight]
	the value is how strong you want your gray to become. (more = lighter)
	

We need to implement the following functions in the classes:
	2 builders (1: that gets array of pixels, 2: A copy builder)
	**getFrame()** // returns the array of pixels
	**rotate90()** // rotate the picture 90 digress
	**smooth(int n)** // check the n amount of neighbers and get the average of the value of the pixels
	**getPixel(int x, int y)** // return the value in the pixel [x][y]
	**crop(int x, int y )** // crop the image from (0,0) to (x,y)
	**addFrom(Frame f)** // add from Frame f the value of each pixel to the correct position in this.frame (if not the same instance or size it will do nothing)
	**compareTo(Frame f)** // compare between 2 sizes of frames. height * weight

# Stage 2:

I need to Implement a container that contains array of frames.

We need to implement the following functions:
	**Frame get(int i)** // get the frame from position i in the array.
	**int size()** // return the amount of frames the array is storing.
	**void Add(Frame f)** // add Frame f to the array. and make it dynamic.
	**void remove(Frame f)** // delete Frame f if existing in the array. and make it dynamic.
	**void Sort(Frame[] f)** // Sort the Frames in f, by the size of them (height * weight)
	**void RotateAll(Frame[] f)** // Rotate all of the frames 90 digress.
	**void smoothAll(Frame[] f, int n)** smooth all of the frames by the number of neighbers n,
	
#Stage 3:
	
Create 5 Junit tests for all the functions.
