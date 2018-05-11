import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.remote.DesiredCapabilities;

import net.sourceforge.htmlunit.corejs.javascript.NativeIterator.WrappedJavaIterator;

import org.openqa.selenium.htmlunit.*;

public class Crawler {

	public static List<String> konecnoComments = new ArrayList<String>();
	public static List<String> konecnoCommRatings = new ArrayList<String>();
	
	public static void main(String[] args) throws InterruptedException, IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--headless");
		//options.addArguments("chrome.switches","--disable-extensions");
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Downloads\\chromedriver_win32\\chromedriver.exe");
		//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		//capabilities.setCapability("marionette", true);
		
		List<String> linkovi = new ArrayList<String>();
		
		/*linkovi.add("https://play.google.com/store/apps/details?id=edu.harvard.harvardmobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.stanford.m&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.stanford.m&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.yale.yalepublic&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.princeton.mobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.mit.mitmobile2&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.ombiel.campusm.monash&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.rutgers.css.Rutgers&feature=search_result&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=uk.ac.ox.it.mobileoxford&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=es.uv.secretaria&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.blackboard.android.central.miami&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.collegemobile.carleton&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.osu.osumobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.blackboard.android.central.ua&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.ombiel.campusm.leeds&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=bucknell.mobile&hl=en");
		//linkovi.add("https://play.google.com/store/apps/details?id=edu.apollogrp.android.classroom.activity&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.ombiel.campusm.keele&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.ashford.talon&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=ca.umanitoba&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.georgetown.georgetownmobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.blackboard.android.central.texasam&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.neu.mobile.myneu&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.missouristate&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.dub.app.xavier&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.texastech.enterprisemobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.emory.emorymobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.uoregon&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.rhomobile.uofmemphis&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.du.twou&hl=en");*/
		
		
		
		linkovi.add("https://play.google.com/store/apps/details?id=edu.apollogrp.android.classroom.activity&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.crowdcompass.appvZXElzJn3D&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.ombiel.campusm.ucl&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.UCLMap&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.graduway.uclalumni&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=ch.ethz.eduapp&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=ch.ethz.ethz&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=ca.utoronto.megaapp&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=ca.utoronto.map&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=de.tum.in.tumcampus&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.ombiel.campusm.leiden&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.guidebook.apps.ColumbiaUL.android&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.guidebook.apps.ColumbiaCCSEAS.android&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.phonegap.columbia&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=au.edu.unimelb.my&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.yc360.college.heidelberg.heidelberg&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.guidebook.apps.UoEEvents.android&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.mcgill&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.stucomm.mytudelftapp&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=uk.ac.ox.it.mobileoxford&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=dk.ku.myucph&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.mapspeople.indoor&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.manchester.mumobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=edu.karolinskainstitutet.mobile&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=npa.aarhusuniapptest&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=se.su.it.handheld.app.hermes&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=de.unibonn.android&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=au.edu.uq.uqnav&hl=en");
		linkovi.add("https://play.google.com/store/apps/details?id=com.MississippiStateUniversity&hl=en");
		
		
		
		String url, title, primary, category, price, totalReviews = null, rating = null, installs = null;
		String fiveStars = null, fourStars = null, threeStars = null, twoStars = null, oneStar = null;
		String updated, version;
		List<WebElement> oceni;
		List<WebElement> total;
		List<WebElement> proverka;
		List<WebElement> osnovnoInfo;
		
