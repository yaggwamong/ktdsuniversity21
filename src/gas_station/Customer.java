package gas_station;
/**
 * 고객
 * @author User
 *
 */
public class Customer {

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
	public void buy(String gas,Customer customer,int orderQty) {
		customer.sell(orderQty);
		if(gas.equals("gasolion")) {
			
			
		}
		this.stock = this.stock + orderQty;
		this.pay(seller,orderQty);
	
}

