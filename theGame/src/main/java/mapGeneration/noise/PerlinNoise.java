package mapGeneration.noise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import mapGeneration.data.Gradient;
import mapGeneration.data.Gradients;

public class PerlinNoise {
	private static final int PERMUTATION_TABLE_SIZE = 256;
	
	private List<Integer> permutationTable = new ArrayList<>();
	private Gradients possibleGradients = new Gradients();

	private int squareSize;
	
	public PerlinNoise(){
		generatePermutationTable();
		generateGradients();
	}

	private void generateGradients() {
		
	}

	private void generatePermutationTable() {
		for(int i = 0; i < PERMUTATION_TABLE_SIZE; i++){
			permutationTable.add(i);
		}
		Collections.shuffle(permutationTable);
		for(int i =0; i < PERMUTATION_TABLE_SIZE; i++){
			permutationTable.add(i);
		}
	}


	public double[][] generateHeigthMap(int heigth, int width, int squareSize){
		this.squareSize = squareSize;
		double[][] heigthMap = new double[heigth][width];
		for(int i = 0; i < heigth; i++){
			for(int j = 0; i < width; j++){
				heigthMap[i][j] = generatePixel(i, j);
			}
		}
		return heigthMap;
		
	}

	private double generatePixel(int i, int j) {
		double x = (double)i /squareSize;
		double y = (double)j /squareSize;
		
		int x0 = (int) x;
		int y0 = (int) y;
		int ii = i % PERMUTATION_TABLE_SIZE;
		int jj = j % PERMUTATION_TABLE_SIZE;
		Gradient[] gradients = new Gradient[4];
		gradients[0] = possibleGradients.getGradient(permutationTable.get(ii + permutationTable.get(jj)) % 8);
		gradients[1] = possibleGradients.getGradient(permutationTable.get(ii + permutationTable.get(jj + 1)) % 8);
		gradients[2] = possibleGradients.getGradient(permutationTable.get(ii + 1 + permutationTable.get(jj)) % 8);
		gradients[3] = possibleGradients.getGradient(permutationTable.get(ii + 1 + permutationTable.get(jj + 1)) % 8);
		
		double s = ponderer(x-x0, y-y0, gradients[0]);
		double t = ponderer(x-(x0+1), y-(y0), gradients[1]);
		double u = ponderer(x-x0, y-(y0+1), gradients[2]);
		double v = ponderer(x-(x0+1), y-(y0+1), gradients[3]);
		
		double tmp = x-x0;
	    double Cx = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    double Li1 = s + Cx*(t-s);
	    double Li2 = u + Cx*(v-u);

	     tmp = y - y0;
	    double Cy = 3 * tmp * tmp - 2 * tmp * tmp * tmp;

	    return Li1 + Cy*(Li2-Li1);

	}

	private double ponderer(double x, double y, Gradient gradient) {
		return gradient.x * x + gradient.y * y;
		
	}
	

}
