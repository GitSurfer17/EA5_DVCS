import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;



  /**
  *
  * HinzKunz.java
  * Datum: 01.12.2017
  *
  * @author Dietmar Trautmann dietmar.trautmann@web.de
  * @version 1.4  16.11.2017 Version3 komplett
  *
  * Klasse HinzKunz stellt 2 Messschieber dar, die mit der Maus eingestellt werden können
  * je nach Wert wird über eine Textausgabe beschrieben welcher Wert grösser ist, Hinz oder Kunz
  */
class HinzKunz extends Frame implements AdjustmentListener{
    //Klassenvariablen
    private Scrollbar scrollbar1 = null;
    private Scrollbar scrollbar2 = null;
    int schieberWertHinz = 0;
    int schieberWertKunz = 0;
    int proportionalFaktor = 5;



   //Konstruktor
   public HinzKunz(){
       this.setSize(800, 400);
       this.show();
       this.setTitle("Hinz und Kunz");
       //Fenster schliessen
       MeinWindowAdapter mwA = new MeinWindowAdapter();
       addWindowListener(mwA);

    }//Konstruktor

  /** Methode init stellt die Scrollbars dar
   *  @param ohne
   *  @return ohne
   */
    public void init(){
      //lokale Variablen
      int schieberWertGesamt = 600;
      
      setLayout(null);
      scrollbar1 = new Scrollbar (Scrollbar.HORIZONTAL,0,10,0,110);
      scrollbar1.setBounds( 80,  50, schieberWertGesamt/2 , 20 );
      scrollbar2 = new Scrollbar( Scrollbar.HORIZONTAL,0,10,0,110 );
      scrollbar2.setBounds( 460,  50, schieberWertGesamt/2 , 20 );
      this.add( scrollbar1 );
      this.add( scrollbar2 );
      scrollbar1.addAdjustmentListener(this);
      scrollbar2.addAdjustmentListener(this);
      }


     /** Methode paint erstellt den grafischen Kontext
      *  @param Graphics g
      *  @return ohne
      */
     public void paint(Graphics g) {
       //lokale Variablen
       final String hinz = "Hinz :";
       final String kunz = "Kunz :";
       final String istGroesser = " ist groesser !";
       final String vdk = "Vergleich der Koerpergroessen - Bewegen Sie die Scrollbars";
       
        //Zeichen und Schreiben der feststehenden Grafikelemente
        g.drawString(hinz,40,60);
        g.drawString(kunz,415,60);
        g.drawString(hinz,40,240);
        g.drawString(kunz,40,280);
        g.drawString(vdk,180,380);

        // Umwandlung des grafischen Kontext in einen 2D-Kontext
        Graphics2D g2 = (Graphics2D) g;
        //Zeichnen der ausgefüllten Rechtecke in Abhängikeit vom jeweiligen Schieberwert
        Rectangle RectH = new Rectangle (80,230,schieberWertHinz,15);
        Rectangle RectK = new Rectangle (80,270,schieberWertKunz,15);
        g2.fill(RectH);
        g2.fill(RectK);

        //Abfrage wer groesser ist, oder ob beide gleich sind
        if (schieberWertHinz > schieberWertKunz){
          g.drawString(hinz + istGroesser ,40,100);
        }//if
         else{
           if (schieberWertKunz > schieberWertHinz){
             g.drawString(kunz + istGroesser ,40,100);
           }//if
            else{
             if (schieberWertKunz == schieberWertHinz){
               g.drawString("Beide sind gleich gross !" ,40,100);
             }//if
            }//else
         }//else

     }//Methode paint

  /** Methode adjustmentValueChanged Listener Methode
   *  @param AdjustmentEvent adjE
   *  @return ohne
   */
     public void adjustmentValueChanged( AdjustmentEvent adjE ) {

      //Beide Scrollbars werden abgefragt
      if ( adjE.getSource() == scrollbar1 ){
        schieberWertHinz = scrollbar1.getValue()*proportionalFaktor;
        }//if
        else{
         if ( adjE.getSource() == scrollbar2 ){
           schieberWertKunz = scrollbar2.getValue()*proportionalFaktor;
         }//if
        }//else

        //Neuzeichnen, aktualisieren
        repaint();
     }//Methode adjustmentValueChanged

}//class