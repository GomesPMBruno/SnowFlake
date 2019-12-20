import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Esercizio per allenarsi con AWT.
 *@author Bruno Gomes
 *@version 17/9/2019
 */
public class Punti implements MouseMotionListener, MouseListener{
    
    /**
     * Variabile che imposta la posizione del Point nella asse orizzontale.
     */
    private int x = 0;
    
    /**
     * Variabile che imposta la posizione del Point nella asse verticale. 
     */
    private int y = 0;
    
    /**
     * Variabile che verifica la distanza orizzontale del Point originale con quello attuale.
     */
    private double dx = 0;
    
    /**
     * Variabile che verifica la distanza verticale del Point originale con quello attuale.
     */
    private double dy = 0;
    
    /**
     * Variabile che indica il colore interno dello Point.
     */
    private Color fillColor = Color.black;

    /**
     * Variabile booleana che verifica se il mouse è sopra lo Point o no.
     */
    private boolean over = false;
    
    /**
     * Variabile che definisce il raggio di un punto.
     */
    public static final int RADIUS = 16;
    
    /**
     * Lista di Listeners.
     */
    private List<PuntiListener> listeners = new ArrayList<PuntiListener>();

    /**
     * Metodo contruttore dello Point.
     * @param x imposta la posizione del Point nella asse orizzontale.
     * @param y imposta la posizione del Point nella asse verticale. 
     */
    public Punti(int x, int y){
            this.x = x;
            this.y = y;
            this.fillColor = Color.black;
    }

        ////////////////////////////////////////////////////////////////////////
        ////////////////////////////Getter & Setter/////////////////////////////
        ////////////////////////////////////////////////////////////////////////
    
    /**
     * Metodo che prende la posizione del Point nella asse orizzontale.
     * @return posizione del Point nella asse orizzontale
     */
    public int getX(){
        return this.x;
    }
    
    /**
     * Metodo che prende la posizione del Point nella asse verticale.
     * @return posizione del Point nella asse verticale
     */
    public int getY(){
        return this.y;
    }
    
    /**
     * Metodo che imposta la posizione del Point nella asse orizzontale.
     * @param x posizione del Point nella asse orizzontale
     */
    public void setX(int x){
        this.x = x;
    }
    
    /**
     * Metodo che imposta la posizione del Point nella asse verticale.
     * @param y posizione del Point nella asse verticale
     */
    public void setY(int y){
        this.y = y;
    }
    
    /**
     * Metodo che verifica la distanza orizzontale del Point originale con quello attuale.
     * @param dx variabile che verifica la distanza orizzontale del Point originale con quello attuale.
     */
    public void setDX(double dx){
        this.dx = dx;
    }
    
    /**
     * Metodo che verifica la distanza verticale del Point originale con quello attuale.
     * @param dy variabile che verifica la distanza verticale del Point originale con quello attuale.
     */
    public void setDY(double dy){
        this.dy = dy;
    }
    
    /**
     * Metodo che prende la distanza orizzontale del Point originale con quello attuale.
     * @return la distanza orizzontale del Point originale con quello attuale
     */
    public double getDX(){
        return this.dx;
    }
    
    /**
     * Metodo che prende la distanza verticale del Point originale con quello attuale.
     * @return la distanza verticale del Point originale con quello attuale
     */
    public double getDY(){
        return this.dy;
    }

        ////////////////////////////////////////////////////////////////////////
        ///////////////////////////Eventi del Mouse/////////////////////////////
        ////////////////////////////////////////////////////////////////////////

    /**
     * Metodo richiamato da Point, quando il mouse viene cliccatto.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseClicked(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse viene premuto.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mousePressed(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse viene rilasciato.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseReleased(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse entra lo Point.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseEntered(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse esci dal Point.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseExited(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse si muove ed è premuto.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseDragged(MouseEvent e){}

    /**
     * Metodo richiamato da Point, quando il mouse si muove dentro lo Point.
     * @param e variabile che registra i eventi dal mouse.
     */
    public void mouseMoved(MouseEvent e){
            if(this.contains(e.getPoint())){
                    if(!over){
                            for(PuntiListener listener : listeners){
                                    listener.mouseEntered();
                            }
                            over = true;
                            this.fillColor = Color.green;
                    }
            }else{
                    if(over){
                            for(PuntiListener listener : listeners){
                                    listener.mouseExited();
                            }
                            over = false;
                            this.fillColor = Color.black;
                    }
            }
    }

        ////////////////////////////////////////////////////////////////////////
        ///////////////////////////Paint & Funzioni/////////////////////////////
        ////////////////////////////////////////////////////////////////////////

    /**
     * Metodo che crea il disegno del Point.
     * @param g variabile che permette il disegno.
     */
    public void paint(Graphics g){
            g.setColor(this.fillColor);
            g.fillOval(this.x - 8 + (int)this.dx, this.y - 8 + (int)this.dy, RADIUS, RADIUS);
            g.setColor(Color.black);
    }
    
    /**
     * Metodo che verifica se il mouse è dentro dello Point.
     * @param p coordinate del mouse.
     * @return valore boolean, se il mouse è dentro dello Point o no.
     */
    public boolean contains(Point p){
            return (p.x >= (x - 8) && p.x <= x + RADIUS - 8 && p.y >= (y - 8) && p.y <= y + RADIUS - 8);
    }

    /**
     * Metodo che aggiunge Pointes dalla lista di Listeners.
     * @param listener variabile che registra i lsitener.
     */
    public void addPuntiListener(PuntiListener listener){
            listeners.add(listener);
    }

    /**
     * Metodo che rimuovi Pointes dalla lista di Listeners.
     * @param listener  variabile che registra i listener.
     */
    public void removePuntiListener(PuntiListener listener){
            listeners.remove(listener);
    }
}