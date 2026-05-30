package co.edu.udea.certificacion.taller.moduloauthycompra.utils;

public class Wait {

    private static Wait wait;
    private Integer mills;

    public Wait(Integer mill){
        try{
            Thread.sleep(mill);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static Wait aLittelBitTime(Integer mills){
        wait = new Wait(mills);
        return wait;
    }
}