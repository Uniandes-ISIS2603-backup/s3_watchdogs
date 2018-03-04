/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.watchdogs.podam;

import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author mac
 */
public class DateTarjetaStrategy implements AttributeStrategy<Date>{

    private int getRandomNumberInRange(int min, int max)
    {
        if(min>=max)
        {
            throw new IllegalArgumentException();
        }
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
    
    @Override
    public Date getValue() {
              
        Calendar c = Calendar.getInstance();
        int year = c.getTime().getYear();
        int month = c.getTime().getMonth();
        int day = c.getTime().getDay();
        
        c.set(getRandomNumberInRange(year, c.getActualMaximum(Calendar.YEAR)), 
                getRandomNumberInRange(month, c.getActualMaximum(Calendar.MONTH)), 
                getRandomNumberInRange(day, c.getActualMaximum(Calendar.DAY_OF_MONTH)));
        
        c.set(Calendar.HOUR_OF_DAY, c.getActualMinimum(Calendar.HOUR_OF_DAY));
        c.set(Calendar.MINUTE, c.getActualMinimum(Calendar.MINUTE));
        c.set(Calendar.SECOND, c.getActualMinimum(Calendar.SECOND));
        c.set(Calendar.MILLISECOND, c.getActualMinimum(Calendar.MILLISECOND));
        return c.getTime();
    }

    
}
