package jp.co.comster.mediator.framework;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import jp.co.comster.mediator.colleague.ColleagueButton;
import jp.co.comster.mediator.colleague.ColleagueCheckbox;
import jp.co.comster.mediator.colleague.ColleagueTextField;

/**
 * ConcreteMediator<br>
 * Mediatorインターフェース・ActionListenerインターフェースを実装し、
 * Frameクラスを継承している
 */
public class LoginFrame extends Frame implements ActionListener, Mediator {
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	/**
	 * Colleagueたちを生成し、配置後に表示する
	 * 
	 * @param title タイトル
	 */
	public LoginFrame(String title) {
		super(title);
		
		// 背景色を設定する
		setBackground(Color.lightGray);
		
		// レイアウトマネージャを使って4×2のグリッドを作る
		setLayout(new GridLayout(4, 2));
		
		// Colleagueたちを生成する
		createColleagues();
		
		// 配置する
		add(checkGuest);
		add(checkLogin);
		add(new Label("Username:"));
		add(textUser);
		add(new Label("Password:"));
		add(textPass);
		add(buttonOk);
		add(buttonCancel);
		
		// 有効/無効の初期指定をする
		colleagueChanged();
		
		// 表示する
		pack();
		setVisible(true);
	}
	
	@Override
	public void createColleagues() {
		// CheckBox
		CheckboxGroup g = new CheckboxGroup();
		checkGuest = new ColleagueCheckbox("Guest", g, true);
		checkLogin = new ColleagueCheckbox("Login", g, false);
		
		// TextField
		textUser = new ColleagueTextField("", 10);
		textPass = new ColleagueTextField("", 10);
		textPass.setEchoChar('*');
		
		// Button
		buttonOk = new ColleagueButton("OK");
		buttonCancel = new ColleagueButton("Cancel");
		
		// Mediatorを設定する
		checkGuest.setMediator(this);
		checkLogin.setMediator(this);
		textUser.setMediator(this);
		textPass.setMediator(this);
		buttonOk.setMediator(this);
		buttonCancel.setMediator(this);
		
		// Listenerのセット
		checkGuest.addItemListener(checkGuest);
		checkLogin.addItemListener(checkLogin);
		textUser.addTextListener(textUser);
		textPass.addTextListener(textPass);
		buttonOk.addActionListener(this);
		buttonCancel.addActionListener(this);
	}
	
	@Override
	public void colleagueChanged() {
		if (checkGuest.getState()) {
			// ゲストログイン
			textUser.setColleagueEnabled(false);
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(true);
		} else {
			// ユーザログイン
			textUser.setColleagueEnabled(true);
			userpassChanged();
		}
	}
	
	/**
	 * textUserまたはtextPassの変更があったときに呼び出される<br>
	 * 各Colleageの有効/無効を判定する
	 */
	private void userpassChanged() {
		if (textUser.getText().length() > 0) {
			textPass.setColleagueEnabled(true);
			if (textUser.getText().length() >= 4 && textPass.getText().length() >= 4) {
				buttonOk.setColleagueEnabled(true);
			} else {
				buttonOk.setColleagueEnabled(false);
			}
		} else {
			textPass.setColleagueEnabled(false);
			buttonOk.setColleagueEnabled(false);
		}
	}
	
	/**
	 * イベントが発生したときに呼び出される<br>
	 * イベント内容を表示して終了する
	 * 
	 * @param e イベント
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		this.dispose();
	}
}
