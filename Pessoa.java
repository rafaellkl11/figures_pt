import java.awt.*;

/**
 * A person that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Pessoa
{
    private int altura;
    private int comprimento;
    private int posiçãoX;
    private int posiçãoY;
    private String cor;
    private boolean estáVisível;

    /**
     * Create a new person at default position with default color.
     */
    public Pessoa()
    {
        altura = 60;
        comprimento = 30;
        posiçãoX = 280;
        posiçãoY = 190;
        cor = "black";
        estáVisível = false;
    }

    /**
     * Make this triangle visible. If it was already visible, do nothing.
     */
    public void tornarVisível()
    {
        estáVisível = true;
        desenhar();
    }
    
    /**
     * Make this triangle invisible. If it was already invisible, do nothing.
     */
    public void tornarInvisível()
    {
        apagar();
        estáVisível = false;
    }
    
    /**
     * Move the triangle a few pixels to the right.
     */
    public void moverDireita()
    {
        moverHorizontal(20);
    }

    /**
     * Move the triangle a few pixels to the left.
     */
    public void moverEsquerda()
    {
        moverHorizontal(-20);
    }

    /**
     * Move the triangle a few pixels up.
     */
    public void moverCima()
    {
        moverVertical(-20);
    }

    /**
     * Move the triangle a few pixels down.
     */
    public void moverBaixo()
    {
        moverVertical(20);
    }

    /**
     * Move the triangle horizontally by 'distance' pixels.
     */
    public void moverHorizontal(int distância)
    {
        apagar();
        posiçãoX += distância;
        desenhar();
    }

    /**
     * Move the triangle vertically by 'distance' pixels.
     */
    public void moverVertical(int distância)
    {
        apagar();
        posiçãoY += distância;
        desenhar();
    }

    /**
     * Slowly move the triangle horizontally by 'distance' pixels.
     */
    public void moverHorizontalLentamente(int distância)
    {
        int delta;

        if(distância < 0) 
        {
            delta = -1;
            distância = -distância;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distância; i++)
        {
            posiçãoX += delta;
            desenhar();
        }
    }

    /**
     * Slowly move the triangle vertically by 'distance' pixels.
     */
    public void moverVerticalLentamente(int distância)
    {
        int delta;

        if(distância < 0) 
        {
            delta = -1;
            distância = -distância;
        }
        else 
        {
            delta = 1;
        }

        for(int i = 0; i < distância; i++)
        {
            posiçãoY += delta;
            desenhar();
        }
    }

    /**
     * Change the size to the new size (in pixels). Size must be >= 0.
     */
    public void mudarTamanho(int novaAltura, int novoComprimento)
    {
        apagar();
        altura = novaAltura;
        comprimento = novoComprimento;
        desenhar();
    }

    /**
     * Change the color. Valid colors are "red", "yellow", "blue", "green",
     * "magenta" and "black".
     */
    public void mudarCor(String novaCor)
    {
        cor = novaCor;
        desenhar();
    }

    /**
     * Draw the person with current specifications on screen.
     */
    private void desenhar()
    {
        int bh = (int)(altura * 0.7);  // body height
        int hh = (altura - bh) / 2;  // half head height
        int hw = comprimento / 2;  // half width
        int x = posiçãoX;
        int y = posiçãoY;
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { x-3, x-hw, x-hw, x-(int)(hw*0.2)-1, x-(int)(hw*0.2)-1, x-hw, 
                              x-hw+(int)(hw*0.4)+1, x, x+hw-(int)(hw*0.4)-1, x+hw, x+(int)(hw*0.2)+1, 
                              x+(int)(hw*0.2)+1, x+hw, x+hw, x+3, x+(int)(hw*0.6), 
                              x+(int)(hw*0.6), x+3, x-3, x-(int)(hw*0.6), x-(int)(hw*0.6) };
            int[] ypoints = { y, y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
                              y+(int)(bh*0.5), y+bh, y+bh, y+(int)(bh*0.65), y+bh, y+bh, 
                              y+(int)(bh*0.5), y+(int)(bh*0.2), y+(int)(bh*0.4), y+(int)(bh*0.2), 
                              y, y-hh+3, y-hh-3, y-hh-hh, y-hh-hh, y-hh-3, y-hh+3 };
            canvas.draw(this, cor, new Polygon(xpoints, ypoints, 21));
            canvas.wait(10);
        }
    }

    /**
     * Erase the person on screen.
     */
    private void apagar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
