package com.lxj.main;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import javax.swing.WindowConstants;
import javax.swing.border.BevelBorder;

import com.lxj.iframe.BookLoginIFrame;
import com.lxj.util.CreatecdIcon;



/**
 * ������
 * 
 */
public class Library extends JFrame {
	private static final JDesktopPane 
				DESKTOP_PANE = new JDesktopPane();//���洰��
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager
				.getSystemLookAndFeelClassName());//����ϵͳ�������
			new BookLoginIFrame();//��¼����
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addIFame(JInternalFrame iframe) { // ����Ӵ���ķ���
		DESKTOP_PANE.add(iframe);	//�����Ӵ���
	}
	public Library() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);////���ùرհ�ť�����¼�
		Toolkit tool = Toolkit.getDefaultToolkit();				//���Ĭ�ϵĹ�����
		Dimension screenSize = tool.getScreenSize();			//�����Ļ�Ĵ�С
		setSize(800, 600);										//���ô����С
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);			//���ô���λ��
		setTitle("ͼ��ݹ���ϵͳ");								//���ô������
		JMenuBar menuBar = createMenu(); 	//���ô����˵����ķ���
		setJMenuBar(menuBar);				//���ò˵���
		JToolBar toolBar = createToolBar(); // ���ô����������ķ���
		getContentPane().add(toolBar, BorderLayout.NORTH);//���ù�����
		final JLabel label = new JLabel();	//����һ����ǩ��������ʾͼƬ
		label.setBounds(0, 0, 0, 0);		//���ô���Ĵ�С��λ��
		label.setIcon(null); // ���屳��
		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();//��������С
				label.setSize(e.getComponent().getSize());//���ñ�ǩ��С
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");//���ñ�ǩ�ı�
			}
		});
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));//����ǩ��ӵ����洰��
		getContentPane().add(DESKTOP_PANE);//�����洰����ӵ���������
	}
	/**
	 * ����������
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // �����������ķ���
		JToolBar toolBar = new JToolBar();		//��ʼ��������
		toolBar.setFloatable(false);			//�����Ƿ�����ƶ�������
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));//���ñ߿�
		
		JButton bookAddButton=new JButton(MenuActions.BOOK_ADD);//ͼ����Ϣ��Ӱ�ť
		ImageIcon icon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//��Ӳ˵���ͼ��	
		bookAddButton.setIcon(icon);//���ð�ťͼ��
		bookAddButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(bookAddButton);//��ӵ���������
		
		JButton bookModiAndDelButton=new JButton(MenuActions.BOOK_MODIFY);//ͼ����Ϣ�޸İ�ť
		ImageIcon bookmodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//����ͼ�귽��
		bookModiAndDelButton.setIcon(bookmodiicon);//���ð�ťͼ��
		bookModiAndDelButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(bookModiAndDelButton);//��ӵ���������
		
		JButton booktypeAddButton=new JButton(MenuActions.BOOKTYPE_ADD);//ͼ�������Ϣ��Ӱ�ť
		ImageIcon icon1=new ImageIcon(Library.class.getResource("/bookTypeAddtb.jpg"));//��Ӳ˵���ͼ��	
		booktypeAddButton.setIcon(icon1);//���ð�ťͼ��
		booktypeAddButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(booktypeAddButton);//��ӵ���������
		
		JButton booktypeModiAndDelButton=new JButton(MenuActions.BOOKTYPE_MODIFY);//ͼ�������Ϣ�޸İ�ť
		ImageIcon bookmodiicon1=CreatecdIcon.add("bookTypeAddtb.jpg");//����ͼ�귽��
		booktypeModiAndDelButton.setIcon(bookmodiicon1);//���ð�ťͼ��
		booktypeModiAndDelButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(booktypeModiAndDelButton);//��ӵ���������
		
		JButton readerAddButton=new JButton(MenuActions.READER_ADD);//������Ϣ��Ӱ�ť
		ImageIcon icon2=new ImageIcon(Library.class.getResource("/readerAddtb.jpg"));//��Ӳ˵���ͼ��	
		readerAddButton.setIcon(icon2);//���ð�ťͼ��
		readerAddButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(readerAddButton);//��ӵ���������
		
		JButton readerModiAndDelButton=new JButton(MenuActions.READER_MODIFY);//������Ϣ�޸İ�ť
		ImageIcon readermodiicon1=CreatecdIcon.add("readerModiAndDeltb.jpg");//����ͼ�귽��
		readerModiAndDelButton.setIcon(readermodiicon1);//���ð�ťͼ��
		readerModiAndDelButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(readerModiAndDelButton);//��ӵ���������
		
		JButton userAddButton=new JButton(MenuActions.USER_ADD);//�û���Ӱ�ť
		ImageIcon icon3=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//��Ӳ˵���ͼ��	
		userAddButton.setIcon(icon3);//���ð�ťͼ��
		userAddButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(userAddButton);//��ӵ���������
		
		JButton userModiAndDelButton=new JButton(MenuActions.USER_MODIFY);//�û��޸İ�ť
		ImageIcon usermodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//����ͼ�귽��
		userModiAndDelButton.setIcon(usermodiicon);//���ð�ťͼ��
		userModiAndDelButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(userModiAndDelButton);//��ӵ���������
		
		JButton GengGaiMiMaButton=new JButton(MenuActions.PW_MODIFY);//�û���Ӱ�ť
		ImageIcon GengGaiMiMaicon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//��Ӳ˵���ͼ��	
		GengGaiMiMaButton.setIcon(GengGaiMiMaicon);//���ð�ťͼ��
		GengGaiMiMaButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(GengGaiMiMaButton);//��ӵ���������
		
		JButton newBookCheckButton=new JButton(MenuActions.NEWBOOK_CHECK);//�������հ�ť
		ImageIcon newBookCheckicon=new ImageIcon(Library.class.getResource("/newbookChecktb.jpg"));//��Ӳ˵���ͼ��	
		newBookCheckButton.setIcon(newBookCheckicon);//���ð�ťͼ��
		newBookCheckButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(newBookCheckButton);//��ӵ���������
		
		JButton newBookOrderButton=new JButton(MenuActions.NEWBOOK_ORDER);//���鶩���Ӱ�ť
		ImageIcon newBookOrdericon=new ImageIcon(Library.class.getResource("/bookOrdertb.jpg"));//��Ӳ˵���ͼ��	
		newBookOrderButton.setIcon(newBookOrdericon);//���ð�ťͼ��
		newBookOrderButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(newBookOrderButton);//��ӵ���������
		
		JButton BookBackButton=new JButton(MenuActions.BOOK_BACK);//ͼ��黹�Ӱ�ť
		ImageIcon BookBackicon=new ImageIcon(Library.class.getResource("/bookOrdertb.jpg"));//��Ӳ˵���ͼ��	
		BookBackButton.setIcon(BookBackicon);//���ð�ťͼ��
		BookBackButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(BookBackButton);//��ӵ���������
		
		JButton BookBorrowButton=new JButton(MenuActions.BOOK_BORROW);//ͼ����ļӰ�ť
		ImageIcon BookBorrowicon=new ImageIcon(Library.class.getResource("/bookBorrowtb.jpg"));//��Ӳ˵���ͼ��	
		BookBorrowButton.setIcon(BookBorrowicon);//���ð�ťͼ��
		BookBorrowButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(BookBorrowButton);//��ӵ���������
		
		JButton BookSearchButton=new JButton(MenuActions.BOOK_SEARCH);//ͼ�������Ӱ�ť
		ImageIcon BookSearchicon=new ImageIcon(Library.class.getResource("/bookBorrowtb.jpg"));//��Ӳ˵���ͼ��	
		BookSearchButton.setIcon(BookSearchicon);//���ð�ťͼ��
		BookSearchButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(BookSearchButton);//��ӵ���������
		
		JButton ExitButton=new JButton(MenuActions.EXIT);//�˳�ϵͳ��ť
		ImageIcon Exiticon=CreatecdIcon.add("exittb.jpg");//����ͼ�귽��
		ExitButton.setIcon(Exiticon);//���ð�ťͼ��
		ExitButton.setHideActionText(true);//��ʾ��ʾ�ı�
		toolBar.add(ExitButton);//��ӵ���������
		return toolBar;
	}
	/**
	 * �����˵���
	 */
	private JMenuBar createMenu() { // �����˵����ķ���
		JMenuBar menuBar = new JMenuBar();//����������
		JMenu baseMenu = new JMenu();// ��ʼ����������ά���˵�
		baseMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg"));//���ò˵�ͼ��
		
		JMenu newBookMenu = new JMenu();// ��ʼ���鶩���˵�
		newBookMenu.setIcon(CreatecdIcon.add("xsdgcd.jpg"));//���ò˵�ͼ��
		
		JMenu borrowMenu=new JMenu();
		borrowMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));
		
		JMenu userMenu=new JMenu();
		userMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));
		
		JMenu readerManagerMItem = new JMenu("������Ϣ����");//����������Ϣ�����Ӳ˵�
		JMenu bookTypeManageMItem = new JMenu("ͼ��������");//����ͼ���������Ӳ˵�
		
		bookTypeManageMItem.add(MenuActions.BOOKTYPE_ADD);
		bookTypeManageMItem.add(MenuActions.BOOKTYPE_MODIFY);
		
		readerManagerMItem.add(MenuActions.READER_ADD);
		readerManagerMItem.add(MenuActions.READER_MODIFY);
		
		JMenu newBookManagerMItem=new JMenu("���鶩������");
		newBookManagerMItem.add(MenuActions.NEWBOOK_ORDER);
		newBookManagerMItem.add(MenuActions.NEWBOOK_CHECK);
		
		JMenu menu = new JMenu("ͼ����Ϣ����");//����ͼ����Ϣ�����Ӳ˵�
		menu.add(MenuActions.BOOK_ADD);//���ͼ����Ϣ��Ӳ˵���
		menu.add(MenuActions.BOOK_MODIFY);//���ͼ����Ϣ�޸Ĳ˵���
		baseMenu.add(readerManagerMItem);//��Ӷ�����Ϣ�����Ӳ˵�
		baseMenu.add(bookTypeManageMItem);//���ͼ���������Ӳ˵�
		baseMenu.add(menu);				//���ͼ����Ϣ�����Ӳ˵�
		baseMenu.addSeparator();		//��ӷָ���
		baseMenu.add(MenuActions.EXIT);//����˳�ϵͳ�˵���
		menuBar.add(baseMenu); // ��ӻ�������ά���˵����˵���
		
		newBookMenu.add(newBookManagerMItem);
		newBookMenu.addSeparator();		//��ӷָ���
		newBookMenu.add(MenuActions.EXIT);//����˳�ϵͳ�˵���
		menuBar.add(newBookMenu); // ��ӻ�������ά���˵����˵���
		
		JMenu borrow=new JMenu("����ͼ��");
		borrow.add(MenuActions.BOOK_BORROW);
		borrow.add(MenuActions.BOOK_SEARCH);
		borrow.add(MenuActions.BOOK_BACK);
		borrowMenu.add(borrow);
		borrowMenu.addSeparator();
		borrowMenu.add(MenuActions.EXIT);
		menuBar.add(borrowMenu);
		
		JMenu updateMItem=new JMenu("���Ŀ���");
		updateMItem.add(MenuActions.PW_MODIFY);
		
		JMenu userMItem = new JMenu("�û�����");
		userMItem.add(MenuActions.USER_ADD);
		userMItem.add(MenuActions.USER_MODIFY);
		userMenu.add(updateMItem);
		userMenu.add(userMItem);
		userMenu.addSeparator();
		userMenu.add(MenuActions.EXIT);
		menuBar.add(userMenu);
		
		return menuBar;
	}
}
