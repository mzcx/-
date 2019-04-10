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
 * �˵��Ͱ�ť��Action����
 * 
 */
public class MenuActions {
	private static Map<String, JInternalFrame> frames; // �Ӵ��弯��
	public static BookModiAction BOOK_MODIFY; // ͼ����Ϣ�޸Ĵ��嶯��
	public static BookAddAction BOOK_ADD; // ͼ����Ϣ��Ӵ��嶯��
	public static BookTypeModiAction BOOKTYPE_MODIFY; // ͼ������޸Ĵ��嶯��
	public static BookTypeAddAction BOOKTYPE_ADD; // ͼ�������Ӵ��嶯��
	public static ReaderModiAction READER_MODIFY; // ������Ϣ�޸Ĵ��嶯��
	public static ReaderAddAction READER_ADD; // ������Ϣ��Ӵ��嶯��
	public static UserModiAction USER_MODIFY; // �û���Ϣ�޸Ĵ��嶯��
	public static UserAddAction USER_ADD; // ������Ϣ��Ӵ��嶯��
	public static GengGaiMiMaAction PW_MODIFY; // �û���Ϣ�޸Ĵ��嶯��
	public static newBookCheckAction NEWBOOK_CHECK; // �������մ��嶯��
	public static newBookOrderAction NEWBOOK_ORDER; // ���鶩�����嶯��
	public static BookBorrowAction BOOK_BORROW; // ͼ����Ĵ��嶯��
	public static BookBackAction BOOK_BACK; // ͼ��黹���嶯��
	public static BookSearchAction BOOK_SEARCH; // ͼ���������嶯��
	public static ExitAction EXIT; // ϵͳ�˳�����

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
	//ͼ���޸���ɾ��
	private static class BookModiAction extends AbstractAction {
		BookModiAction() {
			super("ͼ���޸�", null);
			putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ���޸�");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ���޸�")||frames.get("ͼ���޸�").isClosed()) {
				BookModiAndDelIFrame iframe=new BookModiAndDelIFrame();
				frames.put("ͼ���޸�", iframe);
				Library.addIFame(frames.get("ͼ���޸�"));
			}
		}
	}
	private static class BookAddAction extends AbstractAction {				// ͼ����Ϣ��ӣ������Ѿ�ʵ�֣������
		BookAddAction() {

			super("ͼ����Ϣ���", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ����Ϣ");
			putValue(Action.SHORT_DESCRIPTION, "ͼ����Ϣ���");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ����Ϣ���")||frames.get("ͼ����Ϣ���").isClosed()) {
				BookAddIFrame iframe = new BookAddIFrame();
				frames.put("ͼ����Ϣ���", iframe);
				Library.addIFame(frames.get("ͼ����Ϣ���"));
			}
		}
	}
	//�˳�ϵͳ
	private static class ExitAction extends AbstractAction { // �˳�ϵͳ����
		public ExitAction() {
			super("�˳�ϵͳ", null);
			putValue(Action.LONG_DESCRIPTION, "�˳�ͼ��ݹ���ϵͳ");
			putValue(Action.SHORT_DESCRIPTION, "�˳�ϵͳ");
		}
		public void actionPerformed(final ActionEvent e) {
			System.exit(0);
		}
	}

	private MenuActions() {
		super();
	}
	//ͼ��������
	private static class BookTypeAddAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
		BookTypeAddAction() {

			super("ͼ��������", null);
			//super();
			putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ�ͼ�����");
			putValue(Action.SHORT_DESCRIPTION, "ͼ��������");
		}
		public void actionPerformed(ActionEvent e) {
			if (!frames.containsKey("ͼ��������")||frames.get("ͼ��������").isClosed()) {
				BookTypeAddIFrame iframe = new BookTypeAddIFrame();
				frames.put("ͼ��������", iframe);
				Library.addIFame(frames.get("ͼ��������"));
			}
		}
	}
	//ͼ������޸���ɾ��
		private static class BookTypeModiAction extends AbstractAction {
			BookTypeModiAction() {
				super("ͼ������޸�", null);
				putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��ͼ�����");
				putValue(Action.SHORT_DESCRIPTION, "ͼ������޸�");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("ͼ������޸�")||frames.get("ͼ������޸�").isClosed()) {
					BookTypeModiAndDelIFrame iframe=new BookTypeModiAndDelIFrame();
					frames.put("ͼ������޸�", iframe);
					Library.addIFame(frames.get("ͼ������޸�"));
				}
			}
		}
		private static class ReaderAddAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
			ReaderAddAction() {

				super("������Ϣ���", null);
				//super();
				putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µĶ�����Ϣ");
				putValue(Action.SHORT_DESCRIPTION, "������Ϣ���");
			}
			public void actionPerformed(ActionEvent e) {
				if (!frames.containsKey("������Ϣ���")||frames.get("������Ϣ���").isClosed()) {
					ReaderAddIFrame iframe = new ReaderAddIFrame();
					frames.put("������Ϣ���", iframe);
					Library.addIFame(frames.get("������Ϣ���"));
				}
			}
		}
		//�����޸���ɾ��
			private static class ReaderModiAction extends AbstractAction {
				ReaderModiAction() {
					super("������Ϣ�޸�", null);
					putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ��������Ϣ");
					putValue(Action.SHORT_DESCRIPTION, "������Ϣ�޸�");
				}
				public void actionPerformed(ActionEvent e) {
					if (!frames.containsKey("������Ϣ�޸�")||frames.get("������Ϣ�޸�").isClosed()) {
						ReaderModiAndDelIFrame iframe=new ReaderModiAndDelIFrame();
						frames.put("������Ϣ�޸�", iframe);
						Library.addIFame(frames.get("������Ϣ�޸�"));
					}
				}
			}
			//�û���Ϣ���
			private static class UserAddAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
				UserAddAction() {

					super("�û���Ϣ���", null);
					//super();
					putValue(Action.LONG_DESCRIPTION, "Ϊͼ�������µ��û���Ϣ");
					putValue(Action.SHORT_DESCRIPTION, "�û���Ϣ���");
				}
				public void actionPerformed(ActionEvent e) {
					if (!frames.containsKey("�û����")||frames.get("�û����").isClosed()) {
						UserAddIFrame iframe = new UserAddIFrame();
						frames.put("�û����", iframe);
						Library.addIFame(frames.get("�û����"));
					}
				}
			}
			//�û��޸���ɾ��
				private static class UserModiAction extends AbstractAction {
					UserModiAction() {
						super("�û��޸�", null);
						putValue(Action.LONG_DESCRIPTION, "�޸ĺ�ɾ���û�");
						putValue(Action.SHORT_DESCRIPTION, "�û��޸�");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("�û��޸�")||frames.get("�û��޸�").isClosed()) {
							UserModiAndDelIFrame iframe=new UserModiAndDelIFrame();
							frames.put("ͼ������޸�", iframe);
							Library.addIFame(frames.get("ͼ������޸�"));
						}
					}
				}
				//��������
				private static class GengGaiMiMaAction extends AbstractAction {
					GengGaiMiMaAction() {
						super("���Ŀ���", null);
						putValue(Action.LONG_DESCRIPTION, "���Ŀ���");
						putValue(Action.SHORT_DESCRIPTION, "���Ŀ���");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("���Ŀ���")||frames.get("���Ŀ���").isClosed()) {
							GengGaiMiMa iframe=new GengGaiMiMa();
							frames.put("���Ŀ���", iframe);
							Library.addIFame(frames.get("���Ŀ���"));
						}
					}
				}
				//��������
				private static class newBookCheckAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
					newBookCheckAction() {

						super("��������", null);
						//super();
						putValue(Action.LONG_DESCRIPTION, "Ϊͼ��������������");
						putValue(Action.SHORT_DESCRIPTION, "��������");
					}
					public void actionPerformed(ActionEvent e) {
						if (!frames.containsKey("��������")||frames.get("��������").isClosed()) {
							newBookCheckIFrame iframe = new newBookCheckIFrame();
							frames.put("��������", iframe);
							Library.addIFame(frames.get("��������"));
						}
					}
				}
				//���鶩��
					private static class newBookOrderAction extends AbstractAction {
						newBookOrderAction() {
							super("���鶩��", null);
							putValue(Action.LONG_DESCRIPTION, "���鶩��");
							putValue(Action.SHORT_DESCRIPTION, "���鶩��");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("���鶩��")||frames.get("���鶩��").isClosed()) {
								newBookOrderIFrame iframe=new newBookOrderIFrame();
								frames.put("���鶩��", iframe);
								Library.addIFame(frames.get("���鶩��"));
							}
						}
					}
					//ͼ�����
					private static class BookBorrowAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
						BookBorrowAction() {

							super("ͼ�����", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "ͼ�����");
							putValue(Action.SHORT_DESCRIPTION, "ͼ�����");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("ͼ�����")||frames.get("ͼ�����").isClosed()) {
								BookBorrowIFrame iframe = new BookBorrowIFrame();
								frames.put("ͼ�����", iframe);
								Library.addIFame(frames.get("ͼ�����"));
							}
						}
					}
					//ͼ��黹
					private static class BookBackAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
						BookBackAction() {

							super("ͼ��黹", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "ͼ��黹");
							putValue(Action.SHORT_DESCRIPTION, "ͼ��黹");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("ͼ��黹")||frames.get("ͼ��黹").isClosed()) {
								BookBackIFrame iframe = new BookBackIFrame();
								frames.put("ͼ��黹", iframe);
								Library.addIFame(frames.get("ͼ��黹"));
							}
						}
					}
					//ͼ������
					private static class BookSearchAction extends AbstractAction {				// ͼ�������ӣ������Ѿ�ʵ�֣������
						BookSearchAction() {

							super("ͼ������", null);
							//super();
							putValue(Action.LONG_DESCRIPTION, "ͼ������");
							putValue(Action.SHORT_DESCRIPTION, "ͼ������");
						}
						public void actionPerformed(ActionEvent e) {
							if (!frames.containsKey("ͼ������")||frames.get("ͼ������").isClosed()) {
								BookSearchIFrame iframe = new BookSearchIFrame();
								frames.put("ͼ������", iframe);
								Library.addIFame(frames.get("ͼ������"));
							}
						}
					}

}