		Files.deleteIfExists(Paths.get("rezultati.csv"));
		File rezultati = new File("rezultati.csv");
		FileWriter writer = new FileWriter(rezultati);
		String separator = ";";
		writer.append("\"sep=;\""+"\n");
		writer.append("URL;Title;Subtitle;Category;Price;Reviews;Rating;5 stars;4 stars;3 stars;2 stars;1 star;Installs;LastUpdated;RequiredAndroidVersion;CommentRating;Comment");
		writer.append("\n");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new ChromeDriver(options);
		for(int i=0;i<linkovi.size();i++){
			
			konecnoComments.clear();
			konecnoCommRatings.clear();
			
			url = "";
			title = "";
			primary = "";
			category = "";
			price = "";
			totalReviews = "";
			rating = "";
			fiveStars = "";
			fourStars = "";
			threeStars = "";
			twoStars="";
			oneStar="";
			installs="";
			oceni = null;
			total = null;
			proverka = null;
			osnovnoInfo = null;
			updated="";
			version="";
		
					
			driver.get(linkovi.get(i));
			url = driver.getCurrentUrl();
			System.out.println("URL: "+url);
			
			
			title = driver.findElement(By.className("AHFaub")).getText();
			System.out.println("Title: "+title);
			
			
			primary = driver.findElements(By.xpath("//a[contains(@class, 'hrTbp R8zArc')]")).get(0).getText();
			
			
			category = driver.findElements(By.xpath("//a[contains(@class, 'hrTbp R8zArc')]")).get(1).getText();
			System.out.println("Category: "+category);
			
			
			price = driver.findElement(By.cssSelector(".LkLjZd.ScJHi.HPiPcc.IfEcue")).getText();
			if(price.trim().equals("Install")){
				price = "FREE";
			}
			else{
				price = price.replace("$", "").trim();
				price = price.replace("Buy", "").trim();
				price = price.trim();
			}
			System.out.println("Price: "+price);
			
			
			try{
				total = driver.findElements(By.cssSelector(".AYi5wd.TBRnV"));
				totalReviews = total.get(0).getText();
				System.out.println("Total reviews: "+totalReviews);
				
			}
			catch(Exception e){}
		    
			try{
				rating = driver.findElement(By.className("BHMmbe")).getText();
				rating = rating.replace(".", ",");
				System.out.println("Rating: "+rating);
				
			}
			catch(Exception e){}
			
			try{	
				oceni = driver.findElements(By.className("L2o20d"));
				fiveStars = oceni.get(0).getAttribute("title");
				System.out.println("5 stars: "+fiveStars);
				
				fourStars = oceni.get(1).getAttribute("title");
				System.out.println("4 stars: "+fourStars);
				
				threeStars = oceni.get(2).getAttribute("title");
				System.out.println("3 stars: "+threeStars);
				
				twoStars = oceni.get(3).getAttribute("title");
				System.out.println("2 stars: "+twoStars);
				
				oneStar = oceni.get(4).getAttribute("title");
				System.out.println("1 star: "+oneStar);
			}
			catch(Exception e){	}
			
			osnovnoInfo = driver.findElements(By.className("htlgb"));
			
			try{
				installs = osnovnoInfo.get(2).getText();
				System.out.println("Number of installs: "+installs);
			}
			catch(Exception e){}
			
			try {
				updated = osnovnoInfo.get(0).getText();
				System.out.println("Last updated: "+updated);
			}
			catch(Exception e){}
			
			try {
				version = osnovnoInfo.get(4).getText();
				System.out.println("Required version: "+version);
				
			}
			catch(Exception e){}
			
			
			driver.get(linkovi.get(i)+"&showAllReviews=true");
			/*((JavascriptExecutor) driver)
				.executeScript("window.scrollTo(0, document.body.scrollHeight)");*/	
			
			
			int index=1;
			List<WebElement> comments = driver.findElements(By.xpath("//span[contains(@jsname, 'bN97Pc')]"));
			List<WebElement> commentRatings = driver.findElements(By.xpath("//div[contains(@class, 'pf5lIe')]"));
			System.out.println("Comments: ");
			int startingIndex=0;
			ExtractComments(driver,startingIndex);
			
			for(int j=0;j<konecnoComments.size();j++){
				
				System.out.print("\n");
				System.out.println(konecnoCommRatings.get(j) + " " + konecnoComments.get(j));
				
				String komentar = URLEncoder.encode(konecnoComments.get(j));
				
				
				writer.append(url);
				writer.append(separator+title);
				writer.append(separator+primary);
				writer.append(separator+category);
				writer.append(separator+price);
				writer.append(separator+totalReviews);
				writer.append(separator+rating);
				writer.append(separator+fiveStars);
				writer.append(separator+fourStars);
				writer.append(separator+threeStars);
				writer.append(separator+twoStars);
				writer.append(separator+oneStar);
				writer.append(separator+installs);
				writer.append(separator+updated);
				writer.append(separator+version);
				writer.append(separator+konecnoCommRatings.get(j));
				writer.append(separator+komentar);
				writer.append(separator+" ");
				writer.append("\n");
			}
			
			System.out.println("------------------------------------------------------------------------\n");
		}
		
		writer.close();
		driver.close();
		driver.quit();
	}
	
	int startingIndex=0;
	
	public static void ExtractComments (WebDriver driver,int startingIndex) {
		List<WebElement> comments = driver.findElements(By.xpath("//span[contains(@jsname, 'bN97Pc')]"));
		List<WebElement> commentRatings = driver.findElements(By.xpath("//div[contains(@class, 'pf5lIe')]"));
		
		if(comments.size() <= startingIndex) {
			return;
		}
		if(startingIndex > 0) {
			comments = comments.subList(startingIndex,comments.size());
			commentRatings = commentRatings.subList(startingIndex,commentRatings.size());
		}
		for(int i=0;i<comments.size();i++){
			String komentar = comments.get(i).getText();
			String rejting = commentRatings.get(i+1).findElement(By.tagName("div")).getAttribute("aria-label");
			String komentarRejting = rejting.replaceAll("[\\D]", "");
			//System.out.println(komentarRejting + " " + komentar);
			konecnoComments.add(komentar);
			konecnoCommRatings.add(komentarRejting);
			((JavascriptExecutor) driver)
			.executeScript("arguments[0].scrollIntoView()",comments.get(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			startingIndex++;
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ExtractComments(driver,startingIndex);
	}

}
