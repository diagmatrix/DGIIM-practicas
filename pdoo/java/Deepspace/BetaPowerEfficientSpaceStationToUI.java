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
public class BetaPowerEfficientSpaceStationToUI extends PowerEfficientSpaceStationToUI {

    BetaPowerEfficientSpaceStationToUI(BetaPowerEfficientSpaceStation s) {
        super(s);
    }
    
  @Override
  public String getName () {
    return super.getName() + " (beta)";
  }
    
}
