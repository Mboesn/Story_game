package story_game.text;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;

import org.yaml.snakeyaml.LoaderOptions;
import org.yaml.snakeyaml.Yaml;
import org.yaml.snakeyaml.constructor.Constructor;

public class PageLoader {

    /**
     * Loads all the pages in the index file.
     * 
     * @return A hashmap with the page id as the key, and page as value, empty if
     *         failed to load.
     */
    public static HashMap<String, PageYAML> loadPages() {
        try {
            // Loading index file which includes a list of all the YAML files.
            InputStream indexStream = PageLoader.class.getClassLoader().getResourceAsStream("pages/index.txt");

            if (indexStream == null)
                throw new RuntimeException("pages/index.txt not found");

            BufferedReader reader = new BufferedReader(new InputStreamReader(indexStream));
            List<String> pageNames = reader.lines().toList();

            // For every page load it and insert in hashmap.
            Yaml yaml = new Yaml();
            HashMap<String, PageYAML> pages = new HashMap<>();
            for (String name : pageNames) {
                if (!name.equals("")) {
                    InputStream pageStream = PageLoader.class.getClassLoader()
                            .getResourceAsStream("pages/" + name + ".yaml");

                    if (pageStream == null)
                        throw new RuntimeException("pages/" + name + " not found");

                    PageDTO pageDTO = yaml.loadAs(pageStream, PageDTO.class);
                    PageYAML page = new PageYAML(pageDTO.id, pageDTO.text);
                    pages.put(page.id(), page);
                }
            }
            return pages;
        } catch (Exception e) {
            System.out.println("failed to load game\nerror: " + e);
            e.printStackTrace();
        }
        return new HashMap<>();
    }
}
