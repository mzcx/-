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
 * 主窗体
 * 
 */
public class Library extends JFrame {
	private static final JDesktopPane 
				DESKTOP_PANE = new JDesktopPane();//桌面窗体
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager
				.getSystemLookAndFeelClassName());//设置系统界面外观
			new BookLoginIFrame();//登录窗口
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void addIFame(JInternalFrame iframe) { // 添加子窗体的方法
		DESKTOP_PANE.add(iframe);	//新增子窗体
	}
	public Library() {
		super();
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);////设置关闭按钮处理事件
		Toolkit tool = Toolkit.getDefaultToolkit();				//获得默认的工具箱
		Dimension screenSize = tool.getScreenSize();			//获得屏幕的大小
		setSize(800, 600);										//设置窗体大小
		setLocation((screenSize.width - getWidth()) / 2,
				(screenSize.height - getHeight()) / 2);			//设置窗体位置
		setTitle("图书馆管理系统");								//设置窗体标题
		JMenuBar menuBar = createMenu(); 	//调用创建菜单栏的方法
		setJMenuBar(menuBar);				//设置菜单栏
		JToolBar toolBar = createToolBar(); // 调用创建工具栏的方法
		getContentPane().add(toolBar, BorderLayout.NORTH);//设置工具栏
		final JLabel label = new JLabel();	//创建一个标签，用来显示图片
		label.setBounds(0, 0, 0, 0);		//设置窗体的大小和位置
		label.setIcon(null); // 窗体背景
		DESKTOP_PANE.addComponentListener(new ComponentAdapter() {
			public void componentResized(final ComponentEvent e) {
				Dimension size = e.getComponent().getSize();//获得组件大小
				label.setSize(e.getComponent().getSize());//设置标签大小
				label.setText("<html><img width=" + size.width + " height="
						+ size.height + " src='"
						+ this.getClass().getResource("/backImg.jpg")
						+ "'></html>");//设置标签文本
			}
		});
		DESKTOP_PANE.add(label,new Integer(Integer.MIN_VALUE));//将标签添加到桌面窗体
		getContentPane().add(DESKTOP_PANE);//将桌面窗体添加到主窗体中
	}
	/**
	 * 创建工具栏
	 * 
	 * @return JToolBar
	 */
	private JToolBar createToolBar() { // 创建工具栏的方法
		JToolBar toolBar = new JToolBar();		//初始化工具栏
		toolBar.setFloatable(false);			//设置是否可以移动工具栏
		toolBar.setBorder(new BevelBorder(BevelBorder.RAISED));//设置边框
		
		JButton bookAddButton=new JButton(MenuActions.BOOK_ADD);//图书信息添加按钮
		ImageIcon icon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//添加菜单栏图标	
		bookAddButton.setIcon(icon);//设置按钮图标
		bookAddButton.setHideActionText(true);//显示提示文本
		toolBar.add(bookAddButton);//添加到工具栏中
		
		JButton bookModiAndDelButton=new JButton(MenuActions.BOOK_MODIFY);//图书信息修改按钮
		ImageIcon bookmodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//创建图标方法
		bookModiAndDelButton.setIcon(bookmodiicon);//设置按钮图标
		bookModiAndDelButton.setHideActionText(true);//显示提示文本
		toolBar.add(bookModiAndDelButton);//添加到工具栏中
		
		JButton booktypeAddButton=new JButton(MenuActions.BOOKTYPE_ADD);//图书类别信息添加按钮
		ImageIcon icon1=new ImageIcon(Library.class.getResource("/bookTypeAddtb.jpg"));//添加菜单栏图标	
		booktypeAddButton.setIcon(icon1);//设置按钮图标
		booktypeAddButton.setHideActionText(true);//显示提示文本
		toolBar.add(booktypeAddButton);//添加到工具栏中
		
		JButton booktypeModiAndDelButton=new JButton(MenuActions.BOOKTYPE_MODIFY);//图书类别信息修改按钮
		ImageIcon bookmodiicon1=CreatecdIcon.add("bookTypeAddtb.jpg");//创建图标方法
		booktypeModiAndDelButton.setIcon(bookmodiicon1);//设置按钮图标
		booktypeModiAndDelButton.setHideActionText(true);//显示提示文本
		toolBar.add(booktypeModiAndDelButton);//添加到工具栏中
		
		JButton readerAddButton=new JButton(MenuActions.READER_ADD);//读者信息添加按钮
		ImageIcon icon2=new ImageIcon(Library.class.getResource("/readerAddtb.jpg"));//添加菜单栏图标	
		readerAddButton.setIcon(icon2);//设置按钮图标
		readerAddButton.setHideActionText(true);//显示提示文本
		toolBar.add(readerAddButton);//添加到工具栏中
		
		JButton readerModiAndDelButton=new JButton(MenuActions.READER_MODIFY);//读者信息修改按钮
		ImageIcon readermodiicon1=CreatecdIcon.add("readerModiAndDeltb.jpg");//创建图标方法
		readerModiAndDelButton.setIcon(readermodiicon1);//设置按钮图标
		readerModiAndDelButton.setHideActionText(true);//显示提示文本
		toolBar.add(readerModiAndDelButton);//添加到工具栏中
		
		JButton userAddButton=new JButton(MenuActions.USER_ADD);//用户添加按钮
		ImageIcon icon3=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//添加菜单栏图标	
		userAddButton.setIcon(icon3);//设置按钮图标
		userAddButton.setHideActionText(true);//显示提示文本
		toolBar.add(userAddButton);//添加到工具栏中
		
		JButton userModiAndDelButton=new JButton(MenuActions.USER_MODIFY);//用户修改按钮
		ImageIcon usermodiicon=CreatecdIcon.add("bookModiAndDeltb.jpg");//创建图标方法
		userModiAndDelButton.setIcon(usermodiicon);//设置按钮图标
		userModiAndDelButton.setHideActionText(true);//显示提示文本
		toolBar.add(userModiAndDelButton);//添加到工具栏中
		
		JButton GengGaiMiMaButton=new JButton(MenuActions.PW_MODIFY);//用户添加按钮
		ImageIcon GengGaiMiMaicon=new ImageIcon(Library.class.getResource("/bookAddtb.jpg"));//添加菜单栏图标	
		GengGaiMiMaButton.setIcon(GengGaiMiMaicon);//设置按钮图标
		GengGaiMiMaButton.setHideActionText(true);//显示提示文本
		toolBar.add(GengGaiMiMaButton);//添加到工具栏中
		
		JButton newBookCheckButton=new JButton(MenuActions.NEWBOOK_CHECK);//新书验收按钮
		ImageIcon newBookCheckicon=new ImageIcon(Library.class.getResource("/newbookChecktb.jpg"));//添加菜单栏图标	
		newBookCheckButton.setIcon(newBookCheckicon);//设置按钮图标
		newBookCheckButton.setHideActionText(true);//显示提示文本
		toolBar.add(newBookCheckButton);//添加到工具栏中
		
		JButton newBookOrderButton=new JButton(MenuActions.NEWBOOK_ORDER);//新书订购加按钮
		ImageIcon newBookOrdericon=new ImageIcon(Library.class.getResource("/bookOrdertb.jpg"));//添加菜单栏图标	
		newBookOrderButton.setIcon(newBookOrdericon);//设置按钮图标
		newBookOrderButton.setHideActionText(true);//显示提示文本
		toolBar.add(newBookOrderButton);//添加到工具栏中
		
		JButton BookBackButton=new JButton(MenuActions.BOOK_BACK);//图书归还加按钮
		ImageIcon BookBackicon=new ImageIcon(Library.class.getResource("/bookOrdertb.jpg"));//添加菜单栏图标	
		BookBackButton.setIcon(BookBackicon);//设置按钮图标
		BookBackButton.setHideActionText(true);//显示提示文本
		toolBar.add(BookBackButton);//添加到工具栏中
		
		JButton BookBorrowButton=new JButton(MenuActions.BOOK_BORROW);//图书借阅加按钮
		ImageIcon BookBorrowicon=new ImageIcon(Library.class.getResource("/bookBorrowtb.jpg"));//添加菜单栏图标	
		BookBorrowButton.setIcon(BookBorrowicon);//设置按钮图标
		BookBorrowButton.setHideActionText(true);//显示提示文本
		toolBar.add(BookBorrowButton);//添加到工具栏中
		
		JButton BookSearchButton=new JButton(MenuActions.BOOK_SEARCH);//图书搜索加按钮
		ImageIcon BookSearchicon=new ImageIcon(Library.class.getResource("/bookBorrowtb.jpg"));//添加菜单栏图标	
		BookSearchButton.setIcon(BookSearchicon);//设置按钮图标
		BookSearchButton.setHideActionText(true);//显示提示文本
		toolBar.add(BookSearchButton);//添加到工具栏中
		
		JButton ExitButton=new JButton(MenuActions.EXIT);//退出系统按钮
		ImageIcon Exiticon=CreatecdIcon.add("exittb.jpg");//创建图标方法
		ExitButton.setIcon(Exiticon);//设置按钮图标
		ExitButton.setHideActionText(true);//显示提示文本
		toolBar.add(ExitButton);//添加到工具栏中
		return toolBar;
	}
	/**
	 * 创建菜单栏
	 */
	private JMenuBar createMenu() { // 创建菜单栏的方法
		JMenuBar menuBar = new JMenuBar();//创建工具栏
		JMenu baseMenu = new JMenu();// 初始化基础数据维护菜单
		baseMenu.setIcon(CreatecdIcon.add("jcsjcd.jpg"));//设置菜单图标
		
		JMenu newBookMenu = new JMenu();// 初始新书订购菜单
		newBookMenu.setIcon(CreatecdIcon.add("xsdgcd.jpg"));//设置菜单图标
		
		JMenu borrowMenu=new JMenu();
		borrowMenu.setIcon(CreatecdIcon.add("jyglcd.jpg"));
		
		JMenu userMenu=new JMenu();
		userMenu.setIcon(CreatecdIcon.add("jcwhcd.jpg"));
		
		JMenu readerManagerMItem = new JMenu("读者信息管理");//新增读者信息管理子菜单
		JMenu bookTypeManageMItem = new JMenu("图书类别管理");//新增图书类别管理子菜单
		
		bookTypeManageMItem.add(MenuActions.BOOKTYPE_ADD);
		bookTypeManageMItem.add(MenuActions.BOOKTYPE_MODIFY);
		
		readerManagerMItem.add(MenuActions.READER_ADD);
		readerManagerMItem.add(MenuActions.READER_MODIFY);
		
		JMenu newBookManagerMItem=new JMenu("新书订购管理");
		newBookManagerMItem.add(MenuActions.NEWBOOK_ORDER);
		newBookManagerMItem.add(MenuActions.NEWBOOK_CHECK);
		
		JMenu menu = new JMenu("图书信息管理");//新增图书信息管理子菜单
		menu.add(MenuActions.BOOK_ADD);//添加图书信息添加菜单项
		menu.add(MenuActions.BOOK_MODIFY);//添加图书信息修改菜单项
		baseMenu.add(readerManagerMItem);//添加读者信息管理子菜单
		baseMenu.add(bookTypeManageMItem);//添加图书类别管理子菜单
		baseMenu.add(menu);				//添加图书信息管理子菜单
		baseMenu.addSeparator();		//添加分隔线
		baseMenu.add(MenuActions.EXIT);//添加退出系统菜单项
		menuBar.add(baseMenu); // 添加基础数据维护菜单到菜单栏
		
		newBookMenu.add(newBookManagerMItem);
		newBookMenu.addSeparator();		//添加分隔线
		newBookMenu.add(MenuActions.EXIT);//添加退出系统菜单项
		menuBar.add(newBookMenu); // 添加基础数据维护菜单到菜单栏
		
		JMenu borrow=new JMenu("借阅图书");
		borrow.add(MenuActions.BOOK_BORROW);
		borrow.add(MenuActions.BOOK_SEARCH);
		borrow.add(MenuActions.BOOK_BACK);
		borrowMenu.add(borrow);
		borrowMenu.addSeparator();
		borrowMenu.add(MenuActions.EXIT);
		menuBar.add(borrowMenu);
		
		JMenu updateMItem=new JMenu("更改口令");
		updateMItem.add(MenuActions.PW_MODIFY);
		
		JMenu userMItem = new JMenu("用户管理");
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
