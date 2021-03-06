package Order;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainOrder {
	private static OrderData od = new OrderData();
	private static String curentDir = System.getProperty("user.dir");
	private static JFrame enterFrame;
	private static JFrame frame;
	private static JFrame listFrame;
	private static JFrame listFrameNow;
	public static void main(String[] args) throws IOException {
		enterData();
		listData();
		mainFrame();
	}
	public static void mainFrame() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(3, 1));
		panel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		JButton enterOrderButton = new JButton("Nhập đơn hàng");
		JButton listOrderButton = new JButton("Danh sách đơn hàng");
		JButton optionButton = new JButton("Cài đặt");
		panel.add(enterOrderButton);
		panel.add(listOrderButton);
		panel.add(optionButton);
		frame.add(panel, BorderLayout.CENTER);
		frame.setPreferredSize(new Dimension(600, 600));
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		enterOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				enterFrame.setVisible(true);
			}
		});
		listOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				listFrame.setVisible(true);
			}
		});
		frame.pack();
		frame.setVisible(true);
	}
	public static void enterData() throws IOException {
		enterFrame = new JFrame();
		JPanel enterJPanel = new JPanel();
		enterJPanel.setBorder(new EmptyBorder(new Insets(150, 200, 150, 200)));
		JLabel enterLabel = new JLabel("Tên sản phẩm");
		JTextField enterText = new JTextField(50);
		JLabel enterMoneyLabel = new JLabel("Số tiền");
		JTextField MoneyText = new JTextField(12);
		JLabel numberOrderLabel = new JLabel("Số lượng");
		JTextField numberOrderText = new JTextField(8);
		JButton enterButton = new JButton("Nhập");
		JButton listButton = new JButton("Xem danh sách");
		enterJPanel.add(enterLabel);
		enterJPanel.add(enterText);
		enterJPanel.add(enterMoneyLabel);
		enterJPanel.add(MoneyText);
		enterJPanel.add(numberOrderLabel);
		enterJPanel.add(numberOrderText);
		enterJPanel.add(enterButton);
		enterJPanel.add(listButton);

		enterButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String nameTxt = enterText.getText() +" \n";
				String moneyTxt = MoneyText.getText() + " \n";
				String numberTxt = numberOrderText.getText() + " \n";
				Calendar c = Calendar.getInstance();
				Date date = c.getTime();
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
				String DateTxt = formatter.format(date) + " \n";
				if(!nameTxt.equals(" \n")) {
					od.setNameOrderNow(nameTxt);
					od.setMoneyOrderNow(moneyTxt);
					od.setNumberOrderNow(numberTxt);
					od.setDateOrderNow(DateTxt);
				}
			}
		});
		
		listButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					listDataNow();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		enterFrame.add(enterJPanel);
		enterFrame.setPreferredSize(new Dimension(1650, 1080));
		enterFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		enterFrame.pack();
	}
	
	public static void listData() throws IOException {
		listFrame = new JFrame();
		od.setOrder();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> money = new ArrayList<String>();
		ArrayList<String> num = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		name = od.getNameOrder();
		money = od.getMoneyOrder();
		num = od.getNumberOrder();
		date = od.getDateOrder();
		String[] columName = {"Tên sản phẩm", "Giá (VNĐ)", "Số lượng", "Ngày nhập"};
		Object[][] data;
		data = new String[name.size() +1][];
		int allMoney = 0;
		for(int i = 0; i < name.size(); ++i) {
			data[i] = new String[5];
			data[i][0] = name.get(i);
			data[i][1] = money.get(i);
			data[i][2] = num.get(i);
			data[i][3] = date.get(i);
			int a = Integer.parseInt(money.get(i).trim());
			int b = Integer.parseInt(num.get(i).trim());
			allMoney += a*b;
		}
		data[name.size()] = new String[5];
		data[name.size()][0] = "Tổng";
		data[name.size()][1] = Integer.toString(allMoney);
		data[name.size()][2] ="";
		data[name.size()][3] = "";
		
		JTable table = new JTable(data, columName);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);
        listFrame.add(scrollPane, BorderLayout.CENTER);
		listFrame.setPreferredSize(new Dimension(600, 600));
		listFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listFrame.pack();
	}
	public static void listDataNow() throws IOException {
		listFrameNow = new JFrame();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> money = new ArrayList<String>();
		ArrayList<String> num = new ArrayList<String>();
		ArrayList<String> date = new ArrayList<String>();
		name = od.getNameOrderNow();
		money = od.getMoneyOrderNow();
		num = od.getNumberOrderNow();
		date = od.getDateOrderNow();
		String[] columName = {"Tên sản phẩm", "Giá (VNĐ)", "Số lượng", "Ngày nhập"};
		Object[][] data;
		data = new String[name.size() +1][];
		int allMoney = 0;
		for(int i = 0; i < name.size(); ++i) {
			data[i] = new String[5];
			data[i][0] = name.get(i);
			data[i][1] = money.get(i);
			data[i][2] = num.get(i);
			data[i][3] = date.get(i);
			int a = Integer.parseInt(money.get(i).trim());
			int b = Integer.parseInt(num.get(i).trim());
			allMoney += a*b;
		}
		data[name.size()] = new String[5];
		data[name.size()][0] = "Tổng";
		data[name.size()][1] = Integer.toString(allMoney);
		data[name.size()][2] ="";
		data[name.size()][3] = "";
		
		JTable table = new JTable(data, columName);
        JScrollPane scrollPane = new JScrollPane(table);
        table.setAutoCreateRowSorter(true);
        listFrameNow.add(scrollPane, BorderLayout.CENTER);
		listFrameNow.setPreferredSize(new Dimension(600, 600));
		listFrameNow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		listFrameNow.pack();
		listFrameNow.setVisible(true);
	}
}
