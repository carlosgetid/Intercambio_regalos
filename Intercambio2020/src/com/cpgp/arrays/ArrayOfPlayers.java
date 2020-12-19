package com.cpgp.arrays;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.table.AbstractTableModel;

import com.cpgp.entities.Player;


public class ArrayOfPlayers extends AbstractTableModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static ArrayList<Player> aOfPlay;
	
	public ArrayOfPlayers() {
		aOfPlay=new ArrayList<Player>();
	}
	
	public int getSize() {
		return aOfPlay.size();
	}
	
	public Player getPlayerByIndex(int index) {
		return aOfPlay.get(index);
	}
	
	public Player getPlayerByID(int ID) {
		for(Player c:aOfPlay)
			if(c.getId()==ID)
				return c;
		return null;
	}
	
	public void addPlayer(Player c) {
		if(getSize()<100)
			aOfPlay.add(c);
	}
	
	public void removePlayer(Player c) {
		aOfPlay.remove(c);
	}
	
	public int generateID() {
		if(getSize()==0)
			return 1;
		else
			return getLargestID()+1;
	}
	
	public int getLargestID() {
		int l=getPlayerByIndex(0).getId();
		for(Player c:aOfPlay)
			if(c.getId()>l)
				l=c.getId();
		return l;
	}
	
	public ArrayList<Player> randomArray() {
		Collections.shuffle(aOfPlay);
		return aOfPlay;
	}
	
//	public void replace(int index, Player p) {
//		aOfPlay.set(index, p);
//	}
	
//	
//	// TODO : Read data from text file
//	private void loadOffCategories() {
//		try {
//			BufferedReader bf;
//			String row;
//			
//			int ID;
//			String name;
//			
//			String t[];
//			bf=new BufferedReader(new FileReader("offCategories.txt"));
//			while((row=bf.readLine())!=null) {
//				t=row.split(";");
//				ID=Integer.parseInt(t[0]);
//				name=t[1];
//				addPlayer(new Player(ID, name));
//			}
//			bf.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
//	// TODO : Save data to text file from array
//	public void saveOffCategories() {
//		try {
//			PrintWriter pw;
//			String row;
//			pw=new PrintWriter(new FileWriter("offCategories.txt"));
//			for(Player c:aOfPlay) {
//				row=c.getId()+";"+
//					c.getName()+";";
//				pw.println(row);
//			}
//			pw.close();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	private String columnNames[]={"ID", "Name", "", ""};
	
	public String getColumnName(int col) {
		return columnNames[col];
	}
	
	@Override
	public int getRowCount() {
		return getSize();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}
	
	// Get values from objects of array
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object value=null;
		Player c=getPlayerByIndex(rowIndex);
		
		//All categories has format1 in the array
		//Convert format1--->fomat2
		
		switch (columnIndex) {
		case 0:
			value=c.getId();
			break;
		case 1:
			value=c.getName();
			break;
//		//Place custom buttons in a column of the table according to the column index
//		case 5:
//			value=new ButtonColumn(table, "Player", 5);;
//			break;
//		case 6:
//			value=new ButtonColumn(table, "Player", 6);
//			break;
		}
		return value;
	}
	
	// TODO : Show the values obtained in the table
	@Override
	public Class getColumnClass(int columnIndex) {
		Object value=this.getValueAt(0,columnIndex);
		return (value==null?Object.class:value.getClass());
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==0)
			return false;
		if(columnIndex==2)
			return false;
		if(columnIndex==3)
			return false;
		return true;
	}
	
	// TODO : Modify object values in the array
	@Override
	public void setValueAt(Object value, int rowIndex, int columnIndex) {
		Player c=getPlayerByIndex(rowIndex);
		switch (columnIndex) {
		case 0:
			c.setId((Integer)value);
			break;
		case 1:
			c.setName((String)value);
			break;
//		case 3:
//			c.setPlayerDate((Date)value);
//			break;
//		case 4:
//			c.setPlayerFavorite((boolean)value);
//			saveOffCategories();
//			if(NewTopic.catGroupIndex==1) {
//				//if(table.getRowCount()!=0)
//				NewTopic.filterCategories("");
//			}
//			else {
//				//if(table.getRowCount()!=0)
//				NewTopic.filterCategories("true");
//			}
//			break;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}
	
//	public static void clearTxtSelectedCategories() {
//		NewTopic.txtSelectedCategories.setText("");
//	}
	
//	public static void showSelectedCategories() {
//		for (Player c:aOffCat) {
//			if(c.isPlayerSelection()==true)
//				NewTopic.txtSelectedCategories.append(c.getPlayerName()+"\t");
//		}
//	}
	
}
