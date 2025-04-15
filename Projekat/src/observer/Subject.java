/***********************************************************************
 * Module:  Subject.java
 * Author:  maril
 * Purpose: Defines the Interface Subject
 ***********************************************************************/

package observer;

public interface Subject {
	public void addObserver(Observer observer);
	public void removeObserver(Observer observer);
	public void notifyObervers();
}