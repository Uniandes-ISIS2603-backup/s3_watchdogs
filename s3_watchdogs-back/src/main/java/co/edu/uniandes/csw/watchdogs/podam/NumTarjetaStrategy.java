/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author jc.pulido
 */
public class NumTarjetaStrategy implements AttributeStrategy<String>{

    
    @Override
    public String getValue() {
        Random r = new Random();
        int num1 = r.nextInt(10);
        int num2 = r.nextInt(10);
        int num3 = r.nextInt(10);
        int num4 = r.nextInt(10);
        int num5 = r.nextInt(10);
        int num6 = r.nextInt(10);
        int num7 = r.nextInt(10);
        int num8 = r.nextInt(10);
        int num9 = r.nextInt(10);
        int num10 = r.nextInt(10);
        int num11 = r.nextInt(10);
        int num12 = r.nextInt(10);
        int num13 = r.nextInt(10);
        int num14 = r.nextInt(10);
        int num15 = r.nextInt(10);
        int num16 = r.nextInt(10);

        return  ""+ num1 + num2 + num3 + num4 + num5
                + num6 + num7 + num8 + num9 + num10
                + num11 + num12 + num13 + num14 + num15
                + num16;
    }
    
    
}
