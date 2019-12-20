import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.lang.Math;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.Polygon;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Area;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.imageio.ImageIO;
import javax.swing.JOptionPane;

import org.apache.batik.dom.GenericDOMImplementation;
import org.apache.batik.svggen.SVGGraphics2D;
import org.apache.batik.svggen.SVGGraphics2DIOException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;

/**
 * Progetto.
 * @author Bruno Gomes
 * @version 4/10/2019
 */
public class FioccoPanel extends JPanel implements MouseListener, MouseMotionListener, PuntiListener {
    
        /**
         * Lista di punti.
         */
        private List<Punti> punti = new ArrayList<Punti>();
                
        /**
         * Poligono del Triangolo che l'utente vuole diventare in un fiocco.
         */
        public Polygon triangolo = new Polygon();
        
        /**
         * Poligono del insime di punti che l'utente controlla con il mouse.
         */
        public Polygon puntiPoly = new Polygon();
        
        /**
         * Area del Poligono del Triangolo.
         */
        public Area triArea = new Area();
        
        /**
         * Area del Poligono dei Punti.
         */
        public Area puntiArea = new Area();
        
        /**
         * Variabile che verifica il numero di Punti che l'utente ha.
         */
        private int counter = 0;
        
        /**
         * Variabile che verifica quale Punto l'utente è sopra con il mouse.
         */
        private int attuale = 0;
        
        /** 
         * Variabile booleana che verifica se il mouse è sopra un punto gia esistente.
         */
        private boolean sopra = false;
        
        /**
         * Variabile booleana che verifica se l'utente vuole intersettare il triangolo, default = false.
         */
        private boolean previewed = false;        
        
        /**
         * Variabile booleana che verifica se l'utente vuole generare il fiocco, default = false.
         */
        private boolean generated = false;
        
        /**
         * Differenza di larghezza della finestra attuale in rispetto alla larghezza originale.
         */
        double dx = 0;
        
        /**
         * Differenza di altezza della finestra attuale in rispetto alla altezza originale.
         */
        double dy = 0;
        
        /**
         * Larghezza originale del catetto sinistro.
         */
        int height = 0;
        
        /**
         * Larghezza originale del catetto superiore.
         */
        int cateto = 0;
        
        /**
         * Variabile utilizzata per determinare la lunghezza dal bordo al Point[0] del triangolo.
         */
        int calculusX = 0;
        
        /**
         * Variabile utilizzata per determinare la altezza dal bordo al Point[0] del triangolo.
         */
        int calculusY = 0;
        
        /**
         * Larghezza precedente del catetto prima di avere ridimensionato la finestra.
         */
        double oldWidth = 0;

        /**
         * Altezza precedente del catetto prima di avere ridimensionato la finestra.
         */
        double oldHeight = 0;
        
        /**
         * Larghezza attuale del catetto superiore.
         */
        double currentWidth = 0;

        /**
         * Altezza attuale del catetto sinistro.
         */
        double currentHeight = 0;
        
        /**
         * Variabile che verifica se è la prima volta che il metodo paint() viene chiamato.
         */
        boolean first = true;

        /**
         * Metodo Costruttore.
         */
	public FioccoPanel(){
                this.addMouseListener(this);
                this.addMouseMotionListener(this);
        }

        ////////////////////////////////////////////////////////////////////////
        //////////////////////////Eventi del Mouse//////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        /**
         * Metodo che viene chiamato quando il mouse viene spostato mentre è premuto.
         * @param e eventi del mouse.
         */
        public void mouseDragged(MouseEvent e) {
            Point pp = e.getPoint();
            for (int i = 0; i < punti.size(); i++) {
                if(punti.get(i).contains(pp)){
                    sopra = true;
                    attuale = i;
                    break;
                }
            }
            if (sopra) {
                punti.get(attuale).setX(pp.x);
                punti.get(attuale).setY(pp.y);
                repaint();
                sopra = false;
            }
        }
        
        /**
         * Metodo che viene chiamato quando il mouse viene premuto e rilasciato.
         * @param e eventi del mouse.
         */
        public void mouseClicked(MouseEvent e){
            Point pp = e.getPoint();
            if(counter == 0 && e.getButton() == MouseEvent.BUTTON1){
                punti.add(new Punti(pp.x, pp.y));
                punti.get(counter).addPuntiListener(this);
                this.addMouseListener(punti.get(counter));
                this.addMouseMotionListener(punti.get(counter));
                counter++;
                repaint();
            }else{
                for (int i = 0; i < punti.size(); i++) {
                    if(punti.get(i).contains(pp)){
                        sopra = true;
                        attuale = i;
                    }
                }
                if (sopra) {
                    if (e.getButton() == MouseEvent.BUTTON3){
                        punti.remove(attuale);
                        counter--;
                        repaint();
                    }
                    sopra = false;
                }else{
                    if(e.getButton() == MouseEvent.BUTTON1){
                        punti.add(new Punti(pp.x, pp.y));
                        punti.get(counter).addPuntiListener(this);
                        this.addMouseListener(punti.get(counter));
                        this.addMouseMotionListener(punti.get(counter));
                        counter++;
                        repaint();
                    }
                }
            }
        }

