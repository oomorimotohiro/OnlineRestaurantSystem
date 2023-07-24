package menu;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
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

public class Menuload {
	public List<Menu> menucsv() {
		List<Menu> menulist = new ArrayList<>();
		String targetPath = "/public";
		
		BufferedReader br = null;
		String menu_csv = "C:\\Users\\DC-PCN1144\\Desktop\\menu.csv";

		try {
			File file = new File(menu_csv);
			br = new BufferedReader(new FileReader(file));
			// ファイルから読み取った行を連結する
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = br.readLine()) != null) {
				Pattern cPattern = Pattern.compile(",(?=(([^\"]*\"){2})*[^\"]*$)");
				String[] columns = cPattern.split(line, -1);

				Menu menu = new Menu();

				menu.setRanking(columns[0]);
				menu.setName(columns[1]);
				menu.setKcal(columns[2].replace("\"", ""));
				menu.setPrice(columns[3].replace("\"", ""));
				menu.setCount(columns[4]);

				menulist.add(menu);
			}
			// StringBuilderの初期化
			sb.setLength(0);

		} catch (Exception e) {
			System.out.println(e.getMessage());

		} finally {
			try {
				br.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}

		return menulist;
	}
}
