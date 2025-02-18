
public abstract class Formas
{
    public abstract void tornarVisível();
    public abstract void tornarInvisível();
    public abstract void moverDireita();
    public abstract void moverEsquerda();
    public abstract void moverCima();
    public abstract void moverBaixo();
    public abstract void moverHorizontal(int distância);
    public abstract void moverVertical(int distância);
    public abstract void moverHorizontalLentamente(int distância);
    public abstract void moverVerticalLentamente(int distância);
    public abstract void mudarTamanho(int novoDiâmetro, int novaBase);
    public abstract void mudarCor(String novaCor);    
}
