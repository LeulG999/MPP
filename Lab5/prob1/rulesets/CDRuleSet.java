package Lab5.prob1.rulesets;

import java.awt.Component;

import Lab5.prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		CDWindow cd=(CDWindow) ob;
		String title=cd.getTitleValue();
		String artist=cd.getArtistValue();
		String price=cd.getPriceValue();
		if(title.isEmpty()||artist.isEmpty()||price.isEmpty()){
			throw new RuleException("ALL Fields Can not be empty");
		}
		double priceVal;
		try {
			priceVal = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			throw new RuleException("Price must be a valid number");

		}          if(!price.matches("\\d+\\.\\d{2}")){
			  throw new RuleException("Price must have exactly two decimal places");
		}
		  if(priceVal<=0.49){
			  throw new RuleException("Price must be greater than 0.49");
		  }
	}
	
}
