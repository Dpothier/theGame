package mapGeneration.noise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import mapGeneration.data.Vector;
import mapGeneration.data.Gradients;

public class PerlinNoise {
	private static final int PERMUTATION_TABLE_SIZE = 256;
	
	private List<Integer> permutationTable = new ArrayList<>();
	private Gradients possibleGradients = new Gradients();
	private Vector[][] gradiantTable = new Vector[8][8];
	
	public PerlinNoise(){
		generatePermutationTable();
		generateGradiantTable();
	}

	private void generatePermutationTable() {
		for(int i = 0; i < PERMUTATION_TABLE_SIZE; i++){
			permutationTable.add(i);
		}
		Collections.shuffle(permutationTable);
		for(int i =0; i < PERMUTATION_TABLE_SIZE; i++){
			System.out.println(permutationTable.get(i));
			permutationTable.add(permutationTable.get(i));
		}
	}
	
	private void generateGradiantTable() {
		Random random = new Random();
		for(int i = 0; i < 8; i ++){
			for(int j = 0; j < 8; j++){
				int angle = random.nextInt(360);
				gradiantTable[i][j] = new Vector(Math.cos(angle), Math.sin(angle));
			}
		}
		
	}



	public double[][] generateHeigthMap(int heigth, int width,int squareSize, int res){
		double[][] heigthMap = new double[heigth][width];
		for(int i = 0; i < heigth; i++){
			for(int j = 0; j < width; j++){
				heigthMap[i][j] = generatePixel(i, j,squareSize, res);
			}
		}
		return heigthMap;
		
	}

	private double generatePixel(int i, int j,int squareSize, int res) {
		double x = ((double)i) /squareSize;
		double y = ((double)j) /squareSize;
		
		double fractionnalX = x - (int)x;
		double fractionnalY = x - (int)y;
		
		Vector upperLeftGridPoint = gradiantTable[(int) Math.floor(x)][(int) Math.floor(y)];
		Vector upperRigthGridPoint = gradiantTable[(int)Math.ceil(x)][(int)Math.floor(y)];
		Vector lowerLeftGridPoint = gradiantTable[(int)Math.floor(x)][(int) Math.ceil(y)];
		Vector lowerRigthGridPoint = gradiantTable[(int)Math.ceil(x)][(int)Math.ceil(y)];
		
		Vector distanceToUpperLeft = new Vector(fractionnalX, fractionnalY);
		Vector distanceToUpperRigth= new Vector(fractionnalX - 1, fractionnalY);
		Vector distanceToLowerLeft = new Vector(fractionnalX, fractionnalY - 1);
		Vector distanceToLowerRigth = new Vector(fractionnalX - 1, fractionnalY - 1);
		
		double s = upperLeftGridPoint.dotProduce(distanceToUpperLeft);
		double t = upperRigthGridPoint.dotProduce(distanceToUpperRigth);
		double u = lowerLeftGridPoint.dotProduce(distanceToLowerLeft);
		double v = lowerRigthGridPoint.dotProduce(distanceToLowerRigth);
		
		/*int x0 = (int) x;
		int y0 = (int) y;
		int ii = i &  PERMUTATION_TABLE_SIZE-1;
		int jj = j & PERMUTATION_TABLE_SIZE-1;
		Vector[] gradients = new Vector[4];
		gradients[0] = possibleGradients.getGradient(permutationTable.get(ii + permutationTable.get(jj)) % 8);
		gradients[1] = possibleGradients.getGradient(permutationTable.get(ii+1 + permutationTable.get(jj )) % 8);
		gradients[2] = possibleGradients.getGradient(permutationTable.get(ii + permutationTable.get(jj+1)) % 8);
		gradients[3] = possibleGradients.getGradient(permutationTable.get(ii + 1 + permutationTable.get(jj + 1)) % 8);
		
		double s = ponderer(x-x0, y-y0, gradients[0]);
		double t = ponderer(x-(x0+1), y-(y0), gradients[1]);
		double u = ponderer(x-x0, y-(y0+1), gradients[2]);
		double v = ponderer(x-(x0+1), y-(y0+1), gradients[3]);*/
		
		double fadedX = fade(fractionnalX);
		double fadedY = fade(fractionnalY);
		
		return 0;
		/*double tmp = x-x0;
	    double Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    double Li1 = s + Cx*(t-s);
	    double Li2 = u + Cx*(v-u);

	     tmp = y - y0;
	    double Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return ((Li1 + Cy*(Li2-Li1)) + 1) * 0.5;*/

	}

	private double fade(double x) {
		return 6 * x * x * x * x * x -
			  15 * x * x * x * x +
			  10 * x * x * x;
	}

	private double ponderer(double x, double y, Vector gradient) {
		return gradient.x * x + gradient.y * y;
		
	}
	

}
