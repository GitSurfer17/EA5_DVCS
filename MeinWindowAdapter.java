
 import java.awt.event.*;

 /**EA3
  *
  * MeinWindowAdapter.java
  * Datum: 16.11.2017
  *
  * @author Dietmar Trautmann dietmar.trautmann@web.de
  *
  * @version 1.0  16.11.2017 Version1
  *
  * Adapterklasse (beerbt WindowAdapter) für die Klasse HinzKunz
  */
 class MeinWindowAdapter extends WindowAdapter{
    public void windowClosing(WindowEvent e) {
    System.exit(0);
    }
 }//class