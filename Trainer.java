import java.util.ArrayList;

import com.google.gson.Gson;

public class Trainer {

	ArrayList<Double> gains = new ArrayList<Double>();
	ArrayList<Double> losses = new ArrayList<Double>();
	private ChartStockData[] csd = null;
	private String ticker = "aapl";
	
	public static void main(String[] args) {
		
		new Trainer();
		
	}
	
	public Trainer() {
		try {
			
			APIUser http = new APIUser(ticker);		
			String url = http.urlBuilder(ticker,"1yr");
			http.sendGet(url);
			
			Gson gson = new Gson();
			csd = gson.fromJson(http.getJsonString(), ChartStockData[].class);
			
			
			calcRSIs();
			
			for(int i = 0; i < csd.length; i ++) {
				System.out.println(csd[i]);
			}
			
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void calcRSIs() {
	
		double[] nah = initializeRS();
		double RS = nah[0];
		double AvgSog = nah[1];
		double AvgSol = nah[2]; 
		
	
		csd[14].setRSI(100-(100/(1+RS))); //sets the RSI at the 15th period
		
		for(int i = 15; i < csd.length; i ++) {

			double change = csd[i].getChange();
			
			if(change >= 0) {
				//AvgSog = ((AvgSog * 13) + change)/14;
				gains.remove(0);
				gains.add(change);
				AvgSog = (getSum(gains))/14;
			}
			else {
				//subtract change bc change is negative, effectively adds the number to make AvgSol positive
				//AvgSol = ((AvgSol * 13) - change)/14;
				losses.remove(0);
				losses.add(-change);
				AvgSol = (getSum(losses))/14;
			}
			
			
			RS = AvgSog/AvgSol;
			
			
			double RSI = 100 - (100/(1+RS));
						
			csd[i].setRSI(RSI);
		
		}
			
			
	}
		

	private double getSum(ArrayList<Double> list) {
		// TODO Auto-generated method stub
		double sum = 0;
		for(Double d: list) {
			sum += d;
		}
		return sum;
	}

	private double[] initializeRS() {
		
		int RSILength = 14;
		

		double sumOfGains = 0;
		double sumOfLoss = 0;
		
		for(int i = 0; i < RSILength; i ++) {				
			double change = csd[i].getChange();		
			if(change >= 0) {
				sumOfGains += change;
				gains.add(change);
				}
			else {
				sumOfLoss += -change;
				losses.add(-change);
				}	
			}
		
		double AvgSog = sumOfGains/14;
		double AvgSol = sumOfLoss/14;
		
		double RS = AvgSog/AvgSol;
		
		
		double[] sip = {RS,AvgSog,AvgSol};
		return sip;
			
			
		}
		
	
	}
		

