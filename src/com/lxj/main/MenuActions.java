package com.lxj.main;

import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JInternalFrame;
import com.lxj.iframe.BookAddIFrame;
import com.lxj.iframe.BookBackIFrame;
import com.lxj.iframe.BookBorrowIFrame;
import com.lxj.iframe.BookModiAndDelIFrame;
import com.lxj.iframe.BookSearchIFrame;
import com.lxj.iframe.BookTypeAddIFrame;
import com.lxj.iframe.BookTypeModiAndDelIFrame;
import com.lxj.iframe.GengGaiMiMa;
import com.lxj.iframe.ReaderAddIFrame;
import com.lxj.iframe.ReaderModiAndDelIFrame;
import com.lxj.iframe.UserAddIFrame;
import com.lxj.iframe.UserModiAndDelIFrame;
import com.lxj.iframe.newBookCheckIFrame;
import com.lxj.iframe.newBookOrderIFrame;

/**
 * 菜单和按钮的Action对象
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // 子窗体集合
	public static BookModiAction BOOK_MODIFY; // 图书信息修改窗体动作
	public static BookAddAction BOOK_ADD; // 图书信息添加窗体动作
	public static BookTypeModiAction BOOKTYPE_MODIFY; // 图书类别修改窗体动作
	public static BookTypeAddAction BOOKTYPE_ADD; // 图书类别添加窗体动作
	public static ReaderModiAction READER_MODIFY; // 读者信息修改窗体动作
	public static ReaderAddAction READER_ADD; // 读者信息添加窗体动作
	public static UserModiAction USER_MODIFY; // 用户信息修改窗体动作
	public static UserAddAction USER_ADD; // 读者信息添加窗体动作
	public static GengGaiMiMaAction PW_MODIFY; // 用户信息修改窗体动作
	public static newBookCheckAction NEWBOOK_CHECK; // 新书验收窗体动作
	public static newBookOrderAction NEWBOOK_ORDER; // 新书订购窗体动作
	public static BookBorrowAction BOOK_BORROW; // 图书借阅窗体动作
	public static BookBackAction BOOK_BACK; // 图书归还窗体动作
	public static BookSearchAction BOOK_SEARCH; // 图书搜索窗体动作
	public static ExitAction EXIT; // 系统退出动作

	static {
		frames = new HashMap<String, JInternalFrame>();
		BOOK_MODIFY = new BookModiAction();
		BOOK_ADD = new BookAddAction();
		READER_ADD=new ReaderAddAction();
		READER_MODIFY=new ReaderModiAction();
		BOOKTYPE_ADD=new BookTypeAddAction();
		BOOKTYPE_MODIFY=new BookTypeModiAction();
		USER_ADD=new UserAddAction();
		USER_MODIFY=new UserModiAction();
		NEWBOOK_ORDER=new newBookOrderAction();
		NEWBOOK_CHECK=new newBookCheckAction();
		BOOK_BORROW=new BookBorrowAction();
		BOOK_SEARCH=new BookSearchAction();
		BOOK_BACK=new BookBackAction();
		PW_MODIFY=new GengGaiMiMaAction();
		EXIT = new ExitAction();
	}
	//图书修改与删除
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("图书修改", null);
			putValue(Action.LONG_DESCRIPTION, "修改和删除图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书修改");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书修改")||frames.get("图书修改").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("图书修改", iframe);
				Library.addIFame(frames.get("图书修改"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// 图书信息添加－－－已经实现，请参照
		BookAddAction() {

			super("图书信息添加", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书信息");
			putValue(Action.SHORT_DESCRIPTION, "图书信息添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书信息添加")||frames.get("图书信息添加").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("图书信息添加", iframe);
				Library.addIFame(frames.get("图书信息添加"));
			}
		}
	}
	//退出系统
	private static class ExitAction extends AbstractAction { // 退出系统动作
		public ExitAction() {
			super("退出系统", null);
			putValue(Action.LONG_DESCRIPTION, "退出图书馆管理系统");
			putValue(Action.SHORT_DESCRIPTION, "退出系统");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}
	//图书类别添加
	private static class BookTypeAddAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
		BookTypeAddAction() {

			super("图书类别添加", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的图书类别");
			putValue(Action.SHORT_DESCRIPTION, "图书类别添加");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("图书类别添加")||frames.get("图书类别添加").isClosed()) {
				BookTypeAddIFrame iframe = new BookTypeAddIFrame();
				frames.put("图书类别添加", iframe);
				Library.addIFame(frames.get("图书类别添加"));
			}
		}
	}
	//图书类别修改与删除
		private static class BookTypeModiAction extends AbstractAction {
			BookTypeModiAction() {
				super("图书类别修改", null);
				putValue(Action.LONG_DESCRIPTION, "修改和删除图书类别");
				putValue(Action.SHORT_DESCRIPTION, "图书类别修改");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("图书类别修改")||frames.get("图书类别修改").isClosed()) {
					BookTypeModiAndDelIFrame iframe=new BookTypeModiAndDelIFrame();
					frames.put("图书类别修改", iframe);
					Library.addIFame(frames.get("图书类别修改"));
				}
			}
		}
		private static class ReaderAddAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
			ReaderAddAction() {

				super("读者信息添加", null);
				//super();
				putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的读者信息");
				putValue(Action.SHORT_DESCRIPTION, "读者信息添加");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("读者信息添加")||frames.get("读者信息添加").isClosed()) {
					ReaderAddIFrame iframe = new ReaderAddIFrame();
					frames.put("读者信息添加", iframe);
					Library.addIFame(frames.get("读者信息添加"));
				}
			}
		}
		//读者修改与删除
			private static class ReaderModiAction extends AbstractAction {
				ReaderModiAction() {
					super("读者信息修改", null);
					putValue(Action.LONG_DESCRIPTION, "修改和删除读者信息");
					putValue(Action.SHORT_DESCRIPTION, "读者信息修改");
				}
				public void actionPerformed(ActionEvent e) {
					if (!frames.containsKey("读者信息修改")||frames.get("读者信息修改").isClosed()) {
						ReaderModiAndDelIFrame iframe=new ReaderModiAndDelIFrame();
						frames.put("读者信息修改", iframe);
						Library.addIFame(frames.get("读者信息修改"));
					}
				}
			}
			//用户信息添加
			private static class UserAddAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
				UserAddAction() {

					super("用户信息添加", null);
					//super();
					putValue(Action.LONG_DESCRIPTION, "为图书馆添加新的用户信息");
					putValue(Action.SHORT_DESCRIPTION, "用户信息添加");
				}
				public void actionPerformed(ActionEvent e) {
					if (!frames.containsKey("用户添加")||frames.get("用户添加").isClosed()) {
						UserAddIFrame iframe = new UserAddIFrame();
						frames.put("用户添加", iframe);
						Library.addIFame(frames.get("用户添加"));
					}
				}
			}
			//用户修改与删除
				private static class UserModiAction extends AbstractAction {
					UserModiAction() {
						super("用户修改", null);
						putValue(Action.LONG_DESCRIPTION, "修改和删除用户");
						putValue(Action.SHORT_DESCRIPTION, "用户修改");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("用户修改")||frames.get("用户修改").isClosed()) {
							UserModiAndDelIFrame iframe=new UserModiAndDelIFrame();
							frames.put("图书类别修改", iframe);
							Library.addIFame(frames.get("图书类别修改"));
						}
					}
				}
				//更改密码
				private static class GengGaiMiMaAction extends AbstractAction {
					GengGaiMiMaAction() {
						super("更改口令", null);
						putValue(Action.LONG_DESCRIPTION, "更改口令");
						putValue(Action.SHORT_DESCRIPTION, "更改口令");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("更改口令")||frames.get("更改口令").isClosed()) {
							GengGaiMiMa iframe=new GengGaiMiMa();
							frames.put("更改口令", iframe);
							Library.addIFame(frames.get("更改口令"));
						}
					}
				}
				//新书验收
				private static class newBookCheckAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
					newBookCheckAction() {

						super("新书验收", null);
						//super();
						putValue(Action.LONG_DESCRIPTION, "为图书馆添加新书验收");
						putValue(Action.SHORT_DESCRIPTION, "新书验收");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("新书验收")||frames.get("新书验收").isClosed()) {
							newBookCheckIFrame iframe = new newBookCheckIFrame();
							frames.put("新书验收", iframe);
							Library.addIFame(frames.get("新书验收"));
						}
					}
				}
				//新书订购
					private static class newBookOrderAction extends AbstractAction {
						newBookOrderAction() {
							super("新书订购", null);
							putValue(Action.LONG_DESCRIPTION, "新书订购");
							putValue(Action.SHORT_DESCRIPTION, "新书订购");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("新书订购")||frames.get("新书订购").isClosed()) {
								newBookOrderIFrame iframe=new newBookOrderIFrame();
								frames.put("新书订购", iframe);
								Library.addIFame(frames.get("新书订购"));
							}
						}
					}
					//图书借阅
					private static class BookBorrowAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
						BookBorrowAction() {

							super("图书借阅", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "图书借阅");
							putValue(Action.SHORT_DESCRIPTION, "图书借阅");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("图书借阅")||frames.get("图书借阅").isClosed()) {
								BookBorrowIFrame iframe = new BookBorrowIFrame();
								frames.put("图书借阅", iframe);
								Library.addIFame(frames.get("图书借阅"));
							}
						}
					}
					//图书归还
					private static class BookBackAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
						BookBackAction() {

							super("图书归还", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "图书归还");
							putValue(Action.SHORT_DESCRIPTION, "图书归还");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("图书归还")||frames.get("图书归还").isClosed()) {
								BookBackIFrame iframe = new BookBackIFrame();
								frames.put("图书归还", iframe);
								Library.addIFame(frames.get("图书归还"));
							}
						}
					}
					//图书搜索
					private static class BookSearchAction extends AbstractAction {				// 图书类别添加－－－已经实现，请参照
						BookSearchAction() {

							super("图书搜索", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "图书搜索");
							putValue(Action.SHORT_DESCRIPTION, "图书搜索");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("图书搜索")||frames.get("图书搜索").isClosed()) {
								BookSearchIFrame iframe = new BookSearchIFrame();
								frames.put("图书搜索", iframe);
								Library.addIFame(frames.get("图书搜索"));
							}
						}
					}

}
