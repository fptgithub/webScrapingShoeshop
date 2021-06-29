package webscrapingjava5.main.utils;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

public class WebClienUtil {

	public static String getPage(String url) {
		WebClient web = new WebClient();
		web.getOptions().setThrowExceptionOnScriptError(false);
		try {
			HtmlPage page = web.getPage(url);
			return page.asXml();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}
}
