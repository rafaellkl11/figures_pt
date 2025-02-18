import java.awt.*;
import java.awt.geom.*;

/**
 * Um círculo que pode ser manipulado e que desenha a si mesmo em uma tela.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Círculo extends Formas
{
    protected int diâmetro;
    protected int posiçãoX;
    protected int posiçãoY;
    protected String cor;
    protected boolean estáVisível;
    
    /**
     * Cria um novo círculo na posição padrão com a cor padrão.
     */
    public Círculo()
    {
        diâmetro = 68;
        posiçãoX = 230;
        posiçãoY = 90;
        cor = "azul";
    }

    /**
     * Torna este círculo visível. Se já estiver vísivel, não faz nada.
     */
    public void tornarVisível()
    {
        estáVisível = true;
        desenhar();
    }
    
    /**
     * Torna este círculo invisível. Se já estiver invisível, não faz nada.
     */
    public void tornarInvisível()
    {
        apagar();
        estáVisível = false;
    }
    
    /**
     * Move o círculo alguns pixels para a direita.
     */
    public void moverDireita()
    {
        moverHorizontal(20);
    }

    /**
     * Move o círculo alguns pixels para a esquerda.
     */
    public void moverEsquerda()
    {
        moverHorizontal(-20);
    }

    /**
     * Move o círculo alguns pixels para cima.
     */
    public void moverCima()
    {
        moverVertical(-20);
    }

    /**
     * Move o círculo alguns pixels para baixo.
     */
    public void moverBaixo()
    {
        moverVertical(20);
    }

    /**
     * Move o círculo horizontalmente pela 'distância' em pixels.
     */
    public void moverHorizontal(int distância)
    {
        apagar();
        posiçãoX += distância;
        desenhar();
    }

    /**
     * Move o círculo verticalmente pela 'distância' em pixels.
     */
    public void moverVertical(int distância)
    {
        apagar();
        posiçãoY += distância;
        desenhar();
    }

    /**
     * Move lentamente o círculo horizontalmente pela 'distância' em pixels.
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
    * Move lentamente o círculo verticalmente pela 'distância' em pixels.
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
     * Muda o tamanho para o novo valor (em pixels). Tamanho precise ser >= 0.
     */
    public void mudarTamanho(int novoDiâmetro)
    {
        apagar();
        diâmetro = novoDiâmetro;
        desenhar();
    }

    /**
     * Muda a cor. Cores válidas são "vermelho", "amarelo", "azul", "verde",
     * "magenta" e "preto".
     */
    public void mudarCor(String novaCor)
    {
        cor = novaCor;
        desenhar();
    }

    /**
     * Desenha o círculo com as especificações atuais na tela.
     */
    private void desenhar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, cor, new Ellipse2D.Double(posiçãoX, posiçãoY, 
                                                          diâmetro, diâmetro));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o círculo da tela.
     */
    private void apagar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
