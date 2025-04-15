/***********************************************************************
 * Module:  ContextMenu.java
 * Author:  maril
 * Purpose: Defines the Class ContextMenu
 ***********************************************************************/

package view;

import javax.swing.JPopupMenu;

public class ContextMenu {
   protected JPopupMenu contextMenu = null;
   
   public ContextMenu() {
      contextMenu = new JPopupMenu();
   }
   
   public JPopupMenu getContextMenu() {
      return contextMenu;
   }
   
   /** @param newContextMenu */
   public void setContextMenu(JPopupMenu newContextMenu) {
      contextMenu = newContextMenu;
   }

}