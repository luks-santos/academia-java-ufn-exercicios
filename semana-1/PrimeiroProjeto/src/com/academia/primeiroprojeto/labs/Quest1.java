package com.academia.primeiroprojeto.labs;

public class Quest1 {

	public static void main(String[] args) {
		float[] values = {2, 8, 5, 9, 6};
		float sum = 0f, mean = 0f;

        for (float value : values) {
            sum += value;
        }
		
		mean = sum/values.length;
		System.out.println(mean);
	}

}
