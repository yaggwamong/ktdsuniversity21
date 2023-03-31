package gas_station;

import market.Seller;

/**
 * 주유소
 * @author User
 *
 */
public class GasStation {
	/**
	 * 재고
	 */
	private int gasolion;
	private int via;
	private int lpg;	
	
	/**
	 * 자본금
	 */
	private int money;

	public int getGasolion() {
		return gasolion;
	}

	public void setGasolion(int gasolion) {
		this.gasolion = gasolion;
	}

	public int getVia() {
		return via;
	}

	public void setVia(int via) {
		this.via = via;
	}

	public int getLpg() {
		return lpg;
	}

	public void setLpg(int lpg) {
		this.lpg = lpg;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	public void sell(String gas,int orderQty) {
		if(gas.equals("gasolion")) {
			this.gasolion = this.gasolion-orderQty;
		}
		else if (gas.equals("via")) {
			this.via = this.via-orderQty;
			}
		else {
			this.gasolion = this.gasolion-orderQty;
		}
	}
	public void addMoney(int money) {
		this.money= this.money+money;
	}
	public String toString() {
		return "구매자: 재고: "+ this.gasolion+"L, "
				+ "+ this.via+\"L,"
				+ "+ this.lpg+\"L,"
				+ "자본금: "+this.money+"원";
	}
		

		
	
	
	


}
