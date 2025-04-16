package jp.co.comster.observer.generator;

import java.util.ArrayList;
import java.util.List;

import jp.co.comster.observer.observers.Observer;

/**
 * Subject
 */
public abstract class NumberGenerator {
	/** 保持しているObserverたち */
	private List<Observer> observers = new ArrayList<>();
	
	/**
	 * Observerを追加する
	 * 
	 * @param observer 追加するObserver
	 */
	public void addObserver(Observer observer) {
		observers.add(observer);
	}
	
	/**
	 * Observerを削除する
	 * 
	 * @param observer 削除するObserver
	 */
	public void deleteObserver(Observer observer) {
		observers.remove(observer);
	}
	
	/**
	 * Observerたちへ通知する
	 */
	public void notifyObservers() {
		for (Observer o: observers) {
			o.update(this);
		}
	}
	
	public abstract int getNumber();
	
	/**
	 *  数を生成する
	 */
	public abstract void execute();
}
