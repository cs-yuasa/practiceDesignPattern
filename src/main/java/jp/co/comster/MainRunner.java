package jp.co.comster;

import org.tinylog.Logger;

import jp.co.comster.abstractfactory.AbstractFactoryMain;
import jp.co.comster.adapter.AdapterMain;
import jp.co.comster.bridge.BridgeMain;
import jp.co.comster.builder.BuilderMain;
import jp.co.comster.chainofresponsibility.ChainOfResponsibilityMain;
import jp.co.comster.composite.CompositeMain;
import jp.co.comster.decorator.DecoratorMain;
import jp.co.comster.facade.FacadeMain;
import jp.co.comster.factorymethod.FactoryMethodMain;
import jp.co.comster.flyweight.FlyweightMain;
import jp.co.comster.iterator.IteratorMain;
import jp.co.comster.mediator.MediatorMain;
import jp.co.comster.memento.MementoMain;
import jp.co.comster.observer.ObserverMain;
import jp.co.comster.prototype.PrototypeMain;
import jp.co.comster.singleton.SingletonMain;
import jp.co.comster.state.StateMain;
import jp.co.comster.strategy.StrategyMain;
import jp.co.comster.templatemethod.TemplateMethodMain;
import jp.co.comster.visitor.VisitorMain;

/**
 * 複数のMainクラスを実行する際に使用するクラス
 */
public class MainRunner {
	public static void main(String[] args) {
		Logger.info("======Iteratorパターン=====");
		IteratorMain.main(args);
		Logger.info("======Adapterパターン=====");
		AdapterMain.main(args);
		Logger.info("======TemplateMethodパターン=====");
		TemplateMethodMain.main(args);
		Logger.info("======FactoryMethodパターン=====");
		FactoryMethodMain.main(args);
		Logger.info("======Singletonパターン=====");
		SingletonMain.main(args);
		Logger.info("======Prototypeパターン=====");
		PrototypeMain.main(args);
		Logger.info("=====Builderパターン(text)=====");
		BuilderMain.main(new String[] {"text"});
		Logger.info("=====Builderパターン(html)=====");
		BuilderMain.main(new String[] {"html"});
		Logger.info("=====Builderパターン(markdown)=====");
		BuilderMain.main(new String[] {"markdown"});
		Logger.info("=====AbstractFactoryパターン(list)=====");
		AbstractFactoryMain.main(new String[] {"list.html", "jp.co.comster.abstractfactory.listfactory.ListFactory"});
		Logger.info("=====AbstractFactoryパターン(div)=====");
		AbstractFactoryMain.main(new String[] {"div.html", "jp.co.comster.abstractfactory.divfactory.DivFactory"});
		Logger.info("=====Bridgeパターン=====");
		BridgeMain.main(args);
		Logger.info("=====Strategyパターン=====");
		StrategyMain.main(new String[] {"314", "15"});
		Logger.info("=====Compositeパターン=====");
		CompositeMain.main(args);
		Logger.info("=====Decoratorパターン=====");
		DecoratorMain.main(args);
		Logger.info("=====Visitorパターン=====");
		VisitorMain.main(args);
		Logger.info("=====ChainOfResponsibilityパターン=====");
		ChainOfResponsibilityMain.main(args);
		Logger.info("=====Facadeパターン=====");
		FacadeMain.main(args);
		Logger.info("=====Mediatorパターン=====");
		MediatorMain.main(args);
		Logger.info("=====Observerパターン=====");
		ObserverMain.main(args);
		Logger.info("=====Mementoパターン=====");
		MementoMain.main(args);
		Logger.info("=====Stateパターン=====");
		StateMain.main(args);
		Logger.info("=====Flyweightパターン=====");
		FlyweightMain.main(new String[] {"1212123"});
		
	}
}
