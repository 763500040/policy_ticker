package cn.com.aaic.policyticker.util;

public class GetPreAndAm {

	public double[] getPremiumAndAmount(String CompanyType, String SubdivideType, String policyGrade,
			String numEmployeesStr) {
		// 加油站特殊处理
		if (SubdivideType.equals("加油站")) {
			if (policyGrade.equals("基础版")) {
				return new double[] { 300, 200, 60, 4700.00 };
			} else if (policyGrade.equals("升级版")) {
				return new double[] { 500, 300, 80, 9000.00 };
			} else if (policyGrade.equals("优化版")) {
				return new double[] { 800, 400, 100, 13200.00 };
			} else {
				return null;
			}
		}
		
		// 开始匹配计算对应保费保额
		int sumEmployees = Integer.parseInt(numEmployeesStr);
		if (sumEmployees <= 1000) {
			double[] arr = this.getPremiumAndAmount(CompanyType, SubdivideType, policyGrade, sumEmployees);
			return arr;
		} else {
			double[] arr = this.getPremiumAndAmount(CompanyType, SubdivideType, policyGrade, 1000);
			int addKs = (int) Math.ceil((sumEmployees - 1000d) / 1000d);
			arr[0] = arr[0] + (CalculateUtil.bigDecimalMultiply( addKs , 1500d));

			if (policyGrade.equals("基础版")) {
				arr[3] = arr[3] + CalculateUtil.bigDecimalMultiply(addKs , 15000d);
				arr[1] = CalculateUtil.bigDecimaldivide(arr[0] , 2);   
			} else if (policyGrade.equals("升级版")) {
				arr[3] = arr[3] + CalculateUtil.bigDecimalMultiply(addKs , 23400d);
				arr[1] = CalculateUtil.bigDecimaldivide(arr[0] , 2);   
			} else if (policyGrade.equals("优化版")) {
				arr[3] = arr[3] + CalculateUtil.bigDecimalMultiply(addKs , 33600d);
				arr[1] = CalculateUtil.bigDecimaldivide(arr[0] , 2);   
			} else {
				return null;
			}
			return arr;
		}
	}

	public double[] getPremiumAndAmount(String CompanyType, String SubdivideType, String policyGrade,
			int numEmployees) {
		if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("基础版") && numEmployees >= 1
				&& numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 15600.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 31200.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("基础版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 41600.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 30000.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 48700.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("升级版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 64900.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 43700.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 69900.0;
			return arr;
		} else if (CompanyType.equals("危化生产类") && SubdivideType.equals("生产型") && policyGrade.equals("优化版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 93200.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 12500.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 25000.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("基础版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 33300.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 24000.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 38900.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("升级版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 51900.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 34900.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 55900.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("持有使用类许可证") && policyGrade.equals("优化版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 74500.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 8700.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 17500.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("基础版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 23300.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 16800.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 27300.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("升级版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 36300.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 24400.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 39200.0;
			return arr;
		} else if (CompanyType.equals("危化使用类") && SubdivideType.equals("其他") && policyGrade.equals("优化版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 52200.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 3600.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 7300.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 15900.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 6900.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 11400.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 24800.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 10080.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 16400.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（不带储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 35600.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 5200.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 10400.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("基础版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 22800.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 10000.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 16200.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("升级版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 35500.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 14600.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 23300.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("仓储") && policyGrade.equals("优化版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 51000.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 5700.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 11400.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("基础版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 25000.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 10900.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 17800.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("升级版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 39000.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 16000.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 300) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 25600.0;
			return arr;
		} else if (CompanyType.equals("危化经营型") && SubdivideType.equals("经营、批发（带有储存设施）") && policyGrade.equals("优化版")
				&& numEmployees >= 301 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 56000.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("基础版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 12500.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("基础版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 24960.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("基础版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 33300.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("升级版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 24000.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("升级版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 38900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("升级版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 51900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("优化版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 34900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("优化版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 55900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("使用危险化学品构成重大危险源；使用液氨制冷；涉及镁铝粉的粉尘涉爆")
				&& policyGrade.equals("优化版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 74500.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("基础版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 12500.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("基础版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 25000.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("基础版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 33300.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("升级版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 24000.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("升级版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 38900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("升级版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 51900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("优化版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 34900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("优化版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 55900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("从事达到国家规定规模（体量）的高温熔融金属及熔渣的冶金企业和有色金属企业")
				&& policyGrade.equals("优化版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 74500.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("基础版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 8700.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("基础版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 17500.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("基础版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 23300.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("升级版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 16800.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("升级版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 27300.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("升级版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 36300.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("优化版") && numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 24400.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("优化版") && numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 39200.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业")
				&& SubdivideType.equals("其他化工企业（含石油、医药化工）；粉尘涉爆工贸企业（镁铝粉除外）；存在有限空间作业；涉及典型危险化学品；存在高温熔融金属工艺的机构加工企业")
				&& policyGrade.equals("优化版") && numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 52200.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("基础版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 300.0;
			arr[1] = 200.0;
			arr[2] = 60.0;
			arr[3] = 15600.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("基础版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 600.0;
			arr[1] = 300.0;
			arr[2] = 60.0;
			arr[3] = 31200.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("基础版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 1500.0;
			arr[1] = 800.0;
			arr[2] = 60.0;
			arr[3] = 41600.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("升级版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 500.0;
			arr[1] = 300.0;
			arr[2] = 80.0;
			arr[3] = 30000.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("升级版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 500.0;
			arr[2] = 80.0;
			arr[3] = 48700.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("升级版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2000.0;
			arr[1] = 1000.0;
			arr[2] = 80.0;
			arr[3] = 64900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("优化版")
				&& numEmployees >= 1 && numEmployees <= 100) {
			double[] arr = new double[4];
			arr[0] = 800.0;
			arr[1] = 400.0;
			arr[2] = 100.0;
			arr[3] = 43700.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("优化版")
				&& numEmployees >= 101 && numEmployees <= 500) {
			double[] arr = new double[4];
			arr[0] = 1000.0;
			arr[1] = 600.0;
			arr[2] = 100.0;
			arr[3] = 69900.0;
			return arr;
		} else if (CompanyType.equals("工贸类企业") && SubdivideType.equals("其他单位") && policyGrade.equals("优化版")
				&& numEmployees >= 501 && numEmployees <= 1000) {
			double[] arr = new double[4];
			arr[0] = 2500.0;
			arr[1] = 1500.0;
			arr[2] = 100.0;
			arr[3] = 93200.0;
			return arr;
		} else {
			return null;
		}

	}
}
