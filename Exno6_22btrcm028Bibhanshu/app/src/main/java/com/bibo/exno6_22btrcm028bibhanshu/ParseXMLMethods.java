package com.bibo.exno6_22btrcm028bibhanshu;

import android.view.PixelCopy;

import com.google.firebase.crashlytics.buildtools.reloc.org.apache.http.HttpEntity;

import java.io.StringReader;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import cz.msebera.android.httpclient.HttpResponse;
import cz.msebera.android.httpclient.client.methods.HttpPost;
import cz.msebera.android.httpclient.impl.client.DefaultHttpClient;
import cz.msebera.android.httpclient.util.EntityUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
public class ParseXMLMethods {
    public final static Document XMLfromString(String xml){
        Document doc = null;
        DocumentBuilderFactory dbf =
                DocumentBuilderFactory.newInstance();
        try {

            DocumentBuilder db = dbf.newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xml));
            doc = db.parse(is);

        } catch (Exception e){}
        return doc;
    }
    public final static String getElementValue( Node elem ) {
        Node kid;
        if( elem != null){
            if (elem.hasChildNodes()){
                for( kid = elem.getFirstChild(); kid != null; kid =
                        kid.getNextSibling() ){
                    if( kid.getNodeType() == Node.TEXT_NODE ){
                        return kid.getNodeValue();
                    }
                }
            }
        }
        return "";
    }
    public static String getXML() {
        OkHttpClient client = new OkHttpClient();  // Create OkHttpClient instance
        String url = "http://aravindonlineclasses.com/madlab/Rss.xml";  // URL for the request

        try {
            // Create an HTTP request with the specified URL
            Request request = new Request.Builder()
                    .url(url)
                    .build();

            // Execute the request and get the response
            Response response = client.newCall(request).execute();

            // Return the response as a string
            return response.body().string();
        } catch (Exception e) {
            return "Internet Connection Error >> " + e.getMessage();  // Handle exceptions
        }
    }
    public static int numResults(Document doc){
        Node results = doc.getDocumentElement();
        int res = -1;
        try{
            res =
                    Integer.valueOf(results.getAttributes().getNamedItem("count").getNodeValue())
            ;
        }catch(Exception e ){
            res = -1;
        }
        return res;
    }
    public static String getValue(Element item, String str) {
        NodeList n = item.getElementsByTagName(str);
        return ParseXMLMethods.getElementValue(n.item(0));
    }
}
