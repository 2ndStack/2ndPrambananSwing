/*
 * creator : Latief Al Amin
 * e-mail  : al _amin_o4_032@yahoo.co.id
 * create  : Oct 2, 2010
 */

package com.secondstack.swing.button;

import java.awt.Color;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JButton;

/**
 *
 * @author Latief Al Amin
 */
public class JPButton extends JButton{

    private Color colorDarker = new Color(141, 180, 227);
    private Color colorLighter = new Color(228,237,248);

    private boolean actionPerformed = false;
    private boolean keySpacePressed = false;
    private boolean focusGained = false;

    public JPButton() {
        super();
        setOpaque(false);
        setForeground(new Color(15, 37, 63));
        
        initListener();
    }

    private void initListener(){
        addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                
                if(keySpacePressed){
                    keySpacePressed = false;
                    actionButton(false);
                    return;
                }
                actionButton(true);
            }
        });

        addMouseListener(new MouseListener() {

            public void mouseClicked(MouseEvent e) {
            }

            public void mousePressed(MouseEvent e) {
                if(e.getButton() == MouseEvent.BUTTON1)
                    actionButton(true);
            }

            public void mouseReleased(MouseEvent e) {
                actionButton(false);
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseExited(MouseEvent e) {
            }
        });

        addKeyListener(new KeyListener() {

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    actionButton(true);
                }
                if(e.getKeyCode() == KeyEvent.VK_SPACE){
                    keySpacePressed = true;
                    actionButton(true);
                }
            }

            public void keyReleased(KeyEvent e) {
                    actionButton(false);
            }
        });

        addFocusListener(new FocusListener() {

            public void focusGained(FocusEvent e) {
                focusGained = true;
                repaint();
            }

            public void focusLost(FocusEvent e) {
                focusGained = false;
                repaint();
            }
        });
    }
    
    @Override
    protected void paintComponent(Graphics g) {
//        super.paintComponent(g);
        //Create Graphics2D dan setting ANTIALIASING
        Graphics2D g2d = (Graphics2D) g.create();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

        float width = getWidth()-1;
        float height = getHeight()-1;

        Point2D.Float p1 = new Point2D.Float(0f, 0); // Gradient line start
        Point2D.Float p2 = new Point2D.Float(0f, height/4*3); // Gradient line end
        
        RoundRectangle2D.Float rectButton = new RoundRectangle2D.Float(0, 0, width, height, 20, 20);

        //Gradient
        Color colorDarkerTemp = colorDarker;
        Color colorLighterTemp = colorLighter;
        //warna berubah ketika button ditekan
        if(actionPerformed && isEnabled()){
            colorDarkerTemp = colorLighter;
            colorLighterTemp = colorDarkerTemp;
            actionPerformed = false;
        }
        GradientPaint g2 = new GradientPaint(p1, colorLighterTemp, p2, colorDarkerTemp, true); //cyclicgradient

        //fill gradient RoundReactangle2D
        g2d.setPaint(g2); // Gradient color fill
        g2d.fill(rectButton); // Fill the rectangle

        //draw Garis RoundReactangle2D
        if(focusGained)
            g2d.setPaint(colorLighter);
        else
            g2d.setPaint(colorDarker);
        g2d.draw(rectButton);

        //Draw Text to center
        FontMetrics fm = getFontMetrics(getFont());
        int xString = (int) ((width - fm.stringWidth(getText())) / 2);
        int yString = (int) (fm.getAscent() + (height - (fm.getAscent() + fm.getDescent())) / 2);
        g2d.setPaint(getForeground());
        g2d.setFont(getFont());
        g2d.drawString(getText(), xString, yString);

        //ketika tombol disabled
        if(!isEnabled()){
            RoundRectangle2D.Float rectDisabled = new RoundRectangle2D.Float(0, 0, width+1, height+1, 20, 20);
            g2d.setPaint(new Color(255, 255, 255, 80));
//            g2d.setPaint(colorLighter);
            g2d.fill(rectDisabled);
        }

        g2d.dispose();
    }

    /**
     * Action agar tombol berkedip ketika tombol ditekan..
     * @param action true jika tombol dalam keadan tombol ditekan. false
     * jika penekanan tombol di realese.
     */
    private void actionButton(boolean action){
        actionPerformed = action;
        repaint();
    }
    
    public Color getColorDarker() {
        return colorDarker;
    }

    public void setColorDarker(Color colorDarker) {
        this.colorDarker = colorDarker;
    }

    public Color getColorLighter() {
        return colorLighter;
    }

    public void setColorLighter(Color colorLighter) {
        this.colorLighter = colorLighter;
    }
}
