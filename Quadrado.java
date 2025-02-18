import java.awt.*;

/**
 * Um quadrado que pode ser manipulado e que desenha a si mesmo em uma canvas (tela).
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 * (Traduzido por Daniel Conrado)
 */

public class Quadrado extends Formas
{
    protected int tamanho;
    protected int posiçãoX;
    protected int posiçãoY;
    protected String cor;
    protected boolean estáVisível;

    /**
     * Cria um novo quadrado na posição padrão e com cor padrão.
     */
    public Quadrado()
    {
        tamanho = 60;
        posiçãoX = 310;
        posiçãoY = 120;
        cor = "vermelho";
        estáVisível = false;
    }

    /**
     * Torna este quadrado visível. Se já visível, então não faz nada.
     */
    public void tornarVisível()
    {
        estáVisível = true;
        desenhar();
    }
    
    /**
     * Torna este quadrado invisível. Se já estiver invisível, não faz nada.
     */
    public void tornarInvisível()
    {
        apagar();
        estáVisível = false;
    }
    
    /**
     * Move o quadrado alguns pixels para a direita.
     */
    public void moverDireita()
    {
        moverHorizontal(20);
    }

    /**
     * Move o quadrado alguns pixels para a esquerda.
     */
    public void moverEsquerda()
    {
        moverHorizontal(-20);
    }

    /**
     * Move o quadrado alguns pixels para cima.
     */
    public void moverCima()
    {
        moverVertical(-20);
    }

    /**
     * Move o quadrado alguns pixels para baixo.
     */
    public void moverBaixo()
    {
        moverVertical(20);
    }

    /**
     * Move o quadrado horizontalmente pela 'distância' em pixels.
     */
    public void moverHorizontal(int distância)
    {
        apagar();
        posiçãoX += distância;
        desenhar();
    }

    /**
     * Move o quadrado verticalmente pela 'distância' em pixels.
     */
    public void moverVertical(int distância)
    {
        apagar();
        posiçãoY += distância;
        desenhar();
    }

    /**
     * Move lentamente o quadrado horizontalmente pela 'distância' em pixels.
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
    * Move lentamente o quadrado verticalmente pela 'distância' em pixels.
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
    public void mudarTamanho(int novoTamanho)
    {
        apagar();
        tamanho = novoTamanho;
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
     * Desenha um quadrado com as especificações atuais na tela.
     */
    private void desenhar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.draw(this, cor,
                        new Rectangle(posiçãoX, posiçãoY, tamanho, tamanho));
            canvas.wait(10);
        }
    }

    /**
     * Apaga o quadrado da tela.
     */
    private void apagar()
    {
        if(estáVisível) {
            Canvas canvas = Canvas.getCanvas();
            canvas.erase(this);
        }
    }
}
