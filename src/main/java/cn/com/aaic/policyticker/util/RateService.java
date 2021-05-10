package cn.com.aaic.policyticker.util;

/**
 * 费率调整系数参与保费自动计算的规则
 */
public class RateService {
	
	
	public static double getRateCoefficient(String one ,String two ,String three, String four , String five , String six ,String seven ,String eight,String ten) {
		double  rate  = 1;

		rate =  CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("是否被纳入安全生产领域失信联合惩戒名单", two));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("安全生产标准化等级", three));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("安全风险等级", four));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("隐患排查治理情况", five));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("上年生产安全事故发生情况", six));
		//取以上2.1-2.5调整系数的乘积，且以0.7-1.3为限				
		if(rate<0.7) rate = 0.7;
		if(rate>1.3) rate = 1.3;

		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("涉及两重点一重大", one));
		
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("安全生产违法行为行政处罚", seven));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("坐落地", eight));
		rate = CalculateUtil.bigDecimalMultiply( rate  , getRateCoefficient("上年事故预防服务落实情况", ten));
		
		return rate;
	};
	
    /**
     * @param coefficientName 调整系数名称
     * @param selectName 选项
     * @return 费率系数
     */
    public static double getRateCoefficient(String coefficientName,String selectName){
        double rateCoefficient=0.0;
        switch (coefficientName){
            case "涉及两重点一重大":
                if ("是".equals(selectName)){
                    rateCoefficient=1.5;
                }else if ("否".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"是否被纳入安全生产领域失信联合惩戒名单":
                if ("是".equals(selectName)){
                    rateCoefficient=1.1;
                }else if ("否".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"安全生产标准化等级":
                if ("一级".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("二级".equals(selectName)){
                    rateCoefficient=0.95;
                }else if ("三级".equals(selectName)){
                    rateCoefficient=1;
                }else if ("未参加评定".equals(selectName)){
                    rateCoefficient=1.05;
                }else if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"安全风险等级":
                if ("A".equals(selectName)){
                    rateCoefficient=1.1;
                }else if ("B".equals(selectName)){
                    rateCoefficient=1;
                }else if ("C".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("D".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("未参加评定".equals(selectName)){
                    rateCoefficient=1.05;
                }else if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"隐患排查治理情况":
                if ("开展排查已治理".equals(selectName)){
                    rateCoefficient=0.95;
                }else if ("开展排查未治理".equals(selectName)){
                    rateCoefficient=1.05;
                }else if ("未开展排查".equals(selectName)){
                    rateCoefficient=1.1;
                }else if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"上年生产安全事故发生情况":
                if ("未发生事故".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("发生事故无人员死亡".equals(selectName)){
                    rateCoefficient=1.1;
                }else if ("发生事故有人员死亡".equals(selectName)){
                    rateCoefficient=1.3;
                }else if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"安全生产违法行为行政处罚":
                if ("上年未发生".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("上年发生1次".equals(selectName)){
                    rateCoefficient=1;
                }else if ("上年发生2次".equals(selectName)){
                    rateCoefficient=1.1;
                }else if ("上年发生3次".equals(selectName)){
                    rateCoefficient=1.2;
                }else if ("上年发生4次".equals(selectName)){
                    rateCoefficient=1.3;
                }else if ("上年发生5次".equals(selectName)){
                    rateCoefficient=1.4;
                }else if ("上年发生6次".equals(selectName)){
                    rateCoefficient=1.5;
                }else if ("上年发生7次".equals(selectName)){
                    rateCoefficient=1.6;
                }else if ("上年发生8次".equals(selectName)){
                    rateCoefficient=1.7;
                }else if ("上年发生9次".equals(selectName)){
                    rateCoefficient=1.8;
                }else if ("上年发生10次".equals(selectName)){
                    rateCoefficient=1.9;
                }else if ("上年发生11次及以上".equals(selectName)){
                    rateCoefficient=2;
                }else if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }
                break;
            case"坐落地":
                if ("外环线以外或工业园区内".equals(selectName)){
                    rateCoefficient=1;
                }else if ("外环线以内（含）或不在工业园区内".equals(selectName)){
                    rateCoefficient=1.2;
                }
                break;
            case"禁限控风险":
                if ("不涉及禁限控危险化学品的企业".equals(selectName)){
                    rateCoefficient=1;
                }else if ("涉及禁限控危险化学品的企业".equals(selectName)){
                    rateCoefficient=1.2;
                }
                break;
            case"上年事故预防服务落实情况":
                if ("新保".equals(selectName)){
                    rateCoefficient=1;
                }else if ("良好".equals(selectName)){
                    rateCoefficient=0.9;
                }else if ("一般".equals(selectName)){
                    rateCoefficient=1;
                }else if ("较差".equals(selectName)){
                    rateCoefficient=1.1;
                }
                break;
            default :
                rateCoefficient=0.0;
        }
        return rateCoefficient;
    }
}
