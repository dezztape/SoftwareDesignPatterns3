package adapter_design_pattern;

// Интерфейс для оплаты в тенге
interface PaymentInTenge {
	void payInTenge(double amount);
}

// Класс, представляющий оплату в тенге
class TengePayment implements PaymentInTenge {
	@Override
	public void payInTenge(double amount) {
		System.out.println("Оплачено " + amount + " тенге.");
	}
}

// Интерфейс для оплаты в долларах
interface PaymentInDollars {
	void payInDollars(double amount);
}

// Класс, представляющий оплату в долларах
class DollarPayment implements PaymentInDollars {
	@Override
	public void payInDollars(double amount) {
		System.out.println("Paid " + amount + " dollars.");
	}
}

// Адаптер, позволяющий оплачивать валютой по выбору
class PaymentAdapter implements PaymentInTenge, PaymentInDollars {
	PaymentInTenge tengePayment;
	PaymentInDollars dollarPayment;

	public PaymentAdapter(PaymentInTenge tengePayment, PaymentInDollars dollarPayment) {
		this.tengePayment = tengePayment;
		this.dollarPayment = dollarPayment;
	}

	@Override
	public void payInTenge(double amount) {
		tengePayment.payInTenge(amount);
	}

	@Override
	public void payInDollars(double amount) {
		dollarPayment.payInDollars(amount);
	}
}

class PaymentExample {
	public static void main(String[] args) {
		PaymentInTenge tengePayment = new TengePayment();
		PaymentInDollars dollarPayment = new DollarPayment();

		PaymentAdapter adapter = new PaymentAdapter(tengePayment, dollarPayment);

		// Оплата в тенге
		adapter.payInTenge(5000);

		// Оплата в долларах
		adapter.payInDollars(100);
	}
}
