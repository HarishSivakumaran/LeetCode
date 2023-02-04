// 535. Encode and Decode TinyURL

public class Codec {

    HashMap<String, String> url2Code = new HashMap();
    HashMap<String, String> code2URL = new HashMap();
    String allChar = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLOMNOPQRSTUVWXYZ0912345678";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if (url2Code.containsKey(longUrl))
            return url2Code.get(longUrl);
        String key = "";
        do {
            for (int i = 0; i < 6; i++) {
                int index = (int) Math.random() * allChar.length();
                key += allChar.substring(index, index + 1);
            }
        } while (code2URL.containsKey(key));

        url2Code.put(longUrl, key);
        code2URL.put(key, longUrl);

        return key;

    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return code2URL.get(shortUrl);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));