/*
 * HTBLA Leonding 2017/18
 * Helcig Michael
 */
package gcd;

/**
 *
 * @author michaelhelcig
 */
public class Prime {
    int quantity;
    int prime;
    public Prime(int prime) {
        this.prime = prime;
        this.quantity = 0;
    }
    
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void addToQuantity(){
        this.quantity++;
    }
    
    public int getPrime() {
        return prime;
    }

    public void setPrime(int prime) {
        this.prime = prime;
    }
    
    
   
}
