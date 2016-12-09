package com.fpds.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import java.util.Map;

public class HTTPRequest {

    private static String CHARSET = "utf-8";
    
    public static String doGet(String url){
        
        StringBuffer resultBuffer = null;
		try {
			URL localURL = new URL(url);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection)localURL.openConnection();
			
			httpURLConnection.setRequestProperty("Accept-Charset", CHARSET);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			
			InputStream inputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader reader = null;
			resultBuffer = new StringBuffer();
			String tempLine = null;
			
			if (httpURLConnection.getResponseCode() >= 300) {
			    throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
			}
			
			try {
			    inputStream = httpURLConnection.getInputStream();
			    inputStreamReader = new InputStreamReader(inputStream);
			    reader = new BufferedReader(inputStreamReader);
			    
			    while ((tempLine = reader.readLine()) != null) {
			        resultBuffer.append(tempLine);
			    }
			    
			} finally {
			    
			    if (reader != null) {
			        reader.close();
			    }
			    
			    if (inputStreamReader != null) {
			        inputStreamReader.close();
			    }
			    
			    if (inputStream != null) {
			        inputStream.close();
			    }
			    
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

        return resultBuffer.toString();
    }
    
    /**
     * Do POST request
     * @param url
     * @param parameterMap
     * @return
     * @throws Exception 
     */
    public static String doPost(String url, Map<Object,Object> parameterMap){
        StringBuffer resultBuffer = null;
		try {
			 /* Translate parameter map to parameter date string */
			StringBuffer parameterBuffer = new StringBuffer();
			if (parameterMap != null) {
			    @SuppressWarnings("rawtypes")
				Iterator iterator = parameterMap.keySet().iterator();
			    String key = null;
			    String value = null;
			    while (iterator.hasNext()) {
			        key = (String)iterator.next();
			        if (parameterMap.get(key) != null) {
			            value = (String)parameterMap.get(key);
			        } else {
			            value = "";
			        }
			        
			        parameterBuffer.append(key).append("=").append(value);
			        if (iterator.hasNext()) {
			            parameterBuffer.append("&");
			        }
			    }
			}
			
			System.out.println("POST parameter : " + parameterBuffer.toString());
			
			URL localURL = new URL(url);
			
			HttpURLConnection httpURLConnection = (HttpURLConnection) localURL.openConnection();
			
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setRequestMethod("POST");
			httpURLConnection.setRequestProperty("Accept-Charset", CHARSET);
			httpURLConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
			httpURLConnection.setRequestProperty("Content-Length", String.valueOf(parameterBuffer.length()));
			
			OutputStream outputStream = null;
			OutputStreamWriter outputStreamWriter = null;
			InputStream inputStream = null;
			InputStreamReader inputStreamReader = null;
			BufferedReader reader = null;
			resultBuffer = new StringBuffer();
			String tempLine = null;
			
			try {
			    outputStream = httpURLConnection.getOutputStream();
			    outputStreamWriter = new OutputStreamWriter(outputStream);
			    
			    outputStreamWriter.write(parameterBuffer.toString());
			    outputStreamWriter.flush();
			    int code = httpURLConnection.getResponseCode();
			    if (code >= 300) {
			        throw new Exception("HTTP Request is not success, Response code is " + httpURLConnection.getResponseCode());
			    }
			    
			    inputStream = httpURLConnection.getInputStream();
			    inputStreamReader = new InputStreamReader(inputStream);
			    reader = new BufferedReader(inputStreamReader);
			    
			    while ((tempLine = reader.readLine()) != null) {
			        resultBuffer.append(tempLine);
			    }
			} finally {
			    
			    if (outputStreamWriter != null) {
			        outputStreamWriter.close();
			    }
			    
			    if (outputStream != null) {
			        outputStream.close();
			    }
			    
			    if (reader != null) {
			        reader.close();
			    }
			    
			    if (inputStreamReader != null) {
			        inputStreamReader.close();
			    }
			    
			    if (inputStream != null) {
			        inputStream.close();
			    }
			    
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        return resultBuffer.toString();
    }
    
    /***
     * 从流中完整的读入数据
     * @param inStream
     * @return byte[]
     * @throws IOException
     */
    public static byte[] readAsByteArray(InputStream inStream) throws IOException {
        int size = 1024;
        byte[] buff = new byte[size];
        int readSoFar = 0;
        while (true) {
            int nRead = inStream.read(buff, readSoFar, size - readSoFar);
            if (nRead == -1) {
                break;
            }
            readSoFar += nRead;
            if (readSoFar == size) {
                int newSize = size * 2;
                byte[] newBuff = new byte[newSize];
                System.arraycopy(buff, 0, newBuff, 0, size);
                buff = newBuff;
                size = newSize;
            }
        }
        byte[] newBuff = new byte[readSoFar];
        System.arraycopy(buff, 0, newBuff, 0, readSoFar);
        return newBuff;
    }

    public static String doPost(String url,String data){
    	  PrintWriter out = null;
          BufferedReader in = null;
          String result = "";
          try {
              URL realUrl = new URL(url);
              // 打开和URL之间的连接
              URLConnection conn = realUrl.openConnection();
              // 设置通用的请求属性
              conn.setRequestProperty("accept", "*/*");
              conn.setRequestProperty("connection", "Keep-Alive");
              conn.setRequestProperty("user-agent",
                      "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
              // 发送POST请求必须设置如下两行
              conn.setDoOutput(true);
              conn.setDoInput(true);
              // 获取URLConnection对象对应的输出流
              out = new PrintWriter(conn.getOutputStream());
              // 发送请求参数
              out.print(data);
              // flush输出流的缓冲
              out.flush();
              // 定义BufferedReader输入流来读取URL的响应
              in = new BufferedReader(
                      new InputStreamReader(conn.getInputStream()));
              String line;
              while ((line = in.readLine()) != null) {
                  result += line;
              }
          } catch (Exception e) {
              System.out.println("发送 POST 请求出现异常！"+e);
              e.printStackTrace();
          }
          //使用finally块来关闭输出流、输入流
          finally{
              try{
                  if(out!=null){
                      out.close();
                  }
                  if(in!=null){
                      in.close();
                  }
              }
              catch(IOException ex){
                  ex.printStackTrace();
              }
          }
          return result;
      }    
}