        /**
         * Metodo che viene chiamato quando il mouse viene spostato.
         * @param e eventi del mouse.
         */
        public void mouseMoved(MouseEvent e) {}

        /**
         * Metodo che viene chiamato quando il mouse viene premuto.
         * @param e eventi del mouse.
         */
	public void mousePressed(MouseEvent e){}

        /**
         * Metodo che viene chiamato quando il mouse viene rilasciato.
         * @param e eventi del mouse.
         */
	public void mouseReleased(MouseEvent e){}

        /**
         * Metodo che viene chiamato quando il mouse entra nel Panel.
         * @param e eventi del mouse.
         */
	public void mouseEntered(MouseEvent e){}

        /**
         * Metodo che viene chiamato quando il mouse esci dal Panel.
         * @param e eventi del mouse.
         */
	public void mouseExited(MouseEvent e){}

        ////////////////////////////////////////////////////////////////////////
        ///////////////////Download & Upload dei Elementi///////////////////////
        ////////////////////////////////////////////////////////////////////////

        /**
         * Metodo che salva la posizione dei punti in un file, in modo che possa essere ricavato in futuro.
         * @param file path del file
         */
        public void salvaPunti(File file){
            String path = file.toString();
            
            for (int i = 0; i < this.puntiPoly.npoints; i++) {
                System.out.println("x: " + puntiPoly.xpoints[i]);
                System.out.println("y: " + puntiPoly.ypoints[i]);
            }
            
            try {
                FileOutputStream fos = new FileOutputStream(path);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(this.puntiPoly);
                oos.close();
                fos.close();
            } catch (IOException i) {
                System.out.println("Errore.");
            }
        }
        
        /**
         * Metodo che salva la posizione dei punti in un file, in modo che possa essere ricavato in futuro.
         * @param file path del file
         */
        public void caricaPunti(File file){
            String path = file.toString();
            try {
                FileInputStream fis = new FileInputStream(path);
                ObjectInputStream ois = new ObjectInputStream(fis);
                this.puntiPoly = (Polygon) ois.readObject();
                this.punti.clear();
                for(int i = 0; i < this.puntiPoly.npoints; i++){
                    this.punti.add(new Punti(puntiPoly.xpoints[i], puntiPoly.ypoints[i]));
                }
                repaint();
                ois.close();
                fis.close();
                for (int i = 0; i < this.puntiPoly.npoints; i++) {
                    System.out.println("x: " + puntiPoly.xpoints[i]);
                    System.out.println("y: " + puntiPoly.ypoints[i]);
                }
            } catch (ClassNotFoundException | IOException i) {
                System.out.println("Errore.");
            }
        }
        
        /**
         * Metodo che salva il fiocco in forma svg ("Scatta una foto").
         * @param path path del file
         */
        public void creaSVG(String path){
            previewed = false;
            generated = true;
            repaint();
            DOMImplementation domImpl = GenericDOMImplementation.getDOMImplementation();
            String svgNS = "https://www.w3schools.com/graphics/svg_intro.asp";
            Document document = domImpl.createDocument(svgNS, "svg", null);
            SVGGraphics2D svgGenerator = new SVGGraphics2D(document);
            this.paintComponent(svgGenerator);
            try {
                svgGenerator.stream(path);
            } catch (NoClassDefFoundError | SVGGraphics2DIOException ex) {
                JOptionPane jop = new JOptionPane();
                jop.showOptionDialog(
                        null,
                        "Graphic error. Code: sf206",
                        "Graphic error",
                        JOptionPane.DEFAULT_OPTION,
                        JOptionPane.ERROR_MESSAGE,
                        null, null, null);
            }
        }
        
        /**
         * Metodo che salva il fiocco in forma png ("Scatta una foto").
         * @param path path del file
         * @param size larghezza della risoluzione
         */
        public void creaPNG(String path, int size){
            BufferedImage img = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = img.createGraphics();
            try{  
                drawPoly();
                getIntersected(true, true);
                for(int i = 0; i < 6; i++){
                    g2d.fill(rotateArea((i - 1) * 60, setFlippedTriangle(triArea)));
                    g2d.fill(rotateArea(i * 60, triArea));
                }
            }catch(Exception ex){}
            try{
                ImageIO.write(img, "PNG", new File(path));
            }catch(IOException ioe){}
        }

        ////////////////////////////////////////////////////////////////////////
        ///////////////////Paint e altri metodi di disegno//////////////////////
        ////////////////////////////////////////////////////////////////////////
                
        /**
         * Metodo che intersetta entrambi le aree del Triangolo e della
         * lista di Punti e crea l'area non condivisa tra loro.
         * @param type verifica quale delle 2 versioni di preview il utente vuole (triangolo o fiocco)
         * @param using verifica se l'utente intende fare un repaint
         */
        public void getIntersected(boolean type, boolean using){
            triArea.reset();
            puntiArea.reset();
            
            triArea = new Area(triangolo);
            puntiArea = new Area(puntiPoly);
            
            triArea.subtract(puntiArea);
            if(!using){
                if(type){
                    generated = !generated; 
                }else{
                    previewed = !previewed;
                }
            }
            repaint();
        }
        
