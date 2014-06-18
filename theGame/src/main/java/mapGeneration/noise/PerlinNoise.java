package mapGeneration.noise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PerlinNoise {
	private static final int PERMUTATION_TABLE_SIZE = 256;
	
	private List<Integer> permutationTable = new ArrayList<>();
	private int[][] gradients = new int[8][2];
	
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
	}


	public int[][] generateHeigthMap(){
		return null;
		
	}
	

}
