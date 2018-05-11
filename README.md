# PlayStoreCrawler

Станува збор за crawler кој е направен со Java и Selenium. Crawler-от ги собира сите информации и коментари за низа од Google Play Store апликации.

## Како функционира?

Кодот има листа од линкови од апликации кои ги изминува поединечно со for циклус.
Во циклусот за секоја апликација ги наоѓа и складира основните информации. На пример, кодот за насловот е: 

```
title = driver.findElement(By.className("AHFaub")).getText();  
```

Откако ќе ги собере информациите (title, subtitle, category, price, reviews, rating, installs, 1-5 stars, updated, version), на ред се коментарите кои најпрво треба да ги излиста и складира. За да ги излиста потребно е google drive-от да прави scroll кој е имплементиран со JavaScript. Кодот за коментарите изгледа вака:

```
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
			konecnoComments.add(komentar);
			konecnoCommRatings.add(komentarRejting);
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView()",comments.get(i));
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			startingIndex++;
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		ExtractComments(driver,startingIndex);
	}
```

За крај, откатко сите потребни информации се собрани, заедно со сите коментари, кодот креира нов фајл со наслов rezultati.csv. Без разлика дали rezultati.csv постои или не, кодот генерира нов фајл rezultati.csv кој понатаму ќе се пополни со ифнормациите собрани од crawler-от.
