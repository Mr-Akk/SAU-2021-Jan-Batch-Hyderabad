
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.*;


public class InitialTask {
	
	static HashMap<String, List> hashMap = new HashMap<String, List>();
	
	private static void createCities() {
		List india = new ArrayList<String>();
		List america = new ArrayList<String>();
		List england = new ArrayList<String>();
		List australia = new ArrayList<String>();
		List germany = new ArrayList<String>();

		india.add("chennai");
		india.add("delhi");
		india.add("Mumbai");
		india.add("Hyderabad");
		india.add("Calcutta");
		hashMap.put("India", india);

		america.add("New York");
		america.add("Los Angels");
		america.add("Los santos");
		america.add("California");
		america.add("Washingtom");
		hashMap.put("Usa", america);
		england.add("London");
		england.add("Liverpool");
		england.add("Manchester");
		england.add("Nottingham");
		england.add("Leicester");
		hashMap.put("England", england);
		australia.add("Sydney");
		australia.add("Melbourne");
		australia.add("Brisbane");
		australia.add("Perth");
		australia.add("Adelaide");
		hashMap.put("Australia", australia);
		germany.add("Berlin");
		germany.add("Hamburg");
		germany.add("Munich");
		germany.add("Cologne");
		germany.add("Bremen");
		hashMap.put("Germany", germany);		
	}
	
	static void printCountry(String country) {
		try {
			List cities = hashMap.get(country);
			for(Object s : cities) {
				System.out.println("* " + s);
			}

		} catch (Exception e) {
					System.out.println("City not found!!");		}		
	}

    public static void main(String[] args) throws URISyntaxException, IOException {

        Path path = Paths.get(InitialTask.class.getClassLoader().getResource("sample.html").toURI());

        String contents = new String(Files.readAllBytes(path));

//        System.out.println(contents);

        //Your logic goes here
        createCities();
        Pattern p = Pattern.compile("<head>.*?<title>(.*?)</title>.*?</head>", Pattern.DOTALL); 
        Matcher matcher = p.matcher(contents);
        String title = "";
        while(matcher.find()) {
        	title = matcher.group(1); 
       	}
        System.out.println("The country is : " +title );
        printCountry(title);
    }
}
