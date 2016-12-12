package processor;

public class DataProcessor {

	     public double Mean(String data){
	    	String data1[] = data.split(",");
	    	double mean = 0;
			for(int i=0; i< data1.length; i++)
	    		mean =mean+ Integer.parseInt(data1[i]);
	    	 mean = mean/ data1.length;
	    	return mean;
	    }
	    
	    public double StandardDeviation(String data, double mean){
	    	String[] data1 = data.split(",");
	    	double sum=0;
	    	double sd = 0;
			for(int i=0; i< data1.length; i++){
	    		sum = Math.pow((Integer.parseInt(data1[i]) - mean), 2); 
	    	}
	    	sd =  Math.sqrt(sum/(data1.length));
	    	return sd;
	    }
	}
