package leetcode.medium.string;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class EncodeDecodeTinyURL {
    /*
    Note: This is a companion problem to the System Design problem: Design TinyURL.
TinyURL is a URL shortening service where you enter a
URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.

Design the encode and decode methods for the TinyURL service.
 There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL
     */

    Map<Integer, String> map = new HashMap<>();
    Random random = new Random();
    int key = random.nextInt(Integer.MAX_VALUE);
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {

        while(map.containsKey(key))
        {
            key = random.nextInt(Integer.MAX_VALUE);
        }
        map.put(key, longUrl);

        return "http://tinyurl.com/" + key;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {

        String keyFromUrl = shortUrl.replace("http://tinyurl.com/", "");

        return map.get(Integer.parseInt(keyFromUrl));

    }

    /*
    The number of URLs that can be encoded is limited by the range of \text{int}int.

The average length of the codes generated is independent of the \text{longURL}longURL's length, since a random integer is used.

The length of the URL isn't necessarily shorter than the incoming \text{longURL}longURL. It is only dependent on the relative order in which the URLs are encoded.

Since a random number is used for coding, again, as in the previous case, the number of collisions could increase with the increasing number of input strings, leading to performance degradation.

Determining the encoded URL isn't possible in this scheme, since we make use of random numbers.


     */
}
