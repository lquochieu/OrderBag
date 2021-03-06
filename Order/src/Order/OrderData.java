package Order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class OrderData {
	private static String curentDir = System.getProperty("user.dir");
	private ArrayList<String> NameOrderNow = new ArrayList<String>();
	private ArrayList<String> MoneyOrderNow = new ArrayList<String>();
	private ArrayList<String> NumberOrderNow = new ArrayList<String>();
	private ArrayList<String> DateOrderNow = new ArrayList<String>();
	private ArrayList<String> NameOrder = new ArrayList<String>();
	private ArrayList<String> MoneyOrder = new ArrayList<String>();
	private ArrayList<String> NumberOrder = new ArrayList<String>();
	private ArrayList<String> DateOrder = new ArrayList<String>();
	
	
	
	public ArrayList<String> getNameOrderNow() {
		return NameOrderNow;
	}
	public ArrayList<String> getMoneyOrderNow() {
		return MoneyOrderNow;
	}
	public ArrayList<String> getNumberOrderNow() {
		
		return NumberOrderNow;
	}
	public ArrayList<String> getDateOrderNow() {
		
		return DateOrderNow;
	}
	
	public void setOrder() throws IOException{
		BufferedReader bfNameReader = null;
		BufferedReader bfMoneyReader = null;
		BufferedReader bfNumberReader = null;
		BufferedReader bfDateReader = null;
		try {
			bfNameReader = new BufferedReader(new FileReader(curentDir + "/NameOrder.txt"));
			String nameLine = bfNameReader.readLine();
			while(nameLine != null) {
				NameOrder.add(nameLine);
				nameLine = bfNameReader.readLine();
			}
			bfNameReader.close();
			bfMoneyReader = new BufferedReader(new FileReader(curentDir + "/MoneyOrder.txt"));
			String moneyLine = bfMoneyReader.readLine();
			while(moneyLine != null) {
				MoneyOrder.add(moneyLine);
				moneyLine = bfMoneyReader.readLine();
			}
			bfMoneyReader.close();
			bfNumberReader = new BufferedReader(new FileReader(curentDir + "/NumberOrder.txt"));
			String NumLine = bfNumberReader.readLine();
			while(NumLine != null) {
				NumberOrder.add(NumLine);
				NumLine = bfNumberReader.readLine();
			}
			bfNumberReader.close();
		    bfDateReader = new BufferedReader(new FileReader(curentDir + "/DateOrder.txt"));
		    String DateLine = bfDateReader.readLine();
		    while(DateLine != null) {
		    	DateOrder.add(DateLine);
		    	DateLine = bfDateReader.readLine();
		    }
		    bfDateReader.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public ArrayList<String> getNameOrder() {
		return NameOrder;
	}
	public ArrayList<String> getMoneyOrder() {
		return MoneyOrder;
	}
	public ArrayList<String> getNumberOrder() {
		return NumberOrder;
	}
	public ArrayList<String> getDateOrder() {
		return DateOrder;
	}
	public void setNameOrderNow(String nameTxt) {
		BufferedWriter bwNameOrder = null;
		FileWriter fwNameOrder = null;
		File fileNameOrder = new File(curentDir + "/NameOrder.txt");
		try {
			fwNameOrder = new FileWriter(fileNameOrder.getAbsoluteFile(), true);
			bwNameOrder = new BufferedWriter(fwNameOrder);
			bwNameOrder.write(nameTxt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bwNameOrder!= null) {
				
				try {
					bwNameOrder.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
		this.NameOrderNow.add(nameTxt);
	}
	public void setMoneyOrderNow(String MoneyTxt) {
		BufferedWriter bwMoneyOrder = null;
		FileWriter fwMoneyOrder = null;
		File fileMoneyOrder = new File(curentDir + "/MoneyOrder.txt");
		try {
			fwMoneyOrder = new FileWriter(fileMoneyOrder.getAbsoluteFile(), true);
			bwMoneyOrder = new BufferedWriter(fwMoneyOrder);
			bwMoneyOrder.write(MoneyTxt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bwMoneyOrder != null) {
				try {
					bwMoneyOrder.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		this.MoneyOrderNow.add(MoneyTxt);
	}
	
	public void setNumberOrderNow(String NumberTxt) {
		BufferedWriter bwNumberOrder = null;
		FileWriter fwNumberOrder = null;
		File fileNumberOrder = new File(curentDir + "/NumberOrder.txt");
		try {
			fwNumberOrder = new FileWriter(fileNumberOrder.getAbsoluteFile(), true);
			bwNumberOrder = new BufferedWriter(fwNumberOrder);
			bwNumberOrder.write(NumberTxt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bwNumberOrder!= null) {
				
				try {
					bwNumberOrder.close();
					} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
		this.NumberOrderNow.add(NumberTxt);
	}
	public void setDateOrderNow(String DateTxt) {
		BufferedWriter bwDateOrder = null;
		FileWriter fwDateOrder = null;
		File fileDateOrder = new File(curentDir + "/DateOrder.txt");
		try {
			fwDateOrder = new FileWriter(fileDateOrder.getAbsoluteFile(), true);
			bwDateOrder = new BufferedWriter(fwDateOrder);
			bwDateOrder.write(DateTxt);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(bwDateOrder!= null) {
				
				try {
					bwDateOrder.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}
	}
		this.DateOrderNow.add(DateTxt);
	}

}