        /**
         * Metodo che gira i diversi triangoli in modo da creare il fiocco.
         * @param angle angulo in gradi
         * @param s la forma del triangolo
         * @return 
         */
        private Shape rotateArea(int angle, Shape s){
            AffineTransform at = new AffineTransform();
            at.rotate(Math.toRadians(angle), triangolo.xpoints[1], triangolo.ypoints[1]);
            return at.createTransformedShape(s);
        }
        
        /**
         * Metodo che si occupa di capovolgere i triangoli in modo che siano specchiati.
         * @param area l'area del triangolo
         * @return 
         */
        private Shape setFlippedTriangle(Area area){
            AffineTransform primo = new AffineTransform();
            primo.scale(-1, 1);
            AffineTransform alCentro = new AffineTransform();
            alCentro.translate(-(triangolo.xpoints[0]) * 2, 0);
            AffineTransform totale = new AffineTransform();
            totale.concatenate(primo);
            totale.concatenate(alCentro);
            return totale.createTransformedShape(area);
        }
        
        /**
         * Metodo che svuota e ricrea i poligoni del Triangolo e di tutti i Punti.
         */
        public void drawPoly(){            
            triangolo.reset();
            puntiPoly.reset();
            
            if (first) {
                height = this.getHeight() / 2;
                cateto = (int)(height * 1.1547) / 2;
                oldHeight = this.getHeight();
                oldWidth = this.getWidth();
                first = !first;
            }
            
            currentHeight = this.getHeight();
            currentWidth = this.getWidth();
            
            calculusX = (this.getWidth() - cateto) / 2;
            
            calculusY = (this.getHeight() / 4);
            
            triangolo.addPoint(calculusX, calculusY);
            triangolo.addPoint(calculusX, calculusY + height);
            triangolo.addPoint(calculusX + cateto, calculusY);
            
            dx = currentWidth - oldWidth;
            dy = currentHeight - oldHeight;
            
            for(int i = 0; i < punti.size(); i++){
                puntiPoly.addPoint(punti.get(i).getX() + (int)punti.get(i).getDX(), punti.get(i).getY() + (int)punti.get(i).getDY());
            }
        }
        
        /**
         * Metodo che permette di disgnare nel Panel.
         * @param g componente grafica.
         */
        @Override
	public void paintComponent(Graphics g){
            Graphics2D g2d = (Graphics2D) g;
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
            g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON );
            drawPoly();
            if(previewed){
                g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
                getIntersected(true, true);
                g2d.fill(triArea);
            }else if(generated){
                g2d.clearRect(0, 0, this.getWidth(), this.getHeight());
                g2d.translate((calculusX / 4), -(calculusY));
                getIntersected(true, true);
                for(int i = 0; i < 6; i++){
                    g2d.fill(rotateArea((i - 1) * 60, setFlippedTriangle(triArea)));
                    g2d.fill(rotateArea(i * 60, triArea));
                }
            }else{
                g2d.setColor(Color.white);
                g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
                g2d.setColor(Color.cyan);
                g2d.fillPolygon(triangolo);
                g2d.setColor(Color.black);
                for (int i = 0; i < punti.size();i++) {
                    System.out.println(punti.get(i).getX());
                    punti.get(i).setDX((punti.get(i).getX() * currentWidth / oldWidth) - punti.get(i).getX());
                    punti.get(i).setDY((punti.get(i).getY() * currentHeight / oldHeight) - punti.get(i).getY());
                    
                    System.out.println(punti.get(i).getDX());
                    System.out.println(punti.get(i).getX() + punti.get(i).getDX());
                    
                    punti.get(i).paint(g2d);
                    if(i != 0){
                        g2d.drawLine(punti.get(i).getX() + (int)punti.get(i).getDX(),
                                punti.get(i).getY() + (int)punti.get(i).getDY(),
                                punti.get(i - 1).getX() + (int)punti.get(i - 1).getDX(),
                                punti.get(i - 1).getY() + (int)punti.get(i - 1).getDY());
                    }
                    if ((i + 1) == punti.size()){
                       g2d.drawLine(punti.get(i).getX() + (int)punti.get(i).getDX(),
                               punti.get(i).getY() + (int)punti.get(i).getDY(),
                               punti.get(0).getX() + (int)punti.get(0).getDX(),
                               punti.get(0).getY() + (int)punti.get(0).getDY());
                    }
                }
            }
	}

        ////////////////////////////////////////////////////////////////////////
        /////////////////////////Codici dei Listener////////////////////////////
        ////////////////////////////////////////////////////////////////////////
        
        /**
         * Metodo che viene chiamato quando il mouse viene premuto sopra un punto. 
         */
	public void pointToggled(){
		repaint();
	}

        /**
         * Metodo che viene chiamato quando il mouse viene entra in un punto. 
         */
	public void mouseEntered(){
		repaint();
	}

        /**
         * Metodo che viene chiamato quando il mouse viene esce da un punto. 
         */
	public void mouseExited(){
		repaint();
	}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
