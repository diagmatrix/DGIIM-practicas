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
class SafeSuppliesCardDeck extends CardDeck<SuppliesPackage> {
    @Override
    public SuppliesPackage next() {
        SuppliesPackage h=(SuppliesPackage)(super.next());
        return new SuppliesPackage(h) ;
    }
}