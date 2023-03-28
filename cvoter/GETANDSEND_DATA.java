/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clientvoter;

import java.awt.Image;
import java.util.ArrayList;

/**
 *
 * @author abhimanyuyadav
 */


public class GETANDSEND_DATA {
    
    ArrayList<String> candidateName;
    ArrayList<Image> candidatePhoto;
    ArrayList<String> candidateHouse;
    
    public GETANDSEND_DATA(ArrayList<String> candidateName, ArrayList<Image> candidatePhoto,ArrayList<String> candidateHouse,ClFrame2 clframe2){
        
        this.candidateHouse = candidateHouse;
        this.candidateName = candidateName;
        this.candidatePhoto = candidatePhoto;
        sendData(clframe2);
    }
    
    private void sendData(ClFrame2 clframe2)
    {
        int a = candidateName.size();
        new ClFrame3(a,candidateName,candidateHouse,candidatePhoto).setVisible(true);
        clframe2.setVisible(false);
    }
}
