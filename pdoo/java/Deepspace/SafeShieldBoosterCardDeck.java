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
class SafeShieldBoosterCardDeck extends CardDeck<ShieldBooster> {
    @Override
    public ShieldBooster next() {
        ShieldBooster h=(ShieldBooster)(super.next());
        return new ShieldBooster(h) ;
    }
}
