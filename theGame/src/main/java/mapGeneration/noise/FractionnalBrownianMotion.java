package mapGeneration.noise;

public class FractionnalBrownianMotion {
	
	private Noise noise;
	private double lacunarity;
	private double gain;
	private int octaves;

	public FractionnalBrownianMotion(Noise noise, double lacunarity, int octaves){
		this.noise = noise;
		this.lacunarity = lacunarity;
		this.gain = 1/lacunarity;
		this.octaves = octaves;
	}

	public double[][] generateHeigthMap(int heigth, int width){
		double[][] heigthMap = new double[heigth][width];
		for(int i = 0; i < heigth; i++){
			for(int j = 0; j < width; j++){
				heigthMap[i][j] = (generatePixel(i, j));
			}
		}
		return heigthMap;
	}

	private double generatePixel(int x, int y) {
		double total = 0;
		double frequency = 1;
		double amplitude = gain;
		
		for(int i = 0; i < octaves; i++){
			total += noise.generatePixel((float)x * frequency, (float)y * frequency) * amplitude;
			frequency *= lacunarity;
			amplitude *= gain;
		}

		return total;
	}
}
