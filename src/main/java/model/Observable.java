/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import viewFx.Observer;

/**
 *
 * @author youne
 */
public interface Observable {
    
   public void registerObserver(Observer obs);
//     public void removeObserver(Observer obs);
     public void notifyObservers();

     
     
     
     
 }


