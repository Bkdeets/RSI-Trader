
public class ChartStockData {
	
  private String date;

  public String getDate() { return this.date; }

  public void setDate(String date) { this.date = date; }

  private double open;

  public double getOpen() { return this.open; }

  public void setOpen(double open) { this.open = open; }

  private double high;

  public double getHigh() { return this.high; }

  public void setHigh(double high) { this.high = high; }

  private double low;

  public double getLow() { return this.low; }

  public void setLow(double low) { this.low = low; }

  private double close;

  public double getClose() { return this.close; }

  public void setClose(double close) { this.close = close; }

  private int volume;

  public int getVolume() { return this.volume; }

  public void setVolume(int volume) { this.volume = volume; }

  private int unadjustedVolume;

  public int getUnadjustedVolume() { return this.unadjustedVolume; }

  public void setUnadjustedVolume(int unadjustedVolume) { this.unadjustedVolume = unadjustedVolume; }

  private double change;

  public double getChange() { return this.change; }

  public void setChange(double change) { this.change = change; }

  private double changePercent;

  public double getChangePercent() { return this.changePercent; }

  public void setChangePercent(double changePercent) { this.changePercent = changePercent; }

  private double vwap;

  public double getVwap() { return this.vwap; }

  public void setVwap(double vwap) { this.vwap = vwap; }

  private String label;

  public String getLabel() { return this.label; }

  public void setLabel(String label) { this.label = label; }

  private double changeOverTime;

  public double getChangeOverTime() { return this.changeOverTime; }

  public void setChangeOverTime(int changeOverTime) { this.changeOverTime = changeOverTime; }
  
  //------------------------------
  
  private double RSI;
  
  public double getRSI() {
	  return RSI;
  }

  public void setRSI(double RSI) {
	this.RSI = RSI;
	
}
  public String toString() {
	return Double.toString(RSI);
	  
  }
  
  
}

