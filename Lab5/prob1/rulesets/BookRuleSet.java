package Lab5.prob1.rulesets;

import java.awt.Component;

import Lab5.prob1.gui.BookWindow;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		// TODO Auto-generated method stub
		 BookWindow book= (BookWindow) ob;
		 String isbn=book.getIsbnValue();
		 String title=book.getTitleValue();
		 String price=book.getPriceValue();
       if(isbn.isEmpty() || title.isEmpty()||price.isEmpty() ){
		   System.out.println("All Fields Must be nonempty!");
	   }
		if (!isbn.matches("\\d+") || (isbn.length() != 10 && isbn.length() != 13)) {
			throw new RuleException("ISBN must be numeric and 10 or 13 digits");
		}
		if (isbn.length() == 10 && !(isbn.startsWith("0") || isbn.startsWith("1"))) {
			throw new RuleException("ISBN with length 10 must start with 0 or 1");
		}
		if (isbn.length() == 13 && !(isbn.startsWith("978") || isbn.startsWith("979"))) {
			throw new RuleException("ISBN with length 13 must start with 978 or 979");
		}
		double priceVal;
		try {
			priceVal = Double.parseDouble(price);
		} catch (NumberFormatException e) {
			throw new RuleException("Price must be a valid number");
		}
		if (!price.matches("\\d+\\.\\d{2}")) {
			throw new RuleException("Price must have exactly two decimal places");
		}
		if(priceVal<=0.49){
			throw new RuleException("Price must be greater than 0.49");
		}
	}

}
