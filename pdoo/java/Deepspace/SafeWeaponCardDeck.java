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
class SafeWeaponCardDeck extends CardDeck<Weapon> {
    @Override
    public Weapon next() {
        Weapon h=(Weapon)(super.next());
        return new Weapon(h) ;
    }
}
