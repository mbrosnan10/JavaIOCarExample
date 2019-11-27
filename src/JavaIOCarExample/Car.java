/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaIOCarExample;

/**
 *
 * @author k00214761
 */
public class Car
{

    /**
     *
     * @return
     */
    @Override
    public String toString()
    {
	String text = "";

	text += "reg:" + regYear + "-" + regCounty + "-" + regNumber + System.lineSeparator();
	text += color + " " + make + " " + model + System.lineSeparator();
	text += "for sale at :" + city + " - " + price + "euro" + System.lineSeparator();
	text += owners + " previous owners. " + mileage + " miles " + System.lineSeparator();

	return text;
    }
    double regYear;
    String regDash1;//Read Token:CarReg-Dash
    String regCounty;//Read Token:CarReg-City
    String regDash2;	//Read Token:CarReg-Dash
    double regNumber;//Read Token:CarReg-Number

    String make;		//Read Token:Make
    String model;	//Read Token:Model
    String color;	//Read Token:Color
    //
    //	Add to City
    //
    String city;		//Read Token 09:Location
    double price;	//Read Token 10:Price
    //
    //	Rest
    //
    double owners;
    double mileage;

}
