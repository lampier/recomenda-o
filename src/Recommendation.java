
import java.util.ArrayList;
import java.util.Collections;

public class Recommendation {
	public void printMoviesRecommendation() {
	    RaterDatabase.initialize("ratings.csv ");
	    System.out.println("read data for " + RaterDatabase.size() + " raters");
	    MovieDatabase.initialize("ratedmoviesfull.csv");
	    System.out.println("read data for " + MovieDatabase.size() + " movies");
		FourthRatings fr = new FourthRatings();
		String raterID = "65";
		int numRaters = 20;
		ArrayList<Rating> ratings = fr.getRecommendations(raterID,numRaters);
	    if (ratings.size() == 0 || ratings.size() == 1)
	    	System.out.println(ratings.size() + " movie matched");
	    else
	    	System.out.println(ratings.size() + " movies matched");
	    for(int i=0; i< ratings.size(); i++) {
	    	if (i<15)
	    		System.out.printf("%d - %.2f - %s - %s\n", i, ratings.get(i).getValue(), ratings.get(i).getItem() ,MovieDatabase.getTitle(ratings.get(i).getItem()));
		}

	}
}
