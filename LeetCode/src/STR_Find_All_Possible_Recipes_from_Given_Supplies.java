import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class STR_Find_All_Possible_Recipes_from_Given_Supplies {
	public static void main(String[] args) {
		String[] recipes = { "bread", "sandwich", "burger" };
		List<List<String>> ingredients = new ArrayList<List<String>>();
		List<String> temp = new ArrayList<String>();
		temp.add("yeast");
		temp.add("flour");
		ingredients.add(new ArrayList<String>(temp));
		temp.clear();
		temp.add("bread");
		temp.add("meat");
		ingredients.add(new ArrayList<String>(temp));
		temp.clear();
		temp.add("sandwich");
		temp.add("meat");
		temp.add("bread");
		ingredients.add(new ArrayList<String>(temp));
		String[] supplies = { "yeast", "flour", "meat" };
		System.out.println(findAllRecipes(recipes, ingredients, supplies));
	}

	public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
		boolean flag = true;
		Set<String> suppliesAvailable = new HashSet<String>();
		for (int i = 0; i < supplies.length; i++) {
			suppliesAvailable.add(supplies[i]);
		}
		while (flag) {
			flag = false;
			for (int i = 0; i < recipes.length; i++) {
				if (!suppliesAvailable.contains(recipes[i])) {
					if (isPossibleToCook(suppliesAvailable, ingredients.get(i))) {
						suppliesAvailable.add(recipes[i]);
						flag = true;
					}
				}
			}
		}
		List<String> result = new ArrayList<String>();
		for (int i = 0; i < recipes.length; i++) {
			if (suppliesAvailable.contains(recipes[i])) {
				result.add(recipes[i]);
			}
		}
		return result;
	}

	public static boolean isPossibleToCook(Set<String> supplies, List<String> ingredients) {
		for (int i = 0; i < ingredients.size(); i++) {
			if (!supplies.contains(ingredients.get(i))) {
				return false;
			}
		}
		return true;
	}
}
