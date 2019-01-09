package StrategyDesignPattern;

import java.awt.Point;

public interface SearchStrategy {
	public void search(String[][] ar);
	public void getCarrier(String[][] ar);
	public void getSubmarine(String[][] ar);
	public void getCells();
	public void getStrategyName();
}
