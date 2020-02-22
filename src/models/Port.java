package models;

/**
 *
 * @author JALEXISRDV
 */
public class Port {
    
    private pPort port;

    public Port() {
        port = new pPort();
        //Todos los leds se apagan
        setAllPin(0);
    }
    
    /*pin = led que se prende
      bit = 0 (apagar) o 1 (prender)
    */
    public void setPin(int pin, int bit) {
        port.setPin( (short) pin, (short) bit);
    }
    
    public void setAllPin(int bit) {
        port.setAllDataBits( (short) bit);
    }

}
