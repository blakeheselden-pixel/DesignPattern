import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class CSVUsageReader implements UsageReader {
    private final String resourcePath;

    public CSVUsageReader(String resourcePath) { this.resourcePath = resourcePath; }

    @Override
    public double readUsage(String brand, String type) {
        try {
            InputStream in = getClass().getResourceAsStream(resourcePath);
            if (in == null) throw new RuntimeException("Missing resource: " + resourcePath);
            try (BufferedReader br = new BufferedReader(new InputStreamReader(in))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] p = line.split(",");
                    if (p.length < 3) continue;
                    if (p[0].trim().equalsIgnoreCase(brand)
                            && p[1].trim().equalsIgnoreCase(type)) {
                        return Double.parseDouble(p[2].trim());
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException("Failed to read usage for " + brand + "," + type, e);
        }
        throw new RuntimeException("No usage entry for " + brand + "," + type);
    }
}
