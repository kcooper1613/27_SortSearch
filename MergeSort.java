import java.io.*;
import java.util.*;
public class MergeSort{
    public int number;
    private static String pValue;
    public MergeSort(){
    }
	public static void main(String[] arg)throws Exception{
		BufferedReader CSVFile =  new BufferedReader(new FileReader("pizzahut.csv"));
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String dataRow = CSVFile.readLine();
		ArrayList<String> towns = new ArrayList<String>(1000);
		while (dataRow != null){
			String[] tmp = dataRow.split(",");
			String[] townInfo = tmp[2].split("-");
			towns.add(townInfo[1]);
			dataRow = CSVFile.readLine(); 
		}
		CSVFile.close();
		
		/*String town1 = towns.get(10);
		String town2 = towns.get(100);
		System.out.println("Comparing 10 ("+town1+") to 100 ("+town2+")");
		System.out.println(town1.compareTo(town2));*/
				
		System.out.println(quickSort(towns, Math.round(towns.size()/2)));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	}
	public static ArrayList<String> quickSort(ArrayList<String> a, int pivot) { 
		int ind = a.size/2;
		if(a.size() <2){
			return a;
		}
		ArrayList<String>less = new ArrayList<String>();
		ArrayList<String>more = new ArrayList<String>();
		for( int z = 0; z < a.size(); z++){
			if(a.get(z).compareTo(a.get(pivot)) < 0) {
				less.add(a.get(z));
			}
			if(a.get(z).compareTo(a.get(pivot)) == 0){
				//less.add(a.get(z));
			}
			if(a.get(z).compareTo(a.get(pivot)) > 0){
				more.add(a.get(z));
			}
		}
		
		int lessPivot = Math.round(less.size()/2);
		int morePivot = Math.round(more.size()/2);
		ArrayList<String> overall = new ArrayList<String>(quickSort(less, lessPivot));
		overall.addAll(quickSort(more, morePivot));
		//return overall;
		search(a, ind, br);
	}
		
	public static void search(ArrayList<String> b, int l, String br){
		//private String i = b.get(l);
		System.out.println("Search called");
		String key = br;
		if(key.compareTo(b.get(l))==0){
			System.out.println("The Value you were looking for was found" +key);
		}
		if(key.compareTo(b.get(l))>0){
			l--;
			search(b,l, key);
		}
		if(key.compareTo(b.get(l))<0){
			l++;
			search(b,l, key);
		}
		if(l<0 || l > b.size()){
			System.out.println("We could not find the value you were looking for in the array");
			return;
		}
	}
}
