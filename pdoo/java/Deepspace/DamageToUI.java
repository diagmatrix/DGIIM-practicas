/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Deepspace;

/**
 *
 * @author Profe
 */
public abstract class DamageToUI {
    private int nShields;

    DamageToUI(Damage d) {
        nShields=d.getNShields();
    }

    public int getNShields() {
        return nShields;
    }
    
    public abstract String getWeaponInfo();
    
    
}
