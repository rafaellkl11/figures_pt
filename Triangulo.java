import java.awt.*;

/**
 * A triangle that can be manipulated and that draws itself on a canvas.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Triangulo
{
    private int altura;
    private int base;
    private int posiçãoX;
    private int posiçãoY;
    private String cor;
    private boolean estáVisível;

    /**
     * Create a new triangle at default position with default color.
     */
    public Triangulo()
    {
        altura = 60;
        base = 70;
        posiçãoX = 210;
        posiçãoY = 140;
        cor = "green";
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
    public void mudarTamanho(int novaAltura, int novaBase)
    {
        apagar();
        altura = novaAltura;
        base = novaBase;
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
     * Draw the triangle with current specifications on screen.
     */
    private void desenhar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            int[] xpoints = { posiçãoX, posiçãoX + (base/2), posiçãoX - (base/2) };
            int[] ypoints = { posiçãoY, posiçãoY + altura, posiçãoY + altura };
            canvas.draw(this, cor, new Polygon(xpoints, ypoints, 3));
            canvas.wait(10);
        }
    }

    /**
     * Erase the triangle on screen.
     */
    private void apagar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
