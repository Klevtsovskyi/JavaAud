package T11_WebClients;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class A11_01 {

	public static void main(String[] args) {
		String url = "https://slovnyk.ua/?swrd=";
		
		Scanner in = new Scanner(System.in);
		System.out.print("Введіть слово: ");
		String word = in.next();
//		String word = "куховар";
		
		url = url + word;
		String html = getHtml(url);
//		System.out.println(html);
		String result = getDefinition(html);
		System.out.println(result);

		in.close();
	}
	
	public static String getDefinition(String html) {
		Pattern p = Pattern.compile("<div class=\"toggle-content\".*?>(.*?)</div>", Pattern.DOTALL);
		Matcher m = p.matcher(html);
		
		if (!m.find()) {
			System.err.println("Нема :(");
			return "";
		}
		return m.group(1).replaceAll("<.+?>", "").trim();
	}
	
	public static String getHtml(String url) {
		URI uri = URI.create(url);
		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder()
//			.GET()
//			.header("user-agent", "hello!")
			.uri(uri)
			.build();
		try {
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			System.out.println(request.uri());
			System.out.println("Status: " + response.statusCode());
//			System.out.println(response.headers());
			return response.body();
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
		return "";
	}

}