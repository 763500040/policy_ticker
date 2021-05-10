package cn.com.aaic.policyticker.controller;

import java.math.BigDecimal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import cn.com.aaic.policyticker.util.CalculateUtil;
import cn.com.aaic.policyticker.util.GetPreAndAm;
import cn.com.aaic.policyticker.util.RateService;

@Controller
public class TickerController {
	
	@RequestMapping("ticker")
	public String ticker(HttpServletRequest request) {
		return "ticker";
	}
	
	
	@RequestMapping("rate")
	public String rate(HttpServletRequest request, Model model) {
		String companyName = request.getParameter("companyName");
		String CompanyType = request.getParameter("CompanyType");
		String SubdivideType = request.getParameter("SubdivideType");
		String numEmployees = request.getParameter("numEmployees");
		String policyGrade = request.getParameter("policyGrade");
		
		double sumAmount = 0;
		double singleAccidentAmount = 0;
		double singleManAmount =0;
		double basePremium = 0;
		
		GetPreAndAm getPreAndAm = new GetPreAndAm();
		double[] arr = getPreAndAm.getPremiumAndAmount(CompanyType, SubdivideType, policyGrade, numEmployees);
		sumAmount = arr[0];
		singleAccidentAmount = arr[1];
		singleManAmount = arr[2];
		basePremium = arr[3];
		
		model.addAttribute("companyName",companyName);
		model.addAttribute("CompanyType",CompanyType);
		model.addAttribute("SubdivideType",SubdivideType);
		model.addAttribute("numEmployees",numEmployees);
		model.addAttribute("policyGrade",policyGrade);
		model.addAttribute("sumAmount",sumAmount); //总保额
		model.addAttribute("singleAccidentAmount",singleAccidentAmount); //单人赔偿限额
		model.addAttribute("singleManAmount",singleManAmount);  //单次事故赔偿限额
		model.addAttribute("basePremium",basePremium);  //基础保费
		
		return "rate";
	}
	
	
	@RequestMapping(value = "jisuanPremium",  method = RequestMethod.POST)
	public String jisuanPremium(@RequestParam Map<String,Object> map,  HttpServletRequest request ,Model model) {
		double rateCoefficient = RateService.getRateCoefficient((String)map.get("one"),
				(String)map.get("two"),
				(String)map.get("three"),
				(String)map.get("four"),
				(String)map.get("five"),
				(String)map.get("six"),
				(String)map.get("seven"),
				(String)map.get("eight"),
				(String)map.get("ten")
				);
		
		//计算最终保费，保留两位小数
		double realPremium =(Double.parseDouble((String)map.get("basePremium"))) * rateCoefficient;
        BigDecimal bg = new BigDecimal(realPremium);
        realPremium = bg.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        model.addAttribute("realPremium",realPremium);  //总保费
        
        double sumAmoumt = Double.parseDouble((String)(map.get("sumAmount")));
        //费用  所有费用都是 10%
        double fee = CalculateUtil.bigDecimalMultiply(sumAmoumt, 0.1d);
        model.addAttribute("fee",fee);  //总保费
        
         //将10个系数给转义掉
        model.addAttribute("oneMean",RateService.getRateCoefficient("涉及两重点一重大", (String)(map.get("one"))));
        model.addAttribute("twoMean",RateService.getRateCoefficient("是否被纳入安全生产领域失信联合惩戒名单", (String)(map.get("two"))));
        model.addAttribute("threeMean",RateService.getRateCoefficient("安全生产标准化等级", (String)(map.get("three"))));
        model.addAttribute("fourMean",RateService.getRateCoefficient("安全风险等级", (String)(map.get("four"))));
        model.addAttribute("fiveMean",RateService.getRateCoefficient("隐患排查治理情况",(String)(map.get("five"))));
        model.addAttribute("sixMean",RateService.getRateCoefficient("上年生产安全事故发生情况",(String)(map.get("six")) ));
        model.addAttribute("sevenMean",RateService.getRateCoefficient("安全生产违法行为行政处罚", (String)(map.get("seven"))));
        model.addAttribute("eightMean",RateService.getRateCoefficient("坐落地",(String)(map.get("eight")) ));
        model.addAttribute("tenMean",RateService.getRateCoefficient("上年事故预防服务落实情况", (String)(map.get("ten"))));
        
        
		map.forEach((key, value) -> {
			model.addAttribute(key,value);
		});
		
		return "jisuanPremium";
	}
}
