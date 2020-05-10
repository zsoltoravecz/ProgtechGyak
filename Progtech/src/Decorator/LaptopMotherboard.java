package Decorator;

import Commom.Battery;
import Commom.Camera;
import Commom.Memory;
import Commom.Microphone;
import Commom.Processor;
import Commom.Screen;
import Commom.Sim;
import Commom.Simtypes;
import Commom.Socket;
import Commom.Speaker;
import Commom.Touchpanel;
import Exceptions.Notvalidmemorysocket;
import Exceptions.Notvalidprocessorsocket;
import Laptop.Keyboard;
import Laptop.Touchpad;
import Phone.Wrap;
import java.util.ArrayList;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author O.Zsolt
 */
public class LaptopMotherboard extends Motherboard{

    
    public Motherboard laptopmotherboard=new Motherboard();
    
    
    //Decorator
    @Override
    public  String getInfo(){
        
      return laptopmotherboard.getInfo()+this.battery.getBattery()+";"+this.camera.getCamera()+";"+
              this.memory.getMemory()+";"+this.processor.getProcessor()+";"+this.screen.getScreen()+
              ";"+this.keyboard.getKeyboard()+";"+this.touchpad.getTouchpad()+";"+this.wrap.getWrap();
    }
    protected Socket memorysocket;
    protected Socket processorsocket;
    protected Battery battery;
    protected Camera camera;
    protected Memory memory;
    protected Processor processor;
    protected Screen screen;
    
    protected Keyboard keyboard;
    protected Touchpad touchpad;
    
    
    protected Laptop.Wrap wrap;
    

   public LaptopMotherboard(Battery battery,Camera camera,Memory memory,
           Processor processor,Screen screen,Keyboard keyboard,Touchpad touchpad,Socket memorysocket,Socket processorsocket) throws Exception{
   
       this.battery=battery;
       this.camera=camera;
       this.memory=memory;
       this.processor=processor;
       this.screen=screen;
       this.keyboard=keyboard;
       this.touchpad=touchpad;
      
       this.memorysocket=memorysocket;
       this.processorsocket=processorsocket;
       
       ///
       //Singleton
       this.wrap=Laptop.Wrap.getInstance();
       
       if (this.memorysocket!=this.memory.getSocket()) {
           throw new Notvalidmemorysocket();
       }
       if(this.processorsocket!=this.processor.getSocket()){
           throw new Notvalidprocessorsocket();
       }
      
       
       
   }
   
}
