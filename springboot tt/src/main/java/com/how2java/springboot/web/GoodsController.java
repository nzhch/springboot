package com.how2java.springboot.web;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.IntArraySerializer;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.how2java.springboot.pojo.Goods;
import com.how2java.springboot.pojo.Account;
import com.how2java.springboot.service.GoodsService;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.OutputStream;

@RestController
public class GoodsController {
	@Autowired GoodsService goodservice;
	
	/*restful 部分*/

    
	@PostMapping("/hello")
    public String add(@RequestBody Account acc) throws Exception {
        //System.out.println(acc);
        return "success";
    }
    @CrossOrigin
    @RequestMapping("/goods")
    public void request(HttpServletRequest request, HttpServletResponse response,@RequestParam("name")String name) {
        
        try {
            BufferedReader streamReader = new BufferedReader( new InputStreamReader(request.getInputStream(), "UTF-8"));
            StringBuffer responseStrBuilder = new StringBuffer();
            String inputStr;
            while ((inputStr = streamReader.readLine()) != null)
                responseStrBuilder.append(inputStr);
            
            
            System.out.println(responseStrBuilder);
            JSONObject jsonObject = JSONObject.parseObject(responseStrBuilder.toString());
            
            createExcel(jsonObject,name,response);
            
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    
    
    
    
    
    public void createExcel(JSONObject jsonObject,String name,HttpServletResponse response) {
    	String[] heads= {"商品名称","商品ID","日期","商品收藏数","商品访客数","商品浏览量","支付订单数","支付转化率","支付件数","支付买家数","支付金额","成团订单数","成团件数","是否新款"};
        SXSSFWorkbook workbook = new SXSSFWorkbook();// 创建一个Excel文件
        SXSSFSheet sheet = workbook.createSheet();// 创建一个Excel的Sheet
        SXSSFRow titleRow = sheet.createRow(0);//创建表头
        for(int i=0;i<heads.length;i++){//表头赋值
            titleRow.createCell(i).setCellValue(heads[i]);
        }

    	Integer n=jsonObject.size();
    	JSONObject tf=JSONObject.parseObject((String) jsonObject.get(0));
    	boolean p=(boolean)tf.get("success");
    	System.out.println(p);
    	try {
        	int j=0;
        	
    		for(int x=0;x<n;x++)
            {
        		
        		JSONObject number=JSONObject.parseObject((String) jsonObject.get(x));
                JSONArray result =number.getJSONArray("result");
                if (result.size() > 0) {//单元格赋值
                	
                    for (int i = 0; i < result.size(); i++) {
                        
                        JSONObject json = result.getJSONObject(i); // 遍历 jsonarray 
                       
                        if(json.get("goodsName")!=null)
                        {
                        	
                        SXSSFRow row = sheet.createRow(j + 1);
                        row.createCell(0).setCellValue(json.get("goodsName").toString());//商品名称
                        row.createCell(1).setCellValue(json.get("goodsId").toString());//商品ID
                        row.createCell(2).setCellValue(json.get("statDate").toString());//日期
                        row.createCell(3).setCellValue(json.get("goodsFavCnt").toString());//商品收藏数
                        row.createCell(4).setCellValue(json.get("goodsUv").toString());//商品访客数
                        row.createCell(5).setCellValue(json.get("goodsPv").toString());//商品浏览量
                        row.createCell(6).setCellValue(json.get("payOrdrCnt").toString());//支付订单数
                        row.createCell(7).setCellValue(json.get("goodsVcr").toString());//支付转化率
                        row.createCell(8).setCellValue(json.get("payOrdrGoodsQty").toString());//支付件数
                        row.createCell(9).setCellValue(json.get("payOrdrUsrCnt").toString());//支付买家数
                        row.createCell(10).setCellValue(json.get("payOrdrAmt").toString());//支付金额
                        row.createCell(11).setCellValue(json.get("cfmOrdrCnt").toString());//成团订单数
                        row.createCell(12).setCellValue(json.get("cfmOrdrGoodsQty").toString());//成团件数
                        row.createCell(13).setCellValue(json.get("isNewstyle").toString());//是否新款*/
                        j++;
                        }

                    }
                }       
    	}
		} finally {
			// TODO: handle finally clause
	        try {
	        	String path="/"+name+".xls";
	        	//OutputStream f=new FileOutputStream(path);
	        	//workbook.write(f);
	        	System.out.println("woc");				
	        	response.setContentType("application/ vnd.ms-excel");
	        	response.addHeader("Content-Disposition", "attachment; filename=test.xls");
	        	//response.setHeader("Access-Control-Allow-Origin", "*");
	        	OutputStream out1 = response.getOutputStream();
	            workbook.write(out1);
	            out1.flush();
	            
	            //f.flush();
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
		
		}
    	

    	   
          
            	
    	



}

