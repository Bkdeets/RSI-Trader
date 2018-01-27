
public class Candle {
	//Properties ----------------------------------------------------------------
	private double open;
	private double high;
	private double low;
	private double close;
	private int volume;
	private String date;
	
	//Constructor---------------------------------------------------------------
	public Candle(double open, double high, double low, double close, int volume, String date) {
		this.open = open;
		this.high = high;
		this.low = low;
		this.close = close;
		this.volume = volume;
		this.date = date;
		
		}
	
	//Behaviors ----------------------------------------------------------------
	//Modifies build in toString() method
	public String toString() {
		return this.open + "|" + this.high + "|" + this.low + "|" + this.close + "|" + this.volume + "|" +this.date +"\n";
	}
	
	//All of these methods get whichever candle property
	public String getDate() {
		return this.date;
	}
	public Double getHigh() {
		return this.high;
	}
	public Double getOpen() {
		return this.open;
	}
	public Double getLow() {
		return this.low;
	}
	public Double getClose() {
		return this.close;	
	}
	public int getVolume() {
		return this.volume;
	}
    //-----------------------------------------------------
	
	//Calculates if candle is an up or down candle
	public int upDown() {
		if(open<close) {
			return 1;
		}
		else {
			return 0;
		}
	}
	
	//Calculates # period RSI
	public double RSICalc(int period) {
		double RSI = 0.0;
		
		return RSI;
		
	}
	
	public double percentChange() {
		return (close-open)/open;
	}


	
	
}
