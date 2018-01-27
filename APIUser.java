
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

import com.google.gson.Gson;




public class APIUser {

	private final String USER_AGENT = "Safari";
	private String jsonString;
	private StockData sd = null;
	private String ticker;

	public APIUser(String ticker) throws Exception {

		this.ticker = ticker;
		
		
		
	}



	public String urlBuilder(String ticker, String flag) {
		// TODO Auto-generated method stub
		String url = "https://api.iextrading.com/1.0/stock";

		String endingCall = "/quote";
				
				
		String begTicker = "/";
		if(flag.equals("quote")) {
			endingCall = "/quote";
		}
		
		if(flag.equals("1yr")) {
			endingCall = "/chart/1y";
		}
		
		url = url + begTicker + ticker + endingCall;
		return url;
	}

	// HTTP GET request
	public void sendGet(String url) throws Exception {

		URL obj = new URL(url);
	
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		// optional default is GET
		con.setRequestMethod("GET");

		// add request header
		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();

		// print result
		System.out.println(response.toString());

		jsonString = response.toString();
		
		

	}

	public String getJsonString() {
		return jsonString;
	}
	
	public StockData getStockData() {
		return sd;
	}

}