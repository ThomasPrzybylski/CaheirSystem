import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SystemGUI {

	static Catagory cat = new Catagory();

	static LinkedList<FoodItem> food;
	
	JFrame SysFrame, alterFrame, registerFrame;
	JPanel sysPane, alterPane, registerPane;

	JMenuBar menu;
	JButton register, alter, close, simTest;

	JComboBox <CatagoryNode> catagory;
	JComboBox <FoodItem> item;
	JComboBox <Size> size;
	JComboBox <Double> price;
	JButton add, edit, remove;
	JButton addCat, editCat, removeCat;
	JButton addSize, editSize, removeSize;
	JButton reset, exit;
	JOptionPane save;

	public static void main(String[] args) {

		IOSys<Catagory> io = new IOSys<Catagory>();
		cat = (io.ReadBinaryFile("save.dat"));

		LayoutManager flow = new FlowLayout();

		JFrame sysFrame = new JFrame("system");
		sysFrame.setLayout(flow);
		sysFrame.setSize(1000, 1000);
		sysFrame.setDefaultCloseOperation(2);
		sysFrame.setVisible(true);
		JMenuBar menu = new JMenuBar();
		menu.setSize(1000, 50);
		@SuppressWarnings("unused")
		JMenuItem file = new JMenuItem("save");
		sysFrame.add(menu);

		JPanel sysPane1 = new JPanel();
		JPanel sysPane2 = new JPanel();
		sysPane1.setLayout(flow);
		sysPane1.add(new JLabel("Register #--------"));
		sysPane2.setLayout(flow);
		JButton register = new JButton("Open Register System");
		register.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				Register();
			}});
		JButton alter = new JButton("Edit Information");
		alter.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				AlterFrame();
			}});
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				IOSys.writeToBinary("save", cat);
				System.exit(0);
			}});
		JButton simTest = new JButton("Simmulation Test");
		simTest.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {


			}});
		sysPane2.add(register);
		sysPane2.add(alter);
		sysPane2.add(close);
		sysPane2.add(simTest);
		sysFrame.add(sysPane1);
		sysFrame.add(sysPane2);

	}
	public static void Register() {
		LayoutManager flow = new FlowLayout();
		LayoutManager grid = new GridLayout(4,1);
		String [] catlist = cat.toStringArray();
		

		final JFrame registerFrame = new JFrame("Register");
		registerFrame.setLayout(grid);
		registerFrame.setSize(500, 500);
		registerFrame.setDefaultCloseOperation(2);
		registerFrame.setVisible(true);
		
		JPanel registerPane = new JPanel();
		registerPane.setLayout(flow);
		registerFrame.add(registerPane);
		
		final JComboBox<String> fditem = new JComboBox<String>();

		final JComboBox<String> catag = new JComboBox<String>(catlist);
		catag.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				LinkedListNode<CatagoryNode> tempor = cat.get(new CatagoryNode(catag.getSelectedItem().toString()));				
				LinkedListNode<FoodItem> temporary = tempor.element.getFirstFoodList();
				LinkedList<FoodItem> temp = new LinkedList<FoodItem>();
				temp.list = temporary;
				String [] foodlist = temp.toStringArray();
				fditem.removeAllItems();
				for (int x = 0; x < foodlist.length; x++)
				fditem.addItem(foodlist [x]);
			}
			
		});
		registerPane.add(catag);
		registerPane.add(fditem);
		
		JButton close = new JButton("Close");
		close.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				registerFrame.dispose();
			}});
		registerPane.add(close);

		
	}
	public static void AlterFrame(){
		LayoutManager flow = new FlowLayout();
		LayoutManager grid = new GridLayout(4,1);

		final JFrame alterFrame = new JFrame("Alter");
		alterFrame.setLayout(grid);
		alterFrame.setSize(500, 500);
		alterFrame.setDefaultCloseOperation(2);
		alterFrame.setVisible(true);
		
		JPanel alterPane = new JPanel();
		JPanel alterPanel = new JPanel();
		JPanel alterPanes = new JPanel();
		JPanel alterSysPane = new JPanel();
		alterPane.setLayout(flow);
		final JTextField catagory = new JTextField(15);
		catagory.setToolTipText("Allows one to Select a Catagory.");
		PopupMenu catpop = new PopupMenu(cat.toString());
		catpop.add(catpop);
		catagory.add(catpop);
		final JTextField item = new JTextField(15);
		item.setToolTipText("Allows one to Select a Food Item.");
		final JTextField size = new JTextField(15);
		size.setToolTipText("Allows one to set a size of an Item.");
		final JTextField price = new JTextField(15);
		price.setToolTipText("Allows one to set a price of a size of an Item.");
		final JTextArea descrip = new JTextArea(20,20);
		descrip.setToolTipText("Allows one to set a description of an Item.");
		JButton add = new JButton("Add Item");
		add.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CatagoryNode temp = new CatagoryNode(catagory.getText());
				if(!cat.contains(new CatagoryNode(catagory.getText())))
				{
				cat.add(temp);
				}
				if(!cat.contains(new FoodItem(item.getText())))
				{
					temp.add(new FoodItem(item.getText(),size.getText(), Double.parseDouble(price.getText()), descrip.getText(), null));
				}
				IOSys.writeToBinary("save.dat", cat);
					

			}});
		JButton edit = new JButton("Edit Item");
		edit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				CatagoryNode temp = new CatagoryNode(catagory.getText());
				if(cat.contains(new CatagoryNode(catagory.getText())))
				{
				if(cat.contains(new FoodItem(item.getText())))
				{
					LinkedListNode<FoodItem> newtemp = temp.get(new FoodItem(item.getText()));
					newtemp.element.setName(item.getText());
					newtemp.element.setDescription(descrip.getText());
					newtemp.element.addToSize(new Size(size.getText(),Double.parseDouble(price.getText())));
				}
				}
				IOSys.writeToBinary("save.dat", cat);					

			}});
		JButton remove = new JButton("Remove Item");
		remove.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				if(cat.contains(new CatagoryNode(catagory.getText())))
				{
				if(cat.contains(new FoodItem(item.getText())))
				{
					cat.get(new CatagoryNode(catagory.getText())).getElement().remove(new FoodItem(item.getText()));
				}}
				IOSys.writeToBinary("save.dat", cat);


			}});
		JButton addSize= new JButton("Add Size"); 
		addSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				CatagoryNode temp = new CatagoryNode(catagory.getText());
				if(!cat.contains(new CatagoryNode(catagory.getText())))
				{
				cat.add(temp);
				}
				if(cat.contains(new FoodItem(item.getText())))
				{
					LinkedListNode<FoodItem> newtemp = cat.list.element.get(new FoodItem(item.getText()));
					newtemp.element.addToSize(new Size(size.getText(),Double.parseDouble(price.getText())));;
				}
				IOSys.writeToBinary("save.dat", cat);

			}});
		JButton editSize = new JButton("Edit Size");
		editSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {


				CatagoryNode temp = new CatagoryNode(catagory.getText());
				if(!cat.contains(new CatagoryNode(catagory.getText())))
				{
				cat.add(temp);
				}
				if(cat.contains(new FoodItem(item.getText())))
				{
					LinkedListNode<FoodItem> newtemp = cat.list.element.get(new FoodItem(item.getText()));
					newtemp.element.getSize().remove((new Size(size.getText(),Double.parseDouble(price.getText()))));
					newtemp.element.getSize().add((new Size(size.getText(),Double.parseDouble(price.getText()))));
				}
				IOSys.writeToBinary("save.dat", cat);


			}});
		JButton removeSize = new JButton("Remove Size");
		removeSize.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				CatagoryNode temp = new CatagoryNode(catagory.getText());
				if(!cat.contains(new CatagoryNode(catagory.getText())))
				{
				cat.add(temp);
				}
				if(cat.contains(new FoodItem(item.getText())))
				{
					LinkedListNode<FoodItem> newtemp = cat.list.element.get(new FoodItem(item.getText()));
					newtemp.element.getSize().remove((new Size(size.getText(),Double.parseDouble(price.getText()))));
				}
				IOSys.writeToBinary("save.dat", cat);

			}});
		JButton reset = new JButton("Reset");
		reset.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {

				catagory.setText("");
				item.setText("");
				size.setText("");
				price.setText("");
				descrip.setText("");
				
				
			}});
		JButton exit= new JButton("Close");
		exit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				alterFrame.dispose();

			}});
		alterPane.add(catagory);
		alterPane.add(item);
		alterPane.add(size);
		alterPane.add(price);
		alterPane.add(descrip);
		alterPanel.add(add);
		alterPanel.add(edit);
		alterPanel.add(remove);
		alterPanes.add(addSize);
		alterPanes.add(editSize);
		alterPanes.add(removeSize);
		alterSysPane.add(reset);
		alterSysPane.add(exit);
		
		alterFrame.add(alterPane);
		alterFrame.add(alterPanel);
		alterFrame.add(alterPanes);
		alterFrame.add(alterSysPane);
		
		
	}
}
