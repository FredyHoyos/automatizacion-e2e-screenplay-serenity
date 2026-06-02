package co.edu.udea.certificacion.taller.moduloauthycompra.utils;

public class Wait {

    private Wait(){
    }

    public static void aLittelBitTime(Integer mills){
        try{
            Thread.sleep(mills);
        }catch (InterruptedException e){
            Thread.currentThread().interrupt();
            throw new IllegalStateException("Interrupted while waiting", e);
        }
    }
}