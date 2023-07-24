package menu;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileUrlResource;

import bean.Menu;
import jakarta.annotation.Resources;

/**
 * @author takeshitakonomi
 */
public class Menuload {
	public List<Menu> menucsv(){
		List<Menu> menulist = new ArrayList<>();
		String targetPath = "/public";
		
		BufferedReader br = null;
		// ファイルから読み取った行を連結する
		StringBuilder sb = new StringBuilder();
					
        try {
			ClassPathResource resource = new ClassPathResource(targetPath + "/menu.csv");
			InputStream in = resource.getInputStream();
			br = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8));
			String line = null;
			while((line = br.readLine()) != null) {
				Pattern cPattern = Pattern.compile(",(?=(([^\"]*\"){2})*[^\"]*$)"); 
	            String[] columns = cPattern.split(line, -1); 
				Menu menu = new Menu(columns);
	            menulist.add(menu);
			}
			// StringBuilderの初期化
	            sb.setLength(0);
	            
			} catch (Exception e) {
				e.printStackTrace();
	            System.out.println(e.getMessage());
	        } finally {
				if (null != br) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
						// todo nothing.
					}
				}
			}
	        
	        return menulist;
	
        
	}
}
