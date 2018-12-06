package webShop;

public class WarehouseType implements Warehouse {

	@Override
	public void invoiceProcessing() {
		
		System.out.println("--------------------------");
		System.out.println("Order is being processed for transport...");

	}

	@Override
	public void findCustomerItem() {
		
		
		System.out.println("--------------------------");
		System.out.println("Item is found i warehouse storage");

	}

	@Override
	public void packingItems() {
		
		System.out.println("--------------------------");
		System.out.println("Order is being packing");

	}

	@Override
	public void dispatchment() {
		System.out.println("--------------------------");
		System.out.println("Order is dispatched");

	}

}
